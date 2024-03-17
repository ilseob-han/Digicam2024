package 학생성적관리;
import java.util.*;

public class StuSetProcessing {

	public static void add() {

		
		int addTemp = 0;
		int stuNo = 0;
		System.out.println("자동입력: 1, 수기입력: 2");
		addTemp = numReturn();
		System.out.println("추가할 학생 수 입력");
		stuNo = numReturn();
		Set<StudentScoreHasA> studentSet = new HashSet<>();
		
		if (addTemp == 1) {
			for (int i = 0; i < stuNo; i++) {
				StudentScoreHasA student = new StudentScoreHasA();
				student.setName1("학생" + i);
				student.setKor(90 + i);
				student.setMat(90 + i * 2);
				student.setEng(90 + i * 4); // 성적 자동입력 삭제
				studentSet.add(student); // 학생 객체를 stuList에 추가}
			}
		}

		else {
			for (int i = 0; i < stuNo; i++) {
				StudentScoreHasA student = new StudentScoreHasA();
				System.out.println("학생명을 입력하세요.");
				student.setName1(stringReturn());
				System.out.println("국어점수를 입력하세요.");
				student.setKor(numReturn());
				System.out.println("수학점수를 입력하세요.");
				student.setMat(numReturn());
				System.out.println("영어점수를 입력하세요.");
				student.setEng(numReturn());
				studentSet.add(student); // 학생 객체를 stuList에 추가
			}
		}

	}
	// 학생 추가 종료

	public static void print() {
		Iterator<StudentScoreHasA> iterator = studentSet.iterator();

	        while (iterator.hasNext()) {
	        	StudentScoreHasA student = iterator.next();
	            System.out.println("이름: " + student.getName1());
	            System.out.println("국어 점수: " + student.getKor());
	            System.out.println("수학 점수: " + student.getMat());
	            System.out.println("영어 점수: " + student.getEng());
	            System.out.println();

			}
//		for (int i = 0; i < a; i++) {
//			StudentScoreHasA student = stuList.get(i);
//
//			// System.out.println(student); 주소 출력
//			System.out.println("이름: " + student.getName());
//			System.out.println("국어 점수: " + student.getKor());
//			System.out.println("수학 점수: " + student.getMat());
//			System.out.println("영어 점수: " + student.getEng());
//			System.out.println("총점: " + student.getTotal());
//			System.out.println("평균: " + student.getAvg());
//
//			System.out.println();

	} // 학생 출력 종료

	public static void clear(ArrayList<StudentScoreHasA> stuList) {
		System.out.println("전체삭제: 1, 검색 후 삭제: 2");
		stuList.clear();

	} // 학생 삭제 종료

	public static void printOne(ArrayList<StudentScoreHasA> stuList) {

		int studentIndex = Search(stuList);
		// 학생1의 인덱스를 찾았는지 확인 후 작업 진행
		if (studentIndex != -1) {
			// 해당 인덱스에 있는 학생의 성적 정보 수정
			StudentScoreHasA student = stuList.get(studentIndex);
			System.out.println(studentIndex);
			// 윗줄과 동일 System.out.println(stuList.get(studentIndex));
			System.out.println(student);
			System.out.println("이름: " + student.getName());
			System.out.println("국어 점수: " + student.getKor());
			System.out.println("수학 점수: " + student.getMat());
			System.out.println("영어 점수: " + student.getEng());
			System.out.println("총점: " + student.getTotal());
			System.out.println("평균: " + student.getAvg());
			System.out.println();
		} else {
			System.out.println("해당 학생을 찾을 수 없습니다.");
		}
	}

	// studentChange 시작
	public static void change(ArrayList<StudentScoreHasA> stuList) {

		int studentIndex = Search(stuList);
		// 학생1의 인덱스를 찾았는지 확인 후 작업 진행
		if (studentIndex != -1) {
			// 해당 인덱스에 있는 학생의 성적 정보 수정
			StudentScoreHasA student = stuList.get(studentIndex);
			System.out.println("수정 할 학생명을 입력하세요.");
			student.setName1(stringReturn());
			System.out.println("수정 할 국어점수를 입력하세요.");
			student.setKor(numReturn());
			System.out.println("수정 할 수학점수를 입력하세요.");
			student.setMat(numReturn());
			System.out.println("수정 할 영어점수를 입력하세요.");
			student.setEng(numReturn()); // 성적 자동입력 삭제
		} else {
			System.out.println("해당 학생을 찾을 수 없습니다.");
		}
	}// studentChange종료

	public static int Search(ArrayList<StudentScoreHasA> stuList) {

		System.out.println("검색할 학생명을 입력하세요.");

		String targetName = stringReturn();
		int studentIndex = -1;

		for (int j = 0; j < stuList.size(); j++) {
			StudentScoreHasA student = stuList.get(j);
			if (student.getName().equals(targetName)) {
				studentIndex = j;
				break;
			}
		}
		return studentIndex;
	}

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
