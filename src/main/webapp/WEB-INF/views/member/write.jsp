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
<h2>회원등록</h2>
<form name="form1" method="post" action="${path }/member/insert.do">
<table border="1" width="400px">
  <tr>
    <td>아이디</td>
    <td><input name="userId"></td> 
  </tr>
  <tr>
    <td>비밀번호</td>
    <td><input name="password" type="password"></td> 
  </tr>
  <tr>
    <td>이름</td>
    <td><input name="name"></td> 
  </tr>
  <tr>
    <td>아메일</td>
    <td><input name="email"></td> 
  </tr>
  <tr>
    <td colspan="2" align="center"><input type="submit" value="확인"></td>
  </tr>
</table>
</form>
</body>
</html>