package day2020;

import java.util.Scanner;

public class s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a=0,b=0;
		int num;
		
		for(int i=0;i<5;i++);
		{
		num=sc.nextInt();
		System.out.println(num+":");
		}
		
		if(num>0)
		  a++;
		else if (num<0)
		  b++;
	}
		System.out.println("양수갯수"+a);
	    System.out.println("음수갯수"+b);
		
       
       
	}

}
