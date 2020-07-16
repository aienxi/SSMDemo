package com.xinyu.tool;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DES {

	public static void main(String args[]) {
		//待加密内容
		String str = "<uid>taracww</uid><pwd>cww68252425</pwd><time>20180912173740</time>";
		//密码，长度要是8的倍数
		String password = "EW2sdfkj";

		String result = DES.encrypt(str,password);
		
		System.out.println("加密后："+new String(result));

		//直接将如上内容解密
		try {
			String decryResult = DES.decrypt(result, password);
			System.out.println("解密后："+new String(decryResult));
		} catch (Exception e1) {
		e1.printStackTrace();
		}

		} 
	
//		public static String entryptPassword(String plainPassword) {
//		byte[] salt = Digests.generateSalt(SALT_SIZE);
//		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
//		return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
//		}
//		public static final int HASH_INTERATIONS = 1024;
//		public static final int SALT_SIZE = 8;

		/**
		* 加密
		* @param datasource byte[]
		* @param password String
		* @return byte[]
		*/
		public static String encrypt(String datasource, String password) {
			SecureRandom random = new SecureRandom();
			try{
				DESKeySpec desKey = new DESKeySpec(password.getBytes());
				SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
				SecretKey securekey = keyFactory.generateSecret(desKey);
				Cipher cipher = Cipher.getInstance("DES");
				cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
				return new String(cipher.doFinal(datasource.getBytes()));
			}catch(Exception e){
				e.printStackTrace();
				return "";
			}
		}
		/**
		* 解密
		* @param src byte[]
		* @param password String
		* @return byte[]
		* @throws Exception
		*/
		public static String decrypt(String src, String password){
			SecureRandom random = new SecureRandom();
			try{
				DESKeySpec desKey = new DESKeySpec(password.getBytes());
				SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
				SecretKey securekey = keyFactory.generateSecret(desKey);
				Cipher cipher = Cipher.getInstance("DES");
				cipher.init(Cipher.DECRYPT_MODE, securekey, random);
				return new String(cipher.doFinal(src.getBytes()));
			}catch(Exception e){
				e.printStackTrace();
				return "";
			}
		}
}
