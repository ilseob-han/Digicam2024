import java.util.Scanner;
public class recurPibot {

	public static void main(String[] args) {
	
        Scanner sc = new Scanner(System.in);
        
        do {
        
        System.out.println("피보나치 순번을 입력하세요");
        int x = sc.nextInt();
        System.out.println("피보나치 수 는 "+recur(x)+"입니다.");
        }
        while(true);
}

	private static int recur(int x) {
		
		if(x>1) {	
			return recur(x-1)+recur(x-2);
		}
		
//		else if(x==2)
//		{
//			return 1;
//		}
		
		else if(x==1)
		{
			return 1;
		}
		
		return 0;
		// TODO Auto-generated method stub		
	}
}



