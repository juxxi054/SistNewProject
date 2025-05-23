package day0312;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class CheckRadio02 extends JFrame implements ActionListener,ItemListener{

	Container cp;
	JCheckBox cbDriverLic,cbBold;
	JCheckBox [] cbHobby=new JCheckBox[4];
	JButton btnhobby;
	
	JLabel lblResult;
	
	public  CheckRadio02 (String tittle) {
		super(tittle); 
		
		//위치 너비
		this.setBounds(200,100,800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp=this.getContentPane();
		cp.setBackground(new Color(255,165,0));
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign() 
	
	{
		this.setLayout(null);
		
		cbDriverLic=new JCheckBox("운전면허");
		cbDriverLic.setBounds(50,50,100,30);
		cbDriverLic.setOpaque(false);
		cbDriverLic.addItemListener(this); //아이템대상임을 표기
		this.add(cbDriverLic);
		
		//굵게 할지에 관한 체크박스
		
		cbBold=new JCheckBox("라벨을 굵게");
		cbBold.setBounds(50,100,150,30);
		cbBold.setOpaque(false);
		cbBold.addItemListener(this);
		this.add(cbBold);
		
		//취미체크박스
		String [] hobby= {"영화보기","책읽기","여행","헬스"};
		
		int xpos=50;
		for(int i=0;i<cbHobby.length;i++)
		{
			cbHobby[i]=new JCheckBox(hobby[i]);
			cbHobby[i].setBounds(xpos,150,100,30);
			cbHobby[i].setOpaque(false);
			this.add(cbHobby[i]);
			xpos+=100;
		}
		
		//결과라벨
		lblResult=new JLabel("안녕 체크앤 라디오 연습중이야",JLabel.CENTER);
		lblResult.setBounds(50,25,400,400);
		lblResult.setBorder(new LineBorder(Color.pink,5));
		this.add(lblResult);
		
		//버튼
		btnhobby=new JButton("나의 취미 알아보기");
		btnhobby.setBounds(170,200,300,20);
		this.add(btnhobby);
		btnhobby.addActionListener(this); //버튼에 이벤트 추가
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 new CheckRadio02("스윙");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 체크박스 눌렀을때 라벨에 출력
		String msg="나의 취미는";
		int select=0;
		for(int i=0;i<cbHobby.length;i++)
		{
			if(cbHobby[i].isSelected())
			{
				select++;
				msg+="["+cbHobby[i].getText()+"]";
			}
		}
		if(select==0)
			msg="나는 해당하는 취미가 없어요";
		else
			msg+="입니다";
		
		//라벨에 출력
		lblResult.setText(msg);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		//버튼을 눌렀을때 라벨에 출력
		
	Object ob=e.getItem();
	
	if(ob==cbDriverLic)
	{
		String s="체크상태:"+cbDriverLic.isSelected()+","+cbDriverLic.getText();
		if(cbDriverLic.isSelected())
			lblResult.setText("운전면허가 있습니다");
		else
			lblResult.setText("운전면허가 없습니다");
		
		//lblResult.setText(s);
	} else if (ob==cbBold)
	{
		if(cbBold.isSelected())
			lblResult.setFont(new Font("",Font.BOLD,20));
		else 
			lblResult.setFont(new Font("",Font.PLAIN,20));
	}
	
	}

}
