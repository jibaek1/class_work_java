package my_test.ch06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 단일 클라이언트로부터 파일을 수신하는 1:1 파일 서버.
 * 클라이언트가 전송한 파일을 지정된 디렉토리에 저장한다.
 */
public class SimpleFileServer {

    // 서버 포트 번호 (설정 파일 사용 권장)
    private static final int PORT = 5000;
    // 파일 저장 디렉토리
    private static final String UPLOAD_DIR = "Uploads/";

    /**
     * 서버를 시작하고 클라이언트 연결을 대기한다.
     */
    public static void main(String[] args) {
        // 업로드 디렉토리 생성
        new File(UPLOAD_DIR).mkdirs();
        System.out.println("Server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            // 단일 클라이언트 연결 수락
            System.out.println("Waiting for client connection...");
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected");
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace(); // 실제 애플리케이션에서는 로깅 프레임워크 사용 권장
        }
    }

    /**
     * 클라이언트로부터 파일을 수신하고 저장한다.
     * @param socket 클라이언트 소켓
     */
    private static void handleClient(Socket socket) {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {

            // 파일 이름 수신 (고정 100바이트)
            byte[] nameBuffer = new byte[100];
            in.read(nameBuffer);
            String fileName = new String(nameBuffer).trim();
            System.out.println("Receiving file: " + fileName);

            // 파일 경로를 나타내는 객체를 메모리에 만듭니다
            // 파일 저장 경로 설정
            File file = new File(UPLOAD_DIR + fileName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                // 파일 내용을 읽고 쓰기 위한 버퍼 (4KB 크기)
                //
                // 8 bits = 1 byte
                // 1,024 bytes = 1 KB (킬로바이트)
                // 1,024 KB = 1 MB (메가바이트)
                // 1,024 MB = 1 GB (기가바이트)
                // 1,024라는 단위가 사용되는 이유는 컴퓨터는 2진수 체계와 관련
                // 메모리 용량을 계산할 때 2의 거듭제고으로 표현 하기 때문.
                // 1,024는 2의 10승
                byte[] buffer = new byte[4096];
                int bytesRead;

                // 첫 번째 in.read(buffer): 4KB 읽음 → bytesRead = 4096, 파일에 저장.
                // 두 번째 in.read(buffer): 4KB 읽음 → bytesRead = 4096, 파일에 저장.
                // 세 번째 in.read(buffer): 2KB 읽음 → bytesRead = 2048, 파일에 저장.
                // 네 번째 in.read(buffer): 더 읽을 데이터 없음 → bytesRead = -1, 루프 종료.
                // 데이터를 읽을 때까지 반복 (EOF로 종료)
                while ((bytesRead = in.read(buffer)) != -1) {
                    // 읽은 데이터를 파일에 쓰기
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("File saved: " + fileName);
            // 클라이언트에게 성공 메시지 전송
            out.write("File uploaded successfully: ".getBytes());
            out.write(fileName.getBytes());
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원 정리
            try {
                socket.close();
                System.out.println("Client disconnected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

