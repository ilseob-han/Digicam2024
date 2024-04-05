package threadex;

import java.net.*;
import java.util.*;

import main.MainClass;
import vo.ChatVO;
import vo.CreateVO;
import vo.RoomListVO;
import vo.TypeVO;

import java.io.*;

public class MainThread extends Thread {
	Socket socket;
	List<Socket> list;
	boolean isFirst;

	public MainThread(Socket socket, List<Socket> list, boolean isFirst) {
		super();
		this.socket = socket;
		this.list = list;
		this.isFirst = isFirst;
	}

	@Override
	public void run() {

		super.run();

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;

		try {
			while (true) {
				// 수신 (recv)
				ois = new ObjectInputStream(socket.getInputStream());
				if (isFirst) { // 만약 처음 들어왔다면 채팅방 리스트 보내주기 - 일단 이게 안됨.
					oos = new ObjectOutputStream(socket.getOutputStream());
					RoomListVO roomListVO = new RoomListVO();
					roomListVO.setType("RoomList"); // Type : RoomList
					roomListVO.roomList = MainClass.roomList; // 방 정보
					roomListVO.port = MainClass.port; // 포트 정보
					oos.writeObject(roomListVO);
					oos.flush();
					isFirst = false;
				}
				TypeVO typeVO = ((TypeVO) ois.readObject());
				System.out.println("타입 들어옴" + typeVO);
				String Type = typeVO.getType();
				if (Type.equals("Create")) {
					System.out.println("여기여기");
					Socket clientSocket = null;
					CreateVO createVO = (CreateVO) typeVO;
					// 이름에 맞게 포트 생성해주기
					MainClass.roomList.add(createVO.getrName()); // 방 이름, 포트번호 저장
					MainClass.port.add(MainClass.PORT); // 방 이름, 포트번호 저장
					ServerSocket nowServerSocket = new ServerSocket(MainClass.PORT++); // 채팅 서버소켓 생성
					MainClass.serverList.add(nowServerSocket); // 포트 연결
					List<Socket> clientList = new ArrayList<Socket>(); // 채팅 클라이언트 소켓 만들어주기
					MainClass.connectSocket.add(clientList); // 클라이언트 소켓 리스트에 넣어주기
					System.out.println(createVO.getrName() + "과 PORT " + (MainClass.PORT - 1) + "생성완료!");
					RoomListVO roomListVO = new RoomListVO();
					roomListVO.setType("RoomList"); // Type : RoomList
					roomListVO.roomList = MainClass.roomList; // 방 정보
					roomListVO.port = MainClass.port; // 포트 정보

					// 모든 사람에게 생성된 방 보내주기
					for (Socket s : list) {
						oos = new ObjectOutputStream(s.getOutputStream());
						oos.writeObject(roomListVO);
						oos.flush();
					}
					int nowPort = MainClass.PORT - 1;
					new ServerThread(nowPort, clientSocket, nowServerSocket, clientList).start();
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