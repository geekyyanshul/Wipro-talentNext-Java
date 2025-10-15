import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
        
        int num = Integer.parseInt(request.getParameter("num"));
        
        
        if(num<10)
        {
            RequestDispatcher rd = request.getRequestDispatcher("page1.jsp");
            rd.forward(request, response);
        }
        else if(num>=10 && num<99)
        {
            RequestDispatcher rd = request.getRequestDispatcher("page2.jsp");
            rd.forward(request, response);
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("error_page.jsp");
            rd.forward(request, response);
        }
    }

}
