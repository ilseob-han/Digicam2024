import java.util.Scanner;

public class ArrayExam01Java {

	public static void main(String[] args) {

//		String []name = new String[3];
		String[][] score = new String[3][4];
		
		float []avg = new float[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<3; i++)
		{
		for(int k=0; k<4;k++) {
			
			switch (k) {
			case 0:
				System.out.println("학생이름:");
				score[i][k] = sc.next();
				break;
			case 1:
				System.out.println("국어점수:");
				score[i][k] = sc.next();
				break;
			case 2:
				System.out.println("영어점수:");
				score[i][k] = sc.next();
				break;
			case 3:
				System.out.println("수학점수:");
				score[i][k] = sc.next();
				break;	
		}
		}
		}
//		
//		int scoreSum = 0;
//		int scoreAve = 0;	
//		
//		for(int k=1; k<4;k++) {
//			scoreSum+=Integer.parseInt(score[k]);
//			scoreAve=scoreSum/k;}
//		
//		
//		System.out.println("학생이름:"+score[0]);
//		System.out.println("국어점수:"+score[1]);
//		System.out.println("영어점수:"+score[2]);
//		System.out.println("수학점수:"+score[3]);
//		System.out.println("점수합계:"+scoreSum);
//		System.out.println("평균점수:"+scoreAve);
//		
//		
		}
		
		}
		



		
			




//입력: 이름, 국, 영, 수
//연산: 총, 평
//출력: 이름,국어,영어,수학,총점,평균