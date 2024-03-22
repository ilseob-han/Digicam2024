import java.util.Scanner;
public class HomeWork6 {

	public static void main(String[] args) {
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

}