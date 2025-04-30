package com._abstract;

public abstract class Computer {
    // 속성

    // 생성자

    // 추상 메서드
    public abstract void display();
    public abstract void typing();

    //구현 메서드
    public void turnOn(){
        System.out.println("컴퓨터를 켭니다.");
    }
    public void turnOff(){
        System.out.println("컴퓨터를 끕니다.");
    }
}
