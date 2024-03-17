public class WhileMultipleTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2;

		while (i < 10)

		{

			int j = 2;

			while (j < 10) {

				System.out.print(j + "*" + i + "=" + (i * j) + "\t");
				j++;
			}
			i++;
			System.out.println();
		}

	}

}