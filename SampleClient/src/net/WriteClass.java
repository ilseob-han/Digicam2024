package net;

import java.net.InetAddress;
import java.net.Socket;
import java.io.*;

import view.ChatFrame;
import view.LoginFrame;

public class WriteClass extends Thread {
	Socket socket;
	ChatFrame cf;

	public WriteClass(Socket socket, ChatFrame cf) {
		this.socket = socket;
		System.out.println("socketwrite" + socket);
		this.cf = cf;
	}

	public void sendMessage() {
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			String msg = "";
			String id = LoginFrame.id.getText();
			// 그 외 전송
			msg = "[" + id + "]" + cf.input.getText();

			// server로 전송
			pw.println(msg);
			pw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}