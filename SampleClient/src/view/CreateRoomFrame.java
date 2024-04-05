package view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import vo.CreateVO;

public class CreateRoomFrame extends Frame implements ActionListener {
	public static TextField rName = new TextField(8); // 방 이름 입력
	Label mainLabel = new Label("STALK");
	Button createBtn = new Button("생성");
	ChatListFrame clf;
	Socket socket;
	private ObjectOutputStream oos;

	public CreateRoomFrame(ChatListFrame clf, Socket socket) {
		this.socket = socket;
		this.clf = clf;
		mainLabel.setBounds(50, 50, 150, 30);
		add(mainLabel);
		setLayout(null);
		setTitle("방생성");

		Label label = new Label("방 이름 입력: ");
		label.setBounds(50, 100, 100, 30);
		add(label);

		rName.setBounds(150, 100, 250, 30);
		add(rName);

		createBtn.setBounds(200, 180, 100, 30);
		createBtn.addActionListener(this);
		add(createBtn);

		setBounds(0, 0, 500, 300);
		setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == createBtn) {
			// 데이터 송신
			try {
				oos = new ObjectOutputStream(socket.getOutputStream());
				CreateVO createList = new CreateVO();
				createList.setType("Create");	// Type : Create
				createList.setrName(CreateRoomFrame.rName.getText());	// 방 이름
				// server에 객체 전송
				oos.writeObject(createList);
				oos.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			// CraetaRoomFrame 을 시각화
			clf.setVisible(true);
			// 현재창 닫기
			this.dispose();
		}
	}

}