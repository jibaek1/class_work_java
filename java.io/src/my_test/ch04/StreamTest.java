package my_test.ch04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class StreamTest {

    public static void main(String[] args) {

        try(InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter("abc.txt",true);
            BufferedWriter bw = new BufferedWriter(fw)){

            String line;
            while((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
