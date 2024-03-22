import java.util.Random;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = new int[100];
		
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			data[i] = random.nextInt(100);
		}

		for (int x = 0; x < 100; x++) {System.out.print(data[x]+",");}
		System.out.println("시작==========================");
	
		InsertSort(data, 100);

		for (int i = 0; i < 99; i++) {
			if (data[i] > data[i + 1])
				System.out.print("E");
			System.out.print(data[i]+",");
		}
		
	}

	private static void InsertSort(int[] data, int i) {
		// TODO Auto-generated method stub
		int n = 0;
		int tryNo =0;
		int temp = 0;
		for (int f = 0; f < i-1; f++, n++) { //비교 연산은 n-1
			tryNo+=1;
			if (data[f] > data[f + 1]) {
				temp = data[f];
				data[f] = data[f + 1];
				data[f + 1] = temp;
				
				for(int j=n; j>0; j--)
				{tryNo+=1;
					//irr[j]가 irr[j+1]보다 크면 교체

					if (data[j-1] > data[j]) {
						temp = data[j];
						data[j] = data[j - 1];
						data[j - 1] = temp;
					}
					else break;
				}
			}
		
		}
		System.out.print("시도회수 : " + tryNo+"회 ");
	}
}
