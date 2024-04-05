package net;

import java.io.*;
import java.net.Socket;

import view.ChatFrame;

public class ReadThread extends Thread {
	Socket socket;
	ChatFrame cf;

	public ReadThread(Socket socket, ChatFrame cf) {
		this.socket = socket;
		this.cf = cf;
	}

	@Override
	public void run() {
		super.run();
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String str = br.readLine();
				System.out.println("str is" + str);
				if (str == null) { // 접속 끊김
					System.out.println("접속 끊김");
				}
				cf.TextList.append(str + "\n");

				Thread.sleep(300);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}