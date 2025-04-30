package ch07;

public class DogMainTest {
    // 코드의 진입점
    public static void main(String[] args) {

        // new + 클래스 이름 + ()
        Dog f1 = new Dog();
        Dog f2 = new Dog();
        // 메모리에 올리다 --> 인스턴스화 했다. ---> 인스턴스(객체)

        System.out.println(f1);
        System.out.println(f2);

        f1.kind = "말티즈";
        f2.kind = "리트리버";

        System.out.println(f1.kind);
        System.out.println(f2.kind);
    } // end of main

}
