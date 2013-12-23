package com.taodian.mockapi;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHandler;

import com.taodian.mockapi.servlet.ApiServlet;
import com.taodian.mockapi.servlet.IndexServlet;


public class HTTPServer {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8090);
		
		ServletHandler context = new ServletHandler();
		server.setHandler(context);
		
		context.addServletWithMapping(ApiServlet.class, "/api/route");
		context.addServletWithMapping(IndexServlet.class, "/*");
		//server.stop();
		
		server.start();
		server.join();
	}
}
