import java.util.Scanner;

public class CalculatorOtherClass {

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

			//String result = firstCal.output(num1, cal, num2, num3);

			System.out.println(num1 + "" + cal + "" + num2 + "=" + num3); // output에서 생성된 String 출력
			System.out.println("계속 진행하시려면 'y'를 눌러주세요.");

			doMore = sc.next().charAt(0);

		} while ((doMore == 'y') || (doMore == 'Y'));

	}

}
