import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Assignment extends HttpServlet {
    Connection con = null;
    PreparedStatement ps = null;
    

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        con = DbConnection.takeConnection();

        String sql = "INSERT INTO emp VALUES(?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, request.getParameter("name"));
            ps.setInt(2, Integer.parseInt(request.getParameter("id")));
            ps.setString(3, request.getParameter("designation"));
            ps.executeUpdate();
            out.println("Success");
            request.setAttribute("result", "Success");
        } catch (SQLException e) {
            request.setAttribute("result", "Failed");
            out.println("Failed");
            e.printStackTrace();
        }
        
//      request.setAttribute("result", "Success");
        //out.print("test");
        
        //request.getRequestDispatcher("/assign.jsp").forward(request, response);
        
        out.close();
    }

}
