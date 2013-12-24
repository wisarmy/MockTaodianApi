package com.taodian.mockapi;

public class ApiNameConvert {

	public String getApiPackage(String name){
		String packageName = name.split("_")[0];
		packageName = packageName.trim();
		String f = packageName.substring(0, 1);
		String s = packageName.substring(1);		
		
		return "com.taodian.mockapi.service.impl." + f.toUpperCase() + s + "ApiImpl";
	}
	
	public String formateApiName(String name){

		StringBuffer buf = new StringBuffer();
		
		String[] seg = name.split("_");
		buf.append(seg[0].trim().toLowerCase());
		
		for(int i = 1; i < seg.length; i++){
			String f = seg[i].substring(0, 1);
			String s = seg[i].substring(1);
			buf.append(f.toUpperCase());
			buf.append(s.toLowerCase());
		}
		
		return buf.toString();
	}
}
