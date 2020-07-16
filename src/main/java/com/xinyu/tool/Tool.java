package com.xinyu.tool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Tool {
	
	public static void main(String[] args){
		Tool tool =new Tool();
		tool.getBookUrl();
	}
	public void  getBookUrl(){
		try {
	        FileReader reader = new FileReader("D:/2 项目信息/天津项目/数据/bookidn.txt");
	        BufferedReader br = new BufferedReader(reader);
	        
    		FileWriter writer = new FileWriter("D:/2 项目信息/天津项目/数据/url.txt");
            BufferedWriter bw = new BufferedWriter(writer);
	        
	        String str = null;
	        while((str = br.readLine()) != null) {//
	        	 bw.write(str+"-http://audio.brainhunt.cn/jcjy/detail/detail.jsp?bookid="+str+"&enc="+MD5Util.getMD5(str+"ek#sW2Vox#@7D"));
	             bw.newLine();
	        }
		        br.close();
		        reader.close();
		        bw.close();
                writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
