package springMvc.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.board.data.BoardDaoInter;

@Controller
public class BoardController {

	@Autowired
	private BoardDaoInter dao;
	
	@GetMapping("/list")
	public ModelAndView list()
	{
		ModelAndView model=new ModelAndView();
		
		int totalCount=dao.getTotalCount();
		
		model.addObject("totalCount")
	}
}
