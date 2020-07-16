package com.xinyu.tool;

import java.util.HashMap;
import java.util.Map;

import com.xinyu.tool.bean.AudioCountBean;

public class StaticObject {
	//缓存用户请求获取音频地址方法的请求情况，key为sessionid，value为AudioCountBean
	public static Map <String,AudioCountBean>audioCount =new HashMap<String,AudioCountBean>();

}
