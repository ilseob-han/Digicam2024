
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] name = {"joy", "brad", "ales", "conan", "david"};
		String[] gift = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
		
		
		int length = name.length;
//		System.out.print(length);
		
		String[][] giftMatrix = new String[length+1][length+1];
		
		for (int i=1; i <length+1; i++)
		{
			giftMatrix[i][0]=name[i-1];
			giftMatrix[0][i]=name[i-1];
		}
		
		for (int j=0; j <length+1; j++)
		{
		for (int i=0; i <length+1; i++)
		{
			System.out.print(giftMatrix[i][j]+"\t");
		}
		System.out.println();
		}
		
		
		
		
		
		
		
	}

}
