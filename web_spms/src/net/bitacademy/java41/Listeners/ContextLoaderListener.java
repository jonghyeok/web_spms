package net.bitacademy.java41.Listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.bitacademy.java41.Dao.MemberDao;
import net.bitacademy.java41.Dao.ProjectDao;
import net.bitacademy.java41.Dao.ProjectMemberDao;
import net.bitacademy.java41.Util.DBConnectionPool;

public class ContextLoaderListener implements ServletContextListener{

	
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
		
	DBConnectionPool dbPool =  new DBConnectionPool(ctx.getInitParameter("dburl"),ctx.getInitParameter("user"),ctx.getInitParameter("password"),ctx.getInitParameter("driverClass"));
		
	MemberDao memberDao = new MemberDao(dbPool);
	ProjectDao projectDao = new ProjectDao(dbPool);
	ProjectMemberDao projectmemberDao = new ProjectMemberDao(dbPool);
	
	
	ctx.setAttribute("memberDao", memberDao);
	ctx.setAttribute("projectDao", projectDao);
	ctx.setAttribute("projectmemberDao", projectmemberDao);
	
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}


	
}
