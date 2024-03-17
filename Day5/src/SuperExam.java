class AA {
	private int a;

	AA(int a)
	{
		super();
		this.a = a;
		
	}
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

}

class BB extends AA {
	private int b;

	BB(int a, int b)
	{
		super(a);
		this.b = b;
		
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

}

class CC extends BB {
	private int c;

	CC(int a, int b, int c)
	{
		super(a,b);
		this.c = c;
		
	}
	
	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

}

public class SuperExam {

	public static void main(String[] args) {
		CC cc = new CC(10, 20, 30);

		System.out.println(cc.getA());
		System.out.println(cc.getB());
		System.out.println(cc.getC());
		
		
		CC bb = new CC(1, 2, 3);

		System.out.println(bb.getA());
		System.out.println(bb.getB());
		System.out.println(bb.getC());
		
		System.out.println(cc.getA());
		System.out.println(cc.getB());
		System.out.println(cc.getC());

	}

}
