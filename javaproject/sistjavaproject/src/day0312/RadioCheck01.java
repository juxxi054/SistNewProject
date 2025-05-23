package day0312;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class RadioCheck01 extends JFrame implements ActionListener {

	Container cp;
	JRadioButton [] rb=new JRadioButton[4]; //하나만 선택하고 싶을때 
	JCheckBox [] cb=new JCheckBox[4];
	JLabel[]  lb=new JLabel[4];
	Color[] colors= {Color.red,Color.green,Color.black,Color.orange};
	JLabel lblmessage;
	
	
	public RadioCheck01 (String tittle) {
		super(tittle); 
		
		//위치 너비
		this.setBounds(200,100,300,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp=this.getContentPane();
		cp.setBackground(new Color(255,165,0));
		initDesign();
		this.setVisible(true);
	}
	
	public void initDesign()
	{
		//상단패널에 4개의 라디오버튼 만들기
		String[] str1= {"빨강","초록","검정","오렌지"};
		JPanel pTop=new JPanel();
		pTop.setBorder(new TitledBorder("글자색선택"));
		this.add("North",pTop);
		
		//라디오 버튼을 하나만 선택되도록 하려면 그룹을 지어줘야함

		ButtonGroup bg=new ButtonGroup();
		
		for(int i=0;i<rb.length;i++)   
		{
			rb[i]=new JRadioButton(str1[i],i==1?true:false); //라디오버튼 생성
			pTop.add(rb[i]); //탑패널에 4개의 라디오버튼 추가
			bg.add(rb[i]); //버튼그룹에 4개의 라디오버튼을 추가
			
			rb[i].addActionListener(this);  //버튼에 액션추가
			
	}
		
		
		
		//결과출력
     ImageIcon icon=new ImageIcon("C:\\sist0217\\image\\swingimage\\img2.gif");
		
	lblmessage = new JLabel("오늘은 즐거운 수요일",icon,JLabel.CENTER);
	lblmessage.setHorizontalAlignment(JLabel.LEFT);
	lblmessage.setBorder(new LineBorder(Color.red,2));
	this.add("Center",lblmessage);
	
	//하단패널에 보더로 감싼 5개의 checkbox버튼 만들기
	JPanel pBottom=new JPanel();
	pBottom.setBorder(new TitledBorder("가능한 컴퓨터 언어는?"));
	 this.add("South", pBottom);
	String[] str2= {"Java","Html","JSP","Ajax"};
	
	for(int i=0;i<cb.length;i++)
	{
		cb[i]= new JCheckBox(str2[i]);
		pBottom.add(cb[i]);
		cb[i].addActionListener(this);
	}

	
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      new RadioCheck01("스윙");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob=e.getSource();
		
		//라디오버튼 처리
		for(int i=0;i<rb.length;i++)
		{
			if(ob==rb[i])
			{
				//글자색변경
				lblmessage.setForeground(colors[i]);
				//폰트
				lblmessage.setFont(new Font("",Font.BOLD,20));
				
			}
		}
		
		//체크박스 호출처리,선택한 체크박스의 메세지별 출력
		String msg="나의 가능한 컴퓨터 언어는";
		
		for(int i=0;i<cb.length;i++)
		{
			if(cb[i].isSelected()==true)
			{
				msg+=cb[i].getText()+"  ";
			}
		}
		lblmessage.setText(msg);
	}

}
