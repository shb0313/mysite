<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
				<form:form 
					modelAttribute="userVo"
					id="join-form" 
					name="joinForm" 
					action="${pageContext.request.contextPath }/user/join" 
					method="post">
					
					<label class="block-label" for="name">이름</label>
					<form:input path="name" />
						
						<spring:hasBindErrors name="userVo">
							<c:if test="${errors.hasFieldErrors('name') }">
								<p style="color:#f00; text-align:left; padding:0">
									<!-- 
										${errors.getFieldError("name").defaultMessage }
									 -->
									<spring:message code='${errors.getFieldError("name").codes[0] }' />
								</p>
							</c:if>
						</spring:hasBindErrors>

					<label class="block-label" for="email">이메일</label>
					<form:input path="email" />
					<input type="button" value="중복체크">
					<p style="color:#f00; text-align:left; padding:0">
						<form:errors path="email" />
					</p>
									
					<label class="block-label">
						<spring:message code="user.join.label.password" />
					</label>
					<form:password path="password" />
						<p style="color:#f00; text-align:left; padding:0">
							<form:errors path="password" />
						</p>
						
					<fieldset>
						<legend>성별</legend>
						<form:radiobutton path="gender" value="female" label="여자" />
						<form:radiobutton path="gender" value="male" label="남자" />
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form:form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
</html>