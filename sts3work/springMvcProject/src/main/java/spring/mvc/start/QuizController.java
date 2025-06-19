package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

	
	@GetMapping("quiz/lunch/burger")
	public ModelAndView quiz1()
	{
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("title", "ÀÌ¹ÌÁö Ãâ·Â°úÁ¦");
		mview.addObject("stuName", "손수아");
		
		mview.setViewName("quiz1");
		
		return mview;
	
	}
}