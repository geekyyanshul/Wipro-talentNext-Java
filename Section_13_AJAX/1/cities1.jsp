<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String[] states={"MP","MH","UP"};
String[][] city={{"Bhopal","jabalpur"},{"Mumbai","Nagpur"},{"Lucknow","Kanpur"}};
String state = request.getParameter("state");

out.print("<table >");

out.println("<tr>Cities</tr>");

for(int i=0;i < states.length;i++)
{   if(state.equals(states[i])){
        for(int j=0;j < city[i].length;j++)
        {out.print("<tr>");
        out.print("<td>"+city[i][j]+"</td></tr>");
        }
    }
}
out.print("</table>");
%>
</body>
</html>
