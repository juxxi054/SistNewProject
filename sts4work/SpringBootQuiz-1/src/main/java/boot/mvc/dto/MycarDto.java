package boot.mvc.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//자동으로 mycar라는 테이블이 mysql에 만들어진다
//만약 변수가 변경될경우 자동수정
@Entity
@Table(name = "mycar")
public class MycarDto {

	@Id  //각 엔티티를 구별할수있도록 식별아이디 갖도록 설계(시퀀스)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long num;
	
	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public int getCarprice() {
		return carprice;
	}

	public void setCarprice(int carprice) {
		this.carprice = carprice;
	}

	public String getCarcolor() {
		return carcolor;
	}

	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
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

	@Column(name = "carname")
	private String carname;
	
	@Column  //이름이 같으면 생략가능
	private int carprice;
	
	@Column
	private String carcolor;
	
	@Column
	private String guipday;
	
	@CreationTimestamp  //엔티티 생성시점의 시간 자동등록
	private Timestamp writeday;
}