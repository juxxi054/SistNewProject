package boot.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.BoardDto;
import boot.data.service.BoardService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bservice;

	@GetMapping("/board/list")
	public ModelAndView boardlist(
			@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
			@RequestParam(value ="searchcolumn",required = false) String sc,
			@RequestParam(value ="searchword",required = false) String sw)
	{
		ModelAndView model=new ModelAndView();
		
		//페이징처리에 필요한 변수들
		
		  int totalCount=bservice.getTotalCount(sc, sw);
		  int perPage=5; //한페이지에 보여질 글의 갯수
		  int perBlock=5; //한블럭당 보여질 페이지의 갯수
		  int startNum; //db에서 가져올 글의 시작번호(mysql:0 오라클:1번)
		  int startPage; //각블럭당 보여질 시작페이지
		  int endPage;//각블럭당 보여질 끝페이지
		  int totalPage; //총페이지
		  int no; //각페이지당 출력할 시작번호
		  
		 
		  
		  //총페이지수를 구한다
		  //총글의 갯수/한페이지당 보여질개수로 나눔(7/5=1)
		  //나머지가 1이라도 있으면 무저건 1페이지추가(1+1=2페이지가 필요)
		  totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
		  
		  //각블럭당 보여질 시작페이지
		  //perBlock=5일경우 현재페이지가 1~5 시작1,끝5
		  //만약 현재페이지가 13일경우는 시작11,끝15
		  startPage=(currentPage-1)/perBlock*perBlock+1;
		  endPage=startPage+perBlock-1;
		  
		  //총페이지가 23개일경우 마지막 블럭은 끝 25가 아니라 23이다
		  if(endPage>totalPage)
			  endPage=totalPage;
		  
		  //각페이지에서 보여질 시작번호
		  //예: 1페이지-->0  2페이지-->5 3페이지-->10...
		  startNum=(currentPage-1)*perPage;
		  
		  //각페이지당 출력할 시작번호
		  //예를들어 총글갯수가 23   1페이지: 23  2페이지:18  3페이지: 13.....
		  no=totalCount-(currentPage-1)*perPage;
		  
		  //전체데이타
		  List<BoardDto> list=bservice.getList(sc, sw, startNum, perPage);
		  
		  //출력에 필요한 변수들을 request에저장
		  model.addObject("list", list); //댓글 포함해서 전달
		  model.addObject("startPage", startPage);
		  model.addObject("endPage", endPage);
		  model.addObject("totalPage", totalPage);
		  model.addObject("totalCount", totalCount);
		  model.addObject("no", no);
		  model.addObject("currentPage", currentPage);
		  
		  System.out.println("totalCount="+totalCount);
		 
		model.setViewName("board/boardlist");
		return model;
	}
	
	@GetMapping("/board/addform")
	public String form()
	{
		return "board/writeform";
	}
	
	@PostMapping("/board/insert")
	public String insert(
			@ModelAttribute BoardDto dto,
			HttpSession session)
	{
		
		//insert
		bservice.insertBoard(dto, session);
		return "redirect:list";
	}
}