package boot.board.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "jpaboard")
@Entity
public class BoardDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Timestamp getWriteday() {
		return writeday;
	}

	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}

	@Column(name = "writer",updatable = false)
	private String writer;
	
	@Column
	private String subject;
	
	@Column
	private String content;
	
	@Column
	private String photo;
	
	@Column(name = "writeday",updatable = false)
	@CreationTimestamp
	private Timestamp writeday;
	
}