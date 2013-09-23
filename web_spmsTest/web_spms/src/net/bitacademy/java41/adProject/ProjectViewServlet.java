package net.bitacademy.java41.adProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.Dao.ProjectDao;
import net.bitacademy.java41.Dao.ProjectMemberDao;

@WebServlet("/ad/project/view")
@SuppressWarnings("serial")
public class ProjectViewServlet extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			ProjectDao projectDao = 	(ProjectDao)this.getServletContext().getAttribute("projectDao");
			
			ProjectMemberDao projectMemberDao = (ProjectMemberDao)this.getServletContext().getAttribute("projectmemberDao");
			
			
			request.setAttribute("project", projectDao.get(no));
	    	request.setAttribute("mpview", projectMemberDao.getView(no));
			
	    	
			RequestDispatcher rd = request.getRequestDispatcher("/project/view.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}


