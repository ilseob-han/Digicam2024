
public class HomeWork2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int center = 3;
		for (int i = 0; i < center; i++) {
			for (int j = 0; j < center; j++) 

				{if (j-i <= 0) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}