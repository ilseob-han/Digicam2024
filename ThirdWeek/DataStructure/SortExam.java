import java.util.Random;

public class SortExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int data[] = new int[100];
		
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			data[i] = random.nextInt(100);
		}
		bubbleSort(data);

		for (int i : data) {
			System.out.print(i + " , ");
		}

	}

	private static void bubbleSort(int[] data) {
		int temp = 0;
		int tempNo = 0;
		int totaltempNo = 0;

		for (int j = 0; j < data.length; j++) {
			for (int i = 0; i < data.length - j - 1; i++)

			{
				if (data[i] > data[i + 1]) {
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;
					tempNo += 1;

				}
				totaltempNo += 1;
			}

		}
//		System.out.println("반복문 횟수 = " + tempNo);
		System.out.println("전체 반복문 횟수 = " + totaltempNo);
	}

}
