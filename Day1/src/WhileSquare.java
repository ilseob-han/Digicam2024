
public class WhileSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double num1 = 0;
		double i = 0;

		while(num1<500)
		{
			i++;
			num1 = Math.pow(2, i);

		};
		System.out.println("접은 횟 수:" + i + "  사각형 수" + num1);
		
	}

}
