package ch04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class StreamTest {

    public static void main(String[] args) {
        // 문자 기반 스트림을 사용해서 키보드에서 입력한 값을
        // 파일에다가 저장하시오 (Append 모드 활성화)
        // 단, 버퍼를 사용해야 합니다.
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter("ab.txt",true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            // br.read(); a a a a a a  * 10
            // br.readLine(); aaaaaaaa * 1

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
