package 학생성적관리SET;

import java.util.*;

public class StudentProcess {

	public static void add(HashSet<StudentScoreHasA> stuList, int a) {

		System.out.println("자동입력: 1, 수기입력: 2");
		int addTemp = 0;
		addTemp = 1;

		if (addTemp == 1) {
			for (int i = 0; i < a; i++) {
				StudentScoreHasA student = new StudentScoreHasA();
				student.setName1("학생" + i);
				student.setKor(90 + i);
				student.setMat(90 + i * 2);
				student.setEng(90 + i * 4); // 성적 자동입력 삭제
				stuList.add(student); // 학생 객체를 stuList에 추가}
			}
		}

		else {
			for (int i = 0; i < a; i++) {
				StudentScoreHasA student = new StudentScoreHasA();
				System.out.println("학생명을 입력하세요.");
				student.setName1(stringReturn());
				System.out.println("국어점수를 입력하세요.");
				student.setKor(numReturn());
				System.out.println("수학점수를 입력하세요.");
				student.setMat(numReturn());
				System.out.println("영어점수를 입력하세요.");
				student.setEng(numReturn());
				stuList.add(student); // 학생 객체를 stuList에 추가
			}
		}

	}
	// 학생 추가 종료

	public static void print(HashSet<StudentScoreHasA> stuList) {

//			StudentScoreHasA student = stuList.get(i);
		Iterator<StudentScoreHasA> iterator = stuList.iterator();
		while (iterator.hasNext()) {
			StudentScoreHasA student = iterator.next();
			// System.out.println(student); 주소 출력
			System.out.println("이름: " + student.getName());
			System.out.println("국어 점수: " + student.getKor());
			System.out.println("수학 점수: " + student.getMat());
			System.out.println("영어 점수: " + student.getEng());
			System.out.println("총점: " + student.getTotal());
			System.out.println("평균: " + student.getAvg());

			System.out.println();
		}

	}// 학생 출력 종료

	public static void clear(HashSet<StudentScoreHasA> stuList) {

		stuList.clear();
//		
	} // 학생 삭제 종료

	public static void printOne(HashSet<StudentScoreHasA> stuList) {
		System.out.println("출력할 학생 명을 입력하세요.");
		String targetName = stringReturn();
		Iterator<StudentScoreHasA> iterator = stuList.iterator();
		while (iterator.hasNext()) {
			StudentScoreHasA student = iterator.next();
			if (student.getName().equals(targetName)) {

				System.out.println("이름: " + student.getName());
				System.out.println("국어 점수: " + student.getKor());
				System.out.println("수학 점수: " + student.getMat());
				System.out.println("영어 점수: " + student.getEng());
				System.out.println("총점: " + student.getTotal());
				System.out.println("평균: " + student.getAvg());

				System.out.println();
			}
		}

	}// 학생 출력 종료

	public static void change(HashSet<StudentScoreHasA> stuList) {

		System.out.println("변경할 학생 명을 입력하세요.");
		String targetName = stringReturn();
		Iterator<StudentScoreHasA> iterator = stuList.iterator();
		while (iterator.hasNext()) {
			StudentScoreHasA student = iterator.next();
			if (student.getName().equals(targetName)) {

//				StudentScoreHasA student = new StudentScoreHasA();
				System.out.println("학생명을 입력하세요.");
				student.setName1(stringReturn());
				System.out.println("국어점수를 입력하세요.");
				student.setKor(numReturn());
				System.out.println("수학점수를 입력하세요.");
				student.setMat(numReturn());
				System.out.println("영어점수를 입력하세요.");
				student.setEng(numReturn());
				stuList.add(student); // 학생 객체를 stuList에 추가

				System.out.println();
			}
		}
	}

//	public static int Search(HashSet<StudentScoreHasA> stuList) {
//
//		System.out.println("검색할 학생명을 입력하세요.");
//
//		String targetName = stringReturn();
//		int studentIndex = -1;
//
//		for (int j = 0; j < stuList.size(); j++) {
//			StudentScoreHasA student = stuList.get(j);
//			if (student.getName().equals(targetName)) {
//				studentIndex = j;
//				break;
//			}
//		}
//		return studentIndex;
//	}

	public static int numReturn() {
		Scanner sc = new Scanner(System.in);
		int tempNo = sc.nextInt();
		return tempNo;
	}

	public static Float floatReturn() {
		Scanner sc = new Scanner(System.in);
		float tempNo = sc.nextFloat();
		return tempNo;
	}

	public static String stringReturn() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

}
