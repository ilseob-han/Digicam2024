
public class HomeWork3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int center = 4;
				for (int i = 0; i < center; i++) {
					for (int j = 0; j < center; j++) 

						{if (i - (center-j) >= 0) {
							
							int x = (i - (center-j));
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
					System.out.println();
				}

			}

		}