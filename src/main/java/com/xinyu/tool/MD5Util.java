package com.xinyu.tool;

import java.security.MessageDigest;

public class MD5Util {
    
    public static void main(String[] args) {
    	/**
    	 * http://www.wx.xinyulib.com/lib/m/auth/auth.jsp?u=yzqsg&a=0AE80A9DAF1B58DB0E6CBD0ECC1176F9
    	 * 
    	 * http://kid.wx.xinyulib.com/lib/m/auth/auth.jsp?u=wush&a=20B5F7481B88FA8561006656E57250A4
    	 *微信统一认证
    	 */
//        String pwd = getMD5("yzqsg"+"sWpPiUH$!g!7u");
//        System.out.println(pwd);
    	// String pwd="2018-07-012018-07-31221"+StringUtil.getHourTime()+"TJjDC47*EDiCN3m*k";
    	 String pwd="gltsgidsWpPiUH$!g!7u";
    	// pwd="8001600510008612305582019-07-19 20lnnDla*ZUlt*aXY&S8jX";
    	 System.out.println(pwd);
    	 pwd = getMD5(pwd);
    	 System.out.println(pwd);
    }
    
    public static String getMD5(String message){
        String md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageByte = message.getBytes("UTF-8");
            byte[] md5Byte = md.digest(messageByte);
            md5 = bytesToHex(md5Byte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }
   
    public static String bytesToHex(byte[] bytes){
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
             if(num < 0) {
                 num += 256;
            }
            if(num < 16){
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
}  