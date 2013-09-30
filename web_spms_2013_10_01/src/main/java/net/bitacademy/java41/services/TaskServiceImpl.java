package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TaskServiceImpl implements TaskService{
	@Autowired PlatformTransactionManager txManager;
	@Autowired TaskDao taskDao;

	public Task getTask(int no) throws Exception {
		return taskDao.getTask(no);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int addTask(Task task)throws Exception{
		System.out.println("addTask 들어감");
		taskDao.addTask(task);
		System.out.println(task.getTno() + " + " + task.getEmail() + " + " + task.getPno());
		return task.getTno();
	}

	public int addMemberTask(Task task) throws Exception {
		System.out.println("AddMemberTask들어감");
		
		return taskDao.addMemberTask(task);
	}
	
	public List<Task> listTask(int no) throws Exception{
		System.out.println("listTask 들어감");
		return taskDao.listTask(no);
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int deleteTask(int no) throws Exception{
		try{
			taskDao.deleteMemberTask(no);
			return taskDao.deleteTask(no);
		}catch (Exception e) {
			throw e;
		} 
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int updateTask(Task task)throws Exception{
		try{ 
			return taskDao.updateTask(task);


		}catch (Exception e) {
			throw e;
		} 
	}


}
