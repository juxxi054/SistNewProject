package sping.mvc.board;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@GetMapping("/form1")
	public String form1()
	{
	   return "upload/form1";	
	}
	
	@PostMapping("/save1")
	public ModelAndView read1(@RequestParam String title,
			@RequestParam MultipartFile photo,
			HttpSession session) 
	{
		ModelAndView model=new ModelAndView(); 
	
		//업로드할 실제경로 구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		String fileName=photo.getOriginalFilename(); //업로드한 파일명
		
		//현재날짜와 시간 이용해서 파일명 저장
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		if(fileName.equals(""))
		{
			fileName=sdf.format(new Date())+"_"+fileName;
			
			//path에 업로드 해주기
			
		}
		
		
		model.addObject("fileName",fileName);
		model.addObject("title",title);
		model.addObject("path",path);
		
		model.setViewName("/result1");
		
	return model;
	}
	
}
