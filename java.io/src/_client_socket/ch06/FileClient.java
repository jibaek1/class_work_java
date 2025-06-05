package _client_socket.ch06;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class FileClient {

    private static final int PORT = 5000;
    private final String name;
    private Socket socket;
    private OutputStream out;
    private InputStream in;
    private final Scanner scanner = new Scanner(System.in);

    // 클라이언트 이름
    public FileClient(String name) {
        this.name = name;
    }

    private void connectToServer() throws IOException {
        socket = new Socket("localhost",PORT);
        System.out.println("서버와 연결됐어요!!");
    }

    private void setupStreams() throws IOException {
        out = socket.getOutputStream();
        in = socket.getInputStream();
        System.out.println("소켓과 연결된 바이트 기반 스트림 준비 완료");
    }

    /**
     * 키보드에서 파일 경로를 입력받아서 서버로 파일 보내기
     * @throws IOException
     */
    private void uploadFile() throws IOException {
        System.out.println("보내고 싶은 파일 경로를 입력하세요 (예: C:/test.txt");
        String filePath = scanner.nextLine();

        // 방어적 코드 작성
        // 파일이 정말 있는지 확인
        File file = new File(filePath);
        if (!file.exists() && !file.isFile() ) {
            System.out.println("그 파일은 없거나 잘못됐어요");
            return;
        }

        // 서버측과의 약속
        // 서버측에서 먼저 in.read(100byte) , 클라이언트가 100 먼저 보내기로 함
        String fileName = file.getName();
        byte[] nameBytes = fileName.getBytes();
        // 100칸 고정 (서버측과의 약속)
        byte[] nameBuffer = new byte[100];
        //out.write(100byte);

        // 파일이름이 100칸보다 길면 안됨
        if(nameBytes.length > 100) {
            System.out.println("파일 이름이 너무 길어요 100글자 미만으로 해주세요");
            return;
        }
        // 1바트에 한 글자씩 표현 가능 (아스키 코드 기준)
        // "test.txt" 8칸 차지, 나머지 92칸 비어 있음
        for (int i = 0; i < nameBytes.length; i++) {
            nameBuffer[i] = nameBytes[i];
        }

        // 서버측으로 파일 이름부터 보내기 처리
        out.write(nameBuffer);
        out.flush(); // 바로 보내기

        // 파일 내용을 바이트로 변환해서 보내 주어야 한다.
        try(FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[4096]; // 4KB
            int bytesRead;
            while ( (bytesRead = fis.read(buffer)) != -1 ) {
                out.write(buffer,0,bytesRead);
            }
            out.flush(); // 다 보냈음

            // 서버측에 바이트를 다 받으면 메세지를 보내기로 함
            byte[] responseBuffer = new byte[1024];
            int responseLength = in.read(responseBuffer);
            String response = new String(responseBuffer,0,responseLength);
            System.out.println("서버가 말해요 : " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end of uploads

    private void cleanup() {
        try{
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 실행에 흐름 지정하는 메서드 만들기
    public void fileSendRun() {
        try {
            connectToServer();
            setupStreams();
            uploadFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cleanup();
        }
    }
    // 프로그램 시작
    public static void main(String[] args) {
        FileClient fileClient = new FileClient("황지백");
        fileClient.fileSendRun();
    }
} // end of class
