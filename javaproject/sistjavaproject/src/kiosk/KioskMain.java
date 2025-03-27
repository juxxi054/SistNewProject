package kiosk;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import day0319.DbConnect;
import day0326.shopDbModel;

public class KioskMain extends JFrame implements ActionListener{
	
	
	Container cp;
	JButton btnDrink,btnDesert;
	DbConnect db=new DbConnect();
	JFrame frame =new JFrame();
	
	
	public KioskMain(String title) {
		super(title); 
		
        
		
		cp=this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		initDesign();
	
	}	
	
	public void initDesign()
	{
		frame=new JFrame("주히꾸 베이커리");
		frame.setSize(500,500);
        frame.setVisible(true);
        
        btnDrink=new JButton("음료");
        btnDrink.addActionListener(this); //이벤트추가
        this.add(btnDrink);
        
        btnDesert=new JButton("디저트");
        btnDesert.addActionListener(this);
        this.add(btnDesert);
	}
	
	
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new KioskMain("");
	}

}
