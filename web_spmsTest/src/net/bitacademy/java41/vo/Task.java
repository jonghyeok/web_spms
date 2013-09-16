package net.bitacademy.java41.vo;

import java.io.Serializable;
import java.sql.Date;

public class Task implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int tno;
	int pno;
	String title;
	String uiProtoUrl;
	String content;
	Date startDate;
	Date endDate;
	int status;
	Date drawDate; //작성일,수정일, 최근수정일 
	
	
	public Date getDrawDate() {
		return drawDate;
	}
	public Task setDrawDate(Date drawDate) {
		this.drawDate = drawDate;
		return this;
	}
	String email;
	
	public String getEmail() {
		return email;
	}
	public Task setEmail(String email) {
		this.email = email;
		return this;
	}
	public int getTno() {
		return tno;
	}
	public Task setTno(int tno) {
		this.tno = tno;
		return this;
	}
	public int getPno() {
		return pno;
	}
	public Task setPno(int pno) {
		this.pno = pno;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Task setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getUiProtoUrl() {
		return uiProtoUrl;
	}
	public Task setUiProtoUrl(String uiProtoUrl) {
		this.uiProtoUrl = uiProtoUrl;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Task setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Task setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}
	public Date getEndDate() {
		return endDate;
	}
	public Task setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}
	public int getStatus() {
		return status;
	}
	public Task setStatus(int status) {
		this.status = status;
		return this;
	}
	
	
	
}
