import java.util.*;
import java.util.Random;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class StuList {
	static int[] stuNoarray = { 4, 3, 8, 5, 1, 9, 7, 2, 6 };
	static int[] stuNoarray2 = { 1, 4, 3, 5, 2, 8, 7, 9, 6 };
	static int stuNo = 0;
	static StuInfo head;
	static StuInfo cur;
	static StuInfo newNode;
	static StuInfo del;
	static StuInfo exp;

	public static void main(String[] args) {

	}


	public static void add() {

		newNode = new StuInfo();
		stuPut();

		if (head.next == null) {
			head.next = newNode;
		}

		else if (head.next != null) {
			cur = head;

			curMove();
			// 다음 노드의 총점이 새로 생성된 노드보다 작은 노드에 cur을 위치시킴

			newNode.next = cur.next;
			cur.next = newNode;
		}
		print();
	}

	public static void curMove()
	// 다음 노드의 총점이 새로 생성된 노드보다 작은 노드에 cur을 위치시킴
	{
		while (cur.next != null && cur.next.getTotal() > newNode.getTotal()) {
			cur = cur.next;
		}
	}

	public static void searchPrint() {

		Scanner sc = new Scanner(System.in);
		int move = search();
		cur = head;
		for (int i = 0; i < move; i++) {
			cur = cur.next; // 이동
		}
		System.out.print("이름" + cur.getName() + ", ");
		System.out.print("국어" + cur.getKor() + ", ");
		System.out.print("영어" + cur.getEng() + ", ");
		System.out.print("수학" + cur.getMat() + ", ");
		System.out.print("총점" + cur.getTotal() + ", ");
		System.out.print("평균" + cur.getAvg() + "\n");

	}

	public static int search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생명 입력:");
		String target = sc.nextLine();
		cur = head; // 우선 커서 위치 초기화
		int move = 0;
		// target 찾고
		do {
			cur = cur.next;
			move += 1;

		} while (!cur.getName().equals(target));
		return move;

	}

	public static void modify() {
		Scanner sc = new Scanner(System.in);
		int move = search();
		cur = head;
		for (int i = 0; i < move - 1; i++) {
			cur = cur.next; // 이동
		}

		del = cur.next;
		cur.next = cur.next.next;
		del.next = null;

		newNode = new StuInfo();
		stuPut2();
		cur = head;
		curMove();

		newNode.next = cur.next;
		cur.next = newNode;
		print();

	}

	public static void delete() {
		// TODO Auto-generated method stub
		int move = search();
		cur = head;
		for (int i = 0; i < move - 1; i++) {
			cur = cur.next; // 이동
		}
		del = cur.next;
		cur.next = cur.next.next;//

		del.next = null;
		del = null;
		// 전체 출력 시작

		print();

	}


	private static void stuPut() {
		// TODO Auto-generated method stub

		System.out.println("학생 정보 자동생성 및 출력");
		newNode.setName("학생" + stuNoarray[stuNo]);
		newNode.setKor(stuNoarray[stuNo]);
		newNode.setEng(stuNoarray[stuNo]);
		newNode.setMat(stuNoarray[stuNo]);
		newNode.setTotal();
		stuNo += 1;
//		print();

	}

	private static void stuPut2() {
		// TODO Auto-generated method stub

		System.out.println("학생" + stuNoarray2[stuNo]+ "으로 수정정보 입력");
		newNode.setName("학생" + stuNoarray2[stuNo]);
		newNode.setKor(stuNoarray2[stuNo]);
		newNode.setEng(stuNoarray2[stuNo]);
		newNode.setMat(stuNoarray2[stuNo]);
		newNode.setTotal();
		stuNo += 1;
//		print();

	}

	public static void print() {
		cur = head.next; // 우선 커서 위치 초기화
		while (cur != null) {
			System.out.print("이름: " + cur.getName() + ", ");
			System.out.print("국어: " + cur.getKor() + ", ");
			System.out.print("영어: " + cur.getEng() + ", ");
			System.out.print("수학: " + cur.getMat() + ", ");
			System.out.print("총점: " + cur.getTotal() + ", ");
			System.out.print("평균: " + cur.getAvg() + "\n");

			cur = cur.next;
		} // 전체 출력 종료
	}

}
