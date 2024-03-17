import java.util.Scanner;

public class ArrayExam01Java {

    public static void main(String[] args) {

        String[][] score = new String[3][4];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 4; k++) {
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

        System.out.println("입력된 정보:");
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 4; k++) {
                System.out.print(score[i][k] + " ");
            }
            System.out.println();
        }
    }
}
