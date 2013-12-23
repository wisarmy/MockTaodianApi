package com.taodian.mockapi.service;

import java.util.Map;

public interface ClickApi {

	/**
	 * ���ݿ�ʼʱ�����ʱ�䣬��ѯ����ַÿ��ĵ������
	 * 
	 * ���������� ʱ��
	 * 
	 * ���أ� ���ڣ�����ַ�� ���/pv/uv
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickAppDailyReport(Map<String, Object> param);

	/**
	 * ��ѯӦ�����棬���ж���ַ�ĵ������� 1. ���������� 1. ����ʱ�� 2. �����
	 * 
	 * ����: ����ַ, ���/pv/uv
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickAppShortKeyList(Map<String, Object> param);

	/**
	 * �ֶ�����������ݡ�
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickCleanUpExpiredData(Map<String, Object> param);

	/**
	 * �ֶ�ˢ�µ���ı���
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickRefreshDailyReport(Map<String, Object> param);

	/**
	 * ��ȡð��ÿ���û��ܵĵ����Ϣ
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickEmopUserSummary(Map<String, Object> param);

	/**
	 * �����ڻ�ȡð���û��ĵ����Ϣ
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickEmopUserDailyReport(Map<String, Object> param);

	/**
	 * �����ڻ�ȡð���û�����ַ�ĵ����Ϣ
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickEmopUserShortkeyDailyReport(Map<String, Object> param);

	/**
	 * ��ȡ����̼ұ���
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickActivityShopDaily(Map<String, Object> param);

	/**
	 * ��ȡ���ð���û���taoke������
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickActivityUserDaily(Map<String, Object> param);

	/**
	 * ��ȡ������е�����û��б� ȡ����������ΪM�ң�������SAE guangemop���档
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickActivityDailyUserList(Map<String, Object> param);

	/**
	 * �����û����ͳ�ơ���Ҫ���ڲ��ԡ�
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickShortUrl(Map<String, Object> param);

	/**
	 * ����΢��������Ϣ��
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickWeiboSend(Map<String, Object> param);

	/**
	 * �̼��Կ��ƹ㣬����
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickShopLibTaokeReport(Map<String, Object> param);

	/**
	 * �Կ�΢���������
	 * 
	 * @param app
	 * @param param
	 * @return
	 */
	public String clickUserOutidReport(Map<String, Object> param);

}
