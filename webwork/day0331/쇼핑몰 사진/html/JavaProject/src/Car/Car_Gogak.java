package Car;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Car_Gogak extends JFrame implements ActionListener{

	
	Container cp;
	JTable table;
	JButton btnAdd, btnclose;
	JTextField gogak_name, gogak_hp, gogak_addr, car_name, car_made, car_color , car_pay, car_fuel,car_no;



	//생성자
	public Car_Gogak(String title) {
		super(title); 
		
		//위치 너비
		this.setBounds(700, 280, 500, 450);
		
		
		cp=this.getContentPane();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(245, 245, 245));
		initDesign();
		
		//this.setVisible(true);
	}	
	
	public void initDesign()
	{
        this.setLayout(null);
		
		JLabel title1=new JLabel("성함 "); 
		JLabel title2=new JLabel("전화번호 ");
		JLabel title3=new JLabel("배송지 ");
		JLabel title4=new JLabel("차량명 : ");
		JLabel title5=new JLabel("제조사 : ");
		JLabel title6=new JLabel("색상 : ");
		JLabel title9=new JLabel("연비 : ");
		JLabel title10=new JLabel("가격 : ");
		JLabel title11=new JLabel("번호 : ");
		
		JLabel title7=new JLabel("구매자 정보");
		JLabel title8=new JLabel("차량 정보");
		
		
		title1.setBounds(15,250,100,50);
		this.add(title1);
		
		title2.setBounds(225,248,100,50);
		this.add(title2);
		
		title3.setBounds(15,300,100,50);
		this.add(title3);
		
		title4.setBounds(15,50,100,50);
		title4.setForeground(Color.gray);
		this.add(title4);
		
		title5.setBounds(15,100,100,50);
		title5.setForeground(Color.gray);
		this.add(title5);
		
		title6.setBounds(15,150,100,50);
		title6.setForeground(Color.gray);
		this.add(title6);
		
		title9.setBounds(250,100,100,50);
		title9.setForeground(Color.gray);
		this.add(title9);
		
		title10.setBounds(250,150,100,50);
		title10.setForeground(Color.gray);
		this.add(title10);
		
		title11.setBounds(250,50,100,50);
		title11.setForeground(Color.gray);
		this.add(title11);
		
		
		title7.setBounds(140, 200, 200, 50);
		title7.setFont(new Font("",Font.BOLD,20));
		title7.setHorizontalAlignment(JLabel.CENTER); 
		this.add(title7);
		
		title8.setBounds(140, 10, 200, 50);
		title8.setFont(new Font("",Font.BOLD,20));
		title8.setHorizontalAlignment(JLabel.CENTER); 
		this.add(title8);
		
		
		gogak_name=new JTextField(6);
		gogak_hp=new JTextField(6);
		gogak_addr=new JTextField(6);
		car_name=new JTextField(6);
		car_made=new JTextField(6);
		car_color=new JTextField(6);
		car_no=new JTextField(6);
		car_fuel = new JTextField(6);
		car_pay = new JTextField(6);
		
		gogak_name.setBounds(65,260,150,30);
		this.add(gogak_name);
		
		gogak_hp.setBounds(285,260,160,30);
		this.add(gogak_hp);
		
		gogak_addr.setBounds(65,310,380,30);
		this.add(gogak_addr);
		

		car_name.setBounds(95,60,150,30);
		car_name.setBorder(BorderFactory.createEmptyBorder());
		car_name.setBackground(new Color(245, 245, 245));
		car_name.setFont(new Font("",Font.BOLD,15));
		this.add(car_name);
		

		car_made.setBounds(90,110,150,30);
		car_made.setBorder(BorderFactory.createEmptyBorder());
		car_made.setBackground(new Color(245, 245, 245));
		car_made.setFont(new Font("",Font.BOLD,15));
		this.add(car_made); 
		
		car_color.setBounds(85,160,150,30);
		car_color.setBorder(BorderFactory.createEmptyBorder());
		car_color.setBackground(new Color(245, 245, 245));
		car_color.setFont(new Font("",Font.BOLD,15));
		this.add(car_color); 
		
		car_no.setBounds(305,60,150,30);
		car_no.setBorder(BorderFactory.createEmptyBorder());
		car_no.setBackground(new Color(245, 245, 245));
		car_no.setFont(new Font("",Font.BOLD,15));
		this.add(car_no); 
		
		car_fuel.setBounds(305,110,150,30);
		car_fuel.setBorder(BorderFactory.createEmptyBorder());
		car_fuel.setBackground(new Color(245, 245, 245));
		car_fuel.setFont(new Font("",Font.BOLD,15));
		this.add(car_fuel); 
		
		car_pay.setBounds(295,160,150,30);
		car_pay.setBorder(BorderFactory.createEmptyBorder());
		car_pay.setBackground(new Color(245, 245, 245));
		car_pay.setFont(new Font("",Font.BOLD,15));
		this.add(car_pay); 
		
		btnAdd=new JButton("구매하기");
		btnAdd.setBounds(325,350,120,40);
		this.add(btnAdd);
		
		btnclose=new JButton("구매취소");
		btnclose.setBounds(180,350,120,40);
		this.add(btnclose);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Car_Gogak("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
