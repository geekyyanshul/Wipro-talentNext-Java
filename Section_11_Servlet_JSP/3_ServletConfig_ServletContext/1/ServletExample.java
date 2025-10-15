package com.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletExample1
 */
@WebServlet("/ServletExample1")
public class ServletExample1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ServletContext sc = getServletContext();
        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        Enumeration<String>  e = sc.getInitParameterNames();
        
        String name="";
        
        while(e.hasMoreElements())
        {
            name = e.nextElement();
            pw.print("Name:"+name+"");
            pw.print("value:"+sc.getInitParameter(name)+"<br/>");
            
        }
        
    }

}
