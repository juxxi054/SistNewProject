package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BtnArryaEvent07  extends JFrame implements ActionListener{

	Container cp;
	JButton[] btn=new JButton[6];
	String [] btnLabel= {"Red","Green","Blue","Black","Pink","White"};
	Color[] btnColor= {Color.red,Color.green,Color.blue,Color.black,Color.pink,Color.white};
	
	//생성자
		
			public BtnArryaEvent07(String tittle) {
				super(tittle); // JFrame 
			
			
			
		
			//위치 너비
			this.setBounds(1000,100,900,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cp=this.getContentPane();
			cp.setBackground(new Color(255,165,0));
			initDesign();
			this.setVisible(true);
		}

			
	//디자인
	
			public void initDesign()
			{
			//Panel 은 기본이 FlowLayout
			JPanel panel=new JPanel();
		    panel.setLayout(new GridLayout(7, 1));  //7행1열
			panel.setBackground(Color.black);
			
			//패널을 상단에 배치
			//this.add(panel,BorderLayout.NORTH);
			//this.add("North", panel);	
			this.add(panel,BorderLayout.WEST);
			
			
			//버튼생성
			for(int i=0;i<btn.length;i++)
			{   
				
				btn[i]=new JButton(btnLabel[i]);
				
				//panel에 버튼추가
				panel.add(btn[i]);
				//버튼의 색상을 각각의 색상으로 변경
				btn[i].setBackground(btnColor[i]);
				
				//버튼에 이벤트 추가
				btn[i].addActionListener(this);
				
				
			}

				
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object ob=e.getSource();
				
				//각각의 버튼을 누르면 배경색이 해당제목색으로 변한다
				
			for(int i=0;i<=btn.length;i++) {
				
				if(ob==btn[i]) {
				//프레임의배경색변경
				cp.setBackground(btnColor[i]);
				
				//창제목도 변경
				this.setTitle("Color: "+btnLabel[i] );
			}
				
			}
			
			}
				
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new BtnArryaEvent07("레이아웃이벤트");
	}


	
		
	}


