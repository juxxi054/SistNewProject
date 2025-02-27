package day0227;

class Jungbo{
	
	
	private String name;
	private int age;
	private String job;
	private String hobby;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	//출력 메서드

	public void writeJungbo() {
		
	System.out.println("이름"+this.name+",나이"+age+",직업"+job+",취미"+hobby);	
	}
	
}

///////////////////////////
public class Ex10ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jungbo jb=new Jungbo();
		
		
		jb.setName("이진아");
		jb.setAge(22);
		jb.setJob("교사");
		jb.setHobby("등산");
		
		//출력 메서드로 조회
		jb.writeJungbo();
		
		////////////////////////
		//2번째 객체 생성해서 setter이용 수정 getter이용 출력
		
		Jungbo jb2=new Jungbo();
		jb2.writeJungbo();
		
		
		System.out.println("2번째 객체 생성후 수정조회");
		
		jb2.setName("서수민");
		jb2.setAge(25);
		jb2.setJob("간호사");
		jb2.setHobby("여행");
		
		
		System.out.println(jb2.getName());
		System.out.println(jb2.getAge());
		System.out.println(jb2.getJob());
		System.out.println(jb2.getHobby());
		}

}
