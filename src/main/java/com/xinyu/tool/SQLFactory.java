package com.xinyu.tool;

import java.util.List;

public class SQLFactory{
	public static String loginByIp(){
		return "select site.siteId,site.cssName,site.domainName,wxDomain,cssPackage,site.title,site.button,site.logo as sitelogo,unit.unitId,unit.unitName,unit.validity as unitvalidity,unit.unitStatus,unit.isebook,unit.logo as unitlogo,unit.customName,`user`.userId,`user`.userName,`user`.validity as uservalidity,`user`.`status` as uerstatus "
				+"from site left join unit on site.siteId=unit.siteId left join `user` on unit.unitId=`user`.unitId left join user_ip on `user`.userId=user_ip.userId "
				+"where user_ip.startIpCount<=? and user_ip.endIpCount>=? and (site.domainName=? or site.wxDomain=?)";
	}
	public static String loginByUserName(){
		return "select site.siteId,site.cssName,site.domainName,wxDomain,cssPackage,site.title,site.button,site.logo as sitelogo,unit.unitId,unit.unitName,unit.validity as unitvalidity,unit.unitStatus,unit.isebook,unit.logo as unitlogo,unit.customName,`user`.userId,`user`.userName,`user`.password,`user`.type,`user`.validity as uservalidity,`user`.`status` as uerstatus "
				+ "from site left join unit on site.siteId=unit.siteId left join `user` on unit.unitId=`user`.unitId left join user_ip on `user`.userId=user_ip.userId" 
				+" where (`user`.type=5 or `user`.type=8) and `user`.userName=?  and (site.domainName=? or site.wxDomain=?)";
	}
	public static String authLittleUser(){
		return "select site.siteId,site.cssName,site.domainName,wxDomain,cssPackage,site.title,site.button,site.logo as sitelogo,unit.unitId,unit.unitName,unit.validity as unitvalidity,unit.unitStatus,unit.isebook,unit.logo as unitlogo,unit.customName,`user`.userId,`user`.userName,`user`.password,`user`.type,`user`.validity as uservalidity,`user`.`status` as uerstatus "
				+ "from site left join unit on site.siteId=unit.siteId left join `user` on unit.unitId=`user`.unitId left join user_ip on `user`.userId=user_ip.userId" 
				+" where (`user`.type=5 or `user`.type=8) and `user`.userName=?";
	}
	public static String authCodeLogin(){
		//return "select * from site where siteId=?";
		return "select site.*,unit.customName,unit.unitName,unit.validity as unitvalidity,unit.unitStatus from site LEFT JOIN unit on site.siteId=unit.siteId where unitId=?";
	}
	public static String getPackAgeByDomain(){
		return "select cssPackage,domainName,wxDomain,title,logo from site where domainName=? or wxDomain=?";
	}
	public static String isCodeUser(){
		return "SELECT unit.validity as unitvalidity,unit.unitStatus,`user`.type,`user`.validity as uservalidity,`user`.`status` as uerstatus"
				+" FROM `user` LEFT JOIN unit on `user`.unitId=unit.unitId WHERE `user`.userId=? AND `user`.type=8";
	}
	public static String getClassInfo(){
		return "select * from site_class WHERE siteId=? ORDER BY sort";
	}
	public static String initClassInfo(){
		return "SELECT site.siteId,site_class_book.classId ,site_class.className,site_class_book.bookId"
				+" from site_class_book LEFT JOIN site_class on site_class_book.classId=site_class.classid"
				+" LEFT JOIN site ON site_class.siteId = site.siteId ORDER BY site.siteId,site_class.classId";
	}
	
