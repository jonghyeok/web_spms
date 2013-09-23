package net.bitacademy.java41.controls.task;

import java.sql.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Task;



import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Component("/task/add2.do")
public class TaskAddControl implements PageControl{
	TaskService taskService;
	
	public TaskAddControl setProjectService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}

	@SuppressWarnings("null")
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 	(Map<String,String[]>)model.get("params");
				
		String email = String.valueOf(params.get("email"));

		System.out.println("add들어감 : "+ email);
		
		String UIurl = null;
		
		if(null == (params.get("uiProtoUrl"))){
			UIurl="";
		}else{
			UIurl=(String.valueOf(params.get("uiProtoUrl")));
		}
				
		Task task = new Task();
		task.setEmail(email);
		task.setPno(Integer.parseInt(String.valueOf(params.get("pno"))));
		task.setTitle(String.valueOf(params.get("title")));
		task.setUiProtoUrl(UIurl);
		task.setContent(String.valueOf(params.get("content")));
		task.setStartDate(Date.valueOf(String.valueOf(params.get("startDate"))));
		task.setEndDate(Date.valueOf(String.valueOf(params.get("endDate"))));
		//task.setStatus(0);
		//task.setStatus(Integer.getInteger(params.get("status")[0]));
		task.setStatus(Integer.parseInt(String.valueOf(params.get("status"))));
		
		int resn = taskService.addTask(task);
				
		if(resn>0){
			model.put("pno", task.getPno());
		model.put("status", "SUCCESS");
		return "/task/taskAddResult.jsp";
			
		}else{
			model.put("pno", task.getPno());
			model.put("status", "SUCCESS");
			return "/task/taskAddResult.jsp";
				
		}
	
	}
}
