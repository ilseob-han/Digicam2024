package main;

import java.net.Socket;

import net.ReadClassThread;
import net.ReadThread;
import view.ChatListFrame;

public class MainClass {
	public static ReadThread rt;
	public static String IP = "127.0.0.1";

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(IP, 7894); // 서버 접속
			System.out.println("connection Success!!");

			ChatListFrame cf = new ChatListFrame(socket);

			new ReadClassThread(socket).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}