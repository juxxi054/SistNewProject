package Car;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GogakInfo extends JFrame implements ActionListener{
     Container cp;
      DBConnect db=new DBConnect();
      DefaultTableModel model;
      JTable table;
      JScrollPane scrollPane;
      JButton delete , searchbutton;
      GogakDB gogakdb = new GogakDB();
      CarDbModel cardb = new CarDbModel();
      JTextField jsearch;


      
      //생성자
      public GogakInfo(String title) {
         super(title);
         //위치 너비
         this.setBounds(550, 220, 900, 500);
         //색상
         cp = this.getContentPane();
         cp.setBackground(new Color(125,250,250)); 
         //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         cp.setBackground(Color.white);
         setDegign();
         gogakdb.SelectGogak(this);
         //this.setVisible(true);
      }
      
      
      //디자인
      public void setDegign() {
         this.setLayout(null);
         //table
         String[]title= {"No","차량명","제조사","색상","고객이름","고객번호","고객주소"};
         model= new DefaultTableModel(title,0);
         table=new JTable(model);
         JScrollPane js=new JScrollPane(table);
         js.setBounds(70,70,750,350);
         this.add(js);
      
         searchbutton = new JButton("검색");
         searchbutton.setBounds(465,30,80,30);
         searchbutton.addActionListener(this);
         this.add(searchbutton);
        
         delete = new JButton("예약취소");
         delete.setBounds(720, 12, 100, 40);
         delete.addActionListener(this);
         this.add(delete);
         
         JLabel search = new JLabel("검색(차량번호,고객이름) : ");
         search.setFont(new Font("",Font.BOLD,15));
         search.setBounds(70, 20, 200, 50);
         this.add(search);
         
         jsearch = new JTextField(6);
         jsearch.setBounds(250, 30, 200, 30);
         jsearch.setFont(new Font("",Font.BOLD,15));
         this.add(jsearch);
         
         
      }
      @Override
  		public void actionPerformed(ActionEvent e) {
    	  Object ob = e.getSource();
    	  if(ob == searchbutton) {
    		  gogakdb.SearchGogak(this);
    	  }
    	  else if(ob == delete) {
    	   int selectedRow = table.getSelectedRow();
		   if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "취소할 고객을 선택하여 주세요");
	            return;
		   }
		   System.out.println("안녕");
		   gogakdb.CancelBuy(this);
		   JOptionPane.showMessageDialog(this, "취소되었습니다.");
		   gogakdb.SearchGogak(this);
		   
		   }
  		}
   
      public static void main(String[] args) {
         new GogakInfo(null);
      
      }
   }
