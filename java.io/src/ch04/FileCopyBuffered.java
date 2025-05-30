package ch04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyBuffered {

    public static void main(String[] args) {

        // 파일 경로 지정
        String sourceFilepath = "employees.zip";
        String destinationFilePath = "employees_copy2.zip";

        // 소요 시간 측정
        long startTime = System.nanoTime();

        try( FileInputStream fis = new FileInputStream(sourceFilepath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath);
             BufferedInputStream bfis = new BufferedInputStream(fis);
             BufferedOutputStream bfos = new BufferedOutputStream(fos)){

            byte [] bytes = new byte[1024];
            int data;
            while ((data = bfis.read(bytes)) !=-1 ) {

                bfos.write(bytes,0,data);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일복사중 오류 발생 : " + e.getMessage());
        }

        // 소요 시간 계산
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("1억분에 1초(나노 초)" + duration);
        System.out.println("초 : " + duration/1_000_000_000);

    } // end of main
}
