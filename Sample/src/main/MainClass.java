package main;

import java.io.*;
import java.util.*;

import threadex.MainThread;

import java.net.*;

public class MainClass {
	public static int PORT = 7894; // 채팅용 포트 서버
	public static List<ServerSocket> serverList = new ArrayList<ServerSocket>(); // 채팅 서버 리스트
	public static List<String> roomList = new ArrayList<String>(); // 방 이름
	public static List<Integer> port = new ArrayList<Integer>(); // 포트 번호
	public static List<List<Socket>> connectSocket = new ArrayList<List<Socket>>(); // 채팅 서버에 들어온 클라이언트 소켓 리스트

	public static void main(String[] args) {
		Socket clientSocket = null;
		boolean isFirst = true;
		try {
			ServerSocket serverSocket = new ServerSocket(7894);

			List<Socket> list = new ArrayList<Socket>();

			while (true) {
				// 서버는 항상 열려있어야함
				System.out.println("접속 대기중...");
				clientSocket = serverSocket.accept();
				list.add(clientSocket);

				System.out.println("Client IP: " + clientSocket.getInetAddress() + "Port:" + clientSocket.getPort());

				// 아래 부분은 접속 된 소켓을 통해 소통을 해야함 - 스레드로 이동해야함
				new MainThread(clientSocket, list, isFirst).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}