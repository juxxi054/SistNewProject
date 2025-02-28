package day0228;

class StuInfos{
	private String stuName;
	private String mbti;
	private int age;
	
	//3가지 인자 초기화 하는 명시적 생성자
	//제목메서드 showTittle 이름 mbti 나이
	//출력 showInfo 이름 mbti 나이


	public StuInfos(String stuName, String mbti, int age) {
        this.stuName = stuName;
        this.mbti = mbti;
        this.age = age;
    }

public static void showTitle() {
	System.out.println("이름\t mbti\t 나이");
	System.out.println("------------------");
}

public void showInfo() {
    System.out.println(stuName + "\t" + mbti + "\t" + age);
}

}

public class Ex10ArrQuiz {

	public static void main(String[] args) {
		// 클래스 배열로 생성과 동시에 3명이상 초기화 (이름 mbti 나이 자유)
		
		StuInfos [] info= {
			new StuInfos("김민지","ISTP",18),
			new StuInfos("이해린","ENTJ",20),
			new StuInfos("최하니","ISFP",20)
		};
		
		//총 3명의 정보를 출력합니다
		System.out.println("총"+info.length+"명의 정보를 출력합니다");
		//타이틀 호출
		StuInfos.showTitle();
		//출력문 호출
		for(StuInfos in:info)
			in.showInfo();
		
		

	}
}

