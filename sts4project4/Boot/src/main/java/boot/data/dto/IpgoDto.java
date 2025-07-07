package boot.data.dto;

import java.security.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

public class IpgoDto {

	
	@Data
	@Alias("ipgo")
	
	
	private String num;
	private String sanpum;
	private String photoimage;
	private int price;
	private Timestamp ipgoday;
	
}
