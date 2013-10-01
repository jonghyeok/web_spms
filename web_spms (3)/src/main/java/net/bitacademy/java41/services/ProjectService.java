package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;
import net.bitacademy.java41.vo.ProjectMember;

public interface ProjectService {
	
				
	 List<Project> getProjectList() throws Exception ;
		
	 List<MemberProject> getMyProjects(String email) throws Exception ;
	
	 Project getProject(int no) throws Exception ;
	
	 void addProject(Project project) throws Exception ;
	
	 void deleteProject(int no) throws Exception ;
	
	 void updateProject(Project project) throws Exception;
	
	 List<ProjectMember> getView(int no) throws Exception ;
}















