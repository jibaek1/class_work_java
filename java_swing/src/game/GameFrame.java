package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JFrame implements KeyListener {


    private BufferedImage backgroundImage;
    private BufferedImage player1;
    private BufferedImage player2;

    private ImagePanel imagePanel;

    private int playerX = 300;
    private int playerY = 400;

    private int player2X = 300;
    private int player2Y = 300;

    private boolean flag = true;

    public GameFrame() {
        initData();
        setInitLayout();
        addEventListener();
        // 메인 작업자가 서브 작업자를 생성한다.
        Thread thread1 = new Thread(imagePanel);
        thread1.start();
        // imagePanel 안에 구현한 run() {} 메서드가 시작 된다.
    }

    private void initData() {
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            backgroundImage = ImageIO.read(new File("images/backgroundMap.png"));
            player1 = ImageIO.read(new File("images/player.png"));
            player2 = ImageIO.read(new File("images/player(2).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        imagePanel = new ImagePanel();
    }

    private void setInitLayout() {

        add(imagePanel);

        setVisible(true);
    }

    private void addEventListener() {
        // KeyListener <- 인터페이스야
        // 자바 문법 인터페이스,추상클래스를 구현 클래스(즉 객체로 사용하는 문법을 제공한다.)
        // new KeyListener(){.. 추상 메서드를 구현 메서드를 오버라이드 } (클래스로 바라본다.)

        addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyCode : " + e.getKeyCode());
        // TODO 화살표만 추출해 낼 예정
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            playerY -= 10;
        } else if (code == KeyEvent.VK_DOWN) {
            playerY += 10;
        } else if (code == KeyEvent.VK_LEFT) {
            playerX -= 10;
        } else if (code == KeyEvent.VK_RIGHT) {
            playerX += 10;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // 내부 클래스 생성
    private class ImagePanel extends JPanel implements Runnable {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, 1000, 600, null);
            g.drawImage(player1, playerX, playerY, 100, 100, null);
            g.drawImage(player2, player2X, player2Y, 100, 100, null);
        }

        @Override
        public void run() {
            // direction -> true 라면 오른쪽 가고 있는 상태
            // direction -> false 라면 왼쪽 가고 있는 상태
            boolean direction = true;

            // 서브 작업자가 해야하는 일을 명시하도록 약속 되어 있다.
            while (flag) {
                if (direction == true) {
                    player2X += 5;
                } else {
                    player2X -= 5;
                }
                if (player2X >= 800) {
                    direction = false;
                }

                if (player2X <= 100) {
                    direction = true;
                }
                try {
                    Thread.sleep(1000);
                    // 그림을 다시 그려라
                    repaint();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("playerX : " + playerX);
                System.out.println("playerY : " + playerY);
                System.out.println("----------------------");
                System.out.println("player2X : " + player2X);
                System.out.println("player2y : " + player2Y);
                // 1. 단계 playerX == player2X 같다면 같은 좌표에 있음
                if(playerX == player2X && playerY == player2Y) {
                    System.out.println("XY 좌표선상에서 같은 위치를 가르킨다.");
                    player1 = null;
                }

                // 2. 단계 playerY == Player2Y 같다면 완전 동일 좌표
            }

        }
    } // end of inner class
}
