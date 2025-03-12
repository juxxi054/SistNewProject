package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuizeLabel  extends JFrame implements ActionListener{

Container cp;
JLabel lblResult,lblnum1,lblnum2;
JTextField tfSul1,tfSul2;
JButton btn1,btn2,btn3,btn4,btnAdd;

//생성자
   
   public QuizeLabel(String tittle) {
      super(tittle); 
      
      
      //위치 너비
      this.setBounds(200,100,500,800);
      cp=this.getContentPane();
      cp.setBackground(Color.white);
      initDesign();
      this.setVisible(true);
   }
   
   public void initDesign() {
	   this.setLayout(null);
		lblnum1=new JLabel("숫자1: ");
		lblnum2=new JLabel("숫자2: ");
		
		lblnum1.setBounds(50,30,80,50);
		this.add(lblnum1);
		
		
		lblnum2.setBounds(50,80,80,50);
		this.add(lblnum2);
	   
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
    new QuizeLabel("퀴즈");
}

}