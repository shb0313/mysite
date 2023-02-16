<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
=======
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<<<<<<< HEAD
<link href="${pageContext.request.contextPath }/assets/css/main.css"
=======
<link href="<%=request.getContextPath()%>/assets/css/main.css"
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
<<<<<<< HEAD
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
=======
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile"
<<<<<<< HEAD
						src="${pageContext.request.contextPath }/assets/images/xxx.jpg">
					<h2>안녕하세요. 신해빈의 mysite에 오신 것을 환영합니다.</h2>
=======
						src="<%=request.getContextPath()%>/assets/images/abc.png">
					<h2>안녕하세요. 의 mysite에 오신 것을 환영합니다.</h2>
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
					<p>
						이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br> 메뉴는 사이트 소개, 방명록, 게시판이 있구요.
						Java 수업 + 데이터베이스 수업 + 웹프로그래밍 수업 배운 거 있는거 없는 거 다 합쳐서 만들어 놓은 사이트
						입니다.<br>
<<<<<<< HEAD
						<br> <a href="${pageContext.request.contextPath }/guestbook">방명록</a>에
=======
						<br> <a href="<%=request.getContextPath()%>/guestbook">방명록</a>에
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
						글 남기기<br>
					</p>
				</div>
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