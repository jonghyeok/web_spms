package net.bitacademy.java41.controls.task;

import java.sql.Date;
import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;

public class TaskUpdateControl implements PageControl{


	TaskService taskService;
	
	public TaskUpdateControl setProjectService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		Task task = new Task();

		
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 	(Map<String,String[]>)model.get("params");	


		task.setTno(Integer.parseInt(params.get("tno")[0]));
		task.setPno(Integer.parseInt(params.get("pno")[0]));
		task.setEmail(params.get("email")[0]);
		task.setTitle(params.get("title")[0]);
		task.setUiProtoUrl(params.get("uiProtoUrl")[0]);
		task.setStartDate(Date.valueOf(params.get("startDate")[0]));
		task.setEndDate(Date.valueOf(params.get("endDate")[0]));
		task.setStatus(Integer.parseInt(params.get("status")[0]));
		
		
		int resno = taskService.updateTask(task);
		
		if (resno > 0) {
			model.put("status", "SUCCESS"); 
			model.put("task",task);
		} else{
			model.put("status", "FAIL");
			model.put("task", task);
		}
		
		return "/task/taskUpdateResult.jsp";
		
		
	}
	

	
}
