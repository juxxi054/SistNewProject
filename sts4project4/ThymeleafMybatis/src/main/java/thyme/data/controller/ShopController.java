package thyme.data.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import thyme.data.dto.ShopDto;
import thyme.data.service.ShopService;

@Controller
@RequiredArgsConstructor
public class ShopController {

   
	private final ShopService service = new ShopService();
	
	@GetMapping("/shop/list")
	public String shopList(Model model)
	{
		int totalCount=service.getTotalCount();
		List<ShopDto> list=service.getAllSangpums();
		
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "shop/list";
	}
	
	
	@GetMapping("/shop/addform")
	public String addform()
	{
		return "shop/addform";
	}
	
	@PostMapping("/shop/insert")
	public String insert(@ModelAttribute ShopDto dto,
			@RequestParam("upload") MultipartFile upload,
			HttpSession session)
	{
		service.insertShop(dto, upload, session);
		
		return "redirect:list";
	}
	
	@GetMapping("/shop/detail")
	public String detail(@RequestParam("num") int num,Model model)
	{
		ShopDto dto=Service.getData(num);
		model.addAttribute("dto",dto);
		
		return "shop/shopdetail";
	}
	
	@GetMapping("/shop/delete")
	public String delete(@RequestParam("num"))
	{
		service.deleteShop(num,session);
		return "redirect:list";
		
	}
}



