package thyme.data.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import groovy.transform.builder.Builder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "jpacar")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	@Column(name = "carname",length = 30)//이름이 같으면 생략가능
	private String carname;
	
	@Column
	private String carprice;
	
	@Column(length = 30) //생략시 255
	private String carcolor;
	
	@Column(length = 100)
	private String carphoto;
	
	@Column(length = 30)
	private String guipday;
	
	@CreationTimestamp
	@Column(updatable = false) //수정시 컬럼제외
	private Timestamp writeday;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getCarprice() {
		return carprice;
	}

	public void setCarprice(String carprice) {
		this.carprice = carprice;
	}

	public String getCarcolor() {
		return carcolor;
	}

	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}

	public String getCarphoto() {
		return carphoto;
	}

	public void setCarphoto(String carphoto) {
		this.carphoto = carphoto;
	}

	public String getGuipday() {
		return guipday;
	}

	public void setGuipday(String guipday) {
		this.guipday = guipday;
	}

	public Timestamp getWriteday() {
		return writeday;
	}

	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}

	
	
}