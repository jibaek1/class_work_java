package exercise;

import java.util.Scanner;

public class Exercise6 {

    public static void main(String[] args) {

        // 스캐너 도구를 사용해서
        // 뺄셈, 곱셈, 나눗셈 연산하는 프로그램을 직접 만들어 보자.
        // 사용자에게 값 2개를 연산 하시오

        Scanner sc = new Scanner(System.in);

        System.out.printf("1. 정수값을 입력하시오 : ");
        int x = sc.nextInt();
        System.out.println();

        System.out.printf("2. 정수값을 입력하시오 : ");
        int y = sc.nextInt();
        System.out.println();

        System.out.println("x : " + x);
        System.out.println("y : " + y);

        System.out.println("결과1 : " + (x - y));

    } //end of main

} // end of class
