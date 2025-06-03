package ch04;

import com.sun.source.tree.WhileLoopTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class charBufferedKeyboardConsole {

    public static void main(String[] args) {

        /**
         * inputStreamReader 는 System.in (inputStream)을 기반으로 사용한다
         * BufferedReader 는 InputStreamReader를 wrap 해서 사용한다.
         */

        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                PrintWriter pw = new PrintWriter(System.out);
                BufferedWriter bw = new BufferedWriter(pw)) {

            System.out.println("텍스트를 입력하세요(종료 빈 줄 입력)");

            /**
             * readLine() 메서드는 문자열에 한 줄을 그대로 읽음
             * null은 입력의 끝을 의미 한다(혹시 인텔리제이에서 종료가 안될 때 Ctrl + d 또는 Ctrl + z)
             */
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                bw.write(line.replace("자바", "JAVA"));
                bw.newLine();
                bw.flush();// 물을 내리다
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("스트림 사용중 오류 발생 : " + e.getMessage());
        }

    } // end of main
}
