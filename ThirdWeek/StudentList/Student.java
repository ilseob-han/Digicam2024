import java.util.*;

public class Student {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StuList.exp = StuList.del = StuList.head = StuList.cur = StuList.newNode = new StuInfo();
		StuList.newNode.next = null;
		
		do {
			System.out.println();
			
			System.out.println("성적입력: 1, 성적수정: 2, 성적검색: 3"+ "\n"+ "전체출력: 4, 성적삭제: 5, 종  료: 99");
			int input = sc.nextInt();
			
			switch(input) {
			
			case 1: StuList.add();;break;
			case 2: StuList.modify();break;
			case 3: StuList.searchPrint();break;
			case 4: StuList.print();break;
			case 5: StuList.delete();break;
			case 99: System.exit(0);
			}
		} while (true);
}

}