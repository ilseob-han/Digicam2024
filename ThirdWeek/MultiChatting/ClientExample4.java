import java.net.*;
class ClientExample4 {
    public static void main(String[] args) {
    	System.out.println(args[0]);
        if (args.length != 1) {
            System.out.println(
                "Usage: java ClientExample4 <user-name>");
            return;
        }
        // if (args.length != 1) { ... }: 이 조건문은 
        // 메인 메소드에 전달된 인자의 개수(args.length)가 1이 아닐 때 참이 됩니다. 
        // 여기서 args는 메인 메소드(public static void main(String[] args))
        // 로 전달되는 문자열 배열로, 프로그램 실행 시 명령줄에서 입력된 인자들을 포함합니다.
        
        // 만약 args.length가 1이 아닐 경우 return문을 사용하여 
        // 해당시점 종료. 즉, 인자의 개수가 잘못되었을 때 프로그램은 사용법을 안내한 후 즉시 종료
        
        
        try {
	    // 서버와 연결
            Socket socket = new Socket("127.0.0.1", 9875);
            // 서버 아이피와 포트넘버로 socket 객체 만들기
            // socket은 로컬변수로 메인메서드 안에서만 존재하지만
            // 쓰레드로 보내지면 이후 쓰레드 안에서 독자적으로 작동
            

             // 메시지 송신 쓰레드와 수신 쓰레드 생성해서 시작
            Thread thread1 = new SenderThread(socket, args[0]);
            Thread thread2 = new ReceiverThread(socket);

            thread1.start();
            thread2.start();
        }
        catch (Exception e) {
        	
        	//catch (Exception e)는 모든 종류의 예외를 잡아낼 수 있는 
        	// 일반적인 예외 처리 구문, Exception은 모든 예외 클래스의 슈퍼클래스
            System.out.println(e.getMessage());
        }
    }
}
