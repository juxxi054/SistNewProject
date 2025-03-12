package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEventcolor6 extends JFrame {

	Container cp;	
	JButton btn1,btn2;
	
	public ButtonEventcolor6 (String tittle) {
		super(tittle); 
		
		//위치 너비
		this.setBounds(200,100,300,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cp=this.getContentPane();
		cp.setBackground(new Color(255,165,0));
		initDesign();
		this.setVisible(true);	
	}
	
		
	public void initDesign() {
	this.setLayout(new FlowLayout());
	
	btn1=new JButton("배경색을 핫핑크로 변경");
	this.add(btn1);
	
	btn2=new JButton("배경색을 노랑색으로로 변경");
	this.add(btn2);
	
	//익명내부클래스로 이벤트
	btn1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cp.setBackground(Color.magenta);
		}
	});
	
	btn2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cp.setBackground(Color.yellow);
		}
	});
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ButtonEventcolor6("버튼이벤트");
	}

}
