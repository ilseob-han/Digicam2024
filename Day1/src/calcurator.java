import java.util.Scanner;

public class calcurator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc;
		sc = new Scanner(System.in);

		System.out.println("첫번째 수를 입력하세요");
		int num1 = sc.nextInt();

		System.out.println("두번째 수를 입력하세요");
		int num2 = sc.nextInt();

		System.out.println("연산자를 입력하세요");
		String cal = sc.next();

		switch (cal) {
		case "+":
			System.out.println(num1 + "" + cal + "" + num2 + "=" + (num1 + num2));
			break;
		case "-":
			System.out.println(num1 + "" + cal + "" + num2 + "=" + (num1 - num2));
			break;
		case "*":
			System.out.println(num1 + "" + cal + "" + num2 + "=" + (num1 * num2));
			break;
		case "/":
			System.out.println(num1 + "" + cal + "" + num2 + "=" + ((double) num1 / num2));
			break;
		default:
			System.out.print("연산자 입력 오류 입니다.");

		}

	}

}
