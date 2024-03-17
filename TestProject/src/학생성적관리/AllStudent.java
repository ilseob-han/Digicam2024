package 학생성적관리;
import java.util.Scanner;
public class AllStudent {

	public static void main(String[] args) {
		System.out.println("학생수를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		
		
		StudentScoreHasA[] stu = new StudentScoreHasA[num];
		for(int i=0; i < stu.length;i++) {
			stu[i] = new StudentScoreHasA(); //여기서 실제로 객체가 만들어지지
			stu[i].setName1("학생"+i);
			stu[i].setKor(90+i);
			stu[i].setMat(90+i*2);
			stu[i].setEng(90+i*4);
			
		}
		for(int i=0; i < stu.length;i++) {
			System.out.print(stu[i].getName());
			System.out.print("\t");
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
			
		}
		
	}

}
