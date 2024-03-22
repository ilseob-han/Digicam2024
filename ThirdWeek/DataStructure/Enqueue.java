import java.util.*;

public class Enqueue {
	static int data[] = new int[5];
	static int head = 0;
	static int tail = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		do {
			int num = 0;

			System.out.println("1: 삽입, 2: 제외, 3. 종료");
			num = sc.nextInt();

			switch (num) {

			case 1:
				in();
				break;

			case 2:
				out();
				break;

			case 3:

				break;

			}

			System.out.println("head: " + head + " tail: " + tail);
			for (int i = 0; i < 5; i++) {
				System.out.print(data[i] + "\t");
			}
			System.out.println("==========");
		} while (true);
	}

	private static void in() {
		Scanner sc = new Scanner(System.in);
		System.out.println("삽입할 숫자 입력 :");
		data[tail] = sc.nextInt();;
		tail += 1;

		System.out.println("head: " + head + " tail: " + tail);
		for (int i = 0; i < 5; i++) {
			System.out.print(data[i] + "\t");
		}

		if (tail == 5)
			if (head == 0) {
				System.out.println("메모리가 가득 찼습니다.");
			} else {
				for (int i = 0; i < 5 - head; i++) {
					data[i] = data[i + head];
					data[i + head] = 0;

				}
				tail = tail - head;
				head = 0;

				System.out.println("Shift 후 head: " + head + " tail: " + tail);
			}

	}

	private static void out() {

		System.out.println(data[head] + "를 제외하였습니다.");
		data[head] = 0;
		head += 1;
//		System.out.println("head: " + head + " tail: " + tail);
		for (int i = 0; i < 5; i++) {
//			System.out.print(data[i] + "\t");
		}

		if (tail == 5)
			if (head == 0) {
				System.out.println("메모리가 가득 찼습니다.");
			} else {
				for (int i = 0; i < 5 - head; i++) {
					data[i] = data[i + head];
					data[i + head] = 0;

				}
				tail = tail - head;
				head = 0;

//				System.out.println("Shift 후 head: " + head + " tail: " + tail);
			}

	}

	private static void shift() {
		// TODO Auto-generated method stub

	}

}
