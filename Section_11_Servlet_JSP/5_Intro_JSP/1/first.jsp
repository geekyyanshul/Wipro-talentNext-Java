<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<% Object a=request.getAttribute("prime"); 
ArrayList<Integer> al1 =(ArrayList) a;
%>
<table border="1" text-align="center">
<%  for(int e:al1){
%>  
<tr><td><%=e %></td></tr>
<%} %>  
</table>

</body>
</html>
