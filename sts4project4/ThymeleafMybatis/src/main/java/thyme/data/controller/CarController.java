package thyme.data.controller;

import java.security.Provider.Service;
import java.util.List;

import org.codehaus.groovy.classgen.ReturnAdder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import thyme.data.dto.CarDto;
import thyme.data.repository.CarDao;
import thyme.data.service.CarService;

@Controller
@RequiredArgsConstructor
public class CarController {

	private final CarService service;
	
	@GetMapping("/board/list")
	public String boardList()
	{
		List<CarDto> list=Service.getAllMyCars();
		
		model.add
		
							
				
	}
	
}
