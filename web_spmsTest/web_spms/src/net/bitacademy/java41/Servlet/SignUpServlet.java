package net.bitacademy.java41.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.Dao.MemberDao;
import net.bitacademy.java41.vo.Member;


@WebServlet("/auth/signup")
@SuppressWarnings("serial")
public class SignUpServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/signUp.jsp");
		rd.forward(request, response);
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		int res=0;
		
		try{
			request.setCharacterEncoding("UTF-8");	
			if(request.getParameter("email") == null){
				res= -1; //email값을 안너어줌..
			}else if(request.getParameter("password") == null){
				res=-2; //비밀번호 값을 안너어줌..
			}else if(request.getParameter("name") == null){
				res=-3; //이름을 안너어줌...
			}else{
			
			Member member = new Member()
					.setEmail(request.getParameter("email"))
					.setPassword(request.getParameter("password"))
					.setName(request.getParameter("name"))
					.setTel(request.getParameter("tel"))
					.setBlog(request.getParameter("blog"))
					.setDetailAddress(request.getParameter("detailAddress"));
			
			MemberDao memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
			 res =memberDao.add(member);
			 request.getSession().setAttribute("member", member);
			}
			
			
			
			
			 if(res>0){
			 response.sendRedirect("../main");
			 response.setHeader("Refresh", "10;url=login");
			 
			 }else if(res==-4){
				 
				 out.println("<html><head><title>로그인 결과!</title></head>");
				 out.println("<body><p>-4 내부 오류코드 발생. Email이 충돌됩니다. <br>  다른 Email로 가입해 주시기 바랍니다. 감사합니다.</p></body></html>");
				 response.setHeader("Refresh", "3;url=signup");
				 
				 
			 }else{
					session.invalidate();
					RequestDispatcher rd = request
							.getRequestDispatcher("/auth/loginFail.jsp");
					rd.forward(request, response);
				 
			 }
			
			
				
				
			
			
		}catch(Exception e){
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/auth/error.jsp");
			rd.forward(request, response);
		}

		
				
				
				
				
				
				
				
				
				
				
		
	}
	
	
	
	
	
	
	
}
