
public class ThisExam01 {

int a;
	
	public int getA() {
		return this.a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public ThisExam01 getObject() {
		return this; 
	}
	
	

	public static void main(String []ar) {
		ThisExam01 th = new ThisExam01();
		
		th.setA(100);
		
		ThisExam01 th2 = th.getObject();
		
		System.out.println(th);
		System.out.println(th2);
	}
	
}