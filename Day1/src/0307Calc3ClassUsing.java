
import java.util.Scanner;

public class Calc3 {
	//변수선언
	private		int num1,num2;
	private		char ch;
	private     double result; 
//	private		String doMore;

			
	public Calc3() {
		
	}
	public Calc3(int n1,char c,int n2) {
		this.num1 = n1;
		ch = c;
		num2 = n2; 
//		doMore = "";
	}
	
	public void setNum1(int n) {
		num1 = n;
	}
	public void setNum2(int n) {
		num2 = n;
	}
	public void setCh(char c) {
		ch = c; 
	}
	
	public int getNum1() {
		return num1; 
	}
	public int getNum2() {
		return num2;
	}
	public char getCh() {
		return ch;
	}
	
	public double plus(int n1,int n2) {
		return result = n1+n2; 
	}
	
	public double minus(int n1,int n2) {
		return result = n1-n2; 
	}
	
	public double multi(int n1,int n2) {
		return result = n1*n2; 
	}
	
	public double divide(int n1,int n2) {
		return result = n1/n2; 
	}
	
	public static boolean keepGo(char x) {
		return ((x == 'y') || (x == 'Y'));
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char doMore;
		
		
do{
		int num = sc.nextInt();
		char ch = sc.next().charAt(0);
		int num2 = sc.nextInt();
		double answer=0;

		
		Calc3 calc = new Calc3(num,ch,num2);
		
		switch(ch) {
		case '+': answer=calc.plus(num, num2); break;
		case '-': answer=calc.minus(num, num2); break;
		case '*': answer=calc.multi(num, num2); break;
		case '/': answer=calc.divide(num, num2); break;
		}

		System.out.println(calc.getNum1()+""+calc.getCh()+""+calc.getNum2()+"="+answer);
		System.out.println("계속 진행하시려면 'y'를 눌러주세요.");
		doMore = sc.next().charAt(0);
		
	} while(keepGo(doMore));
		
	}

}