package net.bitacademy.java41.adProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.Dao.MemberDao;
import net.bitacademy.java41.Dao.ProjectDao;
import net.bitacademy.java41.vo.Member;

@WebServlet("/ad/project/delete")
@SuppressWarnings("serial")
public class ProjectDeleteServlet extends HttpServlet {

	int no;
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		try {
			ProjectDao projectDao = 
					(ProjectDao) this.getServletContext().getAttribute("projectDao");
			this.no = Integer.parseInt(request.getParameter("no"));
			
			request.setAttribute("projectno", projectDao.get(no));
			
			System.out.println("no:" +no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/ad/project/projectDelete.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProjectDao projectDao = 
					(ProjectDao) this.getServletContext().getAttribute("projectDao");
			
			request.setAttribute("memberInfo", projectDao.get(no));
									
			if (projectDao.delete(no) > 0) {
				request.setAttribute("status", "SUCCESS");
			} else {
				request.setAttribute("status", "FAIL");
			}
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/project/projectDeleteResult.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}

