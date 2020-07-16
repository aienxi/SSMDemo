package com.xinyu.tool;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String iso2gb(String s) {
        if(s==null)
            return "";
        try {
            return new String(s.getBytes("ISO-8859-1"), "GBK").trim();
        } catch (Exception e) {
            return s;
        }
    }
    public static String gb2iso(String s) {
        if(s==null)
            return "";
        try {
            return new String(s.getBytes("GBK"), "ISO-8859-1").trim();
        } catch (Exception e) {
            return s;
        }
    }
    
    public static String iso2utf(String s) {
        if(s==null)
            return "";
        try {
            return new String(s.getBytes("ISO-8859-1"), "UTF-8").trim();
        } catch (Exception e) {
            return s;
        }
    }
    
    public static String utf2iso(String s) {
        if(s==null)
            return "";
        try {
            return new String(s.getBytes("UTF-8"), "ISO-8859-1").trim();
        } catch (Exception e) {
            return s;
        }
    }
    
    public static String notNull(String s) {
        if(s==null)
            return "";
        else
            return s.trim();
    }
    public static String strToUnicode(String str){
    	return str;
    	/*
    	StringBuffer unicode = new StringBuffer();
    	for (int i = 0; i < str.length(); i++) {
    	    Character character = str.charAt(i);
    	    unicode.append("\\u" + Integer.toHexString(character));
    	}
    	return unicode.toString();
    	*/
    }
    public static int getEndTime() {
    	Calendar curDate = Calendar.getInstance();
        Calendar nextDayDate = new GregorianCalendar(curDate.get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate.get(Calendar.DATE)+1, 0, 0, 0);
        return (int) (nextDayDate.getTimeInMillis() - curDate.getTimeInMillis())/1000;
    }
    public static String getFullDate(){
        String formater = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date myDate = new Date();
        return format.format(myDate);
      }
    public static String getHourTime(){
        String formater = "yyyy-MM-dd HH";
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date myDate = new Date();
        return format.format(myDate);
      }
    public static String getNestHourTime(int ihour){
        String formater = "yyyy-MM-dd HH";
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)+ihour);
        return format.format(calendar.getTime());
      }
    //当前时间加减秒数后的时间
    public static String getHourTime(int iSecond){
        String formater = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)+iSecond);
        return format.format(calendar.getTime());
      }
    public static String getFullTime(){
        String formater = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date myDate = new Date();
        return format.format(myDate);
    }
    public static String getFullTime2(){
        String formater = "yyyyMMddHHmmss";
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date myDate = new Date();
        return format.format(myDate);
    }
    public static String getMonth(String data){
        String formater = "yyyy-MM";
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date myDate=null;
		try {
			myDate = format.parse(data);
		} catch (ParseException e) {

		}  
        return format.format(myDate);
      }
    public static boolean compDate(String bDate, String eDate){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = df.parse(bDate);
            Date d2 = df.parse(eDate);
            return d1.getTime() <= d2.getTime();
            } catch (Exception e) {
            	return false;
            }
    }
    public static boolean compTime(String bDate, String eDate){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df.parse(bDate);
            Date d2 = df.parse(eDate);
            return d1.getTime() <= d2.getTime();
            } catch (Exception e) {
            	return false;
            }
    }
    public static int daysBetween(String bDate,String eDate){  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        try {
			cal.setTime(sdf.parse(bDate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(eDate));
			long time2 = cal.getTimeInMillis();  
			long between_days=(time2-time1)/(1000*3600*24);
		    return Integer.parseInt(String.valueOf(between_days)); 
		} catch (ParseException e) {
			return 0;
		}
    }
    public static String getDatebDays(String cDate,int days){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				 Date date = sdf.parse(cDate);
				 Calendar calendar = new GregorianCalendar();
		    	 calendar.setTime(date);
		    	 calendar.add(Calendar.DATE,days);
		    	 date=calendar.getTime(); 
		    	 return sdf.format(date);	  
			} catch (ParseException e) {
				e.printStackTrace();
				return cDate;
			}
    }
    public static boolean isValidDate(String str) {
        boolean convertSuccess=true;
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         try {
            format.setLenient(false);
            format.parse(str);
         } catch (ParseException e) {
             convertSuccess=false;
         } 
         return convertSuccess;
  }
    public static String gtLastDayOfMonth(String sDate){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
		try {
			date = df.parse(sDate);
			 Calendar calendar = Calendar.getInstance();
		        calendar.setTime(date);
		        calendar.add(Calendar.MONTH, 1);
		        calendar.add(Calendar.DATE,-1);
		        Date theDate = calendar.getTime();
		        sDate= df.format(theDate);
		} catch (ParseException e) {e.printStackTrace();
		}
       
        return sDate;
    }
    public static String secondToMini(int second){
        String str="";
        int temp =0;
             if(second>=3600){
            	 temp= second/3600; 
            	 if(temp>0)str+=temp+"小时";
            	 second=second%3600;
             }
             if(second>=60){
            	 temp= second/60; 
            	 if(temp>0)str+=temp+"分";
            	 second=second%60;
             }
             if(second>0){ 
            	 str+=second+"秒";
             }
             return str;
       }
     
    public static String byteToM(int a){
    	float res= (float)a/1024/1024;
    	DecimalFormat df = new DecimalFormat("0.00");//格式化小数   
    	String s = df.format(res);//返回的是String类型 
    	return s;
    }
    public static String setHtmlTag(String input){
    	input=notNull(input);
    	input=input.replaceAll("<","&lt;");
	  	input=input.replaceAll(">","&gt;");
		input=input.replaceAll("\r","");
		input=input.replaceAll("\n","<br>");
		return input;
    }
    public static String getHtmlTag(String input){ 
    	input=notNull(input);
    	input=input.replaceAll("<br>","\r\n");
		input=input.replaceAll("&lt;","<");
  		input=input.replaceAll("&gt;",">");
		return input;
    }    
    /**
     * Escape SQL tags, ' to ''; \ to \\.
     * @param input string to replace
     * @return string
     */
    public static String escapeSQLTags(String input) {
      if (input == null || input.length() == 0) {
        return input;
      }
      StringBuffer buf = new StringBuffer();
      char ch = ' ';
      for (int i = 0; i < input.length(); i++) {
        ch = input.charAt(i);
        if (ch == '\\') {
          buf.append("\\");
        }
        else if (ch == '\'') {
          buf.append("\'");
        }
        else {
          buf.append(ch);
        }
      }
      return buf.toString();
    }
    public static String  escape(String src){
    	int i;  
    	char j;  
    	StringBuffer tmp = new StringBuffer();
    	tmp.ensureCapacity(src.length()*6);
    	for (i=0;i<src.length() ;i++ ){
    		j = src.charAt(i);
    		if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
    			tmp.append(j);
    		else if (j<256){
    			tmp.append( "%" );
    			if (j<16)
    				tmp.append( "0" );
    			tmp.append( Integer.toString(j,16) );
    		}else{
    			tmp.append( "%u" );
    			tmp.append( Integer.toString(j,16) );
    		}  
    	}  
    	return tmp.toString();
    }
    public static String  unescape(String src){
    	StringBuffer tmp = new StringBuffer();
    	tmp.ensureCapacity(src.length());
    	int  lastPos=0,pos=0;  char ch;
    	while (lastPos<src.length()){
    		pos = src.indexOf("%",lastPos);
    		if (pos == lastPos){
    			if (src.charAt(pos+1)=='u'){
    				ch = (char)Integer.parseInt(src.substring(pos+2,pos+6),16);
    				tmp.append(ch);
    				lastPos = pos+6;
    			}else{
    				ch = (char)Integer.parseInt(src.substring(pos+1,pos+3),16);
    				tmp.append(ch);
    				lastPos = pos+3;
    			}
    		}else{
    			if (pos == -1){
    				tmp.append(src.substring(lastPos));
    				lastPos=src.length();
    			}else{
    				tmp.append(src.substring(lastPos,pos));
    				lastPos=pos;
    			}
    		}
    	}
    	return tmp.toString(); 
    }

    public static String getPartString(String str,int len) throws UnsupportedEncodingException {
    	byte b[];
    	int counterOfDoubleByte = 0;
    	b = str.getBytes("GBK");
    	if(b.length <= len)
    		return str;
    	for(int i = 0; i < len; i++){
    		if(b[i] < 0)
    			counterOfDoubleByte++;
    	}
    	if(counterOfDoubleByte % 2 == 0)
    		return new String(b, 0, len, "GBK") + "...";
    	else
    		return new String(b, 0, len - 1, "GBK") + "...";
    } 
    public static int getStringLength(String str) throws UnsupportedEncodingException{
    	byte b[];
    	b = str.getBytes("GBK");
    	return b.length;
    }
    public static String htmlEncode(String txt){
    	  txt = txt.replaceAll("&","&amp;");
    	  txt = txt.replaceAll("&amp;amp;","&amp;");
    	  txt = txt.replaceAll("&amp;quot;","&quot;");
    	  txt = txt.replaceAll("\"","&quot;");
    	  txt = txt.replaceAll("&amp;lt;","&lt;");
    	  txt = txt.replaceAll("<","&lt;");
    	  txt = txt.replaceAll("&amp;gt;","&gt;");
    	  txt = txt.replaceAll(">","&gt;");
    	  txt = txt.replaceAll("&amp;nbsp;","&nbsp;");
    	  //txt = txt.replaceAll("'","&rsquo;");
    	  //txt = txt.replaceAll("&amp;rsquo;","&rsquo;");
    	  return txt;
    	}

    public static String unHtmlEncode(String txt){
    	  txt = txt.replaceAll("&amp;","&");
    	  txt = txt.replaceAll("&quot;","\"");
    	  txt = txt.replaceAll("&lt;","<");
    	  txt = txt.replaceAll("&gt;",">");
    	  txt = txt.replaceAll("&nbsp;"," ");
    	  return txt;
    	}
		
		public static String markColor(String sw,String sTemp,String sColor){
			String sReturn="";
			int i=0,j=0;
			int iTempLength = sTemp.length();
			int iLengthS1 = sw.length();
			String sTemp1=sw.toLowerCase();
			String sTemp2 = sTemp.toLowerCase();
			while(true)
			{
				i=sTemp2.indexOf(sTemp1,j);
				if(i==-1)
				{
					sReturn += sTemp.substring(j,iTempLength);
					break;
				}
				sReturn += sTemp.substring(j,i) + "<font color=\""+sColor+"\">"+ sTemp.substring(i,i+iLengthS1) + "</font>";
				j= i + iLengthS1;
				if(j>iTempLength)
					j = iTempLength;
			}
			return sReturn;
		}		
	    public static String getFloat(double price){
	      return (new DecimalFormat("0.00").format(price));
	    }
	 
	    /**
	     * @param str
	     * @return
	     */
	    public static int strToInt(String str){
	    	int num = 0;
	    	if(str==null){
	    		str = "";
	    	}
	    	try{
	    		num = Integer.parseInt(str);
	    	}catch(Exception e){
	    		num = 0;
	    	}
	    	return num;
	    }
	    
	    public static String objectStr(Object obj){
			String str = "";
			if(obj==null){
				str = "";
			}else{
				str = obj.toString();
			}
			if(str.equals("null")){
				str = "";
			}
			return str;
		}
		/**
		 * @param obj
		 * @return
		 */
		public static int objectInt(Object obj){
			int num = 0;
			if(obj == null){
				num = 0;
			}else{
				try{
					num = Integer.parseInt(obj.toString());
				}catch(Exception e){
					num = 0;
				}
			}
			return num;
		}
		/**
		 * @param obj
		 * @return
		 */
		public static double objectDou(Object obj){
			double num = 0.00;
			if(obj == null){
				num = 0.00;
			}else{
				try{
					num = Double.parseDouble(obj.toString());
				}catch(Exception e){
					num = 0.00;
				}
			}
			return num;
		}
		/**
		 * @param str
		 * @return
		 */
		public static double strToDou(String str){
			double num = 0.00;
	    	if(str==null){
	    		str = "";
	    	}
	    	try{
	    		num = Double.parseDouble(str);
	    	}catch(Exception e){
	    		num = 0.00;
	    	}
	    	return num;
		}
		/**
		 * @param str
		 * @return
		 */
		public static float strToFlo(String str){
			float num = 0.0f;
	    	if(str==null){
	    		str = "";
	    	}
	    	try{
	    		num = Float.parseFloat(str);
	    	}catch(Exception e){
	    		num = 0.0f;
	    	}
	    	return num;
		}
		public static int getIntFromMap(String bYear,String eYear,HashMap <String ,Integer>cole){
			int cout=0,ibYear=0,ieYear=0;
			try{
				ibYear=Integer.parseInt(bYear);
				ieYear=Integer.parseInt(eYear);
			}catch(Exception e){}
			for(;ibYear<=ieYear;ibYear++){
				cout+=cole.get(String.valueOf(ibYear));
			}
			return cout;
		}
		public static int getIntFromMap(int bYear,int eYear,HashMap <String ,Integer>cole){
			int cout=0;
			for(;bYear<=eYear;bYear++){
				try{
					cout+=cole.get(String.valueOf(bYear));
				}catch(Exception e){}
			}
			return cout;
		}
		
		
		public static int[] getRandomIarray(int log){
			int[] result = new int[log];
			for (int i = 0; i < log; i++) {
				result[i] = i;
			}
			for (int i = 0; i < log; i++) {
				 int random = (int) (log * Math.random());
                 int temp = result[i];
                 result[i] = result[random];
                 result[random] = temp;
			}
			 return result;
		}
		public static boolean isNumber(String str){
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
		public static List<String> getHitMulu(String sMulu,String sw){
			List <String>list=new ArrayList<String>();
			if(!StringUtil.isNumber(sw)&&sMulu.indexOf(sw)>0){
				String arrMulu[]=sMulu.split("\r\n");
				for(int i=0;i<arrMulu.length;i++){
					if(arrMulu[i].indexOf(sw)>0){
						list.add(arrMulu[i]);
						if(list.size()==3)break;
					}
				}
			}
			return list;
		}
		//编码
		public static String base64Encoder(String src,String code){
			try {
				src=Base64.getEncoder().encodeToString(src.getBytes(code));
			} catch (UnsupportedEncodingException e) {
			}
			return src;
		}
		//解码
		public static String base64Decoder(String src,String code){
			byte[]asBytes = Base64.getDecoder().decode(src);
			try {
				src=new String(asBytes, code);
			} catch (UnsupportedEncodingException e) {
			}
			return src;
		}
		public static String getURLEncoderString(String src,String code){
			String result = "";
			if (null == src) {
			return "";
			}
			try {
			result = java.net.URLEncoder.encode(src, code);
			} catch (UnsupportedEncodingException e) {
			}
			return result;
		}
		public static String getSearchLink(String con,String add){
			String []cons=con.split("，");
			con="";
			String tKey="";
			for(int i=0;i<cons.length;i++){
				tKey=replaceWorld(cons[i]);
				if(!tKey.equals("")){
					con+=(con.equals("")?"":"，")+"<a class='classfy' href='../search/search.jsp?sw="+StringUtil.getURLEncoderString(replaceWorld(cons[i]),"UTF-8")+"&"+add+"'>"+cons[i]+"</a>";
				}
			}
			return con;
		}
		public static String replaceWorld(String key){
			key=key.replaceAll("著","").replaceAll("等","").replaceAll("译","").replaceAll(" 编","");
			key=key.replaceAll(" 主编","").replaceAll(" 绘","").replaceAll(" 编绘","").replaceAll(" 编写","");
			return key.trim();
		}
		public static List<String> getSplitWords(String sWords){
			String splitSign="，";
			if(sWords.indexOf(",")>-1)
				splitSign=",";
			if(sWords.indexOf(";")>-1)
				splitSign=";";
			String []cons=sWords.split(splitSign);
			List<String> list=new ArrayList<String>();
			for(int i=0;i<cons.length;i++){
				list.add(replaceWorld(cons[i]));
			}
			return list;
		}
	    public static void main(String[] args){
	    	System.out.println(StringUtil.compTime("2020-01-01 0:00:00","2010-01-01 0:00:00"));
//	    	for(int i=1;i<100;i++){
//	    		if(i<10){
//	    			System.out.print("00");
//	    			System.out.println(i);
//	    		}else if(i<100){
//	    			System.out.print("0");
//	    			System.out.println(i);
//	    		}else{
//	    			System.out.println(i);
//	    		}
//	    	}
//	    	System.out.println(StringUtil.gtLastDayOfMonth("2017-12-01"));
//	    	System.out.println("2017-12".length());
	    }  
}

