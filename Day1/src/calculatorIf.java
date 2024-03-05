import java.util.Scanner;

public class calculatorIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc;
		sc = new Scanner(System.in);
		
		System.out.println("첫번째 수를 입력하세요");
		int num1 = sc.nextInt();
		
		System.out.println("연산자를 입력하세요");
		char cal = sc.next().charAt(0);
		
		System.out.println("두번째 수를 입력하세요");
		int num2 = sc.nextInt();

		double num3 =0;
		
		if (cal=='+') {num3= num1+num2;}
		else if (cal=='-') {num3= num1-num2;}
		else if (cal=='*') {num3= num1-num2;}
		else {num3= (double)num1/num2;}

		
		System.out.print(num1+""+cal+""+num2+"="+num3);
		
		
		
	}

}
