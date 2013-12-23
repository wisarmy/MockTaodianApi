package com.taodian.mockapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.taodian.mockapi.http.HTTPResult;

public class TaodianApi {
	private Log log = LogFactory.getLog("com.taodian.api");
	private static String apiRoute = "http://localhost:8090/api/route";

	public HTTPResult call(String name, Map<String, Object> param) {
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("name", name);

		if (param == null) {
			param = new HashMap<String, Object>();
		}

		if (param.containsKey("no_cache")) {
			if (param.get("no_cache") != null) {
				p.put("no_cache", param.get("no_cache"));
			}
			param.remove("no_cache");
		}
		
		p.put("params", JSONValue.toJSONString(param));

		HTTPResult r = post(p);
		System.err.println(r.json);

		r.isOK = false;
		if (r.json != null) {
			if (r.getString("status").equals("ok")) {
				r.isOK = true;
			} else {
				r.errorMsg = r.getString("msg");
				r.errorCode = r.getString("code");
			}
		} else {
			r.errorMsg = "network error";
			r.errorCode = "network_error";
		}

		if (!r.isOK) {
			log.warn("Taobian API error:" + r.errorCode + ",msg:"
					+ r.errorMsg());
		}
		return r;
	}

	public static HTTPResult post(Map<String, Object> param) {
		HTTPResult result = new HTTPResult();
		OutputStreamWriter out;

		URL ar;
		try {

			ar = new URL(apiRoute);

			URLConnection conn = ar.openConnection();
			
			conn.setDoOutput(true);
			
			out = new OutputStreamWriter(conn.getOutputStream());
			out.write(String.format("name=%s&params=%s", param.get("name"), param.get("params")));
			
			out.flush();


			BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {

				JSONParser parser = new JSONParser();

				JSONObject parserObject = (JSONObject) parser.parse(inputLine);
				result.json = parserObject;

			}

			out.close();
			in.close();
			
		} catch (Exception e) {
			System.out.println("Exception:" + e.toString());
		}

		result.isOK = true;
		return result;
	}
}