	public static String getIndexPic(){
		return "select home_content.*,home.* from home_content LEFT JOIN home ON home_content.homeId=home.homeId WHERE home_content.status=8 AND home.siteId=? AND home.modulType=? ORDER BY home_content.sort";
	}
	public static String getLatestBook(){
		return "select book.*,home.homeId from book LEFT JOIN home_content ON book.bookId=home_content.bookId LEFT JOIN home ON home_content.homeId=home.homeId WHERE book.onlineStatus=1 and home_content.`status`=8 AND home.`status`=8 AND home.siteId=? AND home.modulType=?  ORDER BY home_content.sort";
	}
	public static String getTopicBook(){
		return "select book.* from book LEFT JOIN home_content ON book.bookId=home_content.bookId LEFT JOIN home ON home_content.homeId=home.homeId WHERE book.onlineStatus=1 and home_content.`status`=8 AND home.`status`=8 AND home.homeId=?  ORDER BY home_content.sort";
	}
	public static String getBookListByTopicId(){
		return "select book.* from book LEFT JOIN home_content ON book.bookId=home_content.bookId LEFT JOIN home ON home_content.homeId=home.homeId WHERE book.onlineStatus=1 and home_content.`status`=8 AND home.`status`=8 AND home.homeId=?  ORDER BY home_content.sort";
	}
	public static String getTopicInfo(){
		return "select * from home where `status`=8 AND siteId=? AND modulType=? ORDER BY sort";
	}
	public static String getATopicInfo(){
		return "select * from home where `status`=8 AND siteId=? AND (modulType=13 or modulType=14) ORDER BY modulType,sort";
	}
	public static String getClassBookList(int iFrom){
			return "SELECT distinct book.* from site_class_book LEFT JOIN book ON book.bookId=site_class_book.bookId where book.onlineStatus=1 and book.onlineStatus=1 and site_class_book.classId=?  ORDER BY site_class_book.bookSort,site_class_book.bookId";
	}
	public static String getBookNameHitList(int iFrom,int sType,String sw){
		String typeSql="";
		if(sType==1){
			typeSql="(REPLACE(REPLACE(REPLACE(bookName,' ','' ),'（',''),'）','') LIKE '%"+sw+"%')";
		}else if(sType==2){
			typeSql="(authorName LIKE '%"+sw+"%')";
		}else if(sType==3){
			typeSql="(anchorName LIKE '%"+sw+"%')";
		}else if (sType==4){
			typeSql="(keywords LIKE '%"+sw+"%')";
		}else{
			typeSql="(REPLACE(REPLACE(REPLACE(bookName,' ','' ),'（',''),'）','') LIKE '%"+sw+"%' OR authorName  LIKE '%"+sw+"%' OR anchorName  LIKE '%"+sw+"%' or keywords LIKE '%"+sw+"%')";
		}
		
		return "SELECT distinct book.* from site_class_book LEFT JOIN book  ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId "
			 + "where book.onlineStatus=1 and site_class.siteId=? AND "+typeSql+" ORDER BY btype, site_class_book.bookSort";
	}
	public static String getBookMuluHitList(int iFrom,String sw){
		return "SELECT distinct book.* from site_class_book LEFT JOIN book  ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId "
			 + "where book.onlineStatus=1 and site_class.siteId=? AND catalog LIKE '%"+sw+"%' and bookName not LIKE '%"+sw+"%' and authorName not LIKE '%"+sw+"%' and anchorName not LIKE '%"+sw+"%' and keywords not LIKE '%"+sw+"%'"
			 +" ORDER BY btype, site_class_book.bookSort"; 
	}
	public static String getSummaryHitList(int iFrom,String sw){
		return "SELECT distinct book.* from site_class_book LEFT JOIN book  ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId "
			 + "where book.onlineStatus=1 and site_class.siteId=? AND summary LIKE '%"+sw+"%' and bookName not LIKE '%"+sw+"%' and authorName not LIKE '%"+sw+"%' and anchorName not LIKE '%"+sw+"%' and keywords not LIKE '%"+sw+"%' and catalog not LIKE '%"+sw+"%'"
			 +" ORDER BY btype, site_class_book.bookSort"; 
	}
	public static String getBookMuluHitCount(int iFrom,String sw){
		return "SELECT count(distinct book.bookid) as icount from site_class_book LEFT JOIN book  ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId "
			 + "where book.onlineStatus=1 and site_class.siteId=? AND catalog LIKE '%"+sw+"%' and bookName not LIKE '%"+sw+"%' and authorName not LIKE '%"+sw+"%' and anchorName not LIKE '%"+sw+"%' and keywords not LIKE '%"+sw+"%'"; 
	}
	public static String getSummaryHitCount(int iFrom,String sw){
		return "SELECT count(distinct book.bookid) as icount from site_class_book LEFT JOIN book  ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId "
			 + "where book.onlineStatus=1 and site_class.siteId=? AND summary LIKE '%"+sw+"%' and bookName not LIKE '%"+sw+"%' and authorName not LIKE '%"+sw+"%' and anchorName not LIKE '%"+sw+"%' and keywords not LIKE '%"+sw+"%' and catalog not LIKE '%"+sw+"%'"; 
	}
	public static String getBookInfoBySiteBid(){
		return "SELECT book.bookId,book.onlineStatus,site_class_book.codeKey,site.siteId,site.domainName,site.wxDomain,site.cssPackage FROM book"
			 +" LEFT JOIN site_class_book ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class.classId=site_class_book.classId"
			 +" LEFT JOIN site ON site_class.siteId=site.siteId where site_class_book.id=?";
	}
	public static String getChapterListByBookId(){
		return "select * from book_article where bid=? ORDER BY sort";
	}
	public static String isBookInsite(){
		return "SELECT COUNT(1) as icount from book LEFT JOIN site_class_book on book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId"
			 +" WHERE site_class_book.bookId=? AND site_class.siteId=? AND book.onlineStatus=1";
	}
	public static String getChapterInPage(){
		return "select * from book_article where id=?";
	}
	public static String getBookInfoByBookId(){
		return "select * from book where bookId=? and book.onlineStatus=1";
	}
	public static String getBookInfoOpacUrlByBookId(){
		return "SELECT book.*,opacUrlInfo.wxOpacUrl,opacUrlInfo.pcOpacUrl "
			  +"FROM book LEFT JOIN opacUrlInfo ON book.bookId=opacUrlInfo.bookId and opacUrlInfo.untilId=? "
			  +"WHERE book.bookId=? and book.onlineStatus=1";
	}
	public static String getHistoryInfo(){
		return "SELECT book.bookId,book.bookName,book.anchorName,book.authorName,book.bookImg,book.chapterNum,book.times,book_article.id,book_article.sort,book_article.title "
				+"FROM book_article LEFT JOIN book ON book_article.bid=book.bookId WHERE book_article.id=?";
	}
	public static String getFavInfo(){
		return "SELECT book.bookId,book.bookName,book.anchorName,book.authorName,book.bookImg,book.chapterNum,book.times FROM  book WHERE bookId=?";
	}
	public static String getDomForUrl(){
		return "SELECT site.domainName,site.cssPackage from site WHERE siteId=?";
	}
	public static String getChapterAudioUrl(String stype){
		if(stype.equals("last")){
			return "select * from book_article where bid=(select bid from book_article where id=?) and (sort =(select sort from book_article where id=?)-1)";
		}else if(stype.equals("next")){
			return "select * from book_article where bid=(select bid from book_article where id=?) and (sort =(select sort from book_article where id=?)+1)";
		}else{
			return "select * from book_article where id=?";
		}
	}
	public static String addApplyIbfo(){
		return "INSERT INTO applyinfo(untilName,surname,telphone,applytime,applyip) VALUES(?,?,?,?,?)";
	}
	
