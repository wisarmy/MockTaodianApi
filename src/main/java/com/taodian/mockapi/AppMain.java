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

import com.taodian.mockapi.entity.ShortUrlModel;
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
			
			String path = "data/" + cmd.getOptionValue("short_data");
			
			ShortUrlModel sum = new ShortUrlModel();
			Map<String, Object> shortMap = new HashMap<String, Object>();
			
			log.info("FileReader path:" + path);
			
			try {
				
				BufferedReader in = new BufferedReader(new FileReader(path));
				String line = null;
				
				while((line = in.readLine()) != null){
					
					String[] arr = line.split(";");
					
					//length > 1 , prevent empty line
					if(arr.length>1){
						sum.shortKey = arr[0].trim();
						sum.userId = Integer.parseInt(arr[1].trim());
						sum.shopId = Long.parseLong(arr[2].trim());
						sum.longUrl = arr[3].trim();
					}else{
						continue;
					}
					
					shortMap.put(sum.shortKey, sum);
				}
			} catch (Exception e) {
				log.info("FileReader Exception:" + e.toString());
			}
			
			cache.cleanAll();
			cache.set("short_data", shortMap, 1000);
		}
	}
}
