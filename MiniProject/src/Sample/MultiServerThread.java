package Sample;

import java.net.*;
import java.io.*;
public class MultiServerThread implements Runnable{
    private Socket socket;
    // 클라이언트와의 네트워크 통신을 위한 소켓
    private MultiServer ms;
    // MultiServerThread가 속한 MultiServer 인스턴스. 
    // 서버 전체를 참조하여 다른 클라이언트들과의 상호작용이 가능하게 함
    private ObjectInputStream ois;
    // 소켓을 통해 들어오는 데이터 스트림을 객체 단위로 읽기 위한 스트림
    
    private ObjectOutputStream oos;
    // 소켓을 통해 나가는 데이터 스트림을 객체 단위로 쓰기 위한 스트림.
    
    public MultiServerThread(MultiServer ms){
        this.ms = ms;
        //생성자. 이 스레드가 소속될 MultiServer 인스턴스를 받아와 멤버 변수 ms에 할당             
    }
    public synchronized void run(){ 	   	
    // 인터페이스의 run 메서드 구현. 이 메서드는 스레드가 시작될 때 자동으로 호출됩니다. 
    // 여기서는 클라이언트로부터 메시지를 받아 처리하고, 
    // "exit" 메시지를 받으면 스레드를 종료합니다.
    
    // run 메서드는 먼저 MultiServer로부터 소켓을 받아와 
    // ObjectInputStream과 ObjectOutputStream을 초기화
    
    	boolean isStop = false;
        try{
            socket = ms.getSocket();
            ois = new ObjectInputStream(socket.getInputStream());
            // 변수 선언은 이미 이전에 ObjectInputStream ois에서 이루어짐
            // ois는 ObjectInputStream 타입의 객체를 참조하기 위해 사용된 변수
            
            oos = new ObjectOutputStream(socket.getOutputStream());
            String message = null;
            
            
            while(!isStop){
                message = (String)ois.readObject();
                // 클라이언트로부터 메시지를 받기 위해 무한 루프를 돌며 
                // ois.readObject()를 호출
                
                String[] str = message.split("#");
                if(str[1].equals("exit")){
                    broadCasting(message);
                    isStop = true;
            // 메시지가 "exit"를 포함하면, 루프에서 빠져나와 클라이언트 연결을 종료 
                 }else{
                    broadCasting(message);
                }
            }
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+
            		"정상적으로 종료하셨습니다");
            // ms.getList().remove(this);를 호출하여 자신을 서버의 클라이언트 목록에서 제거
            
            System.out.println("list size : "+ms.getList().size());
            
            
        }catch(Exception e){
            ms.getList().remove(this);
            System.out.println(socket.getInetAddress()+
            		 "비정상적으로 종료하셨습니다");

            System.out.println("list size : "+ms.getList().size());
        }
    }
    public void broadCasting(String message)throws IOException{
        for(MultiServerThread ct : ms.getList()){
           ct.send(message);      
    //받은 메시지를 MultiServer 인스턴스를 통해 관리되는 모든 클라이언트에게 브로드캐스트
        }
    }
    public void send(String message)throws IOException{
        oos.writeObject(message);        
        // 이 스레드에 연결된 클라이언트에게 메시지를 전송
    }
}
