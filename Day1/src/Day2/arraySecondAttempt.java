package Day2;

import java.util.Scanner;

public class arraySecondAttempt {
	public static void main(String[] args) {
		int stuNo =0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생숫자를 입력하세요");
		stuNo = callOutNo();
			
		arrayGenerator(stuNo);
		
//		String[] name = new String[stuNo];
//		int[][] score = new int[stuNo][4];
//		float[] avg = new float[stuNo];
		
		for (int j = 0; j < stuNo; j++) {
		
			System.out.println("이름을 입력하세요");
			name[j] = sc.next(); // 이름입력
			System.out.println("국어, 영어, 수학 점수를 입력해주세요.");
			for (int i = 0; i < 3; i++) { // score[3]은 총점이므로, -1.
				score[j][i] = sc.nextInt(); // 성적입력
				score[j][3] += score[j][i]; // score[0],[1],[2] 합 [3]에 대입
			}
			avg[j] = score[j][3] / 3.f; // 총점 나누기 과목수 3 해서 평균 산출
		}
		
		
		for (int j = 0; j < stuNo; j++) {
			System.out.print(name[j] + "\t");
			for (int i = 0; i < 4; i++) {
				System.out.print(score[j][i] + "\t");
			}
			System.out.println(avg[j]);
		}
	}

	private static void arrayGenerator(int stuNo) {
		// TODO Auto-generated method stub
		String[] name = new String[stuNo];
		int[][] score = new int[stuNo][4];
		float[] avg = new float[stuNo];
	}

	public static int callOutNo() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}