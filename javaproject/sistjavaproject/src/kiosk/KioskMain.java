package kiosk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import day0319.DbConnect;
import day0326.shopDbModel;

public class KioskMain extends JFrame implements ActionListener {
    Container cp;
    JPanel b_JPanel;
    JButton btn1, btn2, btn3;

    public KioskMain(String title) {
        super(title);

        cp = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp.setBackground(Color.white);

        initDesign();

        this.setSize(600, 600);
        this.setVisible(true);
    }

    public void initDesign() {
        this.setLayout(new BorderLayout());
        
     // 상품 목록 패널
        b_JPanel = new JPanel();
        b_JPanel.setLayout(new GridLayout(3, 3, 4, 10)); // 2열 그리드
        cp.add( b_JPanel, BorderLayout.CENTER);

        btn1 = new JButton("음료");
        this.add(btn1);

        btn2 = new JButton("디저트");
        this.add(btn2);
        
        btn3 = new JButton("장바구니");
        this.add(btn3,BorderLayout.SOUTH);
      
        this.setVisible(true);                                            
        
            }
        
    

    public static void main(String[] args) {
        new KioskMain("주히꾸 베이커리");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}