package com.xinyu.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public boolean isBasic=false;
	public String basicUser="";
	public String basicPwd="";

	public static void main(String[] args) {
		HttpUtil httpUtil=new HttpUtil();
		String url="http://218.76.60.131/opac/reader/doLogin?rdid=00000180039015&rdPasswd=cbd52caf4b2d52759a19037eaf1690af";
		String res=httpUtil.httpGet(url);
		System.out.println(res.indexOf("欢迎您"));
	}
	public String  httpGet(String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String rs="";
        try {
            HttpGet httpget = new HttpGet(url);
            if(isBasic){
            	 httpget.addHeader("Authorization", "Basic " + StringUtil.base64Encoder(basicUser+":"+basicPwd, "Utf-8"));
	        }
            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                rs=EntityUtils.toString(entity,"UTF-8");
            }
            response.close();
        } catch (Exception e) {
        }  finally {
            try {
                httpclient.close();
            } catch (Exception e) {
            }
        }
        return rs;
 	}
	public String httpPost(String url, Map<String, String> map, String encoding){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        String rs="";
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        if (map != null && map.keySet().size() > 0) {
        	for (Entry<String, String> entry : map.entrySet()) {
        		formparams.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        	}
		}
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, encoding);
            httppost.setEntity(uefEntity);
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                	rs=EntityUtils.toString(entity, encoding);
                }
            } finally {
                response.close();
            }
        } catch (Exception e) {
        }  finally {
            try {  
                httpclient.close();  
            } catch (Exception e) {
            }  
        }
        return rs;
   }
	public String  httpGet2(String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String rs="";
        try {
            HttpGet httpget = new HttpGet(url);
            if(isBasic){
            	 httpget.addHeader("Authorization", "Basic " + StringUtil.base64Encoder(basicUser+":"+basicPwd, "Utf-8"));
	        }
            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                rs=EntityUtils.toString(entity,"UTF-8");
            }
            response.close();
        } catch (Exception e) {
        }  finally {
            try {
                httpclient.close();
            } catch (Exception e) {
            }
        }
        return rs;
 	}
	/**
	 * 
	 * @param url
	 * @param stringJson
	 * @param headers
	 * @param encoding
	 * @return
	 */
	 public String httpPostRaw(String url, String stringJson, String headers,String encoding){
		   String res="";
		   	CloseableHttpClient httpClient = HttpClients.custom().build();
			HttpPost httpPost = new HttpPost(url);
			StringEntity entity;
			try {
				httpPost.setHeader("Content-type", "application/json");
				httpPost.addHeader("Authorization", "Bearer "+headers);
				entity = new StringEntity(stringJson,encoding);
				httpPost.setEntity(entity);
				CloseableHttpResponse response = httpClient.execute(httpPost);
				res=EntityUtils.toString(response.getEntity());
			} catch (Exception e) {
				System.out.println("httpPostRaw"+e.getMessage());
			}
		   return res;
	   }
   public String getValueByTagName(String content,String tagName){
	   content=content.replaceAll("\"","");
	   content=content.substring(content.indexOf("name="+tagName));
	   content=content.substring(content.indexOf("value=")+"value=".length());
	   int sign=content.indexOf(">");
	   int sign1=content.indexOf(" ");
	   sign=sign<sign1?sign:sign1;
	   int sign2=content.indexOf("/");
	   sign=sign<sign2?sign:sign2;
	   content=content.substring(0,sign);
	   return content;
   }
}
