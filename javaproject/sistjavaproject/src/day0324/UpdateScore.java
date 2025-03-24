package day0324;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateScore extends JFrame {
	
	
	Container cp;
	JTextField tfName,tfJava,tfJsp,TfSpring;
	JComboBox<String> cbBan;
	JButton btnMod; //수정버튼
	String num; //수장할번호
	
	public UpdateScore(String tittle) {
		super(tittle); // JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		
		//위치 너비
		this.setBounds(250,100,300,300);
		//색상
		//this.setBackground(Color.blue);
		//this.getContentPane().setBackground(Color.pink); //Color 클래스의 상수변수
		//this.getContentPane(). setBackground(new Color(255,165,0));
		
		cp=this.getContentPane();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(new Color(255,200,150));
		initDesign();
		//this.setVisible(true);
	}

	
	public void initDesign()
	{
		this.setLayout(null);
		
		JLabel title1=new JLabel("학생명");
		JLabel title2=new JLabel("반");
		JLabel title3=new JLabel("Java");
		JLabel title4=new JLabel("Jsp");
		JLabel title5=new JLabel("Spring");
		
		title1.setBounds(30,10,60,30);
		this.add(title1);
		
		title2.setBounds(30,40,60,30);
		this.add(title2);
		
		title3.setBounds(30,70,60,30);
		this.add(title3);
		
		title4.setBounds(30,100,60,30);
		this.add(title4);
		
		title5.setBounds(30,130,60,30);
		this.add(title5);
		
		tfName=new JTextField(4);
		
		String [] ban= {"1강의장","2강의장","3강의장","4강의장"};
		cbBan=new JComboBox<String>(ban);
		tfJava=new JTextField(4);
		tfJsp=new JTextField(4);
		TfSpring=new JTextField(4);
		
		tfName.setBounds(90,15,70,20);
		this.add(tfName);
		
		cbBan.setBounds(90,45,70,20);
		this.add(cbBan);
		

		tfJava.setBounds(90,75,70,20);
		this.add(tfJava);
		

		tfJsp.setBounds(90,105,70,20);
		this.add(tfJsp);
		

		TfSpring.setBounds(90,135,70,20);
		this.add(TfSpring); 
		
		
		//버튼
		btnMod=new JButton("수정");
		btnMod.setBounds(50,170,80,25);
		this.add(btnMod);
		
	}
	
}

	// public static void main(String[] args) {
		// TODO Auto-generated method stub
   //new AddScore("성적추가");
	//}

//}
