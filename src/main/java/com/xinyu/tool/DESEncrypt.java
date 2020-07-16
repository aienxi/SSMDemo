package com.xinyu.tool;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESEncrypt {
	public static String KeyWrd = "Def@ulT8KeY"; // 默认KEY值,用于DES加密用

	/**
	 * Describe:
	 * 
	 * @param rawTxt
	 * @return
	 * 
	 * @see com.eehoos.encrypt.Encrypt#encrypt(java.lang.String)
	 */
	public static String encrypt(String rawTxt) {
		return encrypt(rawTxt, KeyWrd);
	}

	public static void setKeyWrd(String key) {
		KeyWrd = key;
		return;
	}

	public static String encrypt(String str, String key) {
		try {
			if (str == null || str.length() < 1)
				return "";
			DESKeySpec keySpec = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			Cipher c1 = Cipher.getInstance("DES");
			c1.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] cipherByte = c1.doFinal(str.getBytes());
			return bytes2Hex(cipherByte);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String decrypt(String str) {
		return decrypt(str, KeyWrd);
	}

	public static String decrypt(String str, String key) {
		try {
			if (str == null || str.length() < 1)
				return "";
			DESKeySpec keySpec = new DESKeySpec(key.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = keyFactory.generateSecret(keySpec);
			Cipher c1 = Cipher.getInstance("DES");
			c1.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(c1.doFinal(hex2byte(str)), "UTF-8");
		} catch (Exception e) {
			 e.printStackTrace();
			return "";
		}
	}

	private static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	private static byte[] hex2byte(String hexStr) {
		try {
			byte[] bts = new byte[hexStr.length() / 2];
			for (int i = 0, j = 0; j < bts.length; j++) {
				bts[j] = (byte) Integer.parseInt(hexStr.substring(i, i + 2), 16);
				i += 2;
			}
			return bts;
		} catch (Exception e) {
			return "".getBytes();
		}
	}
	
	String url = "http://mblib.swu.edu.cn:8080/sms/opac/dxlib/opacdxlibverify.action?encode=gbk&method=get&sn=%s";
	public static void main(String[] args) {
		String src = "<uid>taracww</uid><pwd>cww68252425</pwd><time>"+StringUtil.getFullTime2()+"</time>";
		String sn = DESEncrypt.encrypt(src,"EW2sdfkj");
		
		System.err.println(sn);
	}

}
