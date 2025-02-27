package day0227;

public class Ex3WorkerMethod {

	static class MyInfo{
	
	private String name;	
	private int age;

	
	//setter 메서드
	public void setName(String name)
	{
	   this.name=name;	
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	
	//getter 메서드
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	MyInfo my1=new MyInfo();
	
	//set메서드로 수정
	my1.setName("주히");
	my1.setAge(25);
	
	//get메서드로 값얻기
    String name=my1.getName();
    int age=my1.getAge();
    
    System.out.println(name);
    System.out.println(age);
		
		
	}

}
