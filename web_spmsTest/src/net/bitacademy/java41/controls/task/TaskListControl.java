package net.bitacademy.java41.controls.task;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;
@Component("/task/list.do")
public class TaskListControl implements PageControl{

	TaskService taskService;
	
	public TaskListControl setProjectService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}
	
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		@SuppressWarnings("unchecked")
		Map<String,String[]> params = (Map<String, String[]>) model.get("params");
		
		int no = Integer.parseInt(params.get("no")[0]);
		

		List<Task> list =  taskService.listTask(no);
		
		for(Task t : list){
			System.out.println(t.getEmail()+" " + t.getTitle());
		}
		
		
		model.put("pno", no);
		model.put("list",list);
		System.out.println("task list =  " + no);
				
		return "../task/taskList.jsp";
	
	}

}
