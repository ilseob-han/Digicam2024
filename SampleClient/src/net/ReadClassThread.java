package net;

import java.io.*;
import java.net.Socket;

import view.ChatListFrame;
import vo.RoomListVO;
import vo.TypeVO;

public class ReadClassThread extends Thread {
	Socket socket;
//	ClientFrame cf;

	public ReadClassThread(Socket socket/* , ClientFrame cf */) {
		this.socket = socket;
//		this.cf = cf;
	}

	@Override
	public void run() {
		super.run();
		ObjectInputStream ois = null;
		try {
			while (true) {
				ois = new ObjectInputStream(socket.getInputStream());
				TypeVO typeVO = ((TypeVO) ois.readObject());
				String Type = typeVO.getType();
				if (Type.equals("RoomList")) {
					RoomListVO roomListVO = (RoomListVO) typeVO; // 방 정보 받아오기
					ChatListFrame.cliRoomList = roomListVO; // 복사
					ChatListFrame.list.clear();
					for (int i = 0; i < roomListVO.roomList.size(); i++) { // 실시간으로 방 받아와지게
						ChatListFrame.list.add(roomListVO.roomList.get(i));
					}
				} 
				Thread.sleep(300);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}