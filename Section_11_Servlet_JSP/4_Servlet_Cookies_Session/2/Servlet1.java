import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        Cookie[] c = request.getCookies();
        if(c==null)
        {
            pw.print("No cookies");
        }
        else
        {
            pw.print("<table>");
            for(int i=0;i<c.length;i++)
            {
                pw.print("<tr>");
                pw.print("<td>"+c[i].getName()+"</td>");
                pw.print("<td>"+c[i].getValue()+"</td>");
                pw.print("</tr>");
            }
            pw.print("</table>");   
        }   
    }
}
