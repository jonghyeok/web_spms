package net.bitacademy.java41.dao;

import java.util.List;

import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;


public interface ProjectDao {
		
	
	 List<Project> list() throws Exception;
	
	 Project get(int no) throws Exception;
	
	 List<MemberProject> listByMember(String email) throws Exception ;
	
	 int add(Project project) throws Exception ;
	
	 int update(Project project) throws Exception ;
	
	 int delete(int no) throws Exception;

}
