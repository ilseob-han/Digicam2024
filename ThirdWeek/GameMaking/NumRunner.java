import java.util.*;

public class NumRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		smallestNo a = new smallestNo();
		BabyGin c = new BabyGin();
		organizedNumber b = new organizedNumber();
		do {
			System.out.print("1번:작은수, 2번: 정돈된수, 3번: BabyGin, 4번: 종료 ");
			int num = sc.nextInt();

			switch (num) {
			case 1:
				a.smallestNoRunner(); // ?ㅼ옄由??レ옄 援먯감
				break;

			case 2:
				b.organizedNumberRunner(); // ?뺣룉????異쒕젰
				break;
				
			case 3:				
				c.BabyGinRunner(); // babygin ?ㅽ뻾
				break;
			case 4:
				System.out.print("醫낅즺 ?⑸땲??");
				System.exit(num);
			}

		} while (true);
	}

}
