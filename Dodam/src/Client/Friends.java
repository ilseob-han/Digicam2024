package Client;

import java.util.*;
import java.sql.Timestamp;
import java.util.ArrayList;


/*친구관계가 a,b 와 b,a의 경우 중복이 되지 않도록 친구 명세가 관리되도록 하는 방법이 필요하다. 
 * 
 * 
 */


public class Friends {

	public Friends() {
	}

	String myID;
	String friendID;
	String friendStatus;
	int friendLevel;
	String friendStartTime;

	static ArrayList<Friends> myFriendList = new ArrayList<>();
	static ArrayList<Friends> friendList = new ArrayList<>(); // ArrayList 생성
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		CreateNewAccount.createUser();
		CreateNewAccount.printUser(); // 생성된 사용자 출력
//		Login.login();
		makingFriends();
		printFriendList();

		// 친구목록 출력 테스트
		System.out.println("친구목록 출력 myid 입력");
		String myID = scanner.nextLine();
		ArrayList<Friends> myFriendList = Friends.showFriends(myID);

		// 친구여부 검증 테스트
		System.out.println("친구여부 검증 myid, friendid 입력");
		myID = scanner.nextLine();
		String friendID = scanner.nextLine();
		areTheyFriend(myID, friendID);
		
		// 친구 삭제 
		System.out.println("친구삭제 myid, friendid 입력");
		myID = scanner.nextLine();
		friendID = scanner.nextLine();
		unFriend(myID, friendID);

	}

	public static void unFriend(String myID, String friendID) {

		// 입력된 myID와 friendID를 기준으로 친구를 찾아서 상태를 변경함
		for (Friends friend : friendList) {
			if (friend.getMyID().equals(myID) && friend.getFriendID().equals(friendID)) {
				friend.setFriendStatus("Inactive");
				System.out.println("Friendship between " + myID + " and " + friendID + " has been terminated.");
				return;
			}
		}
		// 친구를 찾지 못한 경우
		System.out.println("Error: Friendship between " + myID + " and " + friendID + " not found.");
	}

	// 내 아이디와 친구 아이디 받아 친구여부 트루/펄스로 반환
	public static boolean areTheyFriend(String myID, String friendID) {
		for (Friends friend : friendList) {
			if (friend.getMyID().equals(myID) && friend.getFriendID().equals(friendID)
					&& friend.getFriendStatus().equals("Active")) {
				System.out.println("true");
				return true; // 무효화
			}
		}
		System.out.println("false");
		return false;
	}

	// 내 아이디 받아 친구 명세 보여줌
	public static ArrayList<Friends> showFriends(String myID) {
		ArrayList<Friends> myFriendList = new ArrayList<>();
		for (Friends friend : friendList) {
			if (friend.getMyID().equals(myID)) {
				myFriendList.add(friend);
				System.out.println("My ID: " + friend.getMyID());
				System.out.println("Friend ID: " + friend.getFriendID());
				System.out.println("Friend Status: " + friend.getFriendStatus());
				System.out.println("Friend Level: " + friend.getFriendLevel());
				System.out.println("Friend Start Time: " + friend.getFriendStartTime());
				System.out.println();
			}
		}
		return myFriendList;
	}

	// 친구 추가
	static void makingFriends() {
		Random random = new Random();
		for (int i = 0; i < 30; i++) {
			Friends friend = new Friends();
			int myID = random.nextInt(10) + 1; // 1부터 10까지의 임의의 숫자 설정
			int friendID;
			do {
				friendID = random.nextInt(10) + 1; // 1부터 10까지의 임의의 숫자 설정
			} while (friendID == myID); // myID와 friendID가 같으면 다시 생성
			friend.setFriendID("ID_" + friendID);
			friend.setMyID("ID_" + myID);
			friend.setFriendStatus("Active");
			friend.setFriendLevel(1);
			friend.setFriendStartTime(new Timestamp(System.currentTimeMillis()).toString());
			friendList.add(friend);
		}

		// 친구명세 수기 추가
//		System.out.println("친구명세 수기추가 테스트");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter information for a friend:");
//		System.out.print("My ID: ");
//		String myID = scanner.nextLine();
//		System.out.print("Friend ID: ");
//		String friendID = scanner.nextLine();
//		System.out.print("Friend Status: ");
//		String friendStatus = scanner.nextLine();
//		System.out.print("Friend Level: ");
//		int friendLevel = scanner.nextInt();
//		scanner.nextLine(); // Consume newline left-over
//
//		Friends friend = new Friends();
//		friend.setMyID(myID);
//		friend.setFriendID(friendID);
//		friend.setFriendStatus(friendStatus);
//		friend.setFriendLevel(friendLevel);
//		friend.setFriendStartTime(new Timestamp(System.currentTimeMillis()).toString());
//
//		friendList.add(friend);
//
//		scanner.close();

	}

	
	// 친구 목록을 출력하는 메서드
	public static void printFriendList() {
		System.out.println("Friends List:");
		for (Friends friend : friendList) {
			System.out.println("My ID: " + friend.getMyID());
			System.out.println("Friend ID: " + friend.getFriendID());
			System.out.println("Friend Status: " + friend.getFriendStatus());
			System.out.println("Friend Level: " + friend.getFriendLevel());
			System.out.println("Friend Start Time: " + friend.getFriendStartTime());
			System.out.println();
		}
	}

	public String getMyID() {
		return myID;
	}

	public void setMyID(String myID) {

		this.myID = myID;
	}

	public String getFriendID() {
		return friendID;
	}

	public void setFriendID(String friendID) {

		this.friendID = friendID;
	}

	public String getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(String friendStatus) {
		this.friendStatus = friendStatus;
	}

	public int getFriendLevel() {
		return friendLevel;
	}

	public void setFriendLevel(int i) {
		this.friendLevel = i;
	}

	public String getFriendStartTime() {
		return friendStartTime;
	}

	public void setFriendStartTime(String friendStartTime) {
		this.friendStartTime = friendStartTime;
	}

}
