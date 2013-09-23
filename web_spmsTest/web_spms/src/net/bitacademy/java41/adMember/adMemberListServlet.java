package net.bitacademy.java41.adMember;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.Dao.MemberDao;
import net.bitacademy.java41.Dao.ProjectDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;

@WebServlet("/ad/member/list")
@SuppressWarnings("serial")
public class adMemberListServlet extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MemberDao memberDao = 
				(MemberDao)this.getServletContext().getAttribute("memberDao");
			
			request.setAttribute("list", memberDao.list());
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/ad/member/list.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}



