package net.bitacademy.java41.adMember;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.Dao.MemberDao;
import net.bitacademy.java41.vo.Member;

@WebServlet("/ad/member/delete")
@SuppressWarnings("serial")
public class MemberDeleteServlet extends HttpServlet {

	String email;
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		try {
			MemberDao memberDao = 
					(MemberDao) this.getServletContext().getAttribute("memberDao");
			this.email = request.getParameter("email");
			request.setAttribute("memberInfo", memberDao.get(email));
			
			System.out.println("email:" +email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/ad/member/memberDelete.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MemberDao memberDao = 
					(MemberDao) this.getServletContext().getAttribute("memberDao");
			
			request.setAttribute("memberInfo", memberDao.get(email));
									
			if (memberDao.delete(email) > 0) {
				request.setAttribute("status", "SUCCESS");
			} else {
				request.setAttribute("status", "FAIL");
			}
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/ad/member/memberDeleteResult.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}

