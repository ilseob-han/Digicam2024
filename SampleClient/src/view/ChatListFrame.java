package view;


import java.util.*;
import java.util.List;

import main.MainClass;
import net.ReadThread;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import vo.RoomListVO;

public class ChatListFrame extends Frame implements WindowListener, ActionListener {
	CreateRoomFrame crf;
	Socket socket;
	Label mainLabel = new Label("STALK");
	Button createRoombtn = new Button("create");
	Button enterbtn = new Button("enter");
	public static java.awt.List list = new java.awt.List();

	public List<RoomListVO> chatList = new ArrayList<>();
	public static RoomListVO cliRoomList = new RoomListVO();

	public ChatListFrame(Socket socket) {
		setLayout(null);
		this.socket = socket;
		crf = new CreateRoomFrame(this, socket);

		new LoginFrame(this);

		mainLabel.setBounds(50, 50, 150, 30);
		add(mainLabel);
		createRoombtn.setBounds(350, 50, 50, 30);
		createRoombtn.addActionListener(this);
		add(createRoombtn);
		enterbtn.setBounds(200, 520, 50, 50);
		enterbtn.addActionListener(this);
		add(enterbtn);
		list.setBounds(50, 100, 350, 400);
		add(list); // 채팅방 리스트

		setBounds(0, 0, 450, 600);

		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == createRoombtn) {
			// CraetaRoomFrame 을 시각화
			crf.setVisible(true);
			// 현재창 닫기
			this.dispose();
		} else if (obj == enterbtn) {
			int index = -1;
			ChatFrame cf = null;
			for (int i = 0; i < cliRoomList.roomList.size(); i++) {
				if (list.getSelectedItem().equals(cliRoomList.roomList.get(i))) {
					index = i;
					break;
				}
			}
			int selectPort = cliRoomList.port.get(index);
			String roomName = cliRoomList.roomList.get(index);
			try {

				// 채팅 포트 소켓 생성
				System.out.println("select port is " + selectPort);
				Socket chatSocket = new Socket(MainClass.IP, selectPort);
				cf = new ChatFrame(this, chatSocket, roomName);
				MainClass.rt = new ReadThread(chatSocket, cf);
				MainClass.rt.start();

			} catch (Exception e1) {
				e1.printStackTrace();
			}

			// ChatFrame 을 시각화
			cf.setVisible(true);
			// 현재창 닫기
			this.dispose();
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}