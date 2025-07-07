package boot.mvc.dto;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Repository;

@Repository
public class MycarDao {

	@AutoConfigureOrder
	MycarInter carinter;
	
	
	//insert
	public void insertCar(MycarDto dto)
	{
		carinter.save(dto);  //id타입 유무에 따라서 자동으로 insert,update 정함
		
		
	}
}
