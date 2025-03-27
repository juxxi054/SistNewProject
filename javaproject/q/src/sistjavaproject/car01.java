package Car;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class car01 extends JFrame implements ActionListener{

	
	Container cp;
	JTable table;
	JButton btnAdd;
	JTextField gogak_name, gogak_hp, gogak_addr, car_name, car_made, car_color;



	//생성자
	public car01(String title) {
		super(title); 
		
		//위치 너비
		this.setBounds(250, 100, 550, 550);
		
		
		cp=this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		initDesign();
		
		this.setVisible(true);
	}	
	
	public void initDesign()
	{
        this.setLayout(null);
		
		JLabel title1=new JLabel("구매자 이름:"); 
		JLabel title2=new JLabel("구매자 번호:");
		JLabel title3=new JLabel("배송지:");
		JLabel title4=new JLabel("차량 이름:");
		JLabel title5=new JLabel("차량 제조사:");
		JLabel title6=new JLabel("차량 색상:");
		
		JLabel title7=new JLabel("구매자 정보");
		JLabel title8=new JLabel("차량 정보");
		
		
		title1.setBounds(30,50,100,50);
		this.add(title1);
		
		title2.setBounds(30,100,100,50);
		this.add(title2);
		
		title3.setBounds(30,150,100,50);
		this.add(title3);
		
		title4.setBounds(30,250,100,50);
		this.add(title4);
		
		title5.setBounds(30,300,100,50);
		this.add(title5);
		
		title6.setBounds(30,350,100,50);
		this.add(title6);
		
		
		title7.setBounds(120, 10, 200, 50);
		title7.setHorizontalAlignment(JLabel.CENTER); 
		this.add(title7);
		
		title8.setBounds(120, 200, 200, 50);
		title8.setHorizontalAlignment(JLabel.CENTER); 
		this.add(title8);
		
		
		gogak_name=new JTextField(6);
		gogak_hp=new JTextField(6);
		gogak_addr=new JTextField(6);
		car_name=new JTextField(6);
		car_made=new JTextField(6);
		car_color=new JTextField(6);
		
		gogak_name.setBounds(120,65,250,20);
		this.add(gogak_name);
		
		gogak_hp.setBounds(120,115,250,20);
		this.add(gogak_hp);
		

		gogak_addr.setBounds(120,165,250,20);
		this.add(gogak_addr);
		

		car_name.setBounds(120,265,250,20);
		this.add(car_name);
		

		car_made.setBounds(120,315,250,20);
		this.add(car_made); 
		
		car_color.setBounds(120,365,250,20);
		this.add(car_color); 
		
		btnAdd=new JButton("구매하기");
		btnAdd.setBounds(400,400,90,40);
		this.add(btnAdd);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new car01("구매");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
