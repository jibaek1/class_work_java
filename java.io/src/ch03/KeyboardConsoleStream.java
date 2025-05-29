package ch03;

import java.io.*;

/**
 * 바이트 단위 스트림에 이름 형태
 * InputStream(System.in), OutputStream(System.out)
 * 문자 기반 스트림에 이름 형태
 * xxxReader, xxxWriter  (문자 기반 형태 네이밍 형식)
 */
public class KeyboardConsoleStream {

    public static void main(String[] args) {
        /**
         * InputStreamReader 의 read() 메서드는 하나의 문자를 읽어서
         * 그 문자의 유니코드(UTF-8, UTF-16) 값으로(정수값) 반환합니다.
         */

        // 프로그램 목표 : 키보드에서 문자 기반에 스트림을 사용해서 코드로 데이터를 읽어 보자.
        try (InputStreamReader reader = new InputStreamReader(System.in);
             PrintWriter writer = new PrintWriter(System.out, true)
        ) {
            System.out.println("텍스트를 입력하세요(종료 하려면 ctrl + D ");

//            int charCode = reader.read();
//            System.out.println("--------------------");
//            System.out.println((char)charCode);

            int charCode;
            while ((charCode = reader.read()) != -1) {
                // System.out.println((char) charCode);
                writer.println((char) charCode);
            }
            /**
             * 입력된 문자를 콘솔에 출력을 하는데 버퍼를 즉시 비움
             */
            writer.flush(); // 즉시 출력
        } catch (IOException e) {
            /**
             * 예: 키보드 입력 오류, 콘솔 출력오류가 여기서 catch 됨
             */
            System.out.println("입출력중 오류 발생");
        }
    } // end of main
}
