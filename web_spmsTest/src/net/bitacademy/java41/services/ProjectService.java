package net.bitacademy.java41.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.dao.ProjectMemberDao;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;
import net.bitacademy.java41.vo.ProjectMember;
@Component
public class ProjectService {
	ProjectDao projectDao;
	MemberDao memberDao;
	ProjectMemberDao projectMemberDao;
		
	public ProjectService setProjectMemberDao(ProjectMemberDao projectMemberDao) {
		this.projectMemberDao = projectMemberDao;
		return this;
	}
	
	public ProjectService setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
		
	public List<Project> getProjectList() throws Exception {
		return projectDao.list();
	}
		
	public List<MemberProject> getMyProjects(String email) throws Exception {
		return projectDao.listByMember(email);
	}
	
	public Project getProject(int no) throws Exception {
		return projectDao.get(no);
	}
	
	public void addProject(Project project) throws Exception {
		try {
			projectDao.add(project);
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	
	public int getDeleteProject(int no) throws Exception {
		return projectDao.delete(no);
		
	}	
	
	public int updateProject
	(String title, String content, Date startDate, Date endDate, String tag, int no) throws Exception{
		return projectDao.update(title, content, startDate, endDate, tag, no);
	}
	
	public List<ProjectMember> getView(int no) throws Exception {
		return projectMemberDao.getView(no);
	}
}













