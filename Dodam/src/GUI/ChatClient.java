package GUI;
import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 9552;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // 메시지 수신을 위한 쓰레드
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage); // 서버로부터 받은 메시지 출력
                    }
                } catch (IOException e) {
                    System.err.println("Error in client: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }).start();

        // 메시지 전송
        String input;
        while ((input = consoleReader.readLine()) != null) {
            out.println(input); // 서버에 메시지 전송
        }
    }
}
