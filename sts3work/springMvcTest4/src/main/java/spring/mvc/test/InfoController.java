package spring.mvc.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dto.InfoDto;

@Controller
public class InfoController {


@GetMapping("/info/myform")
public String myform()
{
	return "info/infoform";
}


@PostMapping("/info/write")
public String result(@ModelAttribute  InfoDto dto)
{
	return "info/infowrite";
}
}





