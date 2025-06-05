package _client_socket.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 클라이언트 측 코드
 * 1:1 양방향 통신 구현하기
 */
public class ClientFile02 {

    public static void main(String[] args) {

        // 준비물
        // 1. 연결해야 할 IP 주소와 포트 번호가 필요하다.
        // 2. 소켓이 필요 하다.
        // 3. 출력 스트림 필요
        // 4. 입력 스트림 필요
        Socket socket = null;
        try {
            socket = new Socket("localhost",5000);

            // 서버로 메시지를 보내기 위한 출력 스트림 필요하다.
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            // writer 데이터를 보낼 수 있음
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // reader 통해서 데이터를 읽을 수 있음

            // 실행에 흐름 -응용 ...
            writer.write("안녕 서버야 !!\n");
            writer.flush();
            // 서버로 부터 데이터를 응답 받아 보자.
            String responseStr = reader.readLine();
            System.out.println("서버에서 온 메세지 : " + responseStr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        System.out.println("클라이언트 소켓 종료시 오류 발생");
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
