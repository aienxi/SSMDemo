package com.xinyu.tool;

import javax.servlet.http.HttpServletRequest;

public class IpUtils {
	 
    public static void main(String[] args) {
    	System.out.println(IpUtils.ipToLong("127.0.0.2"));
    }
    
    //将ip地址转为长整型
	public static  Long ipToLong(String ip) {
        Long ips = 0L;
        if(ip==null || ("").equals(ip)){
        	return ips;
        }
        String[] numbers = ip.split("\\.");  
        //等价上面  
        for (int i = 0; i < 4; ++i) {
            ips = ips << 8 | Integer.parseInt(numbers[i]);  
        }  
        return ips;     
    }
	public static String getIpAddr2(HttpServletRequest request){
          String ip = request.getHeader("x-forwarded-for");
          if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("Proxy-Client-IP");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("WL-Proxy-Client-IP");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getRemoteAddr();
         }
         if (ip.equals("0:0:0:0:0:0:0:1")){
             ip = "本地";
         }
         return ip;
     }
	 public static String getIpAddr(HttpServletRequest request){
         String ip = request.getHeader("X-Forwarded-For");
         if(StringUtil.notNull(ip)!="" && !"unKnown".equalsIgnoreCase(ip)){
             int index = ip.indexOf(",");
             if(index != -1){
                 return ip.substring(0,index);
             }else{
                 return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtil.notNull(ip)!="" && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
}