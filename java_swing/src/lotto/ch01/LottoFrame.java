package lotto.ch01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame extends JFrame implements ActionListener {
    //member
    private JButton button;

    //constructor
    public LottoFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData(){
        setTitle("Lotto game");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("Game Start");
    }
    private void setInitLayout(){
        add(button, BorderLayout.NORTH);

        setVisible(true);
    }
    private void addEventListener(){
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("그림을 그려라");
    }
    //main
    // 테스트 코드 작성
    public static void main(String[] args) {
        new LottoFrame();
    }
} // end of main
