package day0219;

public class IfTest_09 {

	public static void main(String[] args) {
		
		// 점수를 통해서 학점 구하기 (A,B,C,D,F)
		
        int score=85;
        String grade;
        
        //if~else if~else 사용하여 구하기
        if(score>=90)
           grade="A";
        else if (score>80)
           grade="B";
        else if (score>70)	   
           grade="C";
        else if (score>60)	   
           grade="D";
       else 	   
           grade="F";
        
        //출력
        System.out.println("if문 학점은"+grade+"입니다");
        
        // 삼항연산자
        
        grade=score>=90?"A":
        	  score>=80?"B":
        	  score>=70?"C":
              score>=60?"D":"F";
       System.out.println("삼항연산자 학점은"+grade+"입니다");
	}

}
