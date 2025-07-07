package boot.jpa.dto;

import java.time.LocalDateTime; // Import for LocalDateTime

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpashop")
public class ShopDto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int num; 

	@Column(name = "foodname")
	private String foodname;

	@Column
	private int foodprice;

	@Column
	private String foodphoto;

	
	@Column
	private String ipgoday;

	
	@CreationTimestamp
	@Column(name = "created_date", updatable = false) 
	private LocalDateTime createdDate; 


	
	public int getNum() {
		return num;
	}

	
	public void setNum(int num) {
		this.num = num;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public int getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(int foodprice) {
		this.foodprice = foodprice;
	}

	public String getFoodphoto() {
		return foodphoto;
	}

	public void setFoodphoto(String foodphoto) {
		this.foodphoto = foodphoto;
	}

	public String getIpgoday() {
		return ipgoday;
	}

	public void setIpgoday(String ipgoday) {
		this.ipgoday = ipgoday;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	

}