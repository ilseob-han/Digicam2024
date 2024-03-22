import java.util.*;

public class NumberBaseVer2l {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int gameNo=0;
		int strike = 0;
		int tryNo = 0;
		int totalTry = 0;
		
		System.out.println("플레이 할 숫자를 입력하세요.");
		int wantToPlay=sc.nextInt();
		
	
	for (int i=0; i<wantToPlay; i++)
	{
		int[] answer = Deck.randomMaker(); // 컴퓨터 난수 생성
		do {
			
			int[] attack = Deck.numInput(); // 공격 숫자 입력
			
			strike = Deck.ballCount2(answer, attack); // 볼,스트라이크 숫자 산출 및 출력, strike반환
			
			tryNo += 1; 
			
			if (strike == 3) {
				System.out.println("성공까지 걸린 횟수 : " + tryNo);
				gameNo += 1; 
				System.out.println("총 게임 횟수 : " + gameNo);
				totalTry +=tryNo; 
				System.out.println("평균 시도 횟수 : " + totalTry/gameNo);
				
				break;
			}

		} while (true);
	}
	}

	public class Deck {

		static int[] numInput() {  //숫자 3개 입력 하여 배열 반환
			System.out.println("공격하실 숫자를 3개 입력하세요.");
			Scanner sc = new Scanner(System.in);
			int[] number = new int[3];// 숫자 받기
			for (int i = 0; i < 3; i++) {
				number[i] = sc.nextInt();
			}
			return number;
		}

		public static int ballCount2(int[] answer, int[] attack) {
			// TODO Auto-generated method stub
			int strike = 0;
			int ball = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (answer[i] == attack[j] && i==j) {
						strike += 1;
					}
					else if (answer[i] == attack[j] && i!=j) {
						ball += 1;
					}
				}
			}
			System.out.println("볼 : " + ball);
			System.out.println("스트라이트 : " + strike);
			if(strike==3) {System.out.println("스트라이크 3 승리했습니다. ");}
			return strike;
		}

		static int[] randomMaker() {
			int[] number = new int[10];
			for (int i = 0; i < 9; i++) {
				number[i] = i;
//			System.out.print(number[i]);
			}

			for (int i = 0; i < 9; i++) {
				int r = (int) (Math.random() * 10);
				int temp = number[i];
				number[i] = number[r];
				number[r] = temp;
			}

			for (int i = 0; i < 3; i++) {
				System.out.print(number[i]);
			}
			System.out.println("*******************");
			return number;
		}
	}
}