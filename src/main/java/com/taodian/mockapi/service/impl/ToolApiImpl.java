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
		
		String shortUrl = (String) param.get("short_url");
		
		Map<String, ShortUrlModel> shortMap = (Map<String, ShortUrlModel>) cache.get("short_data");
		
		ShortUrlModel sum = shortMap.get(shortUrl);
		data.put("short_key", sum.shortKey);
		data.put("user_id", sum.userId);
		data.put("shop_id", sum.shopId);
		data.put("long_url", sum.longUrl);
		
		res.result = data;
		return res;
	}

}
