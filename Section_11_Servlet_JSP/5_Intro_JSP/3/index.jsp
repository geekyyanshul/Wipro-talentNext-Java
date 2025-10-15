<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<%
    for(int i=1;i<=10;i++)
    {
        int fact=1;
        for(int j=1;j<=i;j++)
        {
            fact *= j;
        }
        %>
    <tr><td><%=i %></td><td><%=fact %></td></tr>
<%
    }
%>
</table>
</body>
</html>
