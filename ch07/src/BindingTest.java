class BindingTest{
	public static void main(String[] args) {
		Parent3 p = new Child3();
		Child3  c = new Child3();

		System.out.println("p.y = " + p.y);
//		System.out.println("p.x = " + p.x);
		p.method();

		System.out.println("c.y = " + c.y);
		System.out.println("c.x = " + c.x);
		System.out.println(c.z);
		c.method();
	}
}

class Parent3 {
	int y = 100;
	static int z = 1000;
	void method() {
		System.out.println("Parent Method");
	}
}

class Child3 extends Parent3 {
	int x = 200;

	void method() {
		System.out.println("Child Method");
	}
}
