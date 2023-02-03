<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="user">
				<form id="join-form" name="joinForm" action="${pageContext.request.contextPath }/user/join" method="post">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="">
					<p style="color:#f00; text-align:left; padding:0">
						<spring:hasBindErrors name="userVo">
							<c:if test="${errors.hasFieldErrors('name') }">
								<!-- 
									${errors.getFieldError("name").defaultMessage }
								 -->
								<spring:message code='${errors.getFieldError("name").codes[0] }' />
							</c:if>
						</spring:hasBindErrors>
					</p>

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					<input type="button" value="중복체크">
					<p style="color:#f00; text-align:left; padding:0">
						<spring:hasBindErrors name="userVo">
							<c:if test="${errors.hasFieldErrors('email') }">
								${errors.getFieldError("email").defaultMessage }
							</c:if>
						</spring:hasBindErrors>
					</p>
										
					<label class="block-label">
						<spring:message code="user.join.label.password" />
					</label>
					<input name="password" type="password" value="">
					<p style="color:#f00; text-align:left; padding:0">
						<spring:hasBindErrors name="userVo">
							<c:if test="${errors.hasFieldErrors('password') }">
								${errors.getFieldError("password").defaultMessage }	
							</c:if>
						</spring:hasBindErrors>
					</p>
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
						<label>남</label> <input type="radio" name="gender" value="male">
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
</html>