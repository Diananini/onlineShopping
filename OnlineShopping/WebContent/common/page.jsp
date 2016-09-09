<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<style type="text/css">
.page_bg td{ background:#d9ecf2; height:24px; border-bottom:1px solid #abc4de;}
</style>
<table width="100%" align="center" cellpadding="0" cellspacing="0">
  <c:choose>
  	  <c:when test="${request.iPageObjectTag[1]==0}">
  	  	 <tr>
		    <td align="right" height="40"><img src="${pageContext.request.contextPath}/common/images/turnpage_ico.gif" width="36" height="36" /></td>
		    <td colspan="9" class="font14_blue_line30">&nbsp;&nbsp;&nbsp;当前没有相关信息！</td>
		  </tr>
  	  </c:when>
  	  <c:when test="${request.iPageObjectTag[1]==1}">
  	    <tr class="page_bg">
		    <td height="35" colspan="10" class="font12_blue">&nbsp;&nbsp; 共有 <strong><span id="count"><c:out value="${iPageObjectTag[0]}"/></span></strong> 条记录!</td>
		</tr>
  	  </c:when>
  	  <c:otherwise>
  	  	    <tr class="page_bg">
			    <td style="width:10%; " height="35" nowrap="nowrap" >&nbsp;&nbsp;共有 <strong><span id="count"><c:out value="${iPageObjectTag[0]}"/></span></strong>条记录&nbsp;</td>
			    <td style="width:12%;" nowrap="nowrap">&nbsp;当前第 <strong><c:out value="${iPageObjectTag[2]}"/></strong> 页/共 <strong><c:out value="${iPageObjectTag[1]}"/></strong> 页</td>
			    <td style="width:63%; line-height:35px; vertical-align:middle; padding-top:5px; padding-right:5px;" valign="middle" align="right" nowrap="nowrap">
			    	<img title="第一页" src="${pageContext.request.contextPath}/common/images/dg_btn_lt_end.gif" border="0" onclick="toPage(1)" style="cursor:hand"/>&nbsp;
			    	<img title="上一页" src="${pageContext.request.contextPath}/common/images/dg_btn_lt.gif" border="0" onclick="toPage(${iPageObjectTag[2]-1})" style="cursor:hand"/>&nbsp;
			    	<img title="下一页" src="${pageContext.request.contextPath}/common/images/dg_btn_rt.gif" border="0" onclick="toPage(${iPageObjectTag[2]+1})" style="cursor:hand"/>&nbsp;
			    	<img title="最后一页" src="${pageContext.request.contextPath}/common/images/dg_btn_rt_end.gif" border="0" onclick="toPage(${iPageObjectTag[1]})" style="cursor:hand"/></td>
			    <td style="width:9%;" nowrap="nowrap">到第 <input id="tagCurPage" size="2" maxlength="3" onkeypress="return myKeyPress(event);" style="cursor:hand; position:relative; top:2px; height:16px; padding:0px; margin:0px;"/> 页</td>
			    <td style="width:5%;" colspan="6" nowrap="nowrap">&nbsp;<img src="${pageContext.request.contextPath}/common/images/turnpage_go.gif" width="24" height="20" border="0" title="GO" onclick="toPage(-1)" style="cursor:hand; position:relative; top:2px;"/></td>
			</tr>
	  <script>
		var pageCount=${iPageObjectTag[1]};
		var curPage=${iPageObjectTag[2]};
		function toPage(pageNo){
		   if(pageNo<0){
		     var tagCurPage=document.getElementById("tagCurPage").value
			 if(tagCurPage.length>0){
			    pageNo=parseInt(tagCurPage);
			 }
		   }
		   if(pageNo==curPage || pageNo<1 || pageNo>pageCount){
				  return;
		   }
		   if(${sPageObjectTag[1]}==''){
		   		window.location="${sPageObjectTag[0]}curPage="+pageNo+"&amp;dataCount="+${iPageObjectTag[0]};
		   }else{
		   	    ${sPageObjectTag[1]}(pageNo);
		   }  
		}
		function myKeyPress(evt){
		    evt = (evt) ? evt : ((window.event) ? window.event : "") //兼容IE和Firefox获得keyBoardEvent对象
		    var key = evt.keyCode?evt.keyCode:evt.which; //兼容IE和Firefox获得keyBoardEvent对象的键值
		    if((key < 48 || key > 57)){
		        return false;
		    }
		}
	  </script>
  	  </c:otherwise>
  </c:choose>

</table>
