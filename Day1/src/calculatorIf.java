import java.util.Scanner;

public class calculatorIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char doMore;
		do {

			Scanner sc = new Scanner(System.in);

			int num1 = input1(Scanner(System.in));
			char cal = input2(sc);
			int num2 = input3(sc);

			double num3 = calculator(num1, cal, num2);

			System.out.println(output(num1, cal, num2, num3)); //output에서 생성된 String 출력
			
			System.out.println("계속 진행하시려면 'y'를 눌러주세요.");

			doMore = sc.next().charAt(0);

		} while ((doMore == 'y') || (doMore == 'Y'));

	}

	public static int input1(Scanner sc) {
		System.out.println("첫번째 수를 입력하세요");
		int num1 = sc.nextInt();
		return num1;
	}

	public static char input2(Scanner sc) {
		System.out.println("연산자를 입력하세요");
		char cal = sc.next().charAt(0);
		return cal;
	}

	public static int input3(Scanner sc) {
		System.out.println("두번째 수를 입력하세요");
		int num1 = sc.nextInt();
		return num1;
	}

	public static int calculator(int num1, char cal, int num2) {
		int num3 = 0;
		if (cal == '+') {
			num3 = num1 + num2;
		} else if (cal == '-') {
			num3 = num1 - num2;
		} else if (cal == '*') {
			num3 = num1 * num2;
		} else {
			num3 = num1 / num2;
		}
		//정수를 float으로 바꾸는 에러 해결 필요
		return num3;
	}
	
	public static String output(int num1, char cal, int num2, double num3)
	{
		return(num1 + "" + cal + "" + num2 + "=" + num3);
	}
	
}
