package spring.mvc.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.sDto;


@Controller
public class formController {

	
	@PostMapping("/quiz/read1")
	public ModelAndView read2(@ModelAttribute sDto dto)
	{
		ModelAndView model=new ModelAndView();
	    
		model.addObject("dto",dto);
		model.setViewName("quiz/process2");
		
		return model;
	}
	
	
}
