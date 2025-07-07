package boot.data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ipgo")
public class IpgoDto {

	private String num;
	private String sangpum;
	private String photoimage;
	private int price;
	private Timestamp ipgoday;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public String getPhotoimage() {
		return photoimage;
	}
	public void setPhotoimage(String photoimage) {
		this.photoimage = photoimage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getIpgoday() {
		return ipgoday;
	}
	public void setIpgoday(Timestamp ipgoday) {
		this.ipgoday = ipgoday;
	}
	
}