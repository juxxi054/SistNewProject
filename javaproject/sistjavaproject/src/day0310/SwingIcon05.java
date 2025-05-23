package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingIcon05 extends JFrame {

	
	Container cp;	
	
	//각각의 이미지아이콘
	ImageIcon icon1=new ImageIcon("C:\\sist0217\\image\\swingimage\\LEFT.GIF");
	ImageIcon icon2=new ImageIcon("C:\\sist0217\\image\\swingimage\\LEFTDOWN.GIF");
	ImageIcon icon3=new ImageIcon("C:\\sist0217\\image\\swingimage\\LEFTROLLER.GIF");
	ImageIcon icon4=new ImageIcon("C:\\sist0217\\image\\swingimage\\ANI08.GIF");
	ImageIcon icon5=new ImageIcon("C:\\sist0217\\image\\swingimage\\img_msn_i10.gif");
	
	JButton btn1,btn2,btn3,btn4;
	
	//생성자
		
		public SwingIcon05 (String tittle) {
			super(tittle); 
			
			//위치 너비
			this.setBounds(200,100,300,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cp=this.getContentPane();
			cp.setBackground(new Color(255,165,0));
			initDesign();
			this.setVisible(true);
		}

		public void initDesign()
		{
			//버튼4개로 생성
			this.setLayout(new GridLayout(2, 2)); //2행2열
			btn1=new JButton("hello",icon1);
			this.add(btn1); //프레임에 추가
			btn1.setHorizontalTextPosition(JButton.CENTER); //텍스트 갈위치
			btn1.setVerticalTextPosition(JButton.BOTTOM); //텍스트 세로위치
			
		    //이벤트
			btn1.setPressedIcon(icon2);  //클릭해야 이미지 수정
			btn1.setRolloverIcon(icon3); //올려만놔도 수정
			
		    btn2=new JButton(icon2);
		    this.add(btn2);
		    
		    btn3=new JButton(icon5);
		    this.add(btn3);
		    
		    btn4=new JButton("안녕");
		    this.add(btn4);
		        	
			
		}
		
			



	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new SwingIcon05("스윙아이콘");
	}

}
