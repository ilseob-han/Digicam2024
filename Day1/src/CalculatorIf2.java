import java.util.Scanner;

public class CalculatorIf2 {

	//field
	private String comment1 = "계속 진행하시려면 'y'를 눌러주세요.";
	private String comment2 = "첫번째 수를 입력하세요.";
	private String comment3 = "연산자를 입력하세요";
	private String comment4 = "두번째 수를 입력하세요";
	private String[] comment5 = {"+","-","*","/"};
	
	//Constructor
	public CalculatorIf2()
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char doMore;
		do {

			Scanner sc = new Scanner(System.in);
			CalculatorIf2 firstCal = new CalculatorIf2();

			int num1 = firstCal.input1(sc);
			char cal = firstCal.input2(sc);	
			int num2 = firstCal.input3(sc);

			double num3 = firstCal.calculator(num1, cal, num2);
			System.out.println(firstCal.output(num1, cal, num2, num3)); //output에서 생성된 String 출력
			System.out.println(firstCal.comment1);

			doMore = sc.next().charAt(0);

		} while ((doMore == 'y') || (doMore == 'Y'));

	}

	public int input1(Scanner sc) {
		System.out.println(comment2);
		int num1 = sc.nextInt();
		return num1;
	}

	public char input2(Scanner sc) {
		System.out.println(comment3);
		char cal = sc.next().charAt(0);
		return cal;
	}

	public int input3(Scanner sc) {
		System.out.println(comment4);
		int num1 = sc.nextInt();
		return num1;
	}

	public int calculator(int num1, char cal, int num2) {
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
	
	public String output(int num1, char cal, int num2, double num3)
	{
		return(num1 + "" + cal + "" + num2 + "=" + num3);
	}
	
}
