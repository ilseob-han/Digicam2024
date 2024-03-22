		import java.util.*;
public class FactorialFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("팩토리억 산출 값을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int fact = sc.nextInt();
		int num = fact;
		long ans = 1;
		
		for (int i=0; i<num; i++)
		{
			ans = fact * ans;

			System.out.println("i:"+i+", fact:"+fact+", ans: "+ans);
			fact-=1;
		}
//		System.out.println(ans);
		
	}

}
