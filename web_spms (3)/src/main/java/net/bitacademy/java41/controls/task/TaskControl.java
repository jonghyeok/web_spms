package net.bitacademy.java41.controls.task;

import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/task")
public class TaskControl{
	@Autowired TaskService taskService;
	@Autowired ServletContext sc;
	long currTime = 0;
	int count = 0;
	String rootRealPath;


	@RequestMapping("/view")
	public String view(int no, HttpSession session,Model model)throws Exception {
		Task task = taskService.getTask(no);
		System.out.println(task.getUiProtoUrl());
		model.addAttribute("pno", no);
		session.setAttribute("task", task);
		return "task/taskView";
	}



	@RequestMapping("/list")
	public String list(int no,HttpSession session, Model model) throws Exception {
		List<Task> list =  taskService.listTask(no);
		for(Task t : list){
			System.out.println(t.getEmail()+" " + t.getTitle());
		}
		model.addAttribute("pno", no);
		model.addAttribute("list",list);
		System.out.println("task list =  " + no);
		return "task/taskList";
	}

	@RequestMapping("/delete")
	public String delete(int tno,int pno,Model model) throws Exception {

		model.addAttribute("task", taskService.deleteTask(tno));
		return  "redirect:list.do?no="+pno;
	}


	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addForm(int no,Model model) throws Exception {
		model.addAttribute("pno", no);
		return "task/taskAdd";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Task task,MultipartFile UIFile,Model model,String NoUI) throws Exception {
		String filename = null;
		String path = null;
		try{
			if(UIFile.getSize() > 0){
				filename = this.getNewFileName();
				path = sc.getAttribute("rootRealPath") + "file/" + filename;
				UIFile.transferTo(new File(path));
				task.setUiProtoUrl(filename);
			}else{
				filename=NoUI;	
			}
			int count=taskService.addTask(task);
			if(count > 0){
				return "redirect:list.do?no="+task.getPno();
			}else{
				model.addAttribute("pno", task.getPno());
				model.addAttribute("status", "FAIL");
				return "task/taskAddResult";
			}
		}catch(Exception e){
			model.addAttribute("pno", task.getPno());
			model.addAttribute("status", "NoSign");
			return "task/taskAddResult";
		}

	}

/*
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Task task,MultipartFile UIFile,Model model,String NoUI) throws Exception {
		String filename = null;
		String path = null;
		try{
			if(UIFile.getSize() > 0){
				filename = this.getNewFileName();
				path = sc.getAttribute("rootRealPath") + "file/" + filename;
				UIFile.transferTo(new File(path));
				task.setUiProtoUrl(filename);
			}else{
				filename=NoUI;	
			}
			int count=taskService.addTask(task);
			if(count > 0){
				return "redirect:list.do?no="+task.getPno();
			}else{
				model.addAttribute("pno", task.getPno());
				model.addAttribute("status", "FAIL");
				return "task/taskAddResult";
			}
		}catch(Exception e){
			model.addAttribute("pno", task.getPno());
			model.addAttribute("status", "NoSign");
			return "task/taskAddResult";
		}
		//		int rsn = taskService.addMemberTask(task);
		//
		//
		//		if(rsn>0){
		//			model.addAttribute("pno", task.getPno());
		//			model.addAttribute("status", "SUCCESS");
		//			return "task/taskAddResult";
		//		}else{
		//			model.addAttribute("pno", task.getPno());
		//			model.addAttribute("status", "FAIL");
		//			return "task/taskAddResult";
		//		}

	}
*/
	private String getNewFileName() {
		long millis = System.currentTimeMillis();
		if(currTime != millis){
			currTime = millis;
			count = 0;
		}
		return "task"+millis+"_"+(++count);
	}



	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateForm(int tno,int pno,Model model) throws Exception {
		Task task = taskService.getTask(tno);
		System.out.println(task.getTitle());
		model.addAttribute("uptask", task);
		model.addAttribute("pno", pno);
		model.addAttribute("tno", tno);
		return "task/taskUpdate";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Task task,MultipartFile UIFile,Model model,String Orignal_uiProtoUrl
			,HttpSession session) throws Exception {
		String filename = null;
		String path = null;
		System.out.println("adsdsdasdasdsadasdasda ===="+UIFile);

		if(UIFile.getSize() > 0){
			filename = this.getNewFileName();
			path = sc.getAttribute("rootRealPath") + "file/" + filename;
			UIFile.transferTo(new File(path));
		}else{
			filename=Orignal_uiProtoUrl;	
		}
		task.setUiProtoUrl(filename);


		session.setAttribute("task", task);
		int resno = taskService.updateTask(task);

		if (resno > 0) {
			model.addAttribute("status", "SUCCESS"); 
			model.addAttribute("task",task);
		} else{
			model.addAttribute("status", "FAIL");
			model.addAttribute("task", task);
		}

		return "task/taskUpdateResult";

	}


}