// 파일: AddFriendDialog.java
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddFriendDialog extends JDialog {
    private JTextField userIdField;
    private JTextField contactField;
    private JButton addButton;
    private JButton cancelButton;
    private boolean succeeded;

    public AddFriendDialog(Frame parent) {
        super(parent, "친구 추가", true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        JLabel userIdLabel = new JLabel("친구 ID: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(userIdLabel, cs);

        userIdField = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(userIdField, cs);

        JLabel contactLabel = new JLabel("연락처(핸드폰/이메일): ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(contactLabel, cs);

        contactField = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(contactField, cs);

        addButton = new JButton("추가");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 여기에 친구 추가 로직을 추가
                succeeded = true;
                dispose();
            }
        });
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(addButton, cs);

        cancelButton = new JButton("취소");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cs.gridx = 2;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(cancelButton, cs);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getUserId() {
        return userIdField.getText().trim();
    }

    public String getContact() {
        return contactField.getText().trim();
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}

// 파일: ChatClient.java
package GUI;

import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to Chat Server");

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Server response: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + SERVER_ADDRESS);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                SERVER_ADDRESS);
            System.exit(1);
        }
    }
}

// 파일: ChatMessageDAO.java
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ChatMessageDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/miniproject1";
    private String jdbcUsername = "gangnam";
    private String jdbcPassword = "qwe123!@#";

    private static final String INSERT_MESSAGE_SQL = 
        "INSERT INTO chat_messages (sender_id, receiver_id, message) VALUES (?, ?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public List<String> getMessagesBetweenUsers(String senderId, String receiverId) {
        List<String> messages = new ArrayList<>();
        String query = "SELECT message FROM chat_messages WHERE (sender_id = ? AND receiver_id = ?) OR (sender_id = ? AND receiver_id = ?) ORDER BY created_at ASC";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, senderId);
            preparedStatement.setString(2, receiverId);
            preparedStatement.setString(3, receiverId);
            preparedStatement.setString(4, senderId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String message = resultSet.getString("message");
                    messages.add(message);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return messages;
    }
    
    

    public void saveMessage(String senderId, String receiverId, String message) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MESSAGE_SQL)) {
            preparedStatement.setString(1, senderId);
            preparedStatement.setString(2, receiverId);
            preparedStatement.setString(3, message);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

// 파일: ChatServer.java
package GUI;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Runnable clientHandler = new ClientHandler(clientSocket);
                threadPool.execute(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    // 여기에서 메시지를 처리하고 클라이언트로 응답을 보냅니다.
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// 파일: ChatWindow.java
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

// 파일: FriendshipDAO.java
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendshipDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/miniproject1";
    private String jdbcUsername = "gangnam";
    private String jdbcPassword = "qwe123!@#";

    // 친구 관계를 데이터베이스에 추가하는 SQL
    private static final String INSERT_FRIENDSHIP_SQL = 
        "INSERT INTO friendships (user_id_1, user_id_2) VALUES (?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public List<String> getFriendsForUser(String userId) {
        List<String> friends = new ArrayList<>();
        String GET_FRIENDS_SQL = "SELECT user_id_1, user_id_2 FROM friendships WHERE user_id_1 = ? OR user_id_2 = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_FRIENDS_SQL)) {
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userId);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String friendId = userId.equals(resultSet.getString("user_id_1")) ? resultSet.getString("user_id_2") : resultSet.getString("user_id_1");
                    friends.add(friendId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friends;
    }

    

    public void addFriendship(String userId1, String userId2) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FRIENDSHIP_SQL)) {
            preparedStatement.setString(1, userId1);
            preparedStatement.setString(2, userId2);
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

// 파일: FriendshipManager.java
package GUI;

public class FriendshipManager {
    private FriendshipDAO friendshipDAO;

    public FriendshipManager() {
        this.friendshipDAO = new FriendshipDAO();
    }

    public void addFriendship(String userId1, String userId2) {
        try {
            friendshipDAO.addFriendship(userId1, userId2);
            System.out.println("친구 추가 성공: " + userId1 + "와(과) " + userId2);
        } catch (Exception e) {
            System.out.println("친구 추가 실패");
            e.printStackTrace();
        }
    }

    public void deleteFriendship(String userId1, String userId2) {
        // 여기에 친구 삭제 로직을 구현합니다. 예를 들면:
        // friendshipDAO.deleteFriendship(userId1, userId2);
        System.out.println("친구 삭제 기능은 아직 구현되지 않았습니다.");
    }
}

// 파일: LoginScreen.java
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginScreen extends JFrame {
    private JTextField txtUserId;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnGoToRegister;
    private UserInfoDAO userInfoDAO; // UserInfoDAO 객체 선언

    public LoginScreen() {
        userInfoDAO = new UserInfoDAO(); // UserInfoDAO 객체 초기화
        initializeUI();
    }

    private void initializeUI() {
        setTitle("로그인");
        setSize(500, 1300); // 화면 크기 조정
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));
        txtPassword = new JPasswordField("비밀번호");
        txtUserId = new JTextField("아이디");

        btnLogin = new JButton("로그인");
        btnGoToRegister = new JButton("회원가입으로 이동");

        // 텍스트 필드 포커스 리스너 추가
        txtUserId.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUserId.getText().equals("아이디")) {
                    txtUserId.setText("");
                }
            }
        });

        txtPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(txtPassword.getPassword()).equals("비밀번호")) {
                    txtPassword.setText("");
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        btnGoToRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToRegistration();
            }
        });

        add(txtUserId);
        add(txtPassword);
        add(btnLogin);
        add(btnGoToRegister);

        setVisible(true);
    }

    private void performLogin() {
        String userId = txtUserId.getText();
        String password = new String(txtPassword.getPassword());

        if (authenticateUser(userId, password)) {
            JOptionPane.showMessageDialog(this, "로그인 성공!");
            this.dispose(); // 로그인 창을 닫습니다.
            new MainScreen(userId).setVisible(true); // 로그인한 사용자 ID를 MainScreen에 전달합니다.
        } else {
            JOptionPane.showMessageDialog(this, "로그인 실패. 아이디 또는 비밀번호를 확인해주세요.");
        }
    }

    private boolean authenticateUser(String userId, String password) {
        String query = "SELECT * FROM users WHERE userID = ? AND password = ?";
        try (Connection connection = userInfoDAO.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void goToRegistration() {
        new RegistrationScreen(); // userInfos 전달 부분 제거
        dispose();
    }
}

// 파일: MainApplication.java
package GUI;


import javax.swing.SwingUtilities;

public class MainApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginScreen loginScreen = new LoginScreen(); // LoginScreen 인스턴스 생성
//                loginScreen.addDummyUsers(); // 더미 사용자 데이터를 데이터베이스에 추가
            }
        });
    }
}

