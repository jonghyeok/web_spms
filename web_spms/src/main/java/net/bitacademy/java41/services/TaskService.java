package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
public interface TaskService {

	 Task getTask(int no) throws Exception;

	
	 int addTask(Task task)throws Exception;
	
	 int addMemberTask(Task task) throws Exception;
	
	 List<Task> listTask(int no) throws Exception;
	
	 int deleteTask(int no) throws Exception;
	
	 int updateTask(Task task)throws Exception;


	
	
	
}
