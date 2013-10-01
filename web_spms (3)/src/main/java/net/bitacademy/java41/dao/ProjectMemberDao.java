package net.bitacademy.java41.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.vo.ProjectMember;


public interface ProjectMemberDao {

	 List<ProjectMember> getView(int no) throws Exception;
	
	 int add(Map<String,Object> paramMap) throws Exception;

	 void deleteAll(int no) throws Exception;
	
}
