package boot.jpa.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//자동으로 mycar라는 테이블이 mysql에 만들어진다
//만약 변수가 변경될경우 자동수정
@Entity
@Table(name = "mycar")
public class MycarDto {

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

	@Id  //각 엔티티를 구별할수있도록 식별아이디 갖도록 설계(시퀀스)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long num;
	
	@Column(name = "carname")
	private String carname;
	
	@Column  //이름이 같으면 생략가능
	private int carprice;
	
	@Column
	private String carcolor;
	
	@Column
	private String guipday;
	
	@CreationTimestamp  //엔티티 생성시점의 시간 자동등록
	@Column(updatable = false)   //수정시 이컬럼은 수정하지 않겠다라는것
	private Timestamp writeday;
}