package 학생성적관리;
import java.util.Scanner;

public class AllStudentAddFunction {

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
	
	public static String stringReturn() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	
	

//		System.out.println(i+"열 학생명 입력:");
//		stu[i].setName1(stringReturn());
//		System.out.println(i+"열 국어점수 입력:");
//		stu[i].setKor(numReturn());
//		System.out.println(i+"열 수학점수 입력:");
//		stu[i].setMat(numReturn());
//		System.out.println(i+"열 영어점수 입력:");
//		stu[i].setEng(numReturn());

	
	
	// 학생 번호 리턴하는 함수 만들려고 했지만 지역변수가 많이 들어가서 일단 보류
//	public static int indexReturn(String target, int accStu) {
//	String target = stringReturn(); // 학생이름 입력받음
//	for (int i = 0; i < accStu; i++) {
//		if (stu[i].getName().equals(target)) { // 입력한 이름과 같은 배열 요소가 있을 경우
//		}
//	}return i}

	public static void main(String[] args) {
		System.out.println("학생 수 입력 프로그램을 시작합니다.");
		Scanner sc = new Scanner(System.in);
		int stop;
		float aveScore = 0;
		int accStu = 0;
		int option;
		int addStu, subjectCode, targetIndex, serchNo;
		
		
		StudentScoreHasA[] stu = new StudentScoreHasA[100]; // 100개의 행 출력

		do {
			System.out.println("성적입력: 1, 성적수정: 2, 성적검색: 3, 전체출력: 4, 성적삭제: 5");
			option = numReturn();

			switch (option) {
			case 1:
				System.out.println("추가할 학생 수를 누르세요.");
				addStu = numReturn(); // 추가할 학생 수

				for (int i = accStu; i < accStu + addStu; i++) { // 추가할 할생수 만큼 학생 생성
					stu[i] = new StudentScoreHasA(); // 여기서 실제로 객체가 만들어짐
		
					stu[i].setName1("학생" + i);
					stu[i].setKor(90 + i);
					stu[i].setMat(90 + i * 2);
					stu[i].setEng(90 + i * 4);  // 성적 자동입력 삭제
					
//					System.out.println(i+"열 학생명 입력:");
//					stu[i].setName1(stringReturn());
//					System.out.println(i+"열 국어점수 입력:");
//					stu[i].setKor(numReturn());
//					System.out.println(i+"열 수학점수 입력:");
//					stu[i].setMat(numReturn());
//					System.out.println(i+"열 영어점수 입력:");
//					stu[i].setEng(numReturn());

				}
				accStu = accStu + addStu;

				break;

			case 2:
				System.out.println("성적을 바꿀 학생 이름을 입력하세요.");
				targetIndex = 0;
				String target = stringReturn(); // 학생이름 입력받음
				for (int i = 0; i < accStu; i++) {
					if (stu[i].getName().equals(target)) { // 입력한 이름과 같은 배열 요소가 있을 경우
						targetIndex = i; // 성적을 바꿀 학생의 배열 인덱스
					}

				}
				if (targetIndex > accStu) { // 찾는 학생이 없을 경우
					System.out.println("해당 학생은 존재하지 않습니다.");
					break;
				}

				System.out.println("성적을 바꿀 과목을 입력하세요." + '\n' + "1.국어, 2.영어, 3.수학, 4.다시" + '\n');
				subjectCode = numReturn(); // 과목번호 입력받음

				if (subjectCode == 4) // 4번은 다시
					break;
				else if (subjectCode > 4) {
					System.out.println("허용되지 않는 숫자입니다.");
				} else {

					System.out.println("새로운 점수를 입력하세요.");
					int changedScore = numReturn(); // 새로운점수 changedScore에 저장

					switch (subjectCode) {
					case 1:
						stu[targetIndex].setKor(changedScore);
						break;
					case 2:
						stu[targetIndex].setEng(changedScore);
						break;
					case 3:
						stu[targetIndex].setMat(changedScore);
						break;
					default:

					}
				}

				break;

			// 학생 성적 조회 시작
			case 3:
				System.out.println("학생 점수를 조회합니다. 이름으로 조회시 1, 평균점수로 조회시 2를 입력하세요.");
				serchNo = numReturn(); // 추가할 학생 수
//				if(serchNo>2)break; //1,2 이외 값 입력시
//				System.out.println("1과 2이외의 값 입력불가. 처음으로 돌아갑니다.");
//					
				// 이름으로 조회시 시작
				if (serchNo == 1) {
					System.out.println("성적을 검색할 학생 이름을 입력하세요.");
					targetIndex = 0;
					target = stringReturn(); // 학생이름 입력받음
					for (int i = 0; i < accStu; i++) {
						if (stu[i].getName().equals(target)) { // 입력한 이름과 같은 배열 요소가 있을 경우
							targetIndex = i; // 성적을 바꿀 학생의 배열 인덱스
						}
					}
					if (targetIndex > accStu) { // 찾는 학생이 없을 경우
						System.out.println("해당 학생은 존재하지 않습니다.");
						break;
					}
//					System.out.print(stu[targetIndex].getStuNo());
//					System.out.print("\t" + ":");
					System.out.print(stu[targetIndex].getName());
					System.out.print("\t" + ":");
					System.out.print(stu[targetIndex].getKor());
					System.out.print("\t");
					System.out.print(stu[targetIndex].getMat());
					System.out.print("\t");
					System.out.print(stu[targetIndex].getEng());
					System.out.print("\t");
					System.out.print(stu[targetIndex].getTotal());
					System.out.print("\t");
					System.out.print(stu[targetIndex].getAvg());
					System.out.println();
					break;
				}
				// 평균점수로 조회시 시작
				else if (serchNo == 2) {
					System.out.println("찾고자 하는 평균 점수를 입력하세요.");
					aveScore = floatReturn(); // 평균 점수 입력 받음
					targetIndex = 0;
					for (int i = 0; i < 100; i++) {
						if (stu[i].getAvg() == aveScore) { // 입력한 이름과 같은 배열 요소가 있을 경우
							targetIndex = i; // 성적을 바꿀 학생의 배열 인덱스
							break;
						}
					}
//					System.out.print(stu[targetIndex].getStuNo());
//					System.out.print("\t" + ":");
					System.out.print(stu[targetIndex].getName());
					System.out.print("\t" + ":");
					System.out.print(stu[targetIndex].getKor());
					System.out.print("\t");
					System.out.print(stu[targetIndex].getMat());
					System.out.print("\t");
					System.out.print(stu[targetIndex].getEng());
					System.out.print("\t");
					System.out.print(stu[targetIndex].getTotal());
					System.out.print("\t");
					System.out.print(stu[targetIndex].getAvg());
					System.out.println();
					break;

				}
				// 1,2 이외 값 입력시
				else {
					System.out.println("입력오류 처음으로 돌아갑니다.");
				}
				;

				// 학생 성적 조회 종료

				// 학생 성적 전체 출력 시작
			case 4:
				System.out.println("전체 학생 성적을 출력합니다.");

				for (int i = 0; i < accStu; i++) {
//					System.out.print(stu[i].getStuNo());
//					System.out.print("\t" + ":");
					System.out.print(stu[i].getName());
					System.out.print("\t" + ":");
					System.out.print(stu[i].getKor());
					System.out.print("\t");
					System.out.print(stu[i].getMat());
					System.out.print("\t");
					System.out.print(stu[i].getEng());
					System.out.print("\t");
					System.out.print(stu[i].getTotal());
					System.out.print("\t");
					System.out.print(stu[i].getAvg());
					System.out.println();

				} break;
				// 학생 성적 전체 출력 종료

				// 학생 성적 삭제
			case 5:
				System.out.println("학생 성적을 삭제합니다. 단일학생 성적삭제: 1, 전체학생 성적삭제: 99");
				/// 단일 학생 성적 삭제
				System.out.println("삭제할 학생 번호를 입력하세요.");
				/// 단일 학생 성적 삭제 종료

				/// 전체학생 성적 삭제

				/// 전체학생 성적 삭제 종료

				// 학생 성적 삭제완료

			}

			System.out.println("계속 진행하려면 아무키나 누르세요(정지: 0)");
			stop = sc.nextInt();
		} while (stop != 0);

	}
}