	public static String getBookPlayCount(String[] bookids) {
		if (bookids.length>1) {
			StringBuffer buffer=new StringBuffer();
			buffer.append("(");
			for (int i = 0; i < bookids.length; i++) { 
				buffer.append(bookids[i]);
				if (i<bookids.length-1) {
					buffer.append(",");
				}
			}
			buffer.append(")");
			return "select bookId, count(0) from downlog where bookId in"+buffer.toString()+" group by bookId";
		}else {
			return "select bookId, count(0) from downlog where bookId ="+bookids[0]+" group by bookId";
		}
		
	}
	
	/***************************
	 * 记录访问日志
	 * sType:
	 * 
	 * index  首页访问
	 * search 分类，检索
	 * topic  专题
	 * detail 详情
	 * AudioServlet 下载，获取音频地址
	 * 
	 * @return
	 */
	public static String writeLog(String sType){
		String sql="";
		if(sType.equals("index")||sType.equals("getHomeInfo")){
			sql="INSERT INTO indexlog(unitId,userId,pUserId,visitFrom,req_month,req_date,req_ip,reqUrl,req_time) VALUES(?,?,?,?,?,?,?,?,?)";
		}else if(sType.equals("search")||sType.equals("searchAuBook")||sType.equals("getlittlebooklist")){
			sql="INSERT INTO searchlog(unitId,userId,pUserId,keyWord,classId,visitFrom,req_month,req_date,req_ip,reqUrl,req_time) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		}else if(sType.equals("detail")||sType.equals("getBookInfo")||sType.equals("getBooDetail")||sType.equals("getlittlebooInfo")){
			sql="INSERT INTO detaillog(unitId,userId,pUserId,bookId,visitFrom,req_month,req_date,req_ip,reqUrl,req_time) VALUES(?,?,?,?,?,?,?,?,?,?)";
		}else if(sType.equals("AudioServlet")||sType.equals("getAudioUrl")||sType.equals("getlittleaudiourl")){
			sql="INSERT INTO downlog(unitId,userId,pUserId,bookId,chapterId,visitFrom,req_month,req_date,req_ip,reqUrl,req_time) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		}
		return sql;
	}
	/*********************设备api接口******************/
	public static String getBaseInfo(){
		return "SELECT touchscreen.*,site.logo,site.siteId,site.cssPackage from touchscreen LEFT JOIN site on touchscreen.siteId=site.siteId where touchscreen.touchcode=? AND touchscreen.touchState!=3 AND site.siteType=2";
	}
	public static String getScreamList(int iSign){
		if(iSign==1){
			return "SELECT touch_unit_screem.*,touchscreen.isscreen FROM touch_unit_screem LEFT JOIN touchscreen ON touch_unit_screem.touchid=touchscreen.touchId WHERE touchscreen.touchcode=? ORDER BY touch_unit_screem.sort";
		}else{
			return "SELECT home_content.homeContentId,home_content.pictureUrl,home_content.sort,touchscreen.isscreen from home_content LEFT JOIN home on home_content.homeId=home.homeId LEFT JOIN site ON home.siteId=site.siteId LEFT JOIN touchscreen ON site.siteId=touchscreen.siteId "
					+" where touchscreen.touchcode=? AND touchscreen.touchState!=3 AND site.siteType=2 AND home.`status`=8 AND home.modulType=16 AND home_content.`status`=8 ORDER BY home_content.sort";
		}
	}
	public static String getSelfClassList(){
		return "SELECT touch_self_class.* FROM touch_self_class LEFT JOIN touchscreen ON touch_self_class.touchId=touchscreen.touchId"
			  +" WHERE touchscreen.touchcode=? ORDER BY touch_self_class.tclassSort";
	}
	public static String getClassList(){
		return "SELECT site_class.* FROM site_class LEFT JOIN site ON site_class.siteId=site.siteId"
			  +" LEFT JOIN touchscreen ON site.siteId=touchscreen.siteId where site.siteType=2 AND touchscreen.touchState!=3 AND touchscreen.touchcode=? ORDER BY site_class.sort";
	}
	public static String getContentList(){
		return "SELECT * FROM touch_content WHERE tclassId=? ORDER BY insertTime DESC";
	}
	public static String getBookList(){
		return "SELECT book.*,site_class_book.bookSort from site_class_book LEFT JOIN book ON book.bookId=site_class_book.bookId where book.onlineStatus=1 and site_class_book.classId=? ORDER BY site_class_book.bookSort,site_class_book.bookId";
	}
	public static String getBookListBySite(){
		return "SELECT book.*,site_class_book.bookSort from site_class_book LEFT JOIN book ON book.bookId=site_class_book.bookId where book.onlineStatus=1 AND book.booktype=1 and site_class_book.classId in (SELECT classId FROM site_class where siteId=?) ORDER BY site_class_book.bookSort,site_class_book.bookId limit ?,?";
	}
	
	public static String getBookListByMcode(){
		return "SELECT book.bookid,book.bookName,book.authorName,book.anchorName,book.chapterNum,book.bookImg,book.summary,book.times,book.filesize,book.commend FROM "
				+"(SELECT distinct bookId FROM site_class_book LEFT JOIN site_class ON site_class_book.classId=site_class.classId "
				+"LEFT JOIN touchscreen ON site_class.siteId=touchscreen.siteId WHERE touchscreen.touchcode=?) "
				+"siteBookTable LEFT JOIN book ON book.bookId=siteBookTable.bookId";
	}
	public static String getChapterList(String bids){
		return "SELECT * FROM book_article where bid in("+bids+") ORDER BY bid,sort";
	}
	public static String GetSimilarBook(int iType,List <String>list){
		String  sField="";
		if(iType==1){
			sField="authorName";
		}else if(iType==2){
			sField="anchorName";
		}else{
			sField="bookName";
		}
		String sql="";
		for(int i=0;i<list.size();i++){
			if(i==0){
				if(sField.equals("bookName")){
					sql+=sField +" like '%"+list.get(i)+"%'";
				}else{
					//sql+=sField +" = '"+list.get(i)+"'";
					sql+=sField +" like '%"+list.get(i)+"%'";
				}
			}else{
				if(sField.equals("bookName")){
					sql+=" or "+sField +" like '%"+list.get(i)+"%'";
				}else{
					//sql+=" or "+sField +" ='"+list.get(i)+"'";
					sql+=" or "+sField +" like '%"+list.get(i)+"%'";
				}
				
			}
		}
		if(!sql.equals("")){
			sql=" and ("+sql+")";
		}
		sql="SELECT distinct book.* from site_class_book LEFT JOIN book ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId "
				 + "where book.onlineStatus=1 and site_class.siteId=? and book.bookId!=? "+sql+" ORDER BY book.btype,book.bookId"; 
		return sql; 
	}
	
	/***************************电子书*******************************/
	
	public static String getEbookClassInfo(){
		return "select * from site_ebookclass WHERE siteId=? ORDER BY sort";
	}
	public static String getEbookClassBookList(){
		return "SELECT distinct book.* from site_ebookclass_book LEFT JOIN book ON book.bookId=site_ebookclass_book.bookId where book.onlineStatus=1 and book.onlineStatus=1 and site_ebookclass_book.classId=?  ORDER BY site_ebookclass_book.bookSort,site_ebookclass_book.bookId";
	}
	public static String getEbookNameHitList(int sType,String sw){
		String typeSql="";
		if(sType==1){
			typeSql="(bookName LIKE '%"+sw+"%')";
		}else if(sType==2){
			typeSql="(authorName LIKE '%"+sw+"%')";
		}else if(sType==3){
			typeSql="(anchorName LIKE '%"+sw+"%')";
		}else if(sType==4){
			typeSql="(keywords LIKE '%"+sw+"%')";
		}else {
			typeSql="(bookName LIKE '%"+sw+"%' OR authorName  LIKE '%"+sw+"%' OR anchorName  LIKE '%"+sw+"%')";
		}
		
		return "SELECT distinct book.* from site_ebookclass_book LEFT JOIN book  ON book.bookId=site_ebookclass_book.bookId LEFT JOIN site_ebookclass ON site_ebookclass_book.classId=site_ebookclass.classId "
			 + "where book.onlineStatus=1 and site_ebookclass.siteId=? AND "+typeSql; 
	}
	public static String getEbookMuluHitList(String sw){
		return "SELECT distinct book.* from site_ebookclass_book LEFT JOIN book  ON book.bookId=site_ebookclass_book.bookId LEFT JOIN site_ebookclass ON site_ebookclass_book.classId=site_ebookclass.classId "
			 + "where book.onlineStatus=1 and site_ebookclass.siteId=? AND catalog LIKE '%"+sw+"%' and bookName not LIKE '%"+sw+"%' and authorName not LIKE '%"+sw+"%' and anchorName not LIKE '%"+sw+"%'"; 
	}
	public static String getEbookMuluHitCount(String sw){
		return "SELECT count(distinct book.bookid) as icount from site_ebookclass_book LEFT JOIN book  ON book.bookId=site_ebookclass_book.bookId LEFT JOIN site_ebookclass ON site_ebookclass_book.classId=site_ebookclass.classId "
			 + "where book.onlineStatus=1 and site_ebookclass.siteId=? AND catalog LIKE '%"+sw+"%' and bookName not LIKE '%"+sw+"%' and authorName not LIKE '%"+sw+"%' and anchorName not LIKE '%"+sw+"%'"; 
	}
	public static String getEbookSummaryHitList(String sw){
		return "SELECT distinct book.* from site_ebookclass_book LEFT JOIN book  ON book.bookId=site_ebookclass_book.bookId LEFT JOIN site_ebookclass ON site_ebookclass_book.classId=site_ebookclass.classId "
			 + "where book.onlineStatus=1 and site_ebookclass.siteId=? AND summary LIKE '%"+sw+"%' and bookName not LIKE '%"+sw+"%' and authorName not LIKE '%"+sw+"%' and anchorName not LIKE '%"+sw+"%' and catalog not LIKE '%"+sw+"%'"; 
	}
	public static String getEbookSummaryHitCount(String sw){
		return "SELECT count(distinct book.bookid) as icount from site_ebookclass_book LEFT JOIN book  ON book.bookId=site_ebookclass_book.bookId LEFT JOIN site_ebookclass ON site_ebookclass_book.classId=site_ebookclass.classId "
			 + "where book.onlineStatus=1 and site_ebookclass.siteId=? AND summary LIKE '%"+sw+"%' and bookName not LIKE '%"+sw+"%' and authorName not LIKE '%"+sw+"%' and anchorName not LIKE '%"+sw+"%' and catalog not LIKE '%"+sw+"%'"; 
	}
	public static String initEbookClassInfo(){
		return "SELECT site.siteId,site_ebookclass_book.classId ,site_ebookclass.className,site_ebookclass_book.bookId"
				+" from site_ebookclass_book LEFT JOIN site_ebookclass on site_ebookclass_book.classId=site_ebookclass.classid"
				+" LEFT JOIN site ON site_ebookclass.siteId = site.siteId ORDER BY site.siteId,site_ebookclass.classId";
	}
	public static String getEbookInfoByBookId(){
		return "select * from book where bookId=? and book.onlineStatus=1";
	}
	public static String readEbook(){
		return "SELECT book.bookName,book.btype,book_article.audio from book LEFT JOIN book_article ON book.bookId=book_article.bid WHERE book.bookId=?";
	}
	public static String getSuggestWords(){
		return "SELECT * FROM sitekeywords WHERE siteId=? ORDER BY showSort";
	}
	public static String GetCueWords(String sw){
		return "SELECT distinct book.bookId,book.bookName,book.authorName,book.anchorName,book.keywords,site_class_book.bookSort"
			   +" FROM book LEFT JOIN site_class_book ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId"
			   +" WHERE site_class.siteId=? AND (REPLACE(REPLACE(REPLACE(,' ','' ),'（',''),'）','') LIKE '%"+sw+"%' OR book.authorName LIKE '%"+sw+"%' or book.anchorName LIKE '%"+sw+"%' OR book.keywords LIKE '%"+sw+"%') ORDER BY site_class_book.bookSort";
	}
	public static String getBookByIsbn(String isbn){
		return "SELECT distinct book.bookId,book.bookName,book.authorName,book.anchorName,book.bookimg"
			   +" FROM book LEFT JOIN site_class_book ON book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId"
			   +" WHERE site_class.siteId=? AND book.isbnlist  like '%"+isbn+"%'";
	}
	
	/*******************小程序操作 个人中心有接口，单位因为https原因，功能签至此一份，目的在于服务于小程序***************/
	public static String getUntilList(String authType){
		return "select * from opacUntil where iState=1 "+authType+" order by proSort ASC,sort ASC";
	}
	public static String getUntilListByLetter(String authType){
		return "select * from opacUntil where iState=1 "+authType+" order by firstletter ASC,sort ASC";
	}
	public static String xinyuCardAuth(){
		return "select xinyuCard.*,unit.unitStatus,unit.validity from xinyuCard LEFT JOIN unit ON xinyuCard.untiId=unit.unitId where cardNumber=?";
	}
	public static String updateFirstUseDate(){
		return "update xinyuCard set firstUseDate=? where cardNumber=?";
	}
	public static String authCardUser(){
		return "select * from opacUntil where iState=1 and untilId=?";
	}
	public static String isCardNumExit(String openId){
		if(openId.equals("")){
			return "select perUserId,cardNum from userinfo where utilId=? and cardNum=? and (wxOpenId='' or wxOpenId is null)";
		}else{
			return "select perUserId,cardNum from userinfo where utilId=? and cardNum=? and wxOpenId='"+openId+"'";
		}
	}
	public static String cardNumRegist(){
		return "INSERT INTO userinfo(wxOpenId,utilId,cardNum,trueName,usersex,userTelNum,userEmail,organization,registeTime) values(?,?,?,?,?,?,?,?,?)";
	}
	public static String getSiteIdByUnitId(){
		return "SELECT siteId,isebook,validity from unit WHERE unitId =? AND validity>=?";
	}
	public static String getHistoryList(){
		return "select * from history where perUserId=? order by lasttime desc";
	}
	public static String getUserInfo(){
		return "select * from userinfo where perUserId=?";
	}
	public static String updateUserInfo(){
		return "update userinfo set trueName=?,usersex=?,userTelNum=?,userEmail=?,organization=? where perUserId=?";
	}
	public static String updateLoginTime(int loginType,int perUserId){
		String sql=" set lastloginTime='"+StringUtil.getFullTime()+"'";
		if(loginType==1){
			sql=sql+",cardBindTime='"+StringUtil.getFullTime()+"'";
		}
		return "update userinfo "+sql+" where perUserId="+perUserId;
	}
	/*************************** openapi *************************************/
	public static String getUntilInfoByUntilId(){
		return "select unit.*,site.cssPackage,site.domainName,site.wxDomain from unit LEFT JOIN site on unit.siteId=site.siteId where unitId=?";
	}
	public static String getUntilUserInfoByUntilId(){
		return "select unit.unitId,unit.unitStatus,unit.siteId,unit.validity,unit.secretKey,site.cssPackage,site.domainName,site.wxDomain,`user`.userId,`user`.`status`,`user`.validity AS uservalidity "
			  +"from unit LEFT JOIN site on unit.siteId=site.siteId LEFT JOIN `user` ON `user`.unitId=unit.unitId where unit.unitId=? AND `user`.type=?";
	}
	public static String getChapteInfo(){
		return "SELECT * FROM book_article WHERE bid=? AND id=? AND bid in(SELECT bookid FROM site_class_book WHERE classid in(SELECT classid FROM site_class WHERE siteid=?)) AND bid in(SELECT bookid FROM book WHERE onlineStatus=1)";
	}
	public static String getUpdateBookList(){
		return "SELECT distinct book.* FROM book LEFT JOIN site_class_book on book.bookId=site_class_book.bookId LEFT JOIN site_class ON site_class_book.classId=site_class.classId"
			  +" where site_class.siteId=? AND site_class_book.intertTime>=? AND site_class_book.intertTime<=? and book.onlineStatus=1";
	}
	public static String getRemoveBookList(){
		return "SELECT * from book where bookId in(SELECT bookId from site_class_book WHERE classid in(SELECT classId FROM site_class WHERE siteId=?)) AND onlineStatus=-1 AND lowerTime>? AND lowerTime<?";
	}
	
	/*************************** planapi *************************************/
	public static String getPlanList() {
		return"SELECT planinfo.unitId, planinfo.pSort, planinfo.lastOper,planinfo.planId,planinfo.planName,planinfo.planDesc,planinfo.planCycle,planinfo.hasPager, planbooks.bookCover,planbooks.fileSize,planbooks.times,planbooks.bookName, planbooks.bookId, planbooks.bsort ,planbooks.chapterNum,plan_user.createTime,plan_user.joinTime  FROM planinfo LEFT JOIN planbooks ON planinfo.planId=planbooks.planId LEFT JOIN plan_user ON planinfo.planId=plan_user.planId and plan_user.userId=?  WHERE planinfo.planState=1 and planinfo.unitId=?  order by pSort, bsort";
	}
	public static String getPlanInfo() {
		return"select planinfo.planId,planinfo.planName,planinfo.planDesc,planinfo.planCycle,planinfo.hasPager, planbooks.bookId, planbooks.bsort ,planbooks.chapterNum,plan_user.createTime,plan_user.joinTime  from planinfo LEFT JOIN planbooks ON planinfo.planId=planbooks.planId LEFT JOIN plan_user ON planinfo.planId=plan_user.planId   where planinfo.planId=? and plan_user.userId=?  order by bsort";
	}
	
	public static String getUserPlan() {
		return"select plan_user.cbookId,plan_user.ccid,plan_user.planId from plan_user,planinfo where plan_user.userId=? and plan_user.pustate=1 and plan_user.planId=planinfo.planId and planinfo.unitId=? order by  plan_user.createTime desc";
	}
	public static String exzitUserPlan() {
		return"select * from plan_user where userId=? and planId=?";
	}
	public static String joinPlan() {
		return "insert into plan_user(userId,planId,joinTime,pustate) values(?,?,?,1)";
	}
	public static String updateJoinPlan() {
		return "update plan_user set pustate=1,createTime=?,joinTime=? where puId=?";
	}
	public static String deleteJoinPlan() {
		//return "update plan_user set pustate=0 where userId=? and planId=?";
		return "DELETE FROM plan_user where userId=? and planId=?";
	}
	public static String updateUserPlan() {
		return"update plan_user set cbookId=?,ccid=?,createTime=?,totalCount=?,currentCount=? where userId=? and planId=?";
	}
	
	public static String getPlanInfoForUser() {
		return"select * from plan_user where userId=? and planId=?";
	}
	public static String getQueryPlan() {
		return"select count(1) from planinfo where unitId=? and planState=1";
	}
	
	public static String getPlanInfowhithIds(Object[] ids,int userId) {
		StringBuffer buffer=new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			buffer.append(ids[i].toString()+",");
		}
		return"SELECT planinfo.unitId, planinfo.pSort, planinfo.lastOper,planinfo.planId,planinfo.planName,planinfo.planDesc,planinfo.planCycle,planinfo.hasPager, planbooks.bookCover,planbooks.fileSize,planbooks.times,planbooks.bookName, planbooks.bookId, planbooks.bsort ,planbooks.chapterNum,plan_user.createTime,plan_user.joinTime  "
		+"FROM planinfo LEFT JOIN planbooks ON planinfo.planId=planbooks.planId LEFT JOIN plan_user ON planinfo.planId=plan_user.planId and plan_user.userId="+userId+" WHERE  planinfo.planId in("+buffer.substring(0, buffer.length()-1)+")  order by plan_user.createTime DESC, bsort";
	}
	
