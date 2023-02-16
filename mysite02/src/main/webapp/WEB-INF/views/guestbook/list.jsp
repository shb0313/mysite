<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("newline", "\n");
%>

=======
<%@page import="com.douzone.mysite.vo.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<<<<<<< HEAD
<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="guestbook">
				<form action="${pageContext.request.contextPath }/guestbook" method="post">
=======
<link href="<%=request.getContextPath()%>/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="guestbook">
				<form action="<%=request.getContextPath()%>/guestbook" method="post">
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
<<<<<<< HEAD
					<c:set var="count" value="${fn:length(list) }"/>	
					<c:forEach items="${list }" var="vo" varStatus="status">
						<li>					
							<table width=510 border=1>
								<tr>
									<td>[${count - status.index }]</td>
									<td>${vo.name }</td>
									<td>${vo.regDate }</td>
									<td>
										<a href="${pageContext.request.contextPath }/guestbook/deleteform&no=${vo.no }">삭제</a>
									</td>	
								</tr>
								<tr>
									<td colspan=4>
										${fn:replace(vo.message, newline, "<br>") }
									</td>
								</tr>
							</table>
							<br>				
					</c:forEach>						
=======
					<li>
						<%
							int count = list.size();
							for(GuestBookVo vo : list) {
						%>
						<table width=510 border=1>
							<tr>
								<td>[<%=count-- %>]</td>
								<td><%=vo.getName() %></td>
								<td><%=vo.getRegDate() %></td>
								<td>
									<a href="<%=request.getContextPath() %>/guestbook?a=deleteform&no=<%=vo.getNo() %>">삭제</a>
								</td>	
							</tr>
							<tr>
								<td colspan=4>
									<%=vo.getMessage().replaceAll("\n", "<br>") %>
								</td>
							</tr>
						</table>
						<br>
						<%
							}
						%>
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
					</li>
				</ul> 
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
	</div>
</body>
</html>