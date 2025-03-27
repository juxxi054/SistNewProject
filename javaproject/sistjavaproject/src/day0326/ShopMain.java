package day0326;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShopMain  extends JFrame implements ActionListener{
	
	Container cp;
	JButton btnAdd,btnDel,btnUpdate,btnSelect;
	shopDbModel dbmodel=new shopDbModel();
	
	public ShopMain(String title) {
		super(title); 
		
		//위치 너비
		this.setBounds(250, 100, 700, 500);
		
		cp=this.getContentPane();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp.setBackground(Color.white);
		initDesign();
		
		this.setVisible(true);
	}	
	
	public void initDesign()
	{
	this.setLayout(new GridLayout(4,1)); //4행 1열의 그리드 레이이웃
	
	btnAdd=new JButton("상품추가");
	btnSelect=new JButton("상품조회");
	btnDel=new JButton("상품삭제");
	btnUpdate=new JButton("상품수정");
	
	this.add(btnAdd);
	this.add(btnSelect);
	this.add(btnDel);
	this.add(btnUpdate);
	
	//이벤트
	btnAdd.addActionListener(this);
	btnSelect.addActionListener(this);
	btnDel.addActionListener(this);
	btnUpdate.addActionListener(this);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	Object ob=e.getSource();
	
	
	if(ob==btnAdd)
		
	{
		//상품추가폼 생성
		shopAdd addshop=new shopAdd("입력폼");
	}else if(ob==btnDel)
	{
		
		String num=JOptionPane.showInputDialog("삭제할 시퀀스 번호를 입력해주세요");
	    int delCode=dbmodel.deleteShop(Integer.parseInt(num));
	    
	    if(delCode==0)
	    	JOptionPane.showMessageDialog(btnDel,"해당num이 존재하지않습니다");
	    else 
	    	JOptionPane.showMessageDialog(btnDel, "삭제되었습니다");
		
		
	}else if(ob==btnSelect)
	{
		shopList list=new shopList("전체출력");
	}else if(ob==btnUpdate)
	{
		//몇번을 수정할지 묻고 그 해당 시퀀스의 수정창을 띄어준다
		String num=JOptionPane.showInputDialog("수정할 num번호를 입력해주세요");
		System.out.println(num);
		//취소시 메소드 종료
		if(num==null)
			return;
		
		shopDto dto=dbmodel.getOneSangpum(num);
	shopupdate update=new shopupdate("수정폼");
		
		//수정폼에 데이터 넣기
		update.num=dto.getNum();
		update.tfSang.setText(dto.getSanmgpum());
		update.tfSu.setText(String.valueOf(dto.getSu()));
		update.tfDan.setText(String.valueOf(dto.getDan()));
	    update.imageName=dto.getPhoto();
	    update.lblPhoto.setText(dto.getNum());
	
		update.setVisible(true);
	}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new ShopMain ("shop main");
	}

	

}
