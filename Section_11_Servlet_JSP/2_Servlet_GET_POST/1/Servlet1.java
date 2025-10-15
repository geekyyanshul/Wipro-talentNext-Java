import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String First_Name = request.getParameter("fname");
        String Last_Name = request.getParameter("lname");
        String Location = request.getParameter("location");
        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        pw.print("<table>");
        pw.print("<tr>");
        pw.print("<td>First Name</td>");
        pw.print("<td>Last Name</td>");
        pw.print("<td>Location</td>");
        pw.print("</tr>");
        
        pw.print("<tr>");
        pw.print("<td>"+First_Name+"</td>");
        pw.print("<td>"+Last_Name+"</td>");
        pw.print("<td>"+Location+"</td>");
        pw.print("</tr>");
        pw.print("</table>");
    }

}
