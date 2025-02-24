package day0224;

public class StringToArry_09 {

	public static void main(String[] args) {
		// 문자열을 분리하는 메서드 split
    
		String menu="김자탕,파스타,타코,햄버거,수제비,김밥";
		
		System.out.println(menu);
		System.out.println("메뉴를 컴마로 분리해서 출력");

		String [] menuarr=menu.split(",");
		System.out.println("분리된 메뉴 갯수:"+menuarr.length);
		
		//출력
		
		System.out.println("출력#1");
		
		for(int i=0;i<menuarr.length;i++)
		{
			System.out.println("메뉴"+(i+1)+":"+menuarr[i]);

			
		System.out.println("출력#2_menuarr을 가로로 전체 출력 for~each");
		
		for(String m:menuarr)
			System.out.println(m+" ");
	
				
		
	}

}
}