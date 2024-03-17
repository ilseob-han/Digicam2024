import java.util.Scanner;

public class MemoryExam {

	public static void main(String[] args) {
		
		MyStack ms = new MyStack();
		MyQueue mq = new MyQueue();
		
		Memory m;
		
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.print("1.Stack 2.Queue 3.exit");
			int num = sc.nextInt();
			
			
			if (num == 1) {m=ms;}
			else {m=mq;}
			


				while(true) {
					System.out.print("1.push 2.pop 3.print");
					
					int n = sc.nextInt();
					
					if(n == 1) {
						m.push(sc.nextInt());
						m.full();
						
					}else if(n == 2) {
						System.out.println(ms.pop());						
					}else if(n == 3) {
						m.print();
					}
				}

		}while(true);
	}

}