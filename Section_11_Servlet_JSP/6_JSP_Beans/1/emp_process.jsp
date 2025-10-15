<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="e1" class="com.bean.Employee"/>

<jsp:setProperty property="*" name="e1"/>

<jsp:getProperty property="id" name="e1"/>
<jsp:getProperty property="name" name="e1"/>
<jsp:getProperty property="salary" name="e1"/>

</body>
</html>
