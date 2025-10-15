import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        HttpSession s = request.getSession();
        if(s.isNew())
        {
            s.setAttribute("count", 1);
        }
        else
        {
            int count = (int) s.getAttribute("count");
            s.setAttribute("count", count+1);
        }   
        pw.print(s.getAttribute("count"));  
    }
}

