package 학생성적관리SET;
import java.util.*;

public class StudentArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int addStu = 3;
//		int accStu = 0;
		int root;

		Scanner sc = new Scanner(System.in);

		HashSet<StudentScoreHasA> stuList = new HashSet<>(); // stuList ArrayList 생성
		//ArrayList<StudentScoreHasA> stuList = new ArrayList<>(); // stuList ArrayList 생성

		System.out.println("학생성적관리 프로그램을 시작합니다. ");
		do {
		
		System.out.println("성적입력: 1, 성적수정: 2, 성적출력: 3, 성적삭제: 4, 종료: 5 ");
		root = sc.nextInt();

		switch (root) {

		case 1: // 학생 성적 입력
			StudentProcess.add(stuList, addStu);
			break;
		case 2: //학생 성적 변경
			StudentProcess.change(stuList);
			break;
		case 3: //학생 성적 출력
			System.out.println("전체출력: 1, 검색 후 출력: 2");
			int ifCase3 = sc.nextInt();
			if (ifCase3 == 2) {
				StudentProcess.printOne(stuList);  //done
			} else {
				StudentProcess.print(stuList);
			}
			break;
		case 4: //학생 성적 삭제
			StudentProcess.clear(stuList);
			break;
		case 5: //종료
			System.exit(0);
		}
	} while (true);
	}
}
