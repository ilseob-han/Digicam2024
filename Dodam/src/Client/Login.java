package Client;

import java.util.*;

public class Login {

	public static void main(String[] args) {

		CreateNewAccount.createUser();
		CreateNewAccount.printUser(); // 생성된 사용자 출력
		login();

	}

	public static void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요.");
		String id = scanner.nextLine();
		System.out.println("비밀번호를 입력해주세요.");
		String pw = scanner.nextLine();

		String userPassword = getPasswordById(id);

		if (pw.equals(userPassword)) {
			System.out.println("로그인 되었습니다.");
		} else if (userPassword == null) {
			System.out.println("아이디가 존재하지 않습니다.");
		} else {
			System.out.println("비밀번호가 잘못되었습니다.");
		}
	}

	public static String getPasswordById(String userID) {
		for (UserInfo user : CreateNewAccount.userList) {
			if (user.getUserID().equals(userID)) {
				return user.getPassword(); // 아이디와 일치하는 사용자를 찾으면 비밀번호 반환
			}
		}
		return null; // 아이디와 일치하는 사용자가 없으면 null 반환
	}

}
