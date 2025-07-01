package boot.mvc.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class QuizDto {

	private String fname;
	private int fprice;
	private ArrayList<String> fphoto;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFprice() {
		return fprice;
	}
	public void setFprice(int fprice) {
		this.fprice = fprice;
	}
	public ArrayList<String> getFphoto() {
		return fphoto;
	}
	public void setFphoto(ArrayList<String> fphoto) {
		this.fphoto = fphoto;
	}
	
}