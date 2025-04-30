package _my_test;

public class Exercise2 {

    public static void main(String[] args) {

        // 1. 데이터 10, 100 , 100 을 변수 선언과 동시에 초기화하고 화면에 출력
        int data1 = 10;
        int data2 = 100;
        int data3 = 100;
        System.out.println("" + data1);
        System.out.println("" + data2);
        System.out.println("" + data3);

        // 2. int ageBox 상자에 20을 담기
        int ageBox = 20;

        // 2.1 ageBox 상자의 값을 30으로 변경하고 기존에 담겨 있던 데이터를 다른 곳으로 옮기기
        int oldAge = ageBox;
        ageBox = 30;
        // 3. int a = 1; int b = 3; 선언하고 a와 b에 담겨 있는 값을 서로 스위칭
        int a = 1;
        int b = 3;
        int temp = a;
        System.out.println("a : " + a + "| b : " + b + " | temp : " + temp);
        b = a;
        System.out.println(" " + b);
        b = temp;
        System.out.println(" " + b);
        // 힌트 - 임시 변수를 사용하여 값을 교환



    } // end of main

} // end of class
