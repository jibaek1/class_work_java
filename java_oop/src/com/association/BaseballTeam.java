package com.association;

public class BaseballTeam {

    String name;
    public BaseballPlayer baseballPlayer;

    public BaseballTeam(String name) {
        this.name = name;
        baseballPlayer = null;
    }

    public void recruitment(BaseballPlayer baseballPlayer) {
        this.baseballPlayer = baseballPlayer;
        System.out.println(name + " 이 영입되었습니다" + baseballPlayer.getName());
    }

    public void showBaseballTeam() {
        if (this.baseballPlayer != null) {
            System.out.println(name + "은 소속한 팀이 있습니다." + this.baseballPlayer.getName());
        } else {
            System.out.println("은 소속한 팀이 없습니다..");
        }
    }

    public void end() {
        if (baseballPlayer == null) {
            System.out.println("이미 소속한 팀이 없습니다.");
        } else {
            System.out.println(baseballPlayer.getName() + "팀을 탈퇴 합니다.");
            this.baseballPlayer = null;
        }
    }
}