	public static String  getUserPlanSubject() {
		return "select question from user_paper where userId=? and pagerId=(select pagerId from plan_pager where planId=?)";
	}
	
	public static String getPlanSubject() {
		return"select * from plan_pager where planId=?";
	}
	
	
	public static String updataUserPlanSubject() {
		return "update user_paper set question=?,finishTime=? where userId=? and pagerId=(select pagerId from plan_pager where planId=?)";
	}
	public static String saveUserPlanSubject() {
		return"insert into user_paper(userId,pagerId,question,finishTime) values(?,(select pagerId from plan_pager where planId=?),?,?)";
	}
	
	public static String submitPager_save() {
		return "insert into user_paper(userId,pagerId,question,answerState,finishTime,selectScore) values(?,(select pagerId from plan_pager where planId=?),?,1,?,?)";
	}
	
	public static String submitPaper_updata() {
		return "update user_paper set answerState=1,question=?,finishTime=?,selectScore=? where userId=? and pagerId=(select pagerId from plan_pager where planId=?)";
	}
	public static String exzistUserSubject() {
		return"select * from user_paper where userId=? and pagerId=(select pagerId from plan_pager where planId=?)";
	}
	/*****************个人中心微信登录****************/
	public static String isWxRegist() {
		return"select * from userinfo where wxOpenId=?";
	}
	public static String wxRegist(){
		return "INSERT INTO userinfo(utilId,wxOpenId,registeTime) values(?,?,?)";
	}
	
