package ch03;

public class Operation4 {

    public static void main(String[] args) {

        // 게임 캐릭터의 상태를 설정
        int playerHealth = 50; // 플레이어의 체력
        int playerLevel = 10; // 플레이어의 레벨
        int enemyHealth = 30; // 적의 체력
        int requiredLevel = 15; // 특정 퀘스트를 수행하기 위한 최소 레벨

        // 1. 플레이어의 체력이 적 체력보다 높은지 확인 -> true, false
        boolean isStronger = playerHealth > enemyHealth;
        System.out.println("isStronger : " + isStronger);

        // 2. 플레이어의 체력이 위험 수준(20이하) 인지 확인
        boolean isInDanger = playerHealth <= 20;
        System.out.println("플레이어가 위험 상태이다 : " + isInDanger);

        // 3. 플레이어 레벨이 퀘스트 수행 가능한 레벨 이상인지 확인
        boolean canDoQuest = playerLevel >= requiredLevel;
        System.out.println("퀘스트를 수행할 수 있다 : " + canDoQuest);

        // 4. 플레이어와 적의 체력이 같은지 확인 (비교 연산자)

        boolean Health = playerHealth == enemyHealth;
        System.out.println("플레이어와 적의 체력이 같다 : " + Health);


        // 5. 플레이어 레벨이 특정 레벨과 같은지 확인(10) (비교 연산자)
        boolean level = playerLevel == 10;
        System.out.println("플레이어의 레벨이 10이다 : " + level);


        // 6. 플레이어 레벨이 특정 레벨과 다른지 확인(10)
        boolean levels = playerLevel != 10;
        System.out.println("플레이어의 레벨이 10이 아니다 " + levels);

    } // end of main

} // end of class
