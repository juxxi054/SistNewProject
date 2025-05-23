package day0312;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class QuizeRadioCheck  extends JFrame implements ActionListener,ItemListener{

	private JCheckBox[] cb;
    private JRadioButton[] rb1, rb2;
    private JLabel label;
    private final Color[] colors = {Color.red, Color.blue, Color.MAGENTA, Color.green, Color.orange};

    public QuizeRadioCheck (String title) {
        super(title);
        setBounds(1100, 250, 800, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setDesign();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setDesign() {
        String[] genders = {"남자", "여자"};
        rb1 = createRadioButtons(genders, new ButtonGroup(), 10, 50, 50, 50);
        
        String[] colorNames = {"빨강", "파랑", "보라", "초록", "주황"};
        rb2 = createRadioButtons(colorNames, new ButtonGroup(), 200, 50, 100, 50);
        
        String[] countries = {"미국", "영국", "일본", "중국", "독일", "프랑스"};
        cb = new JCheckBox[countries.length];
        for (int i = 0, x = 50; i < countries.length; i++, x += 120) {
            cb[i] = new JCheckBox(countries[i]);
            cb[i].setBounds(x, 400, 100, 50);
            cb[i].setOpaque(false);
            cb[i].addItemListener(this);
            add(cb[i]);
        }

        label = new JLabel("이곳에서 출력이 됩니다.", JLabel.CENTER);
        label.setBounds(50, 150, 700, 200);
        label.setFont(new Font("고딕체", Font.PLAIN, 28));
        label.setBorder(new LineBorder(Color.black, 2));
        add(label);
    }

    private JRadioButton[] createRadioButtons(String[] texts, ButtonGroup group, int x, int y, int xGap, int yGap) {
        JRadioButton[] buttons = new JRadioButton[texts.length];
        for (int i = 0; i < texts.length; i++) {
            buttons[i] = new JRadioButton(texts[i]);
            buttons[i].setBounds(x + (i * xGap), y, 50, 50);
            buttons[i].setOpaque(false);
            buttons[i].addActionListener(this);
            group.add(buttons[i]);
            add(buttons[i]);
        }
        return buttons;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        StringBuilder msg = new StringBuilder("내가 여행해본 나라는 ");
        int count = 0;
        for (JCheckBox box : cb) {
            if (box.isSelected()) {
                msg.append(box.getText()).append("  ");
                count++;
            }
        }
        label.setFont(new Font("", Font.PLAIN, count > 4 ? 23 : 28));
        label.setText(count > 0 ? msg.append("입니다.").toString() : "나는 여행해본 나라가 없어요.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for (JRadioButton button : rb1) {
            if (source == button) {
                label.setText("저는 " + button.getText() + "입니다.");
                return;
            }
        }
        for (int i = 0; i < rb2.length; i++) {
            if (source == rb2[i]) {
                label.setForeground(colors[i]);
                return;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   new QuizeRadioCheck ("퀴즈");
	}
}
	

