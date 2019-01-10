<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>회원목록</h2>
<input type="button" value="회원등록" onclick="location.href='${path}/member/write.do'">
<table border="1" width="700px">
  <tr>
    <th>아이디</th>
    <th>이름</th>
    <th>이메일</th>
    <th>가입일</th>
  </tr>
<c:forEach var="row" items="${list }">
  <tr>
    <td>${row.userId }</td>
    <td><a href="${path}/member/view.do?userId=${row.userId }">${row.name }</a></td>
    <td>${row.email }</td>
    <td><fmt:formatDate value="${row.joinDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<%--     <td>${row.joinDate }</td> --%>
  </tr>
</c:forEach>
</table>
</body>
</html>