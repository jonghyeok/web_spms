package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;

public class TaskDeleteControl implements PageControl{
	
	TaskService taskService;
	
	public TaskDeleteControl setProjectService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}
	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		@SuppressWarnings("unchecked")
		Map<String,String[]> params = (Map<String, String[]>) model.get("params");
		
		int tno = Integer.parseInt(params.get("tno")[0]);
		System.out.println("task " + tno);
		int pno = Integer.parseInt(params.get("pno")[0]);
		System.out.println("task pno = " + pno);
		
		model.put("task", taskService.deleteTask(tno));
	
		return  "../task/list.do?no="+pno;
	}

	
	
	
}
