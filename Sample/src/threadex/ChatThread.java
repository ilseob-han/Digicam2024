package threadex;

import java.net.*;
import java.util.*;
import java.io.*;

public class ChatThread extends Thread {
	Socket socket;
	List<Socket> list;

	public ChatThread(Socket socket, List<Socket> list) {
		super();
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {
		super.run();

		try {
			Loop1: while (true) {
				// 수신 (recv)
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str = reader.readLine();
				if (str == null) { // 만약 소켓이 나갔다면 리스트에서 소켓 제거해주고 종료
					for (int i = 0; i < list.size(); i++) {
						if (socket.equals(list.get(i))) {
							list.remove(i);
							break Loop1;
						}
					}
				}
				System.out.println("[받은 메시지]: " + str);
				// 송신 (send)
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i) + " " + socket);
					PrintWriter writer = new PrintWriter(list.get(i).getOutputStream());
					writer.println(str);
					writer.flush();
				}
				Thread.sleep(300);
			}
		} catch (Exception e) {
			System.out.println("연결이 끊긴 IP: " + socket.getInetAddress());
			list.remove(socket); // index뿐만 아니라 Object를 넣어도 제거가 됨

			// 접속되어 있는 남아있는 클라이언트
			for (Socket s : list) {
				System.out.println("접속되어 있는 IP: " + s.getInetAddress() + " Port: " + s.getPort());
			}

			try {
				socket.close(); // 종료 후 소켓 닫아주기
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}