package net.bitacademy.java41.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.Dao.MemberDao;
import net.bitacademy.java41.EmailSend.EmailSender;
import net.bitacademy.java41.Listeners.ContextLoaderListener;
import net.bitacademy.java41.Util.DBConnectionPool;

@WebServlet("/auth/findpwd")
@SuppressWarnings("serial")
public class SendEmailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		DBConnectionPool dbPool =  new DBConnectionPool("jdbc:mysql://localhost/test", "test", "test", "com.mysql.jdbc.Driver");
		
		MemberDao memberDao = new MemberDao(dbPool);
		
		
	String email = request.getParameter("email");
	
	try{
	String pw = memberDao.findPWD(email);
	System.out.println("센드이메일 서블릿 들어옴 e/p = " + email + "  / "  + pw);
	EmailSender em = new EmailSender(email, pw);
	em.sendGMail();

	out.println("<body><p>Your Password Sanded to E-mail , Please chack your E-mail</p></body></html>");
	
	((HttpServletResponse)response).setHeader("refresh","10;url=login");
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
	
	
	
	
}
}
