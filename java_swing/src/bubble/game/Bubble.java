package bubble.game;


import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

import static java.lang.Thread.sleep;

@Getter
@Setter
public class Bubble extends JLabel implements Moveable {

    private int x;
    private int y;

    // 물방울 움직임 상태
    private boolean left;
    private boolean right;
    private boolean up;

    private boolean isLeft; // true, false

    private ImageIcon bubble; // 기본 물방울
    private ImageIcon bomb; // 물방울이 터진 상태

    private Player player;
    private BackgroundBubbleService backgroundBubbleService;


    public Bubble(Player player) {
        this.player = player;

        this.backgroundBubbleService = new BackgroundBubbleService(this);

        initData();
        setInitLayout();
        bubbleStartThread();
    }

    private void bubbleStartThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                if(player.getPlayerWay() == PlayerWay.LEFT){
                    left();
                } else {
                    right();
                }
            }
        }).start();
    }

    private void initData() {
        bubble = new ImageIcon("img/bubble.png");
        bomb = new ImageIcon("img/bomb.png");

        left = false;
        right = false;
        up = false;
    }

    private void setInitLayout() {
        x = player.getX();
        y = player.getY();
        setIcon(bubble);
        //setIcon(bomb);
        setSize(50, 50);
        setLocation(x, y);
    }



    @Override
    public void left() {
        left = true;
        for(int i = 0; i < 400; i++){
            x--;
            setLocation(x,y);
            if(backgroundBubbleService.leftWall() == true){
                // 왼쪽벽일때
                break;
            }

            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        up();
    }

    @Override
    public void right() {
        right = true;
        for(int i = 0; i < 400; i++){
            x++;
            setLocation(x,y);
            if(backgroundBubbleService.rightWall() == true){
                break;
            }
            // 좌표 오른쪽으로 1 움직였는데 오른쪽 벽인이 아닌지 매번 확인
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        up();
    }

    @Override
    public void up() {
        up = true;
        while (true) {
            y --;
            setLocation(x,y);
            if(backgroundBubbleService.topWall() == true) {
                // 왼쪽벽일때
                break;
            }
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // 3초뒤에 이미지를 변경해 보세요
        try {
            Thread.sleep(180);
            setIcon(bomb);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(500);
            setIcon(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
