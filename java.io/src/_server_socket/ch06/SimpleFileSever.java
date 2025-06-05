package _server_socket.ch06;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  1:1 소켓 통신을 활용한 파일 서버를 만들어 보자
 */
public class SimpleFileSever {

    private static final int PORT = 5000;
    private static final String UPLOAD_DIR = "Uploads/";


    // 함수 만들어 보기
    private static void handleClient(Socket socket) {
        try(InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream()) {

            // 동작 흐름 생각해 보기 (클라이언트에서 파일이름 + 바이트 덩어리)
            byte[] nameBuffer = new byte[100];
            in.read(nameBuffer);

            // 파일명 --> 바이트 변환
            // 실제 파일 읽어서 바이트로 변환
            // while ( 1byte ---> 보내기) {
            // }
            String fileName = new String(nameBuffer).trim();
            System.out.println("파일 이름 수신 : " + fileName);

            // 파일을 만드는 방법?? -> 메모리상에서 new File(파일경로+파일이름);
            // 파일 객체를 메모리에 띄움
            File file = new File(UPLOAD_DIR + fileName);
           try(FileOutputStream fos = new FileOutputStream(file)){

            // 파일 내용을 읽고 쓰기 위한 버퍼 (4KB 크기)
            // 단위 정리
            // 8bit = 1byte
            // 1,024 bytes = 1KB(킬로바이트)
            // 1,024 KB    = 1MB(메가바이트)
            // 1,024 MB    = 1GB(기가바이트)
            // 1024라는 단위가 사용되는 이유는 컴퓨터는 2진수 체계와 관련
            // 메모리 용량을 계산할 때 2의 거듭제곱으로 표현하기 때문이다.
            // 2x2x2x2x2x2x2x2x2x2 = 1024
            byte[] buffer = new byte[4096];
            int bytesRead;
            // EOF 를 -1로 표현 함
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
            System.out.println("서버 컴퓨터에 파일 저장 완료: " + fileName);

            out.write("파일 업로드 완료:".getBytes());
            out.write(fileName.getBytes());
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // socket.close();
        }
    }

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("클라이언트에 연결 요청을 기다립니다 ......");
            try(Socket connectedClientSocket = serverSocket.accept()) {
                System.out.println("클라이언트 연결 됨 ........");
                handleClient(connectedClientSocket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    } // end of main

} // end of class
