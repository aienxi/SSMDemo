package com.xinyu.tool;


public class PageManager {
	
	private int iBpage=1;
	private int iEpage=1;
	private int iAllPage=1;


	//获取总页数
	private int getPageCount(int iRecordCount,int iPageSize){
		return (iRecordCount-1)/iPageSize+1;
	}
	
	public void getBpageCount(int iRecordCount,int iPageSize,int iCurPage){
		this.iAllPage=getPageCount(iRecordCount,iPageSize);
		if(iAllPage<=10){
			this.iBpage=1;
			this.iEpage=iAllPage;
		}else{
			if(iCurPage<=5){
				this.iBpage=1;
				this.iEpage=10;
			}else if(iCurPage>iAllPage-5){
				this.iBpage=iAllPage-9;
				this.iEpage=iAllPage;
			}else{
				this.iBpage=iCurPage-4;
				this.iEpage=iCurPage+5;
			}
		}
	}

	public int getiBpage() {
		return iBpage;
	}

	public void setiBpage(int iBpage) {
		this.iBpage = iBpage;
	}

	public int getiEpage() {
		return iEpage;
	}

	public void setiEpage(int iEpage) {
		this.iEpage = iEpage;
	}

	public int getiAllPage() {
		return iAllPage;
	}

	public void setiAllPage(int iAllPage) {
		this.iAllPage = iAllPage;
	}
	
	
}
