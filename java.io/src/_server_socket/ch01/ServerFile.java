package _server_socket.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 서버측 코드
 * 간단한 네트워크를 통한 서버측 프로그래밍에 필요한 준비물
 * 1. 서버 소켓이 필요하다.
 * 2. IP와 포트 번호가 필요하다. ( 0 ~ 65535 번까지 설정 (컴퓨터마다) )
 * 3. 사전 기반 지식 - 잘 알려진 포트 번호 - 주로 시스템 레벨에서 선점 포트 번호 (0부터 1023까지)
 */
public class ServerFile {

    public static void main(String[] args) {

        // 소켓 동신을 하기 위해서 (서버측)
        // 1. 서버 소켓이 필요하다. (서버측에만 가지면 됨)

        // 서버 소켓을 선언 합니다.
        ServerSocket serverSocket = null;

        try {
            // 내가 만든 서버 소켓 프로그래밍에 포트 번호 5000번을 할당 한다.
            // 단. 다른 프로그램이 5000번 포트를 선점하고 있다면 에러 발생한다.
            serverSocket = new ServerSocket(5001);
            System.out.println("서버를 시작합니다 포트번호 - 5000");

            // 클라이언트측 연결을 기다립니다.
            Socket clientSocket = serverSocket.accept(); // 내부 적으로 while 대기 타고 있음 (클라이언트 연결 요청 할때까지)
            // 클라이언트와 연결이 되면 서로 서버측 Socket이 생성이 되고 클라이언트 Socket이 연결 됨
            System.out.println(">>>>클라이언트가 연결을 하였습니다<<<<");

            // 클라이언트에서 보낸  데이터를 읽기 위한 입력 스트림이 필요하다.
            // InputStream input = clientSocket.getInputStream(); // 바이트 단위로 데이터를 읽을 수 있음
            // 문자 기반에 스트림으로 확장 + 보조 스트림
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // 클라이언트가 보낸 데이터 한줄 기반으로 읽어 보기
             String message = reader.readLine();
             System.out.println("클라이언트가 보낸 메세지 : " + message);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원 해제 (서버 소켓 닫기)
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (Exception e) {
                    System.out.println("서버 소켓 종료 중 오류 발생");
                    // 추적이 가능하고, 시간 출력 가능 ---> 파일 생성해서 로그를 남겨 버림
                    e.printStackTrace();
                }
            }
        }
    } // end of main
}
