<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="p2" class="com.all.Page2"/>
<jsp:setProperty property="*" name="p2"/>

<jsp:getProperty property="num" name="p2"/>
<br>
Your Number is greater than 10<br>
</body>
</html>
