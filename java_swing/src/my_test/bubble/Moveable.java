package my_test.bubble;

public interface Moveable {
    // public abstract 생략 가능
    void left();

    void right();

    void up();

    default void down(){};

    // 인터페이스의 모든 메서드는 추상 메서드이어야 한다.
    // 단, default 메서드를 제외하고!!
    // default void a() {}
}
