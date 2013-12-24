package com.taodian.mockapi.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.taodian.mockapi.ApiNameConvert;
import com.taodian.mockapi.service.ClickApi;

public class ApiServlet extends HttpServlet {

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, arg1);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		JSONObject result = new JSONObject();
		
		//name = click_app_daily_report
		String apiName = req.getParameter("name");
		String params = req.getParameter("params");
		
    	ApiNameConvert anc = new ApiNameConvert();
    	
    	ClickApi obj = null;// new ClickApi();
    	
    	Class clz = Class.forName("com.taodian.mockapi.service.impl.ClickApiImpl");
    	Object obj = clz.newInstance();
    	//clz.
    	Method m = obj.getMethod("tool_convert_long_url", Map.class)
    	
    	if (name.startsWith("credit")){s
    		obj = new ClickApiImpl();
	    	Map<String, Object> param = JSONValue.parse(params);
	    	Object ret = m.invoke(null, param);
	    	Result r = (Result) ret;
	    	if(name == "click_app_daily_report"){
	    		Result r = obj.clickAppDailyReport(param);
	    	}
    	}
    
		String pac = anc.getApiPackage(apiName);
		String name = anc.formateApiName(apiName);
		
		System.out.println(pac);
		System.out.println(name);
		
		result.put("status", "err");
		result.put("msg", "not found api name");
		result.put("api_name", req.getParameter("name"));
		result.put("params", req.getParameter("params"));
		result.toJSONString();
		resp.getWriter().print(result);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return super.getLastModified(req);
	}



}
