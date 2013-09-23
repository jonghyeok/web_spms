package net.bitacademy.java41.adMember;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.Dao.MemberDao;
import net.bitacademy.java41.Dao.ProjectDao;


@WebServlet("/ad/member/serch")
@SuppressWarnings("serial")
public class adMemberSerchServlet extends HttpServlet{

	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			MemberDao memberDao = 
				(MemberDao)this.getServletContext().getAttribute("memberDao");
			
			request.setAttribute("smember", memberDao.get(email));
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/ad/member/serch.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
	
	
}
