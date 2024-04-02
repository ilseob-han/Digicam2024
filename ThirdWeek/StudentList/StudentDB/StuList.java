package StudentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	Connection conn; // 여긴 타입과 객체명을 선언한다. 통상 이렇게 안하지만 JDBC에선 이렇게 처리한다.
	PreparedStatement pstmt;
	// 미리 컴파일된 SQL 문을 나타내는 객체입니다.
	// SQL 문은 미리 컴파일되어 PreparedStatement 객체에 저장됩니다.
	// 이 객체를 사용하여 이 문을 효율적으로 여러 번 실행할 수 있습니다.

	public StuList() {
		this("jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC", "gangnam", "qwe123!@#");
		// 데이터베이스/ 호스트/ 포트/ DB이름 / 아이디/ 비번
	}

	public StuList(String url, String user, String pw) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw); // 실제로 conn의 객체가 생성된 부분

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void loadStu() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from student";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) { // 계속 엔터로 너머간다.

			newNode = new StuInfo();

			newNode.setName(rs.getString(1));
			newNode.setStuNo(rs.getInt(2));
			newNode.setKor(rs.getInt(3));
			newNode.setEng(rs.getInt(4));
			newNode.setMat(rs.getInt(5));

			if (head.next == null) {
				head.next = newNode;
			} else if (head.next != null) {
				cur = head;
				curMove();
				// 다음 노드의 총점이 새로 생성된 노드보다 작은 노드에 cur을 위치시킴
				newNode.next = cur.next;
				cur.next = newNode;
			}
		}
		System.out.println("학생 정보 로딩 완료");

	}



	public void save() {
		
		
		try {
			String sql = "truncate student";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		cur = head.next; // 우선 커서 위치 초기화

		while (cur != null) {

			try {
				String sql = "insert into student value(?,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cur.getName());
				pstmt.setInt(2, 9999);
				pstmt.setInt(3, cur.getKor()); // 위치가 0부터 시작하지 않음에 유의
				pstmt.setInt(4, cur.getEng());
				pstmt.setInt(5, cur.getMat());
				pstmt.setInt(6, cur.getTotal());
				pstmt.setDouble(7, cur.getAvg());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			cur = cur.next;
		} // 전체 출력 종료
		System.out.println("학생정보 저장완료");
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

			newNode.next = cur.next; //새로 생성된 노드 연결
			cur.next = newNode;
		}
		print();
	}

	private static void stuPut() {
		// TODO Auto-generated method stub

		System.out.println("학생 정보 자동생성 및 출력");
		newNode.setName("학생" + stuNoarray2[stuNo]);
		newNode.setKor(stuNoarray[stuNo]);
		newNode.setEng(stuNoarray[stuNo]);
		newNode.setMat(stuNoarray[stuNo]);
		print();
		stuNo += 1;

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

	private static void stuPut2() {
		// TODO Auto-generated method stub

		System.out.println("학생" + stuNoarray2[stuNo] + "으로 수정정보 자동입력");
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
		System.out.println("학생정보 출력");
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
