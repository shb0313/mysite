<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>

					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach items="${list }" var="vo" varStatus="status">
						<tr>
							<td>${count - status.index }</td>
							<td style="text-align: left; padding-left: ${vo.depth * 20 }px">		
								<c:choose>
									<c:when test="${vo.depth == 0 }">
										<a href="${pageContext.request.contextPath }/board?a=view&no=${vo.no }">${vo.title }</a>
									</c:when>
									<c:otherwise>
										<img id="rep" src="${pageContext.request.contextPath }/assets/images/reply.png"/>
									<a href="${pageContext.request.contextPath }/board?a=view&no=${vo.no }">${vo.title }</a>	
									</c:otherwise>
								</c:choose>
							</td>
							<td>${vo.userName }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>

							<c:if test="${authUser.no eq vo.userNo }">
								<td><a href="${pageContext.request.contextPath }/board?a=delete&no=${vo.no }"
									class="del">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>

				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li class="selected">2</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>
				<!-- 
				<div class="pager">
					<ul>
						<c:choose>
							<c:when test="${map.prevPage eq 0}">
								<li><a href="${pageContext.request.contextPath }/board?page=1">◀</a></li>												
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath }/board?page=${map.prevPage }">◀</a></li>																												
							</c:otherwise>
						</c:choose>
						
						<c:forEach var="i" begin="${map.prevPage + 1 }" end="${(map.nextPage > map.endPage) ? map.endPage : map.nextPage - 1 }" varStatus="status">
							<c:choose>
								<c:when test="${map.page != i }">
									<li><a href="${pageContext.request.contextPath }/board?page=${i }">${i }</a></li>						
								</c:when>
								<c:otherwise>
									<li class="selected">${map.page }</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:choose>
							<c:when test="${map.nextPage >= map.endPage }">
								<li><a href="${pageContext.request.contextPath }/board?page=${map.endPage }">▶</a></li>																				
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath }/board?page=${map.nextPage }">▶</a></li>																																		
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				-->

				<div class="bottom">
					<c:if test="${not empty authUser }">
						<a href="${pageContext.request.contextPath }/board?a=writeform"	id="new-book">글쓰기</a>
					</c:if>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
</html>