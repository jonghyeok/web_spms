package net.bitacademy.java41.vo;

import java.io.Serializable;
import java.sql.Date;

public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int 		pno;
	protected String 	title;
	protected String 	content;
	protected Date 		startDate;
	protected Date 		endDate;
	protected String 	tag;
	protected String 	leader;
	
	public int getNo() {
		return pno;
	}
	public Project setNo(int pno) {
		this.pno = pno;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Project setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Project setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Project setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Project setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	public String getTag() {
		return tag;
	}
	public Project setTag(String tag) {
		this.tag = tag;
		return this;
	}
	public String getLeader() {
		return leader;
	}
	public Project setLeader(String leader) {
		this.leader = leader;
		return this;
	}
	
}
