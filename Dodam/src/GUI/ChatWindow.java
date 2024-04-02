package GUI;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;
    private String loggedInUserId;
    private String friendId; // 채팅할 친구의 ID

    // ChatWindow 생성자에 loggedInUserId와 friendId를 추가합니다.
    public ChatWindow(String loggedInUserId, String friendId) {
        this.loggedInUserId = loggedInUserId;
        this.friendId = friendId;

        setTitle("채팅 창 - " + friendId); // 친구 ID를 타이틀에 추가
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        initializeChatArea();
        initializeInputArea();

        setVisible(true);
    }

    private void initializeChatArea() {
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        loadChatHistory();
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadChatHistory() {
        ChatMessageDAO chatMessageDAO = new ChatMessageDAO();
        List<String> messages = chatMessageDAO.getMessagesBetweenUsers(loggedInUserId, friendId);
        for (String message : messages) {
            chatArea.append(message + "\n");
        }
    }


    private void initializeInputArea() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        messageField = new JTextField();
        sendButton = new JButton("보내기");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.trim().isEmpty()) {
            chatArea.append(loggedInUserId + ": " + message + "\n"); // 화면에 메시지 표시
            messageField.setText(""); // 입력 필드 초기화
            ChatMessageDAO chatMessageDAO = new ChatMessageDAO();
            chatMessageDAO.saveMessage(loggedInUserId, friendId, message); // 데이터베이스에 메시지 저장
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // 테스트 용도로 사용하는 메인 메서드는 실제 구현에서는 제거하거나 수정할 수 있습니다.
                new ChatWindow("user1", "friend1");
            }
        });
    }
}