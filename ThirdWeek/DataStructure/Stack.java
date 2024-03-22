import java.util.*;

public class Stack {
	static List<String> stackCal = new ArrayList<>();
	static List<String> elements = new ArrayList<>();
	static List<String> stackNum = new ArrayList<>();

	static int eleTop = 0;
	static int calTop = 0;
	static int numTop = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "113 11 + 32 9 2 - 6 + - -";
		String cal1 = "+";
		String cal2 = "-";
		String par1 = "(";
		String par2 = ")";

		String[] TextArray = text.split(" ");
		for (String element : TextArray) {
			elements.add(element);
			eleTop += 1;
		}

		for (String element : elements) {
			System.out.println(element);
		}

		for (String element : elements)
		/*
		 * 연산자를 만나면 스택 상단의 연산자와 비교 > 스택 상단에 연산자가 없으면 푸쉬 > 스택 상단에 왼쪽 괄호가 있으면 푸쉬 > 스택
		 * 상단에연산자+가 있으면 스택 팝업+ 및 푸쉬-
		 */
		{
			if (elements.get(eleTop-1) == cal1 || elements.get(eleTop-1) == cal1) {

				push();
			}

			else if (elements.get(eleTop-1) == par1) {

			} else if (elements.get(eleTop-1) == par2) {

			}

			else {

			}

		}
//			for (int i=0; i<11; i++)
//			{
//				stackCal[i]="a"+i;
//				System.out.print(stackCal[i]+" ");
//				calTop += 1;
//				
//			}

//			System.out.print(stackCal.length);
////			
//			System.out.print(calTop);
//			System.out.print(pop(calTop));

//			pop(calTop);

//			

	}

//	}

	private static String pop(int calTop) {
//		String temp = stackCal[calTop];
//		stackCal[calTop]=null;
//		calTop-=1;
//		return temp;
	} // 탑에 위치한 값 반환

	private static void push() {
		// TODO Auto-generated method stub

	}
}
