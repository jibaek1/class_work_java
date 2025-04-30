package ch04;

import java.util.Scanner;

public class WhileTest3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true; // 깃발

        // 특정 조건이 만족한다면 flag = false
        while (flag){
            int a = scanner.nextInt();
            if(a == 0){
                System.out.println("프로그램 종료");
                break;
            }
            System.out.println("...");


        }

    } // end of main

} // end of class
