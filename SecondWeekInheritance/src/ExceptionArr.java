
public class ExceptionArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		try {
			
		System.out.println(arr[10]);
		}
		catch (Exception in) {
			System.out.println("배열 입력 범위 초과");
		}
		
		// 배열 범위 초과한 부분 조회에 대한 에러 

	}

}
