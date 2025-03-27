package Car;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Car.DBConnect;

public class CarMain  extends JFrame implements ActionListener,ItemListener{

   Container cp;
   JTextArea area;
   JButton btnAdd, btnUpdate, btnDel, btnBuy, btnGogak;
   JRadioButton [] rb = new JRadioButton[4];
   DefaultTableModel model;
   JTable table;
   JScrollPane scrollPane;
   DBConnect db = new DBConnect();
   InsertCar insert = new InsertCar("차량 등록");
   UpdateCar update = new UpdateCar("차량 수정");
   CarDbModel cardb = new CarDbModel();

   
   //생성자
   public CarMain(String title) {
      super(title);
      
      //위치 너비
      this.setBounds(500, 200, 1000, 600);
      //색상
      cp = this.getContentPane();
      cp.setBackground(Color.WHITE);

      setDegign();
      
      //초기화면
      cardb.SelectCar(this, 1);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   //디자인
   public void setDegign() {
      this.setLayout(null);
     
      //버튼
      btnAdd = new JButton("차량 등록");
      btnAdd.setBounds(18, 20, 150, 50);
      btnAdd.addActionListener(this);
      this.add(btnAdd);
      btnUpdate = new JButton("차량 수정");
      btnUpdate.setBounds(208, 20, 150, 50);
      btnUpdate.addActionListener(this);
      this.add(btnUpdate);
      btnDel = new JButton("차량 삭제");
      btnDel.setBounds(408, 20, 150, 50);
      btnDel.addActionListener(this);
      this.add(btnDel);
      btnBuy = new JButton("차량 구매예약");
      btnBuy.setBounds(608, 20, 150, 50);
      btnBuy.addActionListener(this);
      this.add(btnBuy);
      btnGogak = new JButton("구매자 확인");
      btnGogak.setBounds(808, 20, 150, 50);
      btnGogak.addActionListener(this);
      this.add(btnGogak);
      
      //라디오 버튼
      ButtonGroup bg = new ButtonGroup();
      String [] rb_label = {"번호 순","제조사 별","연비 순","가격 순"};
      
      int xpox = 60;
      for(int i =0; i <rb.length; i++) {
    	  //라디오버튼 생성
    	  rb[i] = new JRadioButton(rb_label[i], i==0?true:false);
    	  rb[i].setBounds(xpox, 80, 150, 50);
    	  rb[i].setFont(new Font("",Font.BOLD,15));
    	  //rb[i].setBackground(Color.white);
    	  rb[i].setOpaque(false);
    	  rb[i].addItemListener(this);
    	  bg.add(rb[i]);
    	  this.add(rb[i]);
    	  xpox += 260;
      }
      //테이블
      String[] title = {"차번호","차이름","제조사", "색상", "연비(Km/L)", "가격", "출고일"};
      model = new DefaultTableModel(title, 0);
      table = new JTable(model);
      
      // 테이블에 스크롤 추가
      scrollPane = new JScrollPane(table);
      scrollPane.setBounds(20, 130, 950, 400);
      this.add(scrollPane);
      
      //버튼 액션 추가(추가,수정)
      insert.btnAdd.addActionListener(this);
      update.btnUpdate.addActionListener(this);
   }

   //이벤트
   @Override
   public void itemStateChanged(ItemEvent e) {
	   //라디오버튼 제어
	   for(int i =0; i <rb.length; i++) {
		   if(rb[i].isSelected() == true)
			   cardb.SelectCar(this, i+1);
	   }
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	   Object ob = e.getSource();
	   if(ob == btnAdd) {
		   insert.setVisible(true);
		   
		   insert.jmade.setSelectedItem("기아");
		   insert.jcolor.setSelectedItem("빨간색");
		   insert.pay.setText("");
		   insert.fuel.setText("");
	   }
	   else if(ob == insert.btnAdd) {
		   cardb.InsertCar(insert);
		   //초기화
		   insert.jmade.setSelectedItem("기아");
		   insert.jcolor.setSelectedItem("빨간색");
		   insert.pay.setText("");
		   insert.fuel.setText("");
		   
		   cardb.SelectCar(this, 1);
		   insert.setVisible(false);
	   }
	   else if(ob ==btnUpdate) {
		   int selectedRow = table.getSelectedRow();
		   if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "수정할 차량을 선택하여 주세요");
	            return;
		   }
	       update.jname.setSelectedItem((String)table.getValueAt(selectedRow, 1));
		   update.jmade.setSelectedItem((String)table.getValueAt(selectedRow, 2));
	       update.jcolor.setSelectedItem((String)table.getValueAt(selectedRow, 3));
	       update.fuel.setText((String)table.getValueAt(selectedRow, 4));
	       update.pay.setText((String)table.getValueAt(selectedRow, 5));
		   update.setVisible(true);
	   }
	   else if(ob ==update.btnUpdate) {
		   cardb.UpdateCar(update, this);
		   //초기화
		   /*update.jmade.setSelectedItem("기아");
		   update.jcolor.setSelectedItem("빨간색");
		   update.pay.setText("");
		   update.fuel.setText("");*/

		   cardb.SelectCar(this, 1);
		   update.setVisible(false);
	   }
	   else if ( ob ==btnDel) {
		   int selectedRow = table.getSelectedRow();
		   if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "삭제할 차량을 선택하여 주세요");
	            return;
		   }
		   cardb.DelteCar(this);
		   JOptionPane.showMessageDialog(this, "차량이 삭제되었습니다.");
		   cardb.SelectCar(this, 1);
	   }
   }
   
   public static void main(String[] args) {
      new CarMain("");
   
   }

}
