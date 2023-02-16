<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
=======
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="navigation">
	<ul>
<<<<<<< HEAD
		<li><a href="${pageContext.request.contextPath }">신해빈</a></li>
		<li><a href="${pageContext.request.contextPath }/guestbook?a=list">방명록</a></li>
		<li><a href="${pageContext.request.contextPath }/board?page=1">게시판</a></li>
=======
		<li><a href="<%=request.getContextPath()%>">안대혁</a></li>
		<li><a href="<%=request.getContextPath()%>/guestbook?a=list">방명록</a></li>
		<li><a href="<%=request.getContextPath()%>/board">게시판</a></li>
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
	</ul>
</div>