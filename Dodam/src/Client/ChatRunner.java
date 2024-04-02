package Client;

import java.util.ArrayList;
import java.util.Scanner;

public class ChatRunner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		CreateNewAccount.createUser();
		CreateNewAccount.printUser(); // 생성된 사용자 출력
//		Login.login();
		Friends.makingFriends();
		Friends.printFriendList();

		// 친구목록 출력 테스트
		System.out.println("친구목록 출력 myid ID_5 임의입력");
//		String myID = scanner.nextLine();
//		ArrayList<Friends> myFriendList = Friends.showFriends(myID);
		ArrayList<Friends> myFriendList = Friends.showFriends("ID_5");
		
		// 친구여부 검증 테스트
		System.out.println("친구여부 검증 myid, friendid ID_5 임의입력");
//		myID = scanner.nextLine();
//		String friendID = scanner.nextLine();
		Friends.areTheyFriend("ID_5", "ID_7");
		
		// 친구 삭제 
		System.out.println("친구삭제 myid ID_5, friendid ID_7 입력");
//		myID = scanner.nextLine();
//		friendID = scanner.nextLine();
		Friends.unFriend("ID_5", "ID_7");
		
//		BlockedUsers.Blocking("ID_5", "ID_7");
		

	}

}
