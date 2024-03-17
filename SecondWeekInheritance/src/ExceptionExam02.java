import java.util.Scanner;

public class ExceptionExam02 {

	public static void main(String[] args) throws ArithmeticException, InterruptedException{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		// 예상되는 예외를 인식.
		System.out.println(3 / num);
		Thread.sleep(3000);
		System.out.println("bye");
	}

}
