<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.connection.*,java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    String email = request.getParameter("email");

    try
    {
        Connection con = DbConnection.takeConnection();
        String sql = "select email from emp where email=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,email);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            out.print("Not Available!");
        }
        else
        {
            out.print("Available!");
            In
        }
        con.close();
    }
    catch(Exception e)
    {
        
    }

%>
</body>
</html>

