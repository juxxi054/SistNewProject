package day0321;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.PermissionCollection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import day0319.DbConnect;

public class SawonDbSwing extends JFrame implements ItemListener,ActionListener{
	

DbConnect db=new DbConnect();
Container cp;
JTable table;
DefaultTableModel model;
JRadioButton [] rb=new JRadioButton[6];
JButton btnAdd,btnDel;




//생성자
public SawonDbSwing(String title) {
	super(title); 
	
	//위치 너비
	this.setBounds(250, 100, 700, 500);
	
	cp=this.getContentPane();
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	cp.setBackground(Color.white);
	initDesign();
	
	//테이블 생성후 db로부터 데이터 가져오기(1:전체출력)
	this.sawonTableSelect(1);
	
	
	this.setVisible(true);
}


//디자인
public void initDesign()
{
	this.setLayout(null);

	//table
	String [] tittle= {"번호","ID","사원명","성별","부서명","월급여"};
	model=new DefaultTableModel(tittle, 0); //제목만 일단 넣고 행갯수는 0으로 추가
	table=new JTable(model);		
	
	table.getColumnModel().getColumn(0).setPreferredWidth(10); //셀너비 조절
	table.getColumnModel().getColumn(1).setPreferredWidth(10); 
	
	JScrollPane  js=new JScrollPane(table);
	js.setBounds(10,100,670,350);
	this.add(js);
	
	
	//라디오 버튼 추가
	ButtonGroup bg=new ButtonGroup();
	//전체 남자 여자 홍보부 개발부
	String [] rb_label= {"전체","남자","여자","홍보부","개발부","교육부"};
	
	int xpos=10;
	for(int i=0;i<rb.length;i++)
	{
		//라디오 버튼을 셍성
		rb[i]=new JRadioButton(rb_label[i],i==0?true:false);
		rb[i].setBounds(xpos,50,90,20);
		rb[i].setOpaque(rootPaneCheckingEnabled);
		
		//이벤트 추가
		rb[i].addItemListener(this);
		
		bg.add(rb[i]);
		this.add(rb[i]);
		xpos+=100;
	}
			
	
	//삭제버튼
    btnDel=new JButton("사원삭제");
    btnDel.setBounds(10,10,100,30);
    btnDel.addActionListener(this); //이벤트추가
    this.add(btnDel);
    
    btnAdd=new JButton("사원추가");
    btnAdd.setBounds(150,10,100,30);
    btnAdd.addActionListener(this);
    this.add(btnAdd);
    
}
	

//db데이터 가지고 와서 테이블에 추가

public void sawonTableSelect(int select)
{
	String sql="";
	
	if(select==1)
		sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay from sawon";
	else if (select==2)
		sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
				+ "from sawon where gender='남자'";
	else if (select==3)
		sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
				+ "from sawon where gender='여자'";
	else if (select==4)
		sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
				+ "from sawon where buseo='홍보부'";
	else if (select==5)
		sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
				+ "from sawon where buseo='개발부'";
	else if (select==6)
		sql="select ROWNUM no,num id,name,gender,buseo,to_char(pay,'L999,999,999') pay "
				+ "from sawon where buseo='교육부'";
	
	Connection conn=db.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try {
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		//기존의 데이터 삭제후 가져오기
		model.setRowCount(0);
		
		while(rs.next())
		{
			//테이블에 추가할 벡터 선언후 데이터 추가
			Vector<String> data=new Vector<String>();
			data.add(rs.getString("no"));
			data.add(rs.getString("id"));
			data.add(rs.getString("name"));
			data.add(rs.getString("gender"));
			data.add(rs.getString("buseo"));
			data.add(rs.getString("pay"));
			
			//백터의 데이터를 행으로 추가
			
			model.addRow(data);
		}
		
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		db.dbClose(rs,pstmt, conn);
	}
	
}

public static void main(String[] args) {
	// TODO Auto-generated method stub

	new SawonDbSwing("사원테이블 DB");
}


@Override
public void actionPerformed(ActionEvent e) {
	// 추가버튼,삭제버튼
	Object ob=e.getSource();
	
	Connection conn=db.getConnection();
	PreparedStatement pstmt=null;
	String sql="";
	
	if(ob==btnDel)
	{
		//행번호 얻기
		int row=table.getSelectedRow();
		System.out.println(row);
		
		//선택 안했을경우
		if(row==-1)
		{
			JOptionPane.showMessageDialog(this,"삭제할 행을 먼저 선택해주세요");
			return; //메서드 종료
		}
		
		
		//선택한 행의 id(num)얻기
		String num=(String)model.getValueAt(row,1);
				System.out.println(num);
				
	   //db데이터 삭제 테이블 다시 출력
		sql="delete from sawon where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//num 바인딩
			pstmt.setString(1, num);
			//실행
			pstmt.execute();
			
			//전체 데이터 다시 불러오기
			this.sawonTableSelect(1);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}else if (ob==btnAdd)
	{
		String name=JOptionPane.showInputDialog("사원명도 입력해주세요");
		String gender=JOptionPane.showInputDialog("성별도 입력해주세요");
		String buseo=JOptionPane.showInputDialog("부서도(홍보부,개발부,교육부) 입력해주세요");
		String pay=JOptionPane.showInputDialog("급여도 입력해주세요");
		
		
		sql="insert into sawon values (seq_sawon.nextval,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1,name);
			pstmt.setString(2,gender);
			pstmt.setString(3,buseo);
			pstmt.setString(4,pay);
			
			//실행
			pstmt.execute();
			
			//테이블 다시 호출
			this.sawonTableSelect(1);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


@Override
public void itemStateChanged(ItemEvent e) {
	// 라디오 버튼 제어
	Object ob=e.getSource();
	for(int i=0;i<rb.length;i++)
	{
		if(rb[i]==ob)
			this.sawonTableSelect(i+1);
		
	}
}
}