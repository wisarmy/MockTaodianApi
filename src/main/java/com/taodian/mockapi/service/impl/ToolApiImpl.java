package com.taodian.mockapi.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.taodian.mockapi.AppMain;
import com.taodian.mockapi.Result;
import com.taodian.mockapi.entity.ShortUrlModel;
import com.taodian.mockapi.service.ToolApi;
import com.taodian.util.CacheApi;

public class ToolApiImpl implements ToolApi {
	private CacheApi cache = AppMain.cache;
	
	public Result toolConvertLongUrl(Map<String, Object> param) {
		Result res = Result.emptyOk();
		Map<String, Object> data = new HashMap<String, Object>();
		
		String shortKey = (String) param.get("short_key");
		
		Map<String, Object> shortMaps = (Map<String, Object>) cache.get("short_data");
		
		res.result = shortMaps.get(shortKey);
		
		if(res.result == null){
			res.status = "err";
			res.msg = "The short_key is invalid.";
		}
		return res;
	}
}