	/*****************小程序微信登录****************/
	
	public static String queryUserInfo() {
		return "select * from userinfo where cardNum=? order by cardBindTime";
	}
	public static String queryUserInfo_nowx() {
		return "select * from userinfo where cardNum=? and utilId=? and (wxOpenId='' or wxOpenId is null)";
	}
	
	public static String queryUserInfo1() {
		return "select * from userinfo where wxOpenId=?";
	}
	public static String bindWX() {
		return "update userinfo set wxOpenId=?,cardBindTime=?,trueName=?,usersex=? where perUserId=?";
	}
	public static String bindWX1(String unitId,String wxopenId,String cardNum,String cardBindTime,String name,int sex) {
		return "insert into userinfo(utilId,wxOpenId,cardNum,cardBindTime,trueName,usersex) values("+unitId+",'"+wxopenId+"','"+cardNum+"','"+cardBindTime+"','"+name+"',"+sex+")";
	}
	public static String  bindWX2() {
		return "update userinfo set cardNum=?,cardBindTime=? where perUserId=?";
	}
	public static String getCardInfo() {
		return "select * from xinyuCard where cardNum=? and utilId=?";
	}
	public static String updateBindTime() {
		return "update userinfo set cardBindTime=? where wxOpenId=?";
	}
	public static String insertUserInfo(int utilId,String cardNum) {
		return "insert into userinfo(utilId,cardNum) values("+utilId+",'"+cardNum+"')"; 
	}
	public static String  bindwx3(String cardNum,String time,String openid,String utilId) {
		return "update userinfo set cardNum='"+cardNum+"',cardBindTime='"+time+"',utilId="+utilId+" where wxOpenId='"+openid+"'";
	}
	public static String getcard() {
		return "select xinyuCard.status, xinyuCard.password,xinyuCard.firstUseDate,xinyuCard.expiryDays,xinyuCard.showName,xinyuCard.untiId,xinyuCard.siteId,xinyuCard.isebook,unit.unitStatus,unit.validity,unit.customName,unit.unitId from xinyuCard LEFT JOIN unit ON unit.unitId=xinyuCard.untiId where xinyuCard.cardNumber=? and  xinyuCard.untiId=?";
	}
	public  static String regitsterWX(String openId,String nickName,int sex) {
		 return "insert into userinfo(wxOpenId,trueName,usersex) values('"+openId+"','"+nickName+"',"+sex+")"; 
	}
	public static String getUnitInfo() {
		return "select * from unit where unitId=?";
	}
	
