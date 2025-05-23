package day0312;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GraphicImage04 extends JFrame{

	Container cp;
	static final String fileName1="C:\\sist0217\\image\\logoImg\\profile-picture.png";
	static final String fileName2="C:\\sist0217\\image\\logoImg\\toy06.png";
	static final String fileName3="C:\\sist0217\\image\\logoImg\\toy06.png";
	
			
	
	public GraphicImage04(String title) {
		super(title); //JFrame부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(500, 100, 400, 500);
		
		cp=this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
	

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.green);
		g.drawLine(20, 60, 300, 60); //선
		
		g.setColor(Color.magenta);
		g.drawOval(20, 80, 50, 50); //테두리만 있는 원
		g.fillOval(100, 80,50, 50); //채우기 원
		
		g.setColor(Color.blue);
		g.drawRect(180, 80, 50, 50);
		g.fillRect(250, 80, 50, 50);
		
		//이미지
		
		Image image1=new ImageIcon(fileName1).getImage();
		g.drawImage(image1, 60,220, this);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     new GraphicImage04("스윙");
	}

}
