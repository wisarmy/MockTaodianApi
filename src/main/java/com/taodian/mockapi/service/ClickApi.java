package com.taodian.mockapi.service;

import java.util.Map;

public interface ClickApi {

	/**
	 * 根据开始时间结束时间，查询短网址每天的点击数。
	 * 
	 * 过滤条件： 时间
	 * 
	 * 返回： 日期，短网址， 点击/pv/uv
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickAppDailyReport(Map<String, Object> param);

	/**
	 * 查询应用下面，所有短网址的点击结果。 1. 过滤条件： 1. 创建时间 2. 点击数
	 * 
	 * 返回: 短网址, 点击/pv/uv
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickAppShortKeyList(Map<String, Object> param);

	/**
	 * 手动清理过期数据。
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickCleanUpExpiredData(Map<String, Object> param);

	/**
	 * 手动刷新当天的报表。
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickRefreshDailyReport(Map<String, Object> param);

	/**
	 * 获取冒泡每个用户总的点击信息
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickEmopUserSummary(Map<String, Object> param);

	/**
	 * 按日期获取冒泡用户的点击信息
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickEmopUserDailyReport(Map<String, Object> param);

	/**
	 * 按日期获取冒泡用户短网址的点击信息
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickEmopUserShortkeyDailyReport(Map<String, Object> param);

	/**
	 * 获取活动的商家报表
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickActivityShopDaily(Map<String, Object> param);

	/**
	 * 获取活动的冒泡用户（taoke）报表
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickActivityUserDaily(Map<String, Object> param);

	/**
	 * 获取活动当天有点击的用户列表。 取到点击后结算为M币，保存在SAE guangemop里面。
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickActivityDailyUserList(Map<String, Object> param);

	/**
	 * 输入用户点击统计。主要用于测试。
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickShortUrl(Map<String, Object> param);

	/**
	 * 更新微博发送信息。
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickWeiboSend(Map<String, Object> param);

	/**
	 * 商家淘客推广，报表。
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickShopLibTaokeReport(Map<String, Object> param);

	/**
	 * 淘客微博点击报表。
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickUserOutidReport(Map<String, Object> param);

}