	//收藏管理
	public static String addFav(){
		return "INSERT INTO collection(perUserId,bookId,bookName,cover,bookUrl,author,aothor,chapterNum,untilUserId,userIp,favtime) values(?,?,?,?,?,?,?,?,?,?,?)";
	}
	public static String isHasFav(){
		return "select bookId from collection where bookId=? and perUserId=?";
	}
	public static String getFavList(){
		return "select * from collection where perUserId=? order by favId desc";
	}
	public static String delFav(){
		return "DELETE FROM collection where bookId=? and perUserId=?";
	}
	//听书历史管理
	public static String addHis(){
		return "INSERT INTO history(perUserId,bookId,chapterId,chapterNum,sort,playIndex,playPosition,bookName,title,cover,bookUrl,author,aothor,lasttime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}
	public static String isHasHis(){
		return "select bookId from history where bookId=? and perUserId=?";
	}
	public static String updateHis(){
		return "update history set chapterId=?,chapterNum=?,sort=?,playIndex=?,playPosition=?,title=?,bookUrl=?,lasttime=? where bookId=? and perUserId=?";
	}
	public static String getDistoryList(){
		return "select * from history where perUserId=? order by lasttime desc";
	}
	//听书时长管理
	public static String addListenRecord(){
		return "INSERT INTO listeninfo(perUserId,ListenDate,ListenTimes) values(?,?,?)";
	}
	public static String isHasListenRecord(){
		return "select * from listeninfo where perUserId=? and ListenDate=?";
	}
	public static String updateListenRecord(){
		return "update listeninfo set ListenTimes=? where ListenId=?";
	}
	public static String getListenRecord(){
		return "select * from listeninfo where perUserId=? ORDER BY ListenId DESC";
	}
	public static String addTouchLog() {
		return "insert into touch_log(touchcode,machinecode,updateTime) values(?,?,?)";
	}
	public static String updateTouchLog() {
		return "update touch_log set updateTime=? where touchcode=? and machinecode=?";
	}
	
	public static String queryLog() {
		return "select * from touch_log where touchcode=? and machinecode=?";
	}
	
	// 听书时间活动
	public static String getmatyId() {
		return "select matyId from m_joinaty where perUserId=? order by joinId desc";
	}
	public static String getmAtyInfo() {
		return "select * from m_aty where unitId=? and endTime>="+"'"+StringUtil.getFullDate()+"'";
	}
	public static String gethasAtyUnit(){ 
		return "select * from m_aty where endTime>="+"'"+StringUtil.getFullDate()+"' and '"+StringUtil.getFullDate()+"'  >=startTime and unitId=? order by matyId desc";
	}
	
	// AI
	public static String getAIAction(String sw) {
		return "select ai_action_desc.actionId, ai_action.actionName from ai_action_desc LEFT JOIN ai_action on ai_action_desc.actionId=ai_action.actionId where ai_action_desc.actiondesc like '%"+sw+"%'";
	}
	public static String getactions() {
		return "select * from ai_action";
	}
	public static String  getActionsDesc() {
		return "select * from ai_action_desc order by length(actiondesc)";
	}
	public static String saveAiLog() {
		return "insert into ailog(userword,resultword,resultaction) values(?,?,?)";
	}
	// userapply
	public static String saveUserApply() {
		return "insert into feedback(userId,phoneCode,userName,telNum,email,province,city,county,content,feedBackIp,feedBackTime) values(?,?,?,?,?,?,?,?,?,?,?)";
	}
	public static String getFeedBackInfo(int userId,String phoneCode) {
		if(!phoneCode.equals("")){
			return "select * from feedback where phoneCode='"+phoneCode+"'";
		}else{
			return "select * from feedback where userId="+userId;
		}
	}
	public static String getLisenterList() {
		return"SELECT userinfo.perUserId, userinfo.utilId, userinfo.trueName,SUM(listeninfo.ListenTimes) AS usertime FROM listeninfo LEFT JOIN userinfo ON listeninfo.perUserId=userinfo.perUserId WHERE listeninfo.ListenDate>=? GROUP BY listeninfo.perUserId  ORDER BY usertime DESC";
	}
	public static String getUserTime() {
		return "select SUM(listeninfo.ListenTimes) AS usertime FROM listeninfo LEFT JOIN userinfo ON  listeninfo.perUserId=userinfo.perUserId WHERE listeninfo.perUserId=? and listeninfo.ListenDate>=?  GROUP BY listeninfo.perUserId";
	}
	
	public static String getunitNames() {
		return "select unitId, unitName from unit";
	}
	
	// 专题
	public static String getCurrentSpecial() {
		return "select * from lib_special where unitId=?";
	}
	
	public static String getSpecialDetail() {
		return "select * from lib_book where specialId=? and onlineStatus=1 order by sort";
	}
	
	public static String getSpecialBookDetail() {
		return "select lib_book.*,lib_special.speciaName from lib_book LEFT JOIN lib_special ON lib_book.specialId=lib_special.specialId where bookId=?";
	}
	
	public static String getSpecialAuthors() {
		return "select * from lib_author where authorId=? and status=1";
	}
	
	public static String getAuthorsSpecial(String sw) {
		return "select * from lib_book where authorNameIds like '%"+sw+"%'";
	}
	
	//years
	public static String getyearsbook() {
		return "select * from yearslog where pUserId=?";
	}
	
	public static String getbookclassName() {
		return "select site_class_book.bookId,site_class.className,site_class.classId from site_class_book LEFT JOIN site_class ON site_class_book.classId=site_class.classId  where bookId in";
	}
	
	public static String getYearsUserLisener() {
		return "select perUserId,SUM(ListenTimes) as totalcount from listeninfo where ListenDate>='2019-01-01' and ListenDate<='2019-12-31' group by perUserId order by totalcount desc";
	}
	
	public static String getYsears_Month() {
		return"select perUserId,round(SUM(ListenTimes)/60) as time, left(listeninfo.ListenDate, 7) as month from listeninfo where perUserId=? and ListenDate<'2020-01-01' group by month order by month";
	}
	
	public static String getUserbooks() {
		return"select site_class_book.classId,site_class_book.bookId,site_class.className from site_class_book left join site_class on site_class_book.classId=site_class.classId where site_class_book.classId in (select classId from site_class where siteId=?) and bookId in";
	}
	
	// flexibleclass
	public static String getlocationinfo() {
		return "select * from flexible_class where siteId=? and appLocation=? and online=1 order by sort";
	}
	public static String getChildClass() {
		return "select classId, className,sort,datatype from flexible_class where pClassId=? and online=1";
	}
	public static String getChildClassInfo() {
		return "select * from flexible_class where classId=? and online=1";
	}
	
	public static String getFlexClassData(int datatype,int classId) {
		if (datatype==1) {// 有声书
			return "select flexible_class_detail.img, flexible_class_detail.sort,book.* from flexible_class_detail left join book on flexible_class_detail.bookId=book.bookId where classId="+classId+ " order by flexible_class_detail.sort";
		}else if(datatype==2) {//关键词
			return "select detailId,dataType,sort,img,contenttitle,keywordType from flexible_class_detail where classId="+classId+ " order by flexible_class_detail.sort";
		}else { //推文
			return "select detailId,dataType,sort,img,contenttitle,contentdesc,showStyle,preReDate,articlefrom from flexible_class_detail where classId="+classId+ " and preReDate<='"+StringUtil.getFullDate()+"' order by preReDate DESC,detailId DESC";
		}
	};
	public static String getArticleDetail() {
		return "select * from flexible_class_detail where detailId=?";
	}
	public static String getAPIList() {
		return "select * from vipstatic where showState=1 and VIPstate=1  order by VIPSort";
	}
	// 活动
	public static String getAtyInfoByUserId() {
		return "select m_aty.matyId,m_aty.unitId,m_aty.startTime,m_aty.endTime,m_joinaty.jointime from m_joinaty left join m_aty on m_joinaty.matyId=m_aty.matyId where m_joinaty.perUserId=? order by m_aty.endTime desc";
	}
	public static String getAtyLisenerInfo() {
		return"select m_joinaty.joinTime,m_joinaty.perUserId, userinfo.trueName,userinfo.cardNum,SUM(listeninfo.ListenTimes) AS atytime FROM m_joinaty "
	   +"LEFT JOIN listeninfo on m_joinaty.perUserId=listeninfo.perUserId and listeninfo.ListenDate>=m_joinaty.joinTime and listeninfo.ListenDate<=? "
				+"LEFT JOIN userinfo on m_joinaty.perUserId=userinfo.perUserId"
				+" WHERE m_joinaty.matyId=? GROUP BY m_joinaty.perUserId  ORDER BY atytime DESC";
	}
	
	public static String getAtyByUnit() {
		return"select * from m_aty where unitId=? order by endTime desc";
	}
	public static String userHasJoinAty() {
		return"select * from m_joinaty where perUserId=? and matyId=?";
	}
	public static String joinAty() {
		return"insert m_joinaty(matyId,perUserId,joinTime) values(?,?,?)";
	}
	public static String getAtyByAtyId() {
		return "select * from m_aty where matyId=?";
	}
	public static String getatydas() {
		return "select count(*) from listeninfo where perUserId=? and ListenDate>=? and ListenDate<=? group by perUserId";
	}
	
}

