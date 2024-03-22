import java.util.*;
import java.util.Random;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class StuList {
	static int[] stuNoarray = { 4, 3, 8, 5, 1, 9, 7, 2, 6 };
	static int stuNo = 0;
	static StuInfo head;
	static StuInfo cur;
	static StuInfo newNode;
	static StuInfo del;
	static StuInfo exp;

	public static void main(String[] args) {

	}

	public static void add() {
		int stepNo = 0;
		newNode = new StuInfo();
		stuPut();

		if (head.next == null) {
			head.next = newNode;
		}

		else if (head.next != null) {
			cur = head.next;
			newNode.next = cur;
			head.next = newNode;

			// if (newNode.getTotal() < cur.getTotal()) {
//				cur = cur.next;
//				stepNo += 1;
//			}
		}

		print();
		System.out.println(stepNo);
//		cur.getTotal()
//		newNode.getTotal()

//		cur = head.next;
//		if (head.next == null) {
//			System.out.println("루프1");
//			head.next = newNode;
//		}
//
//		else if(head.next.next == null)
//		{
//			System.out.println("루프2");
//			if (cur.getTotal()<newNode.getTotal())
//			{
//				newNode.next=head.next; 
//				head.next = newNode;
//			}
//			else {
//				cur.next = newNode;
//			}
//		}
//		
//		else {
//			System.out.println("루프3");
//			System.out.println(cur.next);
//			System.out.println("newNode "+newNode.getTotal());
//	
//			for (int i = 0; i < 10; i++) {
////				System.out.println("cur1 "+cur.getTotal());
////				System.out.println("cur.next "+cur.next);
//				
//				if(cur.next != null && newNode.getTotal()<=cur.next.getTotal())
//				{
//					cur = cur.next;
//					stepNo += 1;
//					
//					System.out.println("cur2 "+cur.getTotal());
//					System.out.println("stepNo"+stepNo);
//				}
//		}
//			System.out.println("stepNo"+stepNo);
//
//		
//			
//		//여기선 cur의 이동 숫자에 따라 다르게 배치하는 부분 코딩
//		if (stepNo==0)
//			
//		{cur=head;
//			if (cur.next.getTotal()>newNode.getTotal() )
//			{
//				
//				newNode = cur.next.next;
//				cur.next= newNode;
//			}
//			
//			else {		newNode.next = cur.next;
//			cur.next=newNode;}
//		}
//		
//		else
//		{
//			cur=head;
//			for(int i=1; i<stepNo+2; i++ )
//			{
//				cur=cur.next;
//			}
//			newNode.next=cur.next;
//			cur.next=newNode;
//		}
//		}
//
//		print();
	}

	public static void searchPrint() {

		Scanner sc = new Scanner(System.in);
		int move = search();
		cur = head;

		for (int i = 0; i < move; i++) {
			cur = cur.next; // 이동
		}
		System.out.print("이름" + cur.getName() + ", ");
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
		for (int i = 0; i < move; i++) {
			cur = cur.next; // 이동
		}
		// 변경
		System.out.println("변경 정보 입력");
		System.out.println("이름 입력:");
		newNode.setName(sc.nextLine());
		System.out.println("국어 입력:");
		newNode.setKor(sc.nextInt());
		System.out.println("영어 입력:");
		newNode.setEng(sc.nextInt());
		System.out.println("수학 입력:");
		newNode.setMat(sc.nextInt());

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

	public static void addOrder(int move) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("삽입할 위치 입력:");
//		int move = sc.nextInt();
//		newNode = new StuInfo();

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
		// 전체 출력 시작
		cur = head;
		// 출력
		while (cur != null) {
			System.out.print(cur.getData() + ", ");
			cur = cur.next;
		} // 전체 출력 종료
	}

	private static void stuPut() {
		// TODO Auto-generated method stub

		System.out.println("자동입력 및 출력");
		newNode.setName("학생" + stuNoarray[stuNo]);
		newNode.setKor(stuNoarray[stuNo]);
		newNode.setEng(stuNoarray[stuNo]);
		newNode.setMat(stuNoarray[stuNo]);
		newNode.setTotal();
		stuNo += 1;
//		print();

	}

//		cur = head.next;
//		// 출력
//		while (cur != null) {
//			System.out.print("이름" + cur.getName() + ", ");
//			System.out.print("영어" + cur.getEng() + ", ");
//			System.out.print("수학" + cur.getMat() + ", ");
//			System.out.print("총점" + cur.getTotal() + ", ");
//			System.out.print("평균" + cur.getAvg() + "\n");
//			cur = cur.next;
//		} // 전체 출력 종료

	private static void order(int time) {
		// TODO Auto-generated method stub

	}

	public static void print() {
		cur = head.next; // 우선 커서 위치 초기화
		while (cur != null) {
			System.out.print("이름" + cur.getName() + ", ");
			System.out.print("영어" + cur.getEng() + ", ");
			System.out.print("수학" + cur.getMat() + ", ");
			System.out.print("총점" + cur.getTotal() + ", ");
			System.out.print("평균" + cur.getAvg() + "\n");
			cur = cur.next;
		} // 전체 출력 종료
	}

}
