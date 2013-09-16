package net.bitacademy.java41.controls.task;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;

public class TaskAddFormControl implements PageControl {

	public String execute(Map<String, Object> model) throws Exception {
		
		
		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 	(Map<String,String[]>)model.get("params");
		
		model.put("pno", Integer.parseInt(params.get("no")[0]));
		
		
		return "/task/taskAdd.jsp";
	}
	
}
