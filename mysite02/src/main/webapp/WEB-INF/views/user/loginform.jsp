<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

=======
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String email = (String)request.getAttribute("email");
%>
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<<<<<<< HEAD
<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="${pageContext.request.contextPath }/user">
					<input type='hidden' name='a' value='login'>
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value='${email }'>
					<label class="block-label" >패스워드</label>
					<input name="password" type="password" value="">
		
					<c:if test="${not empty email }">
						<p>
							로그인이 실패 했습니다.
						</p>					
					</c:if>
=======
<link href="<%=request.getContextPath() %>/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="<%=request.getContextPath() %>/user">
					<input type='hidden' name='a' value='login'>
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="<%=(email == null ? "" : email %>">
					<label class="block-label" >패스워드</label>
					<input name="password" type="password" value="">
					<%
						if(null != email) {
					%>
						<p>
							로그인이 실패 했습니다.
						</p>
					<%
						}
					%>
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
<<<<<<< HEAD
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
=======
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
	</div>
</body>
</html>