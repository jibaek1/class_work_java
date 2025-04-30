package com.association;

public class BaseballPlayer {

    private String name;

    public BaseballPlayer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }



    public void player() {
        System.out.println("선수 :" + name);
    }

}
