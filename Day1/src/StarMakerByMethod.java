import java.util.Scanner;

public class StarMakerByMethod {

	public static void main(String[] args) {
		
		int k =0;
		char x;
		do {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 별 모양을 입력하세요.");
		int noOfStar = sc.nextInt();

		// 별 번호에 따른 star# 메소드 실행

		switch (noOfStar) {
		case 1:
			star1();
			break;
		case 2:
			star2();
			break;
		case 3:
			star3();
			break;
		case 4:
			star4();
			break;
		case 5:
			star5();
			break;
		case 6:
			star6();
			break;
			
		}
		System.out.println("계속 진행하시려면 'y'를 눌러주세요.");
		x = sc.next().charAt(0);
		
		} while(x == 'y');

	}

	
	
	
	private static void star6() {

		Scanner sc;
		sc = new Scanner(System.in);

		System.out.println("홀수를 입력하세요");
		int center = sc.nextInt();

		for (int j = 1; j <= (center * 2) - 1; j++) {

			for (int i = 1; i <= (center * 2) - 1; i++) {
				int location = 0;
				if (i < center && j < center) {
					location = 1;
				}

				else if (i > center && j < center) {
					location = 2;

				} else if (i < center && j > center) {
					location = 3;

				} else if (i > center && j > center) {
					location = 4;

				} else if (i == center && j == center) {
					location = 5;
				}

				switch (location) {
				case 1:
					int det1 = center - j;

					if ((i - det1) > 0) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
					break;

				case 2:
					int detJ = center - j;

					if ((2 * center - i - detJ) > 0) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
					break;

				case 3:
					int det3 = center - j;
					if ((det3 + i) > 0) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
					break;

				case 4:
					int det4 = (2 * center - i + center - j);

					if ((det4) > 0) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
					break;

				default:
					System.out.print("*");
					break;

				}

			}
			System.out.println();
		}

	}

	private static void star5() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 2; i > 0; i--) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void star4() {
		int center = 4;
		for (int i = 0; i < center; i++) {
			for (int j = 0; j < center; j++)

			{
				if (i - (center - j) >= 0) {

					int x = (i - (center - j));
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

	private static void star3() {
		int center = 4;
		for (int i = 0; i < center; i++) {
			for (int j = 0; j < center; j++)

			{
				if (i - (center - j) >= 0) {

					int x = (i - (center - j));
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

	public static void star2() {
		int center = 3;
		for (int i = 0; i < center; i++) {
			for (int j = 0; j < center; j++)

			{
				if (j - i <= 0) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void star1() {
		int star = 3;
		for (int i = 0; i < star; i++) {
			for (int j = 0; j < star; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
