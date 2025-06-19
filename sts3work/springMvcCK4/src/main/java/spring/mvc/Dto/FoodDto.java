package spring.mvc.Dto;

public class FoodDto {
  
	
private String photo;
	
	public FoodDto(String name,String photo)
	{
		this.name=name;
		this.photo=photo;
	}
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	
}
