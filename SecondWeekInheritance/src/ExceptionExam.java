import java.util.Scanner;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		try {
			int num = sc.nextInt();
			// 예상되는 예외를 인식.
			System.out.println(3 / num);

		}catch (ArithmeticException ae) {
			System.out.println("0으로 입력하지마");
			return;

		}catch (Exception in) {
			System.out.println("제대로 입력해");
		}
		finally {
			
		}
		

	}

}
//			System.out.println("0으로 입력하지마");