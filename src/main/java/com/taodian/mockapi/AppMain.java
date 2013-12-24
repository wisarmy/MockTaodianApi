package com.taodian.mockapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHandler;

import com.taodian.mockapi.entity.ShortUrlModel;
import com.taodian.mockapi.servlet.ApiServlet;
import com.taodian.mockapi.servlet.IndexServlet;
import com.taodian.util.CacheApi;
import com.taodian.util.SimpleCacheApi;


public class AppMain {
	
	public static CacheApi cache = new SimpleCacheApi();
	
	public static void main(String[] args) throws Exception {
		String port = System.getProperty("http.port", "8090");
		
		Server server = new Server(Integer.parseInt(port));
		
		ServletHandler context = new ServletHandler();
		server.setHandler(context);
		
		context.addServletWithMapping(ApiServlet.class, "/api/route");
		context.addServletWithMapping(IndexServlet.class, "/*");
		//server.stop();
		//server.start();
		
		

		Options options = new Options();
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse( options, args);
		
		options.addOption("short_data", true, "provide short_data path");
		
		if(cmd.hasOption("short_data") || true){
			String path = cmd.getOptionValue("short_data");
			
			ShortUrlModel sum = new ShortUrlModel();
			Map<String, Object> shortMap = new HashMap<String, Object>();
			
			try {
				BufferedReader in = new BufferedReader(new FileReader("data/short_url.txt"));
				String line = null;
				
				while((line = in.readLine()) != null){
					
					String[] arr = line.split(" ");
					
					if(arr.length>0){
						sum.shortKey = arr[0];
						sum.numIid = Long.parseLong(arr[1]);
					}
					
					shortMap.put(sum.shortKey, sum);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			cache.set("short_data", shortMap, 1000);
		}
	}
}
