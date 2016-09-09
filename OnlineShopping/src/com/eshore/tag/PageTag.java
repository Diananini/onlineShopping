package com.eshore.tag;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

public class PageTag extends BaseTagSupport {
	
	private static final Logger log = Logger.getLogger(PageTag.class);
	
	private PageObject object;//分页对象
	
	private String link;//分页链接
	
	private String script; //页面javaScript方法名
	
	public PageObject getObject() {
		return object;
	}

	public void setObject(PageObject object) {
		this.object = object;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public int doStartTag() throws JspException {
		int[] iparams={0,0,0};
		String[] sparams={"",""};
		if(object!=null && object.getData()!=null){
			iparams[0]=object.getDataCount();
			iparams[1]=object.getPageCount();
			iparams[2]=object.getCurPage();
			if(link!=null && link!=""){
				sparams[0]=link;
			}
			if(script!=null && script!=""){
				sparams[1]=script;
			}
			
		}
		getRequest().setAttribute("iPageObjectTag", iparams);
		getRequest().setAttribute("sPageObjectTag", sparams);
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		getRequest().removeAttribute("iPageObjectTag");
		getRequest().removeAttribute("sPageObjectTag");
		return EVAL_PAGE;
	}
}

