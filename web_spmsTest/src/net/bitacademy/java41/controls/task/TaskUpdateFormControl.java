package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;
@Component("/task/update.do")
public class TaskUpdateFormControl implements PageControl {

	TaskService taskService;
	
	public TaskUpdateFormControl setProjectService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}


	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 	(Map<String,String[]>)model.get("params");	
		

		int no = Integer.parseInt(params.get("tno")[0]);
		
		Task task = taskService.getTask(no);
		
		System.out.println(task.getTitle());
		
		model.put("uptask", task);
		model.put("pno", Integer.parseInt(params.get("pno")[0]));
		model.put("tno", Integer.parseInt(params.get("tno")[0]));
		
		return "/task/taskUpdate.jsp";
	}
	
	
	
}
