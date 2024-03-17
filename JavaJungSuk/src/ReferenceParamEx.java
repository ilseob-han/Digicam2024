

class Data {
	int x;
}

public class ReferenceParamEx {
	static void change() {
		d.x = 1000;
		System.out.println("change() : x =" + d.x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.x = 10;

		System.out.println("main() : x =" + d.x);
		System.out.println(d);

		change(d);
		System.out.println(d);
		System.out.println("After change(d.x)");
		System.out.println("main() : x =" + d.x);

	}

}
