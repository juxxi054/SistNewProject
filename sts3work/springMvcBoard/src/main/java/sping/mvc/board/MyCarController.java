package sping.mvc.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import spring.car.data.CarDao;
import spring.car.data.CarDto;

@Controller
public class MyCarController {

	@Autowired
	CarDao dao;
	
	@GetMapping("/car/list")
	public String list(Model model)
	{
		//전체리스트 가져오기
		List<CarDto> list=dao.getAllCarList();
		
		//request에저장
		model.addAttribute("totalCount", list.size());
		return "mycar/carlist";
	}
	
	//입력폼으로 가기
	@GetMapping("/car/writeform")
	public String carform()
	{
		return "mycar/carform";
	}
	
	
	//insert성공후 리스트
	@PostMapping("/car/carinfo")
	public String insert (@ModelAttribute CarDto dto)
	{
	  return "redirect:list";	
	}
}