package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.mvc.dto.FoodDto;



//json 전용 (일반메서드 안됨 5.0이후 가능)
@RestController
public class jsonRestController {

	
@GetMapping	("/list3")
public Map<String, String> list3(@RequestParam String name)

{
  	 
	 List<FoodDto> list=new ArrayList<FoodDto>();
	 
	 
	 list.add(new FoodDto("샌드위치", "1.jpg"));
		list.add(new FoodDto("망고빙수", "11.jpg"));
		list.add(new FoodDto("꼬치구이", "2.jpg"));
		list.add(new FoodDto("햄에그마요", "10.jpg"));
		list.add(new FoodDto("치즈그라탕", "5.jpg"));
		list.add(new FoodDto("샌드위치", "8.jpg"));
		list.add(new FoodDto("에그인헬", "12.jpg"));
		list.add(new FoodDto("토마토가지솥밥", "7.jpg"));
	   
		 Map< String, String> map=new HashMap<String, String>();
		 
		 
		 map.put("name", "없는메뉴");
		 map.put("photo", "noimage.png");
		
		 
		 
		 for(FoodDto dto:list)
		 {
			 if(name.equals(dto.getName()))
			 {
				 map.put("name", dto.getName());
				 map.put("photo", dto.getPhoto());
			 }
		 }
		 
		
	 
		 
	 return map;
}
	
	
}
