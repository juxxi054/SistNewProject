package day0307;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

public class Ex6Map {

	//key value로 이루어진 데이터 집합
	//key로 구분
	//순서는 유지되지않는다
	//key는 중복허용을 하지않는다
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String,String> map=new HashMap<String, String>();
		map.put("name", "영준");
		map.put("age", "26");
		map.put("addr","강남구 역삼동");
		//같은 key값 넣으면 먼저적은 데이터가 없어짐
        map.put("name","수민");
        
        System.out.println("size:"+map.size());
        
        //키값을 알면 정확하게 value알수있다
        System.out.println("이름:"+map.get("name"));
        System.out.println("나이:"+map.get("age"));
        System.out.println("주소:"+map.get("addr"));
        //맵에 없는 키값은 Null로 출력
        System.out.println("MBTI:"+map.get("mbti"));
        
        System.out.println("키값을 한꺼번에 얻은후 값을 얻기");
        
        Set<String> keySet= map.keySet();
        
         Iterator<String> keyIter=keySet.iterator();
         while(keyIter.hasNext())
         {
        	 String key=keyIter.next();
        	 System.out.println(key+"==>"+map.get(key));
         }
         System.out.println("방법2");
         for(String key:keySet)
        	 System.out.println(key+"==>"+map.get(key));
        	 
	}

}
