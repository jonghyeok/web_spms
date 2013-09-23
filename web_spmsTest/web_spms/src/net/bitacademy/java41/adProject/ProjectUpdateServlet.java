package net.bitacademy.java41.adProject;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.Dao.ProjectDao;

@WebServlet("/ad/project/update")
@SuppressWarnings("serial")
public class ProjectUpdateServlet extends HttpServlet {

	int no;
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		try {
			ProjectDao projectDao = 
					(ProjectDao) this.getServletContext().getAttribute("projectDao");
			this.no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("project", projectDao.get(no));
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("/ad/project/projectUpdate.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProjectDao projectDao = 
				(ProjectDao) this.getServletContext().getAttribute("projectDao");
		
		System.out.println("zzz"+no);
		try {
			request.setAttribute("project", projectDao.get(no));
			
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Date startDate = Date.valueOf(request.getParameter("startDate"));
			Date endDate = Date.valueOf(request.getParameter("endDate"));
			String tag = request.getParameter("tag");
			//int no = Integer.parseInt(request.getParameter("no"));
			
			
			System.out.println(no);
			
			if (projectDao.update(title, content, startDate, endDate, tag, no) > 0) {
				request.setAttribute("status", "SUCCESS");
			} else {
				request.setAttribute("status", "FAIL");
			}
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/project/projectUpdateResult.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}

