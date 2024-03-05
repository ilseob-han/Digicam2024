
public class square {

	public static void main(String[] args) {

		double num1 = 0;
		double times = 0;

		for (double i = 0; num1 < 500; i++) {

			num1 = Math.pow(2, i);
			times = i;

		}
		System.out.println("접은 횟 수:" + times + "  사각형 수" + num1);
	}

}
