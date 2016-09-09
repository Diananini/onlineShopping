package com.eshore.tag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageObject {

	private final int DEFAULT_PAGE_SIZE = 10;// 默认显示记录数

	private final int DEFAULT_CUR_SIZE = 1;// 默认当前页

	private List data;// 数据列表

	private int dataCount;// 数据总数

	private int pageSize;// 显示记录数

	private int pageCount;// 总页数

	private int curPage;// 当前页

	public int getCurPage() {//获得当前页
		if (curPage < DEFAULT_CUR_SIZE) {
			curPage = DEFAULT_CUR_SIZE;
		}
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageCount() {//获得页数
		if (dataCount > 0) {
			pageCount = dataCount % pageSize == 0 ? (dataCount / pageSize) : (dataCount / pageSize + 1);
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		if (pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void reqProperty(HttpServletRequest request) {
		String curPage = null, pageSize = null, dataCount = null;

		curPage = request.getParameter("curPage");//设定当前页数
		if (curPage != null && curPage != "") {
			try {
				this.curPage = Integer.valueOf(curPage).intValue();
			} catch (NumberFormatException ex) {
			}
		}

		pageSize = request.getParameter("pageSize");//设定每页的显示数量
		if (pageSize != null && pageSize != "") {
			try {
				this.pageSize = Integer.valueOf(pageSize).intValue();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}

		dataCount = request.getParameter("dataCount");//设定总数量
		if (dataCount != null && dataCount != "") {
			try {
				this.dataCount = Integer.valueOf(dataCount).intValue();
			} catch (NumberFormatException ex) {
				ex.printStackTrace();
			}
		}
	}

	public int getBeginPoint() {//获取开始的数据点
		return (getCurPage() - 1) * getPageSize();
	}
	//获得PageObject对象
	public static PageObject getInstance(HttpServletRequest request) {
		PageObject pageObject = new PageObject();
		pageObject.reqProperty(request);
		return pageObject;
	}
}

