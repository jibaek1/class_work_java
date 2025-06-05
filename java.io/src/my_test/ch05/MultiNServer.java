package my_test.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MultiNServer {

    private static final int PORT = 5000;
    private static Vector<PrintWriter> clientWriters = new Vector<>();
    private static int connectedCount = 0;

    public static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);

                clientWriters.add(out);

                String message;
                while ( (message = in.readLine()) !=null ) {
                    System.out.println("Recived: " + message);
                    for (PrintWriter writer : clientWriters) {
                        writer.println("방송 : " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("소켓 연결중 오류 발생");
            } finally {
                try {
                    if (socket != null) socket.close();
                    clientWriters.remove(out);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("소켓 자원 해제 중 오류 발생");
                }
            }
        }
    } // end of inner class

    // 메인 함수
    public static void main(String[] args) {
        System.out.println("Server started ....");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
                connectedCount++;
                System.out.println("클라이언트 연결 됨 : " + connectedCount);
            }
        } catch (Exception e){
            e.printStackTrace();
            }
    } // end of main

} // end of class
