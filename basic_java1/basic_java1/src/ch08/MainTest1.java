package ch08;

import ch08.Student;

public class MainTest1 {

    public static void main(String[] args) {

        // 인수 값
        Student s1 = new ch08.Student("홍길동", 1, 3);
        System.out.println(s1.name);
        System.out.println(s1.number);
        System.out.println(s1.grade);

    } // end of main

}
