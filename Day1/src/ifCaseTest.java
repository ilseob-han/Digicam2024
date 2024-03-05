import java.util.Scanner;

public class ifCaseTest {

	public static void main(String[] args) {
		Scanner sc;
		sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
		if ( a > b ) {System.out.println("a가 더 큽니다");}
		else {if ( b > a ) {System.out.println("b가 더 큽니다");} 
		else {System.out.println("a와b가 동일합니다");}
			
		}
		
		
	}
	
}
