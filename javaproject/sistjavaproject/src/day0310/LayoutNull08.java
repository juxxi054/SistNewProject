package day0310;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//두개의 라벨과 텍스트필드  버튼만든후 각각 숫자를 넣고 클릭하면 라벨에 22+44=66 출력예정
public class LayoutNull08 extends JFrame {

	Container cp;
	JLabel lblResult,lblnum1,lblnum2;
	JTextField tfSul1,tfSul2;
	JButton btnAdd;
	
	
	
	public LayoutNull08(String tittle) {
		super(tittle); // JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		
		//위치 너비
		this.setBounds(200,100,800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cp=this.getContentPane();
		cp.setBackground(new Color(255,165,0));
		 initDesign();
		this.setVisible(true);
	}

	public  void initDesign()
	{
		//기본레이아웃 없애고 직접지정
		this.setLayout(null);
		lblnum1=new JLabel("숫자1: ");
		lblnum2=new JLabel("숫자2: ");
		
		lblnum1.setBounds(50,30,80,50);
		this.add(lblnum1);
		
		
		lblnum2.setBounds(50,80,80,50);
		this.add(lblnum2);
		
		tfSul1=new JTextField();
		tfSul1.setBounds(100,30,100,40);
		this.add(tfSul1);
		
		tfSul2=new JTextField();
		tfSul2.setBounds(100,80,100,40);
		this.add(tfSul2);
		
		btnAdd=new JButton("숫자더하기");
		btnAdd.setBounds(250,50,100,50);
		this.add(btnAdd);
		
		//결과 나오는곳
		lblResult=new JLabel("결과나오는곳");
		lblResult.setBounds(100, 200, 200,50);
		lblResult.setBorder(new TitledBorder("결과확인"));
		lblResult.setFont(new Font("", Font.BOLD,20));
		this.add(lblResult);
		
		//버튼이벤트_익명내부클래스
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int su1=Integer.parseInt(tfSul1.getText().trim());
				int su2=Integer.parseInt(tfSul2.getText().trim());//앞뒤공백제거후 숫자로 변환
				
				int sum=su1+su2;
				
				String s=su1+"+"+su2+"="+sum;
				lblResult.setText(s);
				
			}
		});
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 new LayoutNull08("스윙레이아웃" ); 
	}

}
