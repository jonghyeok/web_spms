package net.bitacademy.java41.controls.task;

import java.sql.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Task;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;





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
		
		
		
		String email = params.get("email")[0];

		System.out.println("add들어감 : "+ email);
		

		String UIurl = null;
		
		if(null == (params.get("uiProtoUrl"))){
			UIurl="";
		}else{
			
			
			UIurl=(params.get("uiProtoUrl")[0]);
		}
		
		
		Task task = new Task();
		task.setEmail(email);
		task.setPno(Integer.parseInt(params.get("pno")[0]));
		task.setTitle(params.get("title")[0]);
		task.setUiProtoUrl(UIurl);
		task.setContent(params.get("content")[0]);
		task.setStartDate(Date.valueOf(params.get("startDate")[0]));
		task.setEndDate(Date.valueOf(params.get("endDate")[0]));
		//task.setStatus(0);
		//task.setStatus(Integer.getInteger(params.get("status")[0]));
		task.setStatus(Integer.parseInt(params.get("status")[0]));
		
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
