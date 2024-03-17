import java.util.Scanner;

abstract class MemoryAbs {

	public abstract String[] createArr(int size);

	public abstract void push();

	public abstract void pop();

}

class Myqueue extends MemoryAbs {

	@Override
	public String[] createArr(int size) {
		// TODO Auto-generated method stub
		return new String[size];
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void push() {
		// TODO Auto-generated method stub

	}
}

class MyStack extends MemoryAbs {

	@Override
	public String[] createArr(int size) {
		// TODO Auto-generated method stub
		return new String[size];
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
	}

} // mystack종료

public class Memory {

	public static int numReturn() {
		Scanner sc = new Scanner(System.in);
		int tempNo = sc.nextInt();
		return tempNo;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp2 = 0;
		System.out.println("메모리 실험을 시작합니다.");
		System.out.println("메모리 종류를 입력하세요(1번: MyStack, 2번: Queue)");
		temp2 = numReturn();
		if (temp2 == 1) {

			int x = 0;
			int size = 5;

			MyStack stack = new MyStack();
			String[] atackArr = stack.createArr(size);

			for (int i = 0; i < size; i++) {
				atackArr[i] = null;
				System.out.print(atackArr[i] + ", ");
			} // 배열생성종료

			do {
				System.out.println("데이터 처리 종류를 입력하세요");
				System.out.println("(1번: Push, 2번: Pop, 3번: 종료)");
				int tempNo2 = numReturn();
				switch (tempNo2) {

				case 1: // push
					System.out.println("Push를 선택하셨습니다. 처리할 정수를 입력하세요.");
					tempNo2 = numReturn();

//					push(i, tempo2, size,String[] k);
//					

					for (int i = 0; i < size; i++) {
						if (atackArr[i] == null) {
							atackArr[i] = String.valueOf(tempNo2);
							break;
						}
					}

					System.out.println("현재 배열:");
					for (int i = 0; i < size; i++) {
						System.out.print(atackArr[i] + ", ");
					}
					System.out.println("====================");

					break;
				case 2:// pop

					System.out.println("Pop 선택: FILO로 정수를 제거합니다.");

					for (int i = size - 1; i >= 0; i--) {
						if (atackArr[i] != null) {
							atackArr[i] = null;
							break;
						}
					}

					System.out.println("현재 배열:");
					for (int i = 0; i < size; i++) {
						System.out.print(atackArr[i] + ", ");
					}
					System.out.println("====================");

					break;
				case 3:
					System.out.println("3번: 종료");
					break;

				}
				x++;
			} while (x < 20);
			System.out.println("종료되었습니다.");
		}

		else if (temp2 == 2) { // myQuee시작
			System.out.println("myQuee시작");
			int x = 0;
			int size = 5;

			Myqueue stack = new Myqueue();
			String[] atackArr = stack.createArr(size);

			for (int i = 0; i < size; i++) {
				atackArr[i] = null;
				System.out.print(atackArr[i] + ", ");
			} // 배열생성종료

			do {
				System.out.println("데이터 처리 종류를 입력하세요");
				System.out.println("(1번: Push, 2번: Pop, 3번: 종료)");
				int tempNo2 = numReturn();
				switch (tempNo2) {

				case 1: // push
					System.out.println("Push를 선택하셨습니다. 처리할 정수를 입력하세요.");
					tempNo2 = numReturn();

//					push(i, tempo2, size,String[] k);
//					

					for (int i = 0; i < size; i++) {
						if (atackArr[i] == null) {
							atackArr[i] = String.valueOf(tempNo2);
							break;
						}
					}

					System.out.println("현재 배열:");
					for (int i = 0; i < size; i++) {
						System.out.print(atackArr[i] + ", ");
					}
					System.out.println("====================");

					break;
				case 2:// pop

					System.out.println("Pop 선택: FILO로 정수를 제거합니다.");

					for (int i = 0; i < size; i++) {
						if (atackArr[i] != null) {
							atackArr[i] = null;							
							break;
						}
					}
					
					for (int i = 0; i < size-1; i++) {
						if (atackArr[i] == null) {
							atackArr[i] = atackArr[i+1];
							atackArr[i+1]=null;

						}
					}
					
					
					
//					for (int i = size - 1; i >= 0; i--) {
					
//					for (int i = 0; i < size-1; i++) {
//						if (atackArr[i] == null) {
//							atackArr[i] = atackArr[i+1];
//							break;
//						}
//					}

					
				
					System.out.println("현재 배열:");
					for (int i = 0; i < size; i++) {
						System.out.print(atackArr[i] + ", ");
					}
					System.out.println("====================");

					break;
				case 3:
					System.out.println("3번: 종료");
					break;

				}
				x++;
			} while (x < 20);
			System.out.println("종료되었습니다.");

		}

	}

}
