package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
@Component("/task/delete.do")
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
		
		int tno = Integer.parseInt(String.valueOf(params.get("tno")));
		System.out.println("task " + tno);
		int pno = Integer.parseInt(String.valueOf(params.get("pno")));
		System.out.println("task pno = " + pno);
		
		model.put("task", taskService.deleteTask(tno));
	
		return  "../task/list.do?no="+pno;
	}

	
	
	
}
