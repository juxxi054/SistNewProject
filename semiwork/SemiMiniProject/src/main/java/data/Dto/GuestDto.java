package data.Dto;

import java.sql.Timestamp;

public class GuestDto {

	private String num;
	  private String mid;
	  private String photo;
	  private String content;
	  private Timestamp writeday;
	  
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String myid) {
		this.mid = myid;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	  
	  
	}