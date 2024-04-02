package Client;

import java.sql.Timestamp;
import java.util.*;

public class CreateNewAccount {
	Scanner scanner = new Scanner(System.in);
	static ArrayList<UserInfo> userList = new ArrayList<>(); // ArrayList 생성
//	static CreateNewAccount createNewAccount = new CreateNewAccount();

	public static void main(String[] args) {

		
		createUser();
		printUser(); // 생성된 사용자 출력

	}

	public static void createUser() {

		for (int i = 1; i <= 10; i++) {
			UserInfo user = new UserInfo();
			user.setUserID("ID_"+i);
			user.setUserName("User" + i);
			user.setPassword("password" + i);
			user.setEmail("user" + i + "@example.com");
			user.setMobilePhone("010-1234-567" + i);
			user.setSignUp_time(new Timestamp(System.currentTimeMillis())); // 현재 시간으로 설정
			user.setWithdrawal_time(null); // 회원 탈퇴 시간은 null로 설정
			user.setUserStatus("Active"); // 사용자 상태는 Active로 설정

			// ArrayList에 사용자 추가
			userList.add(user);
		}
		printUser();
		// 수기로 입력
//		Scanner scanner = new Scanner(System.in);  
//		UserInfo user = new UserInfo();
//		System.out.println("\nEnter information for user :");
//		System.out.print("User ID: ");
//		user.setUserID(scanner.nextInt());
//		scanner.nextLine(); // 개행 문자(\n) 비우기
//		System.out.print("Username: ");
//		user.setUserName(scanner.nextLine());
//		System.out.print("Password: ");
//		user.setPassword(scanner.nextLine());
//		System.out.print("Email: ");
//		user.setEmail(scanner.nextLine());
//		System.out.print("Mobile Phone: ");
//		user.setMobilePhone(scanner.nextLine());
//		// 현재 시간으로 Sign-up Time 설정
//		user.setSignUp_time(new Timestamp(System.currentTimeMillis()));
//		user.setWithdrawal_time(null); // 회원 탈퇴 시간은 일단 null로 설정
//		user.setUserStatus("Active"); // 사용자 상태는 일단 Active로 설정
//		// ArrayList에 사용자 추가
//		userList.add(user);
	}



	static void printUser() {
		for (UserInfo user : userList) {
			System.out.println("User ID: " + user.getUserID());
			System.out.println("Username: " + user.getUserName());
			System.out.println("Password: " + user.getPassword());
			System.out.println("Email: " + user.getEmail());
			System.out.println("Mobile Phone: " + user.getMobilePhone());
			System.out.println("Sign-up Time: " + user.getSignUp_time());
			System.out.println("Withdrawal Time: " + user.getWithdrawal_time());
			System.out.println("User Status: " + user.getUserStatus());
			System.out.println();
		}
	}
}