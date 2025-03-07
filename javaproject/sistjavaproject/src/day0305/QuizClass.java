package day0305;

import java.lang.classfile.instruction.ReturnInstruction;
import java.security.PublicKey;
import java.text.NumberFormat;
import java.util.Scanner;

class Company{
	
	private String staff,position; //직원명,직급
    private int famSu; //가족수
    
    //디폴트 생성자
    public Company() {
        this.staff = "";
        this.position = "";
        this.famSu = 0;
    }
    
    //사원명.직급,가족수를 인자로 받는 생성자
    
    public Company(String staff,String position, int famsu)
    {
    	this.staff= staff;
    	this.position= position;
    	this.famSu= famsu;
    }
    //각각의 setters & getters

	public String getStaff() {
		return staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getFamSu() {
		return famSu;
	}

	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
    
    
    //직급에 따라 기본급: 부장->450 과장->350 대리->280 사원->220 getGibonPay()
	
	public int getGibonPay()
	{
		switch (position) {
		case "부장": return 450;    //case "부장"->450;
		case "과장": return 350;
		case "대리": return 280;
		case "사원": return 220;
		default: return 0;
		
		}  
	}
    //직급에 따라 수당: 부장,과장->100 , 대리,사원->70만원 getSudangPay()
    
	public int getSudangPay()
	{
		if (position.equals("부장") || position.equals("과장"))
			 return 100;
		if (position.equals("대리") || position.equals("사원")) {
			 return 70;
		}
		else return 0;
	}
    //가족수가 5인이상 50만 5인미만2인이상은 10만 나머지는 0원 getFamPay()
    public int getFamPay()
    {
    	if (famSu>=5) {
    		return 50;
    	}
    	if (famSu>=2) {
    		return 10;
    	}
    	else return 0;
    }
    

    //세금: 기본급의 5%를 반환받아서 세금 getTax()
    
    public int getTax() {
    return (int)(getGibonPay() * 0.05);      
    }
    //실수령액: 기본급+수당+가족수당-세금  getNetPay()
    
    public int getNetPay() {
        return getGibonPay() + getSudangPay() + getFamPay() - getTax();
    }
}



public class QuizClass {
	
	//제목출력 메서드(showTile()) 
	public static void showTitle() {
       
	//사원명 직급 기본급 수당 가족수당 세금 실수령액
   
	 System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
}
	//한개의 사원데이터 출력 메서드 writeSawon
	
	
	
	
	 public static void writeSawon(Company company) 
	 {
		 
	        System.out.println(company.getStaff() + "\t" +
	                company.getPosition() + "\t" +
	                 company.getGibonPay() + "\t" +
	                company.getSudangPay() + "\t" +
	                company.getFamPay() + "\t" +
	                company.getTax() + "\t" +
	                company.getNetPay());
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //인원수를 입력후 인원수 만큼 배열 메모리에 할당
		
		System.out.print("사원의 수를 입력하세요: ");
		Scanner sc=new Scanner(System.in);
		int inwon =sc.nextInt();
		
		//배열에 데이터를 입력후 생성자를 통해서 데이터 저장하기
		Company[] myCompany=new Company[inwon];
		
		for (int i = 0; i < inwon; i++) {
            System.out.println("사원 " + (i + 1) + "의 정보를 입력하세요:");
            System.out.print("사원명: ");
            String staff = sc.nextLine();
            System.out.print("직급: ");
            String position = sc.nextLine();
            System.out.print("가족수: ");
            int famSu = sc.nextInt();
         
            
            myCompany[i] = new Company(staff, position, famSu); 
        }
		//제목출력
		 showTitle();
		//반복문통해서 데이터를 출력하는 메서드를 호출
		 for (int i = 0; i < inwon; i++) {
	            writeSawon(myCompany[i]);
	        }
	}

}
     