// 파일: MainScreen.java
package GUI;

import java.util.List; // 이 줄을 추가
import java.util.ArrayList; // 이 줄을 추가

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen extends JFrame {
	private String loggedInUserId; // 로그인한 사용자의 ID 저장
	private JList<String> friendList;
	private DefaultListModel<String> friendListModel;
	private JList<String> chatList;
	private DefaultListModel<String> chatListModel;
	private JButton addFriendButton; // "친구 추가" 버튼

	
	
	
	
	public MainScreen(String loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
		setTitle("기본 화면");
		setSize(400, 600); // 화면 크기 조정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout()); // 레이아웃을 BorderLayout으로 설정

//        initializeFriendList();
		initializeChatList(this.loggedInUserId);
		initializeAddFriendButton(); // "친구 추가" 버튼 초기화 메소드 호출

		setVisible(true);
	}

	private void initializeAddFriendButton() {
		addFriendButton = new JButton("친구 추가");
		addFriendButton.addActionListener(e -> {
			AddFriendDialog addFriendDialog = new AddFriendDialog(this);
			addFriendDialog.setVisible(true);
			if (addFriendDialog.isSucceeded()) {
				// 여기에서 FriendshipManager를 사용하여 친구 추가 로직을 구현합니다.
				String userId = addFriendDialog.getUserId(); // 예시로, 사용자 ID를 가져옵니다.
				// 실제로 친구를 추가하는 로직은 여러분의 애플리케이션 로직에 따라 다릅니다.
				FriendshipManager friendshipManager = new FriendshipManager();
				friendshipManager.addFriendship(userId, "friendId"); // 'friendId'는 예시입니다. 실제로는 선택된 친구의 ID를 사용해야 합니다.
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addFriendButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

//	private void initializeFriendList() {
//		friendListModel = new DefaultListModel<>();
//		// 예제 데이터 추가
//		friendListModel.addElement("친구1");
//		friendListModel.addElement("친구2");
//		// 더 많은 친구를 추가할 수 있습니다.
//
//		friendList = new JList<>(friendListModel);
//		friendList.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e)) {
//					showPopupMenu(e.getX(), e.getY(), true); // 친구 목록 우클릭 메뉴
//				}
//			}
//		});
//
//		add(new JScrollPane(friendList));
//	}

	public void initializeChatList(String loggedInUserId) {
	    DefaultListModel<String> chatListModel = new DefaultListModel<>();
	    FriendshipDAO friendshipDAO = new FriendshipDAO();
	    List<String> friends = friendshipDAO.getFriendsForUser(loggedInUserId);

	    for (String friendId : friends) {
	        chatListModel.addElement(friendId);
	    }

	    if (chatList != null) {
	        getContentPane().remove(new JScrollPane(chatList));
	    }

	    chatList = new JList<>(chatListModel);
	    chatList.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (e.getClickCount() == 2) {
	                String selectedFriendId = chatList.getSelectedValue();
	                new ChatWindow(loggedInUserId, selectedFriendId).setVisible(true);
	            }
	        }
	    });

	    add(new JScrollPane(chatList), BorderLayout.CENTER);
	    revalidate();
	    repaint();
	}

	private void showPopupMenu(int x, int y, boolean isFriendList) {
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem menuItem;

		if (isFriendList) {
			menuItem = new JMenuItem("친구 추가");
			menuItem.addActionListener(e -> addFriend());
		} else {
			menuItem = new JMenuItem("채팅 시작");
			menuItem.addActionListener(e -> startChat(chatList.getSelectedValue()));
		}

		popupMenu.add(menuItem);
		popupMenu.show(isFriendList ? friendList : chatList, x, y);
	}

	private void addFriend() {
		System.out.println("친구 추가 기능 구현");
		// 친구 추가 로직 구현
	}

	private void startChat(String chatName) {
		System.out.println("채팅 시작 기능 구현: " + chatName);
		// 채팅 시작 로직 구현
	}

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(() -> new LoginScreen()); // LoginScreen을 실행합니다.
	}

}

