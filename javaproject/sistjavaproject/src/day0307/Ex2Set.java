package day0307;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex2Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		HashSet<Integer> set1=new HashSet<Integer>();
		
		set1.add(5);
		set1.add(8);
		set1.add(5);
		set1.add(14);
		set1.add(37);
		
		System.out.println("데이터갯수:"+set1.size());
		
		System.out.println("출력 #1_for~each");
		for(int n:set1)
			System.out.printf("%5d",n);
		
		System.out.println("출력 #2_Itertor");
		Iterator<Integer> iter=set1.iterator();
		while(iter.hasNext())
			System.out.printf("%5d",iter.next());
		System.out.println();
		
		
		System.out.println("출력 #3_for");
		Object[] ob=set1.toArray();
		for(int i=0;i<ob.length;i++)
			System.out.printf("%5d",ob[i]);
		
		
	}

}
