package view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener {

	public static TextField id = new TextField(8); // id 입력
	Button loginBtn = new Button("입장");
	ChatListFrame clf;

	public LoginFrame(ChatListFrame clf) {
		System.out.println(clf+"clf");
		this.clf = clf;

		setLayout(null);
		setTitle("채팅방 입장");

		Label label = new Label("이름 입력: ");
		label.setBounds(50, 60, 100, 30);
		add(label);

		id.setBounds(150, 60, 250, 30);
		add(id);

		loginBtn.setBounds(200, 110, 100, 30);
		loginBtn.addActionListener(this);
		add(loginBtn);

		setBounds(0, 0, 500, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그인 버튼 클릭 시
		
		// ClientFrame 을 시각화
		clf.setVisible(true);
		// 현재창 닫기
		this.dispose();

	}

}