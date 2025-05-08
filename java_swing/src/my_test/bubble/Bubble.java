package my_test.bubble;

import javax.swing.*;

public class Bubble extends JLabel {

    private int x;
    private int y;

    // 물방울 움직임 상태
    private boolean left;
    private boolean right;
    private boolean up;

    private ImageIcon bubble; // 기본 물방울

    private Player player;

    public Bubble(Player player) {
        this.player = player;

        initData();
        setInitLayout();
    }


    private void initData() {
        bubble = new ImageIcon("img/bubble.png");
        left = false;
        right = false;
        up = false;
    }

    private void setInitLayout() {
        x = player.getX();
        y = player.getY();
        setIcon(bubble);
        setSize(50,50);
        setLocation(x,y);
    }

    // getter


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public ImageIcon getBubble() {
        return bubble;
    }

    public Player getPlayer() {
        return player;
    }

    // setter

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setBubble(ImageIcon bubble) {
        this.bubble = bubble;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
