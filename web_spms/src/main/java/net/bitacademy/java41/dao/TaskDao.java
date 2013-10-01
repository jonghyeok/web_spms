package net.bitacademy.java41.dao;

import java.util.List;

import net.bitacademy.java41.vo.Task;


public interface TaskDao {


	int updateTask(Task task)throws Exception ;

	int deleteTask(int no)throws Exception;

	void deleteMemberTask(int no)throws Exception;

	 List<Task> listTask(int no) throws Exception;

	 Task getTask(int no) throws Exception ;

	 int addTask(Task task);
	 
	 int addMemberTask(Task task);







}
