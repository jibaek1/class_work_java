package ch07;

public class CarMainTest {
    // 코드의 진입점
    public static void main(String[] args) {

        Car f1 = new Car();
        Car f2 = new Car();

        System.out.println(f1);
        System.out.println(f2);

        f1.kind = "에쿠스";
        f2.kind = "sm5";

        System.out.println(f1.kind);
        System.out.println(f2.kind);

    } // end of main

}
