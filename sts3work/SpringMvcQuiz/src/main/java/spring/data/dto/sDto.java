package spring.data.dto;

import java.sql.Date;

public class sDto {

	
	private String sname;
	private int pay;
	private String buseo;
	private Date ipsaday;
	
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getBuseo() {
		return buseo;
	}
	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}
	public Date getIpsaday() {
		return ipsaday;
	}
	public void setIpsaday(Date ipsaday) {
		this.ipsaday = ipsaday;
	}
	
}
