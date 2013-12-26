package com.taodian.mockapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHandler;

import com.taodian.mockapi.servlet.ApiServlet;
import com.taodian.mockapi.servlet.IndexServlet;
import com.taodian.util.CacheApi;
import com.taodian.util.SimpleCacheApi;


public class AppMain {
	
	public static CacheApi cache = new SimpleCacheApi();
	private static Log log = LogFactory.getLog("com.taodian.appMain");
	
	public static void main(String[] args) throws Exception {
		String port = System.getProperty("http.port", "8090");
		
		Server server = new Server(Integer.parseInt(port));
		
		ServletHandler context = new ServletHandler();
		server.setHandler(context);
		
		context.addServletWithMapping(ApiServlet.class, "/api/route");
		context.addServletWithMapping(IndexServlet.class, "/*");
		
		server.start();
		
		Options options = new Options();
		options.addOption("short_data", true, "provide short_data path");
		
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse( options, args);
		
		
		if(cmd.hasOption("short_data") || true){
			
			String path = cmd.getOptionValue("short_data");
			
			Map<String, Object> shortMaps = new HashMap<String, Object>();
			
			log.info("FileReader path:" + path);
			
			try {
				
				BufferedReader in = new BufferedReader(new FileReader(path));
				String line = null;
				
				int currentIndex = 0;
				boolean hasFormatRule = true;
				String[] shortUrlFields = null;
				
				while((line = in.readLine()) != null && hasFormatRule){
					Map<String, Object> shortMap = new HashMap<String, Object>();
					
					log.debug("currentIndex: " + currentIndex + ",content:" + line);
					
					if(currentIndex == 0){
						int index = line.indexOf("FORMAT_RULE");
						hasFormatRule = index > -1;
						
						if(hasFormatRule){
							String[] ruleArr = line.split(":");
							if(ruleArr.length == 2){
								shortUrlFields = ruleArr[1].split(";");
							}
							
						}else{
							
							throw new Exception("CustomException:At first line not found FORMAT_RULE keyword that defined short_data format.");
						}
						
						currentIndex ++;
						continue;
					}
					
					
					String[] arr = line.split(";");
					
					if(arr.length>1){
						String short_key = arr[0];
						for (int i = 0; i < shortUrlFields.length; i++) {
							shortMap.put(shortUrlFields[i], arr[i]);
							if(shortUrlFields[i].equals("short_key")){
								short_key = arr[i];
							}
						}
						
						shortMaps.put(short_key, shortMap);

					}else{
						currentIndex ++;
						continue;
					}
					
					currentIndex ++;
					shortMap = null;
				}
			} catch (Exception e) {
				log.info("FileReader Exception:" + e.toString());
			}
			
			cache.cleanAll();
			cache.set("short_data", shortMaps, 1000);
			
		}
	}
}
