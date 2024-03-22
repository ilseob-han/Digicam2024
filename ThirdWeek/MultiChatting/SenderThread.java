
import java.net.*;
import java.io.*;
class SenderThread extends Thread {
    Socket socket;
    String name;
    SenderThread(Socket socket, String name) { 
        this.socket = socket;
        this.name = name;
    }
    public void run() {
        try {
            
        	BufferedReader reader = 
        			new BufferedReader(new InputStreamReader(System.in));
        	// 스캔 받은 텍스트를 문자로 변환 하고 BufferReader로 전달. 
        	
        	PrintWriter writer = 
        			new PrintWriter(socket.getOutputStream());
        	// PrintWriter를 사용하여 데이터를 출력하기 위해 PrintWriter 객체를 생성
        	// PrintWriter는 문자열과 기본 데이터 형식을 출력할 수 있는 보조 출력 스트림
        	// 소켓의 출력 스트림을 얻기 위해 socket.getOutputStream()을 호출하고, 
        	// 이를 PrintWriter의 생성자에 전달
            
	    // 제일 먼저 서버로 대화명 송신한다.
	    writer.println(name);
            writer.flush();
           
	   // 키보드로 입력된 메시지를 서버로 송신 
	    while (true) {
                String str = reader.readLine();
                if (str.equals("bye"))
                    break;
                writer.println(str);
                writer.flush();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            try { 
                socket.close(); 
            } 
            catch (Exception ignored) {
            }
        }
    }
}
