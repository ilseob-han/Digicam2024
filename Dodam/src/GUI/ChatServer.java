package GUI;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 9552;
    private static List<ClientHandler> clientHandlers = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);

        while (true) {
            System.out.println("[SERVER] Waiting for client connection...");
            Socket client = listener.accept();
            System.out.println("[SERVER] Connected to client!");
            ClientHandler clientThread = new ClientHandler(client, clientHandlers);
            clientHandlers.add(clientThread);

            pool.execute(clientThread);
        }
    }

    // ClientHandler 클래스
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private List<ClientHandler> clientHandlers;

        public ClientHandler(Socket socket, List<ClientHandler> clientHandlers) throws IOException {
            this.clientSocket = socket;
            this.clientHandlers = clientHandlers;
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    broadcastMessage(message);
                }
            } catch (IOException e) {
                System.err.println("Error in ClientHandler: " + e.getMessage());
                e.printStackTrace();
            } finally {
                closeConnections();
            }
        }

        private void broadcastMessage(String message) {
            for (ClientHandler clientHandler : clientHandlers) {
                if (!clientHandler.clientSocket.isClosed()) {
                    clientHandler.out.println(message);
                }
            }
        }

        private void closeConnections() {
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}