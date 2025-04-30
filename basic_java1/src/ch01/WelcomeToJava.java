package ch01;

// 파일 이름은 WelcomTo.Java 파일을 생성
// 코드상에는 WelcomeToJava로 작성되어 있다.
// 자바 규칙 - 파일 이름과 클래스명이 동일해야한다.
public class WelcomeToJava {
    /**
     * 콘솔창에
     * 안녕! 자바의 세계에 오신 것을 환영합니다!
     * 오늘은 2025년 4월 9일이야.
     */


    //코드의 진입점(main)
    public static void main(String[] args) {

        System.out.println("안녕! 자바의 세계에 오신 것을 환영합니다");

        //System.out.println("나는 문자열이야");
        //System.out.println(2025);

        System.out.println("오늘은 " + 2025 + "년" + 4 + "월" + 9 + "일이야.");
    } // end of main


} // end of class
