package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import workingWithDB.DB;

import logic.coffee.Coffee;

import dao.CoffeeDao;
import dao.LoginDao;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String n=request.getParameter("username");    
        String p=request.getParameter("userpass");   
          
        HttpSession session = request.getSession(false);  
        if(session!=null)  
        session.setAttribute("name", n);
        //session.setAttribute("userpass", p);//
  
        if(LoginDao.validate(n, p)){   
        	
        	if(n.equals("Admin")){//TO DO!!!!!!
        	
        	//out.print("you are best");    
            RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");    
            rd.forward(request,response);   
			
        	}
        	else{//not admin
        		
        		 RequestDispatcher rd=request.getRequestDispatcher("order.jsp");    
                 rd.forward(request,response);  
                 /*String c=request.getParameter("cType"); 
                 ArrayList<String> coffee=new ArrayList<String> ();
                 coffee.add("arabic");
                 coffee.add("java");
				session.setAttribute("coffee", coffee);
                 //request.setAttribute("coffee", coffee);
                 out.print("coffe"+coffee);*/
                /* ArrayList<Coffee> coffee= CoffeeDao.getCoffee(c);

     			
                 request.setAttribute("coffee", coffee);//.iterator().next()
                 out.print("coffe"+coffee.get(0).toString());*/
     			
        	}
        	
			
			
        }    
        else{    
            out.print("<p style=\"color:red\">Sorry username or password error</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");    
            rd.include(request,response);    
        }    
  
        out.close();      
	}

}
