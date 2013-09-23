package net.bitacademy.java41.adProject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java41.Dao.ProjectDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;

@WebServlet("/ad/project/list")
@SuppressWarnings("serial")
public class ProjectListServlet extends HttpServlet {
	@Override
	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProjectDao projectDao = 
				(ProjectDao)this.getServletContext().getAttribute("projectDao");
			
			request.setAttribute("list", projectDao.list());
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/project/list.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}



