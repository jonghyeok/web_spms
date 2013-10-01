package net.bitacademy.java41.vo;

import java.sql.Date;

public class Feed {

	private  int fno;
	private String content;
	private Date regDate;
	private String email;
	private int pno;
	private String[] photos;
	
	public int getFno() {
		return fno;
	}
	public Feed setFno(int fno) {
		this.fno = fno;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Feed setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Feed setRegDate(Date regDate) {
		this.regDate = regDate;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Feed setEmail(String email) {
		this.email = email;
		return this;
	}
	public String[] getPhotos() {
		return photos;
	}
	public Feed setPhotos(String[] photos) {
		this.photos = photos;
		return this;
	}
	public int getPno() {
		return pno;
	}
	public Feed setPno(int pno) {
		this.pno = pno;
		return this;
	}
	
}
