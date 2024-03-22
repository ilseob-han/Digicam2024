import java.util.Scanner;

public class LnikedExam {

	static LinkNode head;
	static LinkNode cur;
	static LinkNode newNode;
	static LinkNode del;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		del = head = cur = newNode = new LinkNode();
		newNode.next = null;

		
	for (int z =0; z<10; z++) {
			int num2 = 6;

			// 삽입
			System.out.println("삽입할 위치 입력:");
			int move = sc.nextInt();

			newNode = new LinkNode();
			newNode.setData(num2);

			if (move != 1) {
				cur = head; // 우선 커서 위치 초기화

				// 커서 위치 이동 - 삽입하기 위한 위치 -1의 위치로 이동해야 한다.
				for (int i = 0; i < move - 2; i++) {
					cur = cur.next;
				}
				cur.next = newNode; // (cur에 neNode ref를 부여
				newNode.next = cur.next; // cur next를 nn에 부여(후위 링크 연결 항상 먼저)

			}

			if (move == 1) {
				newNode.next = head;
				head = newNode;
			}
			num2 += 1;

			// 전체 출력 시작
			cur = head;
			// 출력
			while (cur != null) {
				System.out.print(cur.getData() + ", ");
				cur = cur.next;
			} // 전체 출력 종료

			System.out.println("삭제할 위치 입력:");
			move = sc.nextInt();

			if (move != 1) {
				cur = head;
				for (int i = 0; i < move - 2; i++) {
					cur = cur.next; // 이동
				}
				del = cur.next;
				cur.next = cur.next.next;//	
			}

			if (move == 1) {
				del = head;
				head = head.next;
			}
			del.next = null;
			del=null;
			// 전체 출력 시작
			cur = head;
			// 출력
			while (cur != null) {
				System.out.print(cur.getData() + ", ");
				cur = cur.next;
			} // 전체 출력 종료

	}

	}

}