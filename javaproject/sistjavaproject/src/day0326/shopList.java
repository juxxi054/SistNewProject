package day0326;

import java.awt.Color;
import java.awt.Container;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class shopList extends JFrame {

		
		
		
		Container cp;
		shopDbModel db=new shopDbModel();
		DefaultTableModel model;
		JTable table;
		Vector<shopDto> list;
		
		
		
		public  shopList (String title) {
			super(title); 
			
			//위치 너비
			this.setBounds(250, 100, 500,300);
			
			cp=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			cp.setBackground(Color.white);
			initDesign();
			
			this.setVisible(true);
		}	
		

		public void initDesign()
		{
		 this.setLayout(null);
		 
		 //db로부터 목록얻기
		 list=db.getAllSangpums();
		 
		 //table
		 String[]title= {"No.","상품명","수량","단가","총금액","구입일자"};
		 model=new DefaultTableModel(title,0);
		 table=new JTable(model);
		 JScrollPane js=new JScrollPane(table);
		 js.setBounds(20,20,500,300);
		 this.add(js);
		 
		 dataWrite();
		
		}
		
		//리스트의 데이터를 추가
		public void dataWrite()
		{
			model.setRowCount(0);
			
			//테이블에 추가
			for(shopDto dto:list)
			{
				Vector<String> data=new Vector<String>();
				data.add(dto.getNum());
	    		data.add(dto.getSanmgpum());
	    		data.add(String.valueOf(dto.getSu()));
	    		data.add(String.valueOf(dto.getDan()));
	    		data.add(String.valueOf(dto.getSu()*dto.getDan()));
	    		data.add(String.valueOf(dto.getGuipday()));
	    		
	    		//테이블모델에 추가
	    		model.addRow(data);
			}
		}
		
}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		new shopList("Shop 전체 리스트");
	}

}*/
