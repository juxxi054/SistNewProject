package spring.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.Dto.FoodDto;


@Controller
public class JsonTestController {

	@GetMapping("/list1")
	@ResponseBody
	public Map<String,String> list1()
	{
	Map<String, String> map=new HashMap<String, String>();
	map.put("name","±èÁ¾Çù");
	map.put("hp","010-8585-9632");
	map.put("addr", "¼­¿ï½Ã °­³²±¸");
	
	return map;
	}

	
	@GetMapping ("/list2")
	@ResponseBody
	public List<FoodDto> list2()
	{
		List<FoodDto> list=new ArrayList<FoodDto>();
		
		list.add(new FoodDto("»÷µåÀ§Ä¡","1.jgpd"));
		list.add(new FoodDto("¸Á°íºù¼ö","11.jgpd"));
		list.add(new FoodDto("²¿Ä¡±¸ÀÌ","2.jgpd"));
		list.add(new FoodDto("ÇÜ¿¡±×¸¶¿ä","10.jgpd"));
		list.add(new FoodDto("Ä¡Áî±×¶óÅÁ","5.jgpd"));
		
		return list;
	}
	
}
