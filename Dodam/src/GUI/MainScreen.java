package GUI;

import java.util.List; // 이 줄을 추가
import java.util.ArrayList; // 이 줄을 추가

import javax.swing.*;

import net.LoginScreen;

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
