package com.taodian.mockapi.service;

import java.util.Map;

import com.taodian.mockapi.Result;

public interface TestApi {

	public Result test(Map<String, Object> param);
}
