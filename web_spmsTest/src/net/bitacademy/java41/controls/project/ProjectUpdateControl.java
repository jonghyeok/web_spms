package net.bitacademy.java41.controls.project;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Project;
@Component("/project/update2.do")
public class ProjectUpdateControl implements PageControl {
	ProjectService projectService;

	public ProjectUpdateControl setProjectService(ProjectService projectService) {
		this.projectService = projectService;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = (Map<String, String[]>) model.get("params");
			
		
	//	model.put("list", projectService.getProjectList());
		
		System.out.println("업데이트 컨트롤 : " + params.get("no")[0]);
		
		int no =Integer.parseInt(params.get("no")[0]);
		String title = params.get("title")[0];
		String content = params.get("content")[0];
		Date startDate = Date.valueOf(params.get("startDate")[0]);
		Date endDate = Date.valueOf(params.get("endDate")[0]);
		String tag = params.get("tag")[0];
		
		
		int resno = projectService.updateProject(title, content, startDate, endDate, tag, no);
		System.out.println(resno);
		//		Project project = projectService.getProject(no);
		
	//	model.put("project", project);
		
	
		if (resno > 0) {
			model.put("status", "SUCCESS"); 
		} else{
			model.put("status", "FAIL");
		}
		 
		
		
		
		return "/project/projectUpdateResult.jsp";
	}

}
