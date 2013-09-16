package net.bitacademy.java41.controls.project;

import java.util.Map;

import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.ProjectService;
import net.bitacademy.java41.vo.Project;

public class ProjectUpdateFormControl implements PageControl {
	ProjectService projectService;

	public ProjectUpdateFormControl setProjectService(ProjectService projectService) {
		this.projectService = projectService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {

		@SuppressWarnings("unchecked")
		Map<String,String[]> params = 	(Map<String,String[]>)model.get("params");

		model.put("list", projectService.getProjectList());
		int no = Integer.parseInt(params.get("no")[0]);
		System.out.println("프로젝트업데이트 폼 : " + no);
		model.put("project", projectService.getProject(no));

		Project p = (Project) model.get("project");

		System.out.println(p.getContent());
		System.out.println(p.getTitle());

		return "/project/projectUpdate.jsp";
	}

}