// 파일: RegistrationScreen.java
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;

public class RegistrationScreen extends JFrame {
    private JTextField txtUserID, txtUserName, txtEmail, txtMobilePhone;
    private JPasswordField txtPassword;
    private JButton btnRegister;
    private ArrayList<UserInfo> userInfos; // 사용자 정보를 저장할 ArrayList

    public RegistrationScreen(ArrayList<UserInfo> userInfos) {
        this.userInfos = userInfos;
        initializeUI();
    }
    
    public RegistrationScreen() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("회원가입");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        txtUserID = new JTextField();
        txtUserName = new JTextField();
        txtEmail = new JTextField();
        txtMobilePhone = new JTextField();
        txtPassword = new JPasswordField();
        btnRegister = new JButton("회원가입");

        add(new JLabel("User ID:"));
        add(txtUserID);
        add(new JLabel("Username:"));
        add(txtUserName);
        add(new JLabel("Password:"));
        add(txtPassword);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Mobile Phone:"));
        add(txtMobilePhone);
        add(btnRegister);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserInfoDAO userInfoDAO = new UserInfoDAO();
                    String userID = txtUserID.getText();
                    if (userInfoDAO.checkUserExists(userID)) {
                        JOptionPane.showMessageDialog(RegistrationScreen.this, "이미 존재하는 UserID입니다. 다른 UserID를 입력해주세요.");
                    } else {
                        UserInfo newUser = createUserInfo();
                        userInfoDAO.insertUser(newUser);
                        JOptionPane.showMessageDialog(RegistrationScreen.this, "회원가입이 완료되었습니다.");
                        dispose();
                        new LoginScreen();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(RegistrationScreen.this, "회원가입 중 오류가 발생했습니다.");
                }
            }
        });

        setVisible(true);
    }

    private UserInfo createUserInfo() {
        String userID = txtUserID.getText();
        String userName = txtUserName.getText();
        String password = new String(txtPassword.getPassword());
        String email = txtEmail.getText();
        String mobilePhone = txtMobilePhone.getText();
        Timestamp signUpTime = new Timestamp(System.currentTimeMillis());

        return new UserInfo(userID, userName, password, email, mobilePhone, signUpTime, "Active");
    }
}

// 파일: UserInfo.java
package GUI;

import java.sql.Timestamp;

public class UserInfo {
    private String userID;
    private String userName;
    private String password;
    private String email;
    private String mobilePhone;
    private Timestamp signUpTime;
    private String userStatus;

    public UserInfo(String userID, String userName, String password, String email, String mobilePhone, Timestamp signUpTime, String userStatus) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.signUpTime = signUpTime;
        this.userStatus = userStatus;
    }

    // Getter와 Setter 메서드들
    // 예시:
    public String getUserID() {
        return userID;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Timestamp getSignUpTime() {
		return signUpTime;
	}

	public void setSignUpTime(Timestamp signUpTime) {
		this.signUpTime = signUpTime;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
    
    

    // 다른 getter와 setter도 마찬가지로 구현합니다.
}

// 파일: UserInfoDAO.java
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/miniproject1";
    private String jdbcUsername = "gangnam";
    private String jdbcPassword = "qwe123!@#";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (userID, userName, password, email, mobilePhone, signUpTime, userStatus) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // SQLException 처리
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // ClassNotFoundException 처리
            e.printStackTrace();
        }
        return connection;
    }
    
    
    // 중복ID 검증
    public boolean checkUserExists(String userID) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE userID = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    public void insertUser(UserInfo user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getMobilePhone());
            preparedStatement.setTimestamp(6, user.getSignUpTime());
            preparedStatement.setString(7, user.getUserStatus());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    

        private static final String UPDATE_USERS_SQL = "UPDATE users SET userName = ?, password = ?, email = ?, mobilePhone = ?, signUpTime = ?, userStatus = ? WHERE userID = ?;";

        public void updateUser(UserInfo user) throws SQLException {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getMobilePhone());
                preparedStatement.setTimestamp(5, user.getSignUpTime());
                preparedStatement.setString(6, user.getUserStatus());
                preparedStatement.setString(7, user.getUserID());

                int result = preparedStatement.executeUpdate();
                System.out.println(result + " rows updated.");
            } catch (SQLException e) {
                printSQLException(e);
            }
        }
    

}


