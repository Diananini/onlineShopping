package com.eshore.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CopyRightTag extends BodyTagSupport{
	private static final long serialVersionUID = 1L;
	private String user;
	private String startY;
    @Override
    public int doStartTag(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    	String endY = sdf.format(new Date());
    	String copyRight = user+"&nbsp;版权所有&nbsp;&nbsp;@copyright "+startY+"-"+endY;
    	try {
			pageContext.getOut().print(copyRight);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return EVAL_PAGE; 
    }
    public int doAfterBody(){
    	//取得标签体
    	BodyContent bc = getBodyContent();
    	JspWriter out = getPreviousOut();
    	try{
    		//将标签体中的内容写入到JSP页面中
    		out.write(bc.getString());
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	return EVAL_BODY_AGAIN;
    }
    public int doEndTag(){
    	return EVAL_PAGE;
    }
	public void setUser(String user) {
		this.user = user;
	}
	public void setStartY(String startY) {
		this.startY = startY;
	}
}
