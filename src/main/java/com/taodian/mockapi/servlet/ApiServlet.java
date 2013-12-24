package com.taodian.mockapi.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.mortbay.log.Log;

import com.taodian.mockapi.ApiNameConvert;
import com.taodian.mockapi.Result;

public class ApiServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		JSONObject result = new JSONObject();
		
		result.put("status", "err");
		
		String apiName = null;
		String params = "{}";
    	Class clz = null;
    	Result res = null;
		
		if(req.getParameter("name") != null){
			apiName = req.getParameter("name");
		}
		
		if(req.getParameter("params") != null){
			params = req.getParameter("params");
		}
		
		if(apiName != null){
	    	ApiNameConvert anc = new ApiNameConvert();
	    	
	    	String pac = anc.getApiPackage(apiName);
	    	String name = anc.formateApiName(apiName);
	    	
			try {
				clz = Class.forName(pac);
				Object apiIns = clz.newInstance();
		    	Method apiMet = clz.getMethod(name, Map.class);
		    	
		    	Map<String, Object> param = (Map)JSONValue.parse(params);
		    	
		    	Object ret = apiMet.invoke(apiIns, param);
		    	res = (Result) ret;
		    	
			} catch (Exception e) {
				Log.debug("invoke method:" + e.toString());
				e.printStackTrace();
			}
			
			if(res != null){
				if(res.status != null && res.status.length() > 0){
					result.put("status", res.status);
				}
				if(res.msg != null && res.msg.length() > 0){
					result.put("msg", res.msg);
				}
				if(res.code != null && res.code.length() > 0){
					result.put("code", res.code);
				}
				if(res.result != null){
					result.put("data", res.result);
				}
			}else {
				result.put("msg", "Api error:result is null");					
			}
		}else{
			result.put("msg", "Api error: lacking api name");
		}


		result.toJSONString();
		resp.getWriter().print(result);
	}

}
