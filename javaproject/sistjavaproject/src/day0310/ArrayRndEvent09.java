package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ArrayRndEvent09 extends JFrame{

	Container cp;
	JButton btnRandom;
	JLabel [] lblFood=new JLabel[9];
	String[] str= {"피자","떡볶이","초밥","국밥","파스타","감자탕","김밥","돈까스","볶음밥"};
	
	public ArrayRndEvent09(String tittle) {
		super(tittle); // JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		
		//위치 너비
		this.setBounds(200,100,700,700);
		//색상
		//this.setBackground(Color.blue);
		//this.getContentPane().setBackground(Color.pink); //Color 클래스의 상수변수
		//this.getContentPane(). setBackground(new Color(255,165,0));
		
		cp=this.getContentPane();
		cp.setBackground(new Color(255,165,0));
		initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		
		//패널을 프레임의 센터에 추가
		JPanel pCenter=new JPanel(new GridLayout(3, 3));
		this.add(pCenter);
		
		//라벨을 패널에 추가
		for(int i=0;i<lblFood.length;i++)
		{
			lblFood[i]=new JLabel(str[i],JLabel.CENTER);
			//r,g,b, 랜덤색상 얻기
			int r=(int)(Math.random()*256); //0~255
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			
			lblFood[i].setBackground(new Color(r, g, b));
			
			lblFood[i].setOpaque(true);
			
			//패널에 라벨추가
			pCenter.add(lblFood[i]);
		
		//프레임의 하단에 버튼생성후 추가
		btnRandom=new JButton("라벨색상변경");
		//this.add(btnRandom,BorderLayout.SOUTH);
		this.add("South",btnRandom);
		
		}
		//버튼을 누르면 라벨부분 랜덤색상 변경 이벤트
		
		//이벤트
		btnRandom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<lblFood.length;i++)
				{
				
				//r,g,b, 랜덤색상 얻기
				int r=(int)(Math.random()*256); //0~255
				int g=(int)(Math.random()*256);
				int b=(int)(Math.random()*256);
				
				lblFood[i].setBackground(new Color(r, g, b));
				
			}
		}
		
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new ArrayRndEvent09("어레이");
	}

}
