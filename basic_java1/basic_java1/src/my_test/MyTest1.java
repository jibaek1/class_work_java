package my_test;

public class MyTest1 {

    public static void main(String[] args) {

        // 이전 배웠던 내용 + 복합 대입연산자 활용해서 직접 문제를 만들고 결과를 확인해 봅시다

        // 10000원이 들어있던 계좌에 2500원을 빼고 남은 돈을 1000원짜리 쿠폰으로 바꿔 남은 잔액은?

        double balance = 10000;
        System.out.println("현재 계좌 잔액 : " + balance);

        balance -= 2500;
        System.out.println("남은 계좌 잔액 : " + balance);

        balance %= 1000;
        System.out.println("쿠폰으로 바꾸고 남은 잔액 : " + balance);

    } // end of main

} // end of class