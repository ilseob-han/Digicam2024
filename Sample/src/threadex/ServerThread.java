package threadex;

import java.net.*;
import java.util.*;

import main.MainClass;
import vo.ChatVO;
import vo.CreateVO;
import vo.RoomListVO;
import vo.TypeVO;

import java.io.*;

public class ServerThread extends Thread {
	Socket socket;
	ServerSocket nowServerSocket;
	List<Socket> list;
	int nowPort;

	public ServerThread(int nowPort, Socket socket, ServerSocket nowServerSocket, List<Socket> list) {
		super();
		this.nowPort = nowPort;
		this.socket = socket;
		this.nowServerSocket = nowServerSocket;
		this.list = list;
	}

	@Override
	public void run() {

		super.run();

		try {
			while (true) { // 채팅방 스레드 생성
				// 서버는 항상 열려있어야함
				System.out.println(nowPort + "포트 접속 대기중...");
				socket = nowServerSocket.accept();
				list.add(socket);

				System.out.println(
						"[" + nowPort + "] Client IP: " + socket.getInetAddress() + "Port:" + socket.getPort());
				
				// 아래 부분은 접속 된 소켓을 통해 소통을 해야함 - 스레드로 이동해야함
				new ChatThread(socket, list).start();
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