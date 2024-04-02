package StudentDB;
import java.sql.SQLException;
import java.util.*;

public class Student {

	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StuList.exp = StuList.del = StuList.head = StuList.cur = StuList.newNode = new StuInfo();
		StuList.newNode.next = null;
		
		StuList exam = new StuList();
		
		System.out.println();
		exam.loadStu(); // 여기서 인스턴스 메소드로 불러오지 않고, 클래스 메소드로 불러오려고 해서 에러가 났었다. 
		exam.save();
		
		do {

			System.out.println("성적입력: 1, 성적수정: 2, 성적검색: 3"+ "\n"+ "전체출력: 4, 성적삭제: 5, 종  료: 99");
			int input = sc.nextInt();
			
			switch(input) {
			
			case 1: StuList.add();;break;
			case 2: StuList.modify();break;
			case 3: StuList.searchPrint();break;
			case 4: StuList.print();break;
			case 5: StuList.delete();break;
			case 6: exam.save();break;
			
			case 99: 
				exam.save();
				System.out.println("학생성적 DB 저장완료. 프로그램을 종료합니다.");
				System.exit(0);
			}
		} while (true);
}

}