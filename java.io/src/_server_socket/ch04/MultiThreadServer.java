package _server_socket.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 서버측  코드
 * 1:1 양방향 통신
 */
public class MultiThreadServer {

    // 메인 쓰레드
    public static void main(String[] args) {
        System.out.println("=====서버 실행======");
        //준비물
        ServerSocket serverSocket = null;
        Socket clientSocket = null;


        try {
            serverSocket = new ServerSocket(5000);
            // 클라이언트 연결 대기 .....
            clientSocket = serverSocket.accept();
            System.out.println("-------------- client connected --------------");
            // 준비물 :
            // 1.키보드에서 값을 받는 스트림이 필요하다.
            // 2.클라이언트 측과 연결된 출력 스트림이 필요 하다. (데이터를 보낼 예정)
            // 3.클라이언트 측과 연결된 입력 스트림이 필요 하다. (데이터를 받을 예정)

            // 준비물 1. 바이트, 문자기반 + 보조 스트림
            // System.in + InputStreamReader + BufferedReader
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
            // 준비물 2. clientSocket 소켓에서 출력 스트림을 뽑아 보자
            // 바이트 기반 스트림 + 문자 기반 스트림으로 확장 + 보조 스트림 (x)
            PrintWriter writerStream = new PrintWriter(clientSocket.getOutputStream(),true);
            // 준비물 3.clientSocket 소켓에서 입력 스트림을 뽑아 보자
            // 바이트 기반 스트림 + 문자 기반 + 보조 스트림
            BufferedReader readerStream
                    = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


            // 3.1
            // 클라이언트 측으로 부터 데이터를 while 돌면서 계속 받는 작업 대기
            // 람다 표현식
            Thread readThread = new Thread(() -> {
                try {
                    String clientMessage;
                    System.out.println("ReadThread 시작~~~");
                    while ( (clientMessage = readerStream.readLine()) != null ) {
                        if("exit".equalsIgnoreCase(clientMessage)){
                            System.out.println("클라이언트가 채팅을 종료 했습니다");
                            break;
                        }
                        System.out.println("클라이언트로 부터 온 msg: " + clientMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("데이터를 읽는 도중 클라이언트와 연결이 종료됨");
                }
            });


            // 1.1 동작 고민 하기 while () ....
            // 메인 작업자가 계속 키보드 입력을 받아서 코드로 가져 오는 것은 너무 바쁨
            // 람다 표현식
            Thread keyboardThread = new Thread(() -> {
                try {
                    String serverKeyboardMessage;
                    while( (serverKeyboardMessage = keyboardReader.readLine()) != null) {
                        writerStream.println(serverKeyboardMessage); // write + \n
                        writerStream.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("메세지 전송중 오류가 발생했습니다.");
                }
            });


            // 작업자들에게 일해 명령어
            keyboardThread.start();
            readThread.start();
            System.out.println("ReadThread 시작~~~");
            // 쓰레드 사용 시 join() 메서드
            readThread.join(); // readThread 쓰레드가 종료 될 때 까지 메인 쓰레드 종료 하지마
            keyboardThread.join(); // keyboardThread 쓰레드가 종료 될 때까지 메인 쓰레드 종료 하지마

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("서버 실행 중 오류 발생 : 포트가 이미 사용중인지 확인 하세요.");
        } finally {

            try {
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("자원 해제 중 오류 발생");
            }
        } // end of finally
    } // end of main
} // end of class
