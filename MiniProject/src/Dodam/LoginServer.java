package Dodam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {

	public static void main(String[] args) {

		try {
			new LoginServer().loginServerStarter();
		} catch (IOException e) {
			System.out.println("서버 시작 중 오류: " + e.getMessage());
		}

	}

	public void loginServerStarter() throws IOException {
		System.out.println("서버로그: 서버가 작동합니다.");
		try (ServerSocket serverSocket = new ServerSocket(9874)) {
			while (true) {
				new PerClinetThread(serverSocket.accept()).start();
			}
		} catch (Exception e) {
			System.out.println("서버 오류: " + e.getMessage());
		}
	}

	class PerClinetThread extends Thread {
		Socket socket;
		DbControl db = new DbControl();

		PerClinetThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

				while (true) {
					String str = reader.readLine();
					String[] parts = str.split("#");

					// 분할된 각 부분 출력
					for (String part : parts) {
						System.out.println(part);
					}

					// 로그인 정보 DB검증
					if (parts.length == 2) {
						String id = parts[0];
						String pw = parts[1];

						if ((pw.equals(db.logInfoReturn(id)))) {
							writer.println("login success");
							System.out.println("server: login success");

						} else {
							writer.println("아이디와 비밀번호가 불일치합니다.");
						}
					}

					else if ("AddUser".equals(parts[0])) {
						// 클라이언트 수신 메시지
						// "AddUser" + "#" + name + "#" + id + "#" + password
//						System.out.println("part2"+parts[2]);
						if (db.existCheck(parts[2]).equals("0")) 
			
						{
//							System.out.println("DB입력실행시작");
							db.dbInput("users",parts[1],parts[2],parts[3]);
							System.out.println("DB입력실행완료"+"name:"+parts[1]+"ID:"+parts[2]+"PW:"+parts[3]);						
							}
						else {
							writer.println("서버: 중복된 ID가 존재합니다.");
							System.out.println("DB: 중복된 ID가 존재합니다.");	
						}
					}
				}
			} catch (Exception e) {
				System.out.println("통신 오류: " + e.getMessage());
			} finally {
				try {
					System.out.println("서버종료");
					socket.close();
				} catch (Exception ignored) {
				}
			}
		}
	}
}
