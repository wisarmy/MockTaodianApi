package com.taodian.mockapi;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ���Žӿڣ�ͳһ���صĽṹ����HTTP �ӿ����棬����ͳһ�����ɷ��ؽ������Ҫ�����ӿڵķ���ֵ���ӿڵ���״̬��
 * �����롣
 * 
 * @author deonwu
 *
 */
public class Result implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���Žӿڣ�����״̬���ɹ�ͳһΪ:ok, ����״̬û����ȷ���壬���Ը��ݸ����ӿ����ж��塣 
	 */
	public String status = null;
	/**
	 * ���Žӿڣ�����ʱ��Ӧ�Ĵ����롣��ÿ���ӿ����ж��塣
	 */
	public String code = null;
	/**
	 * ���Žӿڣ�����ʱ��Ӧ�Ĵ�����Ϣ����ÿ���ӿ����ж��塣
	 */
	public String msg = null;
	
	/**
	 * �ӿڵķ��ؽ������Ҫһ������JSON���л��Ķ�����Ҫ��Map��List���ֽṹ֮һ��
	 */
	public Object result = null;	
	
	public boolean isOk(){
		return status != null && status.trim().equals("ok");
	}
	
	/**
	 * ����һ���յķ���Result���󣬰�status ����Ϊok.
	 * 
	 * @return
	 */
	public static Result emptyOk(){
		Result r = new Result();
		r.status = "ok";
		r.code = "";
		r.msg = "";
		r.result = new HashMap<String, Object>();
		
		return r;
	}
	
	/**
	 * ���ýӿڵĴ����롣
	 * @param code
	 */
	public void error(String code){
		error(code, "");
	}
	
	/**
	 * ���ýӿڵĴ�����ʹ�����Ϣ�� ���Ұ�status ����Ϊ"err".
	 * @param code
	 */
	public void error(String code, String msg){
		this.code = code;
		this.status = "err";
		this.msg = msg;
	}
	
	/**
	 * ����һ�����ؽ����
	 * @param key
	 * @param obj
	 */
	public void putValue(String key, Object obj){
		if(result instanceof Map){
			((Map<String, Object>)result).put(key, obj);
		}
	}
}
