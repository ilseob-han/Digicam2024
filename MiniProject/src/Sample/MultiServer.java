package Sample;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer {
	
	private ArrayList<MultiServerThread> list;
	private Socket socket;

	
	// MultiServer 메서드 시작
	public MultiServer()throws IOException{
		list = new ArrayList<MultiServerThread>();
		// 서버에 연결된 클라이언트를 처리하는 MultiServerThread 인스턴스들의 리스트입니다. 
		// 각 클라이언트 연결은 이 리스트에 추가된 MultiServerThread 객체에 의해 독립적으로 처리됩니다.
		
		ServerSocket serverSocket = new ServerSocket(5000);
		// 서버가 클라이언트의 연결 요청을 수락한 후 생성된 클라이언트 소켓을 참조
		// 생성자에서, 지정된 포트 번호(여기서는 5000)로 ServerSocket을 생성합니다. 
		// 이 서버 소켓은 클라이언트의 연결 요청을 기다립니다.
		MultiServerThread mst = null;

		boolean isStop = false;


		

		
		
		while(!isStop){
			System.out.println("Server ready...");
			socket = serverSocket.accept();
			// 무한 루프 안에서 serverSocket.accept() 메서드를 호출하여 클라이언트의 연결 요청을 대기합니다. 
			// 연결 요청이 들어오면, accept() 메서드는 해당 클라이언트와 통신할 수 있는 새로운 Socket 객체를 반환
			
			mst = new MultiServerThread(this);
			
			
			list.add(mst);
			//각 클라이언트 연결에 대해, MultiServerThread 인스턴스를 생성하고, 이를 list에 추가합니다. 
	
			Thread t = new Thread(mst);
			t.start(); 
			// 멀티서버 쓰레드 실행
			// 그런 다음, 이 MultiServerThread를 실행할 새로운 Thread 객체를 생성하고 시작합니다. 
			// 이렇게 하여, 각 클라이언트는 독립적인 스레드에서 비동기적으로 처리됩니다.

		}
	}
	public ArrayList<MultiServerThread>getList(){
		return list;
	}
	//연결된 클라이언트를 처리하는 MultiServerThread 객체들의 리스트를 반환합니다.
	
	public Socket getSocket()
	{
		return socket;
	}
	// 현재 처리 중인 클라이언트와의 연결 소켓을 반환
	public static void main(String arg[])throws IOException{
		new MultiServer();
	}
	// 클래스의 생성자입니다. 서버 소켓을 생성하고, 클라이언트의 연결 요청을 무한히 대기하며, 
	// 요청이 들어올 때마다 새로운 MultiServerThread 인스턴스를 생성하여 각 클라이언트 연결을 처리
}
