package day0226;

public class QuizObjectTest {

	public static void main(String[] args) {
		/* 과정명: 쌍용 교육센터 자바교육 4강의장
		 * =============================
		 * 학생1정보
		 * 이름:이주연
		 * 나이:17
		 * 지역:부산
		 * 취미:그림그리기
		 * 
		 * 학생2정보
		 * 이름:윤지안
   		 * 나이:24
   		 * 지역:서울
   		 * 취미:요리하기
		 */
		
	        // 과정명 출력
	        QuizObject.processName="쌍용교욱센터 자바교육 4강의장";
	        		System.out.println(QuizObject.processName);
	        System.out.println("=============================");
	        
	        // 학생1 정보
	       
	        System.out.println("학생1정보");
	        QuizObject ob1=new QuizObject();
	        ob1.stuName="이주연";
	        ob1.age=17;
	        System.out.println(ob1.stuName);
	        System.out.println(ob1.age);
	        //set메서드 이용수정
	        ob1.setCity("부산"); //리턴값이 없으므로 변수 못만듬
	        ob1.setHobby("그림그리기");
            //get메서드 이용 값얻기
	        String city1=ob1.getCity();
	        String hobby1=ob1.getHobby();
	        //출력
	        System.out.println(city1);
	        System.out.println(hobby1);
	        
            System.out.println("학생2정보");
            QuizObject ob2=new QuizObject();
	        ob2.stuName="윤지안";
	        ob2.age=24;
	        System.out.println(ob2.stuName);
	        System.out.println(ob2.age);
	        //set메서드 이용수정
	        ob2.setCity("서울"); //리턴값이 없으므로 변수 못만듬
	        ob2.setHobby("요리하기");
            //get메서드 이용 값얻기
	        String city2=ob2.getCity();
	        String hobby2=ob2.getHobby();
	        //출력
	        System.out.println(city2);
	        System.out.println(hobby2);
	}

}
