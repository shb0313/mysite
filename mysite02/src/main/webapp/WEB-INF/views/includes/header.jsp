<<<<<<< HEAD
<%@page import="org.apache.taglibs.standard.tag.common.core.ChooseTag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="header">
	<h1>MySite</h1>
	<ul>
		<c:choose>
			<c:when test="${empty authUser }">
				<li><a href="${pageContext.request.contextPath }/user?a=loginform">로그인</a>
				<li>
				<li><a href="${pageContext.request.contextPath }/user?a=joinform">회원가입</a>
				<li>
			</c:when>
	
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath }/user?a=updateform">회원정보수정</a>
				<li>
				<li><a href="${pageContext.request.contextPath }/user?a=logout">로그아웃</a>
				<li>
				<li>${authUser.name }님 안녕하세요 ^^;</li>
			</c:otherwise>
		</c:choose>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="header">
	<h1>MySite</h1>
	<ul>
		<li><a href="<%=request.getContextPath()%>/user?a=loginform">로그인</a>
		<li>
		<li><a href="<%=request.getContextPath()%>/user?a=joinform">회원가입</a>
		<li>
		<li><a href="<%=request.getContextPath()%>/user?a=updateform">회원정보수정</a>
		<li>
		<li><a href="<%=request.getContextPath()%>/user?a=logout">로그아웃</a>
		<li>
		<li>님 안녕하세요 ^^;</li>
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
	</ul>
</div>