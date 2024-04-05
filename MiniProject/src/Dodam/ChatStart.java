package Dodam;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ChatStart {

	public static void main(String[] args) throws IOException {



		// 로그인 부분 시작
		LoginClient loginSuccess = new LoginClient();
		String ID = loginSuccess.id;

		loginSuccess.setId("1234");
		loginSuccess.setPw("1234");
		System.out.println("로그인 성공: " + loginSuccess.login());
		System.out.println("ID" + loginSuccess.id);
		System.out.println("PW" + loginSuccess.pw);

//		// 회원가입 시작
//		AddUser add = new AddUser();
//		add.setName("새로운 사용자 이름");
//		add.setId("새로운ID");
//		add.setPw("새로운비밀번호");
//		// 설정된 값으로 사용자 추가 시도
//		add.addUser();
//		System.out.println("add User 종료");
//
//		// 멀티채팅 시작
//		JFrame.setDefaultLookAndFeelDecorated(true);
//		MultiClient cc = new MultiClient("127.0.0.1", ID);
//		cc.init();

	}
}
