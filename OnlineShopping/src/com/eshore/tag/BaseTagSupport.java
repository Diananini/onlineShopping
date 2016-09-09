package com.eshore.tag;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 *基本的标签类
 */
public class BaseTagSupport extends TagSupport{

	private static final long serialVersionUID = 1L;

	protected ServletRequest getRequest(){
		return pageContext.getRequest();
	}
}
