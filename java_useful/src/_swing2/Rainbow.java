package _swing2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rainbow extends JFrame implements ActionListener {

    JButton[] buttons = new JButton[7];

    String[] colors = {"빨","주","노","초","파","남","보"};
//    private JButton button1;
//    private JButton button2;
//    private JButton button3;
//    private JButton button4;
//    private JButton button5;
//    private JButton button6;
//    private JButton button7;
    private JPanel panel;

    public Rainbow(){

        initData();
        setInitLayout();
        addEventListener();
    }
    private void initData() {
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        for(int i = 0; i<buttons.length; i++){
            buttons[i] = new JButton(colors[i]);
        }
//        buttons[0] = new JButton("버튼(1)");
//        buttons[1] = new JButton("버튼(2)");
//        buttons[2] = new JButton("버튼(3)");
//        buttons[3] = new JButton("버튼(4)");
//        buttons[4] = new JButton("버튼(5)");
//        buttons[5] = new JButton("버튼(6)");
//        buttons[6] = new JButton("버튼(7)");
    }
    private void setInitLayout() {
        setLayout(null);
        for(int i = 0; i < 7; i++) {
            buttons[i].setLocation(i * 100, 0);
            buttons[i].setSize(100, 50);
            add(buttons[i]);
        }
        panel.setBackground(Color.CYAN);
        panel.setLocation(0,50);
        panel.setSize(700,700);
        add(panel);

        setVisible(true);
    }
    private void addEventListener() {

        for (int i = 0; i < 7; i++) {
            buttons[i].addActionListener(this);
        }
//        button1.addActionListener(this);
//        button2.addActionListener(this);
//        button3.addActionListener(this);
//        button4.addActionListener(this);
//        button5.addActionListener(this);
//        button6.addActionListener(this);
//        button7.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton selectedButton = (JButton) e.getSource();
        System.out.println(selectedButton);
        System.out.println(selectedButton.getText());

        if (selectedButton == buttons[0]) {
            panel.setBackground(Color.RED);
        } else if (selectedButton == buttons[1]) {
            panel.setBackground(Color.ORANGE);
        } else if (selectedButton == buttons[2]) {
            panel.setBackground(Color.YELLOW);
        } else if (selectedButton == buttons[3]) {
            panel.setBackground(Color.GREEN);
        } else if (selectedButton == buttons[4]) {
            panel.setBackground(Color.BLUE);
        } else if (selectedButton == buttons[5]) {
            panel.setBackground(Color.BLACK);
        } else if (selectedButton == buttons[6]) {
            panel.setBackground(Color.MAGENTA);
        }
    }

    public static void main(String[] args) {
        new Rainbow();
    }
}
