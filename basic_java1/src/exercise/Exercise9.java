package exercise;

public class Exercise9 {

    // 메인 함수
    public static void main(String[] args) {
        //호출 연습
        greet("길동");

        // 2. 호출
        int sum1 = square(10);
        System.out.println("sum1 : " + sum1);

        // 3. 호출
        String result1 = signOfNumber(0);
        System.out.println("result1 : " + result1);

        // 4. 호출
        boolean isAdult = checkAdult(10);
        System.out.println("isAdult : " + isAdult);

        // 5. 호출
        int max = findMax(100, 1001);
        System.out.println("max : " + max);

    } // end of main

    static void greet(String greet){
        System.out.println("안녕하세요 [" + greet + "] 님!");

    }
    // 2.
    static int square(int n1){
        return n1 * n1;
    }

    // 3.
    static String signOfNumber(int value){
        if(value == 0) {
            return "ZERO";
        } else if (value > 0) {
            return "positive";
        } else {
            return "negative";
        }

    }
        // 4.
        static boolean checkAdult(int age){
            boolean result = (age >= 18);
            return result;
        }

        // 5.
        static int findMax(int n1, int n2) {
            // 삼항 : (조건식) ? 결과1 : 결과2
             int result = (n1 > n2) ? n1 : n2;
             return result;
        }

}

