package thyme.data.service;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import thyme.data.dto.ShopDto;
import thyme.data.mapper.ShopMapperInter;

@Service
@AllArgsConstructor
public class ShopService {

	private final ShopMapperInter mapper = null;
	
	public int getTotalCount()
	{
		return mapper.getTotalCount();
	}
	
	public void insertShop(
		@ModelAttribute	ShopDto dto,
		@RequestParam("upload")	MultipartFile upload,
		HttpSession session)
	{
		String realpath=session.getServletContext().getRealPath("/save");
		String photoName=upload.getOriginalFilename();
		dto.setPhoto(photoName);
		
		try {
			upload.transferTo(new File(realpath+"\\"+photoName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mapper.insertShop(dto);
	}
	
	public List<ShopDto> getAllSangpums()
	{
		return mapper.getAllSangpums();
	}
	
	public ShopDto getData(int num)
	{
		return mapper.getData(num);
	}
	
	public void deleteShop(
			@RequestParam("num") int num,HttpSession session)
	{
		String oldFileName=mapper.getData(num).getPhoto();
		String realPath=session.getServletContext().getRealPath("/save");
		
		File file=new File(realPath+"\\"+oldFileName);
		if(file.exists())
			file.delete();
		
		mapper.deleteShop(num);
	}
	
	
}
