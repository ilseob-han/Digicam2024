		import java.util.*;
public class FactoRecursiveCall {
	
	static int ans = 1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("팩토리얼 산출 값을 입력하세요");
		Scanner sc = new Scanner(System.in);
		int fact = sc.nextInt();
		int num = fact;
		recur(num);
		System.out.println(ans);
	}

	private static int recur(int num) {
		if (num!=0) {
			ans= num * ans;
			num-=1;
			recur(num);
		}
		return ans;
	}

}
