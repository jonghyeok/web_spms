package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
@Component("/task/view.do")
public class TaskControl implements PageControl {
	TaskService taskService;
	
	public TaskControl setProjectService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = (Map<String, String[]>) model.get("params");
		
		int no = Integer.parseInt(params.get("no")[0]);
		System.out.println("task " + no);
		
		model.put("pno", no);
		model.put("task", taskService.getTask(no));
				
		return "../task/taskView.jsp";
	}
}