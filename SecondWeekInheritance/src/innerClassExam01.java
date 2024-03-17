
/*
 * inner class	: outer class의 멤버를 내것처럼 사용할 수 있게 해주는 클래스.
 * 				: 특정복적 : outer class	의 맞는 목적. 
 * 				: 이벤트 처리할때 주로 사용. 
 * 
 * 
 * 1. member inner class
 * 
 * 2. static inner class - 잘 안씀
 * 
 * 3. local inner class - 잘 안씀 
 * 
 * 4. anonymous inner class - 엄청 많이 씀. 
 * 
 * 
 * outer class
 * inner class
 * 
 * 
 */

public class innerClassExam01 {

	private int a;

	private static int b;

	public void dispTest () {
		class Test {
			public void disp() {
				System.out.println(a);
				System.out.println(b);
			}
		}
		Test test = new Test();
		test.disp();
	}

	public static void main(String[] args) {

//				innerClassExam01 inner = new innerClassExam01();
//				innerClassExam01.Test test = inner.new Test();  //아래 문장과 동일

//				innerClassExam01.Test test = new innerClassExam01().new Test();
		
		innerClassExam01 inner = new innerClassExam01();
		inner.dispTest();
				

		
		

	}
}
