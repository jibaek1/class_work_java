package _client_socket.ch05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 서버와 양방향 통신하는 클라이언트 측 코드
 */
public class MultiNClient {

    private final String name;
    private Socket socket;
    private PrintWriter writerStream; // 서버로 메세지를 전송하는 스트림
    private BufferedReader readerStream;
    private BufferedReader keyboardReader;

    public MultiNClient(String name) {
        this.name = name;
    }

    // 행위

    // 서버에 5000번 포트로 연결 처리 행위
    private void connectToServer() throws IOException {
        socket = new Socket("192.168.0.132",5000);
        System.out.println("connected to the server");
    }

    // 입출력 스트림을 설정하는 처리 행위
    private void setupStreams() throws IOException {
        writerStream = new PrintWriter(socket.getOutputStream(),true);
        readerStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        keyboardReader = new BufferedReader(new InputStreamReader(System.in));
    }

    // 서버로 부터 온 메세지를 실제로 읽는 행위
    private Thread createdReadThread() {
        return new Thread(() -> {
            try {
                String serverMessage;
                while ( (serverMessage = readerStream.readLine()) !=null) {
                    System.out.println("Server Message : " + serverMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // 키보드에서 입력을 받아 서버로 메세지를 전성하는 행위
    private Thread createWriteThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String keyboardMessage;
                    while ( (keyboardMessage = keyboardReader.readLine()) != null ) {
                        writerStream.println("[" + name + "] : " + keyboardMessage);
                        // writerStream.flush();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // 자원을 정리하고 소켓을 닫는 행위
    private void cleanup() {
        try {
            if(socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 읽기/쓰기 스레드를 생성 및 start(시작) 처리
    private void startCommunication() throws InterruptedException {
        Thread readThread = createdReadThread();
        Thread writeThread = createWriteThread();

        readThread.start();
        writeThread.start();

        // 내가 종료 될때 까지 메인 스레드 종료 하지말고 대기해
        readThread.join();
        readThread.join();
    }

    // chatStart() 행위
    public void charRun() {
        try {
            connectToServer();
            setupStreams();
            startCommunication();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            cleanup();
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        System.out.println("클라이언트 프로그램 시작");

        MultiNClient nClient = new MultiNClient("황지백");
        nClient.charRun();
    }
} // end of class
