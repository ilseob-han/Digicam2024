package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;

public class ChatClientGUI extends JFrame {
    private String userName;
    private PrintWriter out;
    private BufferedReader in;
    private JTextField txtInput;
    private JTextArea chatArea;
    private Socket socket;

    public ChatClientGUI() {
        initializeLoginUI();
    }

    private void initializeLoginUI() {
        setTitle("Chat Login");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField txtUserName = new JTextField();
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
            userName = txtUserName.getText().trim();
            if (!userName.isEmpty()) {
                connectToServer();
            }
        });
        setLayout(new GridLayout(2, 1));
        add(txtUserName);
        add(btnLogin);
        setVisible(true);
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 4545); // Same port as the server
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // After successful connection, initialize chat UI
            SwingUtilities.invokeLater(this::initializeChatUI);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeChatUI() {
        setTitle("Chat - " + userName);
        setSize(400, 300);
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        txtInput = new JTextField();
        txtInput.addActionListener(e -> {
            String message = txtInput.getText();
            out.println(userName + ": " + message); // Send message to the server
            txtInput.setText("");
        });
        setLayout(new BorderLayout());
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        add(txtInput, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        listenForMessages();
    }

    private void listenForMessages() {
        new Thread(() -> {
            String messageFromServer;
            try {
                while ((messageFromServer = in.readLine()) != null) {
                    chatArea.append(messageFromServer + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatClientGUI::new);
    }
}