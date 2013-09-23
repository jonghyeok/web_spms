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

@WebServlet("/ad/member/updateMyInfo")
@SuppressWarnings("serial")
public class updateMyInFoServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		
		try {
			Member member = memberDao.get(request.getParameter("email"));
	
		request.setAttribute("umember", member);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/ad/member/memberUpdateForm.jsp");
		rd.forward(request, response);
		
		}catch(Exception e){
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDao memberDao = 
				(MemberDao) this.getServletContext().getAttribute("memberDao");
		
		try {
			Member member = memberDao.get(request.getParameter("email"));
		
			String pwd = request.getParameter("password");
			
				
				String name = request.getParameter("name");
				String tel = request.getParameter("tel");
				String blog = request.getParameter("blog");
				String detailAddress = request.getParameter("detailAddress");
				String tag = request.getParameter("tag");
				String email = member.getEmail();
				int level = member.getLevel();
				
				
				memberDao.memberUpdate(name, tel, blog, detailAddress, tag, email, level);
				request.setAttribute("status", "SUCCESS");
				
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/member/UpdateResult.jsp");
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}

