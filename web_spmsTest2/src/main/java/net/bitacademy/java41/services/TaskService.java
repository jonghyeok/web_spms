package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
@Component
public class TaskService {
	@Autowired PlatformTransactionManager txManager;
	@Autowired TaskDao taskDao;

	public Task getTask(int no) throws Exception {
		System.out.println("getTask 들어감"+no);
		return taskDao.getTask(no);
	}

	
	public int addTask(Task task)throws Exception{
		System.out.println("addTask 들어감");
		
		return taskDao.addTask(task);
	}
	
	
	public List<Task> listTask(int no) throws Exception{
		System.out.println("listTask 들어감");
		return taskDao.listTask(no);
	}
	
	public int deleteTask(int no) throws Exception{
		System.out.println("dlelteTask 들어감 - 삭제대상 TNO : "+no);
		return taskDao.deleteTask(no);
	}
	
	public int updateTask(Task task)throws Exception{
		System.out.println("updateTask 들어감");
		return taskDao.updateTask(task);
	}
	
	
}
