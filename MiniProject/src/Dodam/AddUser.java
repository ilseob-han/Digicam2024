package Dodam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;


public class AddUser {
	String name;
	String id;
	String pw;
	
	
	public static void main(String[] args) {
		AddUser add = new AddUser();
		add.addUser();
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public boolean addUser() {

		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9874);
			AddUserSenderThread sender = new AddUserSenderThread(socket, name, id, pw);
			AddUserReceiverThread receiver = new AddUserReceiverThread(socket);
			sender.start();
			receiver.start();

			sender.join(); // SenderThread가 종료될 때까지 기다림
			receiver.join(); // ReceiverThread가 종료될 때까지 기다림

			return receiver.isLoginSuccess(); // 로그인 성공 여부 반환
		} catch (Exception e) {
			System.out.println("클라이언트 오류: " + e.getMessage());
			return false;
		} finally {
			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				System.out.println("소켓 닫기 오류: " + e.getMessage());
			}
		}
	}
}

class AddUserSenderThread extends Thread {
	private Socket socket;
	private String id;
	private String password;
	private String name;

	public AddUserSenderThread(Socket socket, String name, String id, String password) {
		this.socket = socket;
		this.name = name;
		this.id = id;
		this.password = password;
	}

	@Override
	public void run() {
		try {
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
			writer.println("AddUser" + "#" + name + "#" + id + "#" + password); // "Clinet: UserAdd정보 추가"
			
			System.out.println("client송신"+ "#" +"AddUser" + "#" + name + "#" + id + "#" + password);
			
			// 스트림을 여기서 닫지 않음
		} catch (Exception e) {
			System.out.println("Clinet Add User 송신 오류: " + e.getMessage());
		}
	}

}

class AddUserReceiverThread extends Thread {
	private Socket socket;
	private boolean loginSuccess = false;

	public AddUserReceiverThread(Socket socket) {
		this.socket = socket;
	}

	public boolean isLoginSuccess() {
		return loginSuccess;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String response = reader.readLine();
			if ("login success".equals(response)) {
				loginSuccess = true;
				System.out.println("서버: " + response);
			} else {
				System.out.println(response);
			}
			// 스트림을 여기서 닫지 않음
		} catch (Exception e) {
			System.out.println("수신 오류: " + e.getMessage());
		}
	}
}

