package com.taodian.mockapi.service.impl;

import java.util.Map;

import com.taodian.mockapi.Result;
import com.taodian.mockapi.service.TestApi;

public class TestApiImpl implements TestApi {

	@Override
	public Result test(Map<String, Object> param) {
		
		Result res = new Result();
		res.status = "ok";
		
		return res;
	}

}
