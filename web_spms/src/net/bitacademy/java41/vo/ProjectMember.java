package net.bitacademy.java41.vo;

import java.io.Serializable;

public class ProjectMember implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int pno;
	protected String email;
	protected int level;
	protected String name;
	protected String tel;
	protected String blog;
	
	
	public String getEmail() {
		return email;
	}
	public ProjectMember setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getName() {
		return name;
	}
	public ProjectMember setName(String name) {
		this.name = name;
		return this;
	}
	public String getTel() {
		return tel;
	}
	public ProjectMember setTel(String tel) {
		this.tel = tel;
		return this;
	}
	public String getBlog() {
		return blog;
	}
	public ProjectMember setBlog(String blog) {
		this.blog = blog;
		return this;
	}
	public int getPno() {
		return pno;
	}
	public ProjectMember setPno(int pno) {
		this.pno = pno;
		return this;
	}
	public int getLevel() {
		return level;
	}
	public ProjectMember setLevel(int level) {
		this.level = level;
		return this;
	}
	
	
	
	
	
}
