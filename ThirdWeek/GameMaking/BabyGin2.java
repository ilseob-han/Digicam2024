import java.util.*;

public class BabyGin2 {
	static int[] digits = new int[6];
	

		public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int exit = 0;
		do {
			
			System.out.print("Input 6 Numbers: ");
			int num = sc.nextInt();
			digits = arrMaker(num);

			// arr[0]과 arr[2]의 평균이 arr[1]과 동일한 경우가 발생 개수 파악
			// arr[0~2], arr[3~5]의 두 사례만 비교하면 됨. 
			
			int babyGin = 0;
			for (int i = 0; i < 6; i += 3) {
				if (((double) digits[i + 1] == (double) (digits[i] + digits[i + 2]) / 2)&&(digits[i + 1]-digits[i])<2) {
					babyGin += 1;
				}
			}
			if (babyGin == 2) {
				System.out.println("Baby Gin!!");
			} else {
				System.out.println("Lose!!");
			}
			System.out.println("계속 진행하려면 아무키나 누르세요.(종료는 99를 누르세요.)");
			exit = sc.nextInt();
		} while (exit!=99);
	
	}
	
	// Arrays.sort(digits);를 활용하여 배열 정렬
	private static int[] arrMaker(int number) {
		// TODO Auto-generated method stub
		// 숫자를 문자열로 변환하여 각 자리수에 접근
		int space = String.valueOf(number).length();

		int[] digits = new int[space];
		String numberStr = String.valueOf(number);

		// 각 자리수를 배열에 저장
		for (int i = 0; i < numberStr.length(); i++) {
			digits[i] = Character.getNumericValue(numberStr.charAt(i));

		}
		Arrays.sort(digits);
		
		return digits;
	}}

