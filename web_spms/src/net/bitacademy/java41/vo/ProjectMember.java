package net.bitacademy.java41.vo;

import java.io.Serializable;

public class ProjectMember implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int pno;
	protected int level;
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
