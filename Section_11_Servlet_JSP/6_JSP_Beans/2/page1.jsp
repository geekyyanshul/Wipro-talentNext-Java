<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="p1" class="com.all.Page1"/>
<jsp:setProperty property="*" name="p1"/>

<jsp:getProperty property="num" name="p1"/>
<br>
Your Number is less than or equal to 10<br>
</body>
</html>
