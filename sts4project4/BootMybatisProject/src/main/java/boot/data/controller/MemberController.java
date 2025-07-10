package boot.data.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/member/form")
	public String memform()
	{
		return "member/addform";
	}
	
	@GetMapping("/member/list")
	public String memlist(Model model)
	{
		List<MemberDto> list=service.getAllMembers();
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		return "member/memberlist";
	}
	
	//아이디 중복체크_rest
	@GetMapping("/member/idcheck")
	public @ResponseBody Map<String, Integer> idCheckProcess(@RequestParam String id)
	{
		Map<String, Integer> map=new HashMap<>();
		
		//id
		int idresult=service.getSerchId(id);
		
		map.put("idresult", idresult); //0 or 1
		
		return map;
	}
	
	//insert
	@PostMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto,
			HttpSession session,
			MultipartFile myphoto)
	{
		//업로드폴더
		String path=session.getServletContext().getRealPath("/membersave");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String fileName=sdf.format(new Date())+"_"+myphoto.getOriginalFilename();
		
		//dto의 photo에 저장
		dto.setPhoto(fileName);
		
		//upload
		try {
			myphoto.transferTo(new File(path+"\\"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//insert
		service.insertMember(dto);
		
		return "member/gaipsuccess";
	}
	
	@GetMapping("/member/mypage")
	public String mypage(Model model)
	{
		List<MemberDto> list=service.getAllMembers();
		
		model.addAttribute("list", list);
		
		return "member/mypage";
	}
	
	//마이페이지에서 프로필사진만 변경하고자 할때
	@PostMapping("/member/updatephoto")
	@ResponseBody
	public void photoUpload(String num,MultipartFile photo,
			HttpSession session)
	{
		//업로드될경로 구하기
		String path=session.getServletContext().getRealPath("/membersave");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName=sdf.format(new Date())+photo.getOriginalFilename();
		
		//업로드
		try {
			photo.transferTo(new File(path+"\\"+fileName));
			//db사진수정
			service.updatePhoto(num, fileName); 
			
			//상단 프로필 사진도 변경
			session.setAttribute("loginphoto", fileName);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//수정폼에 출력할 데이타 반환
	@GetMapping("/member/updateform")
	@ResponseBody
	public MemberDto getData(String num)
	{
		return service.getDataByNum(num);
	}
	
	//수정
	@PostMapping("/member/update")
	@ResponseBody
	public void update(MemberDto dto,HttpSession session)
	{
		service.UpdateMember(dto);
		//세션에 저장된 이름도 수정
		session.setAttribute("loginname", dto.getName());
	}
	
	//mypage탈퇴
	@GetMapping("/member/deleteme")
	@ResponseBody
	public void deletemypage(String num,HttpSession session)
	{
		service.deleteMember(num);
		
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
		session.removeAttribute("loginname");
		session.removeAttribute("loginphoto");
	}
	
	//회원목록 강퇴
	@GetMapping("/member/delete")
	@ResponseBody
	public void deleteMember(String num)
	{
		service.deleteMember(num);
				
	}
	
	
	
}