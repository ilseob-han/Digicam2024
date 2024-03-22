import java.util.*;

public class smallestNo {
	static int[] digits = new int[4];

	public static void smallestNoRunner() {
		for (int k = 1000; k < 10000; k++) {

			arrMaker(k);
			arrSoter(); // arr[i]와 arr[i+1]을 비교하여 i가 클 경우 자리 변경(반복 3*3회)
			zeroMover(); // 0의 숫자를 구하여 arr[0]와 arr[0의개수]를 자리 변경
		}
	}

	private static void zeroMover() {
		// 0이 포함된 개수 파악
		int zeroCount = 0;
		for (int i = 0; i < 4; i++) {
			if (digits[i] == 0) {
				zeroCount += 1;
			}
		}

		if (zeroCount > 0) { //0과 0이 아닌 수의 자리 바꾸기 
			int x = digits[0];
			digits[0] = digits[zeroCount];
			digits[zeroCount] = x;
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < digits.length; i++) {
			stringBuilder.append(digits[i]);
		}

		// 문자열을 정수로 변환
		int number2 = Integer.parseInt(stringBuilder.toString());

		// 결과 출력
		System.out.println(number2);

	}

	private static void arrSoter() {
		// 배열을 정렬 Arrays.sort(digits) 와 동일함. 

		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++)
				if (digits[i] > digits[i + 1]) {
					int temp = digits[i];
					digits[i] = digits[i + 1];
					digits[i + 1] = temp;
				}
		}

	}

	private static void arrMaker(int number) {
		// TODO Auto-generated method stub
		// 숫자를 문자열로 변환하여 각 자리수에 접근
		String numberStr = String.valueOf(number);

		// 각 자리수를 배열에 저장
		for (int i = 0; i < numberStr.length(); i++) {
			//문자열로 표현된 숫자를 각 자리마다 분리하여 정수 배열에 저장
			digits[i] = Character.getNumericValue(numberStr.charAt(i));
		}
		System.out.print(number);
		System.out.print("   ");
	}

}
