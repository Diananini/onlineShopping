package com.eshore.utils;

import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;

import com.eshore.tag.PageObject;

public class SetPageObject {
	
	private SetPageObject(){};
	private static SetPageObject instance=null;
	//获得SetPageObject实例
	public static SetPageObject getInstance(){
		if(instance==null){
			instance = new SetPageObject();
		}
		return instance;
	}
	public PageObject setPageObjectData(String curPage,PageObject pageObject,List<Object> listObject){
		pageObject.setDataCount(listObject.size());// 设置页面总数
        int size = listObject.size();
 		List<Object> list = new ArrayList<Object>();
 		list = setPageObjectData( list, size,curPage,listObject, pageObject);//设置每页的数据
 		pageObject.setData(list);
 		return pageObject;
	}
	//返回添加的数据
	private List<Object> setPageObjectData(List<Object> targetlist,int size,String curPagess,List<Object> sourceTcLogList,PageObject pageObject){
		int count = pageObject.getCurPage() * pageObject.getPageSize();//每页应显示的量
		int curtPage = 1;
		if (curPagess != null) curtPage = Integer.valueOf(curPagess);
		if (curtPage == 1) {// 当前页是第一页
			addData( count, size, 0,targetlist,sourceTcLogList);
		} else {
			int start = (pageObject.getCurPage() - 1)* pageObject.getPageSize();
			addData( count, size, start,targetlist,sourceTcLogList);
		}
		return targetlist;
	}
	//添加数据
	private void addData(int count,int size,int start,List<Object> list,List<Object> papaers){
		if (count > size) {// 首页的总量小于 要显示的量;
			for (int i = start; i < size; i++) {
				list.add(papaers.get(i));
			}
		} else {
			for (int i = start; i < count; i++) {
				list.add(papaers.get(i));
			}
		}
	}
}
