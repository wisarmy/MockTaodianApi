package com.taodian.mockapi.entity;

import java.util.Date;

/**
 * ΢�������ߡ�
 * @author deonwu
 */
public class WeiboVisitor {
	public long uid;
	public boolean isMobile = false;
	public String host;
	public String ip;
	public Date created = new Date(System.currentTimeMillis());
	public String agent;

	public boolean isFirst = false;
	public boolean noSave = false;
	
	/**
	 * һ�����ڵ��û��������û���
	 * @return
	 */
	public boolean isNewUser(){
		return created.getTime() > System.currentTimeMillis() - 24 * 60 * 60 * 1000;
	}

	public boolean equals(Object o){
		if(o instanceof WeiboVisitor){
			return ((WeiboVisitor) o).uid == uid;
		}else {
			return false;
		}
	}
	
	public int hashCode(){
		return (int)uid;
	}
}