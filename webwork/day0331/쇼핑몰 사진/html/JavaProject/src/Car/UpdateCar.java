package Car;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdateCar extends JFrame {

    Container cp;
    JTextArea area;
    JButton btnUpdate;
    JTextField pay, fuel;
    JComboBox<String> jcolor, jmade, jname;
    CarDbModel cardb = new CarDbModel();
    Mycanvas mycan;

    // 생성자
    public UpdateCar(String title) {
        super(title);

        // 위치 너비
        this.setBounds(600, 250, 600, 400);
        // 색상
        cp = this.getContentPane();
        cp.setBackground(new Color(225, 225, 225));

        setDegign();

        //this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 디자인
    public void setDegign() {
        this.setLayout(null);

        JLabel title1 = new JLabel("차 제조사");
        JLabel title2 = new JLabel("차 이름");
        JLabel title3 = new JLabel("차 색갈");
        JLabel title4 = new JLabel("차 연비");
        JLabel title5 = new JLabel("차 가격");

        // 소제목
        title1.setBounds(10, 20, 120, 50);
        title1.setFont(new Font("", Font.BOLD, 15));
        this.add(title1);

        title2.setBounds(10, 90, 120, 50);
        title2.setFont(new Font("", Font.BOLD, 15));
        this.add(title2);

        title3.setBounds(10, 160, 120, 50);
        title3.setFont(new Font("", Font.BOLD, 15));
        this.add(title3);

        title4.setBounds(10, 230, 120, 50);
        title4.setFont(new Font("", Font.BOLD, 15));
        this.add(title4);

        title5.setBounds(10, 300, 120, 50);
        title5.setFont(new Font("", Font.BOLD, 15));
        this.add(title5);

        // 텍스트필드
        String[] made_name = {"기아", "현대", "제네시스", "쉐보레"};
        jmade = new JComboBox<>(made_name);
        jmade.setBounds(80, 25, 200, 40);
        this.add(jmade);

        String [] carname = {"K5", "K7", "소렌토"};
        jname = new JComboBox<>(carname);
        jname.setBounds(80, 95, 200, 40);
        this.add(jname);

        String[] color = {"빨간색", "노랑색", "파란색", "초록색", "검은색", "흰색"};
        jcolor = new JComboBox<>(color);
        jcolor.setBounds(80, 165, 200, 40);
        this.add(jcolor);

        fuel = new JTextField();
        fuel.setBounds(80, 235, 200, 40);
        this.add(fuel);

        pay = new JTextField();
        pay.setBounds(80, 305, 200, 40);
        this.add(pay);

        // 이미지 캔버스 설정
        mycan = new Mycanvas();
        mycan.setBounds(300, 20, 300, 200);
        this.add(mycan);
        
        btnUpdate = new JButton("수정하기");
        btnUpdate.setBounds(330, 260, 200, 50);
        btnUpdate.setOpaque(true);
        this.add(btnUpdate);

        // 콤보박스에 아이템 리스너 추가
        jmade.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updatecar();
            }
        });
    }

    public void updatecar() {
        String[] carname = {}; // 초기화
        String selectmade = (String) jmade.getSelectedItem(); // jmade콤보박스 아이템 이름 가져오기
        String imagePath = "";

        // 제조사에 따라 차명과 이미지 경로를 설정
        switch (selectmade) {
            case "기아":
                carname = new String[]{"K5", "K7", "소렌토"};
                imagePath = "C:\\SIST0217\\work\\javaproject\\JavaProject\\image\\kia.png";  // 절대 경로 사용
                break;
            case "현대":
                carname = new String[]{"아반떼", "소나타", "투싼"};
                imagePath = "C:\\SIST0217\\work\\javaproject\\JavaProject\\image\\hyundai.png";  // 절대 경로 사용
                break;
            case "제네시스":
                carname = new String[]{"G70", "G80", "GV80"};
                imagePath = "C:\\SIST0217\\work\\javaproject\\JavaProject\\image\\genesis.png";  // 절대 경로 사용
                break;
            case "쉐보레":
                carname = new String[]{"말리부", "트래버스", "스파크"};
                imagePath = "C:\\SIST0217\\work\\javaproject\\JavaProject\\image\\chevrolet.png";  // 절대 경로 사용
                break;
        }

        // jname 콤보박스 초기화 후 아이템 추가
        jname.removeAllItems(); // jname콤보박스 초기화
        for (String name : carname)
            jname.addItem(name); // jname콤보박스에 아이템 넣기

        // Mycanvas에 경로로 이미지 업데이트
        mycan.updateImage(imagePath);
    }

    // Mycanvas 클래스
    class Mycanvas extends Canvas {
        private Image carlogo;  // 이미지 객체

        public Mycanvas() {
            // 기본 이미지 설정
            carlogo = new ImageIcon("C:\\SIST0217\\work\\javaproject\\JavaProject\\image\\kia.png").getImage();  // 절대 경로로 이미지 로드
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(carlogo, 30, 10, 200, 200, this);
        }

        // 이미지를 업데이트하는 메서드
        public void updateImage(String imagePath) {
            carlogo = new ImageIcon(imagePath).getImage();  // 절대 경로로 새 이미지 로드
            repaint();  // 이미지 변경 후 다시 그리기
        }
    }

    public static void main(String[] args) {
        new UpdateCar("");
    }

}
