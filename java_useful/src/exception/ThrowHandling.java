package exception;

public class ThrowHandling {

    public static void main(String[] args) {

        boolean flag = true;
        if(flag) {
            // 필요에 의해서 직접 미리 만들어 둔 예외 클래스를 생성할 수 있다.(예외를 발생 시킬 수 있다.)
            // new ArithmeticException();
            throw new ArithmeticException();
        }


    } // end of main

}
