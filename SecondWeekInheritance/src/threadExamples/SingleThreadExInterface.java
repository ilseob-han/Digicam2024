package threadExamples;
public class SingleThreadExInterface implements Runnable {
	private int[] temp;
	public SingleThreadExInterface() {
		//super(threadname);
		temp = new int[10];
		for (int start = 0; start < temp.length; start++) {
			temp[start] = start;
		}
	}
	public void run() {
		for (int start : temp) {
			System.out.printf("현재 쓰레드이름: %s,", Thread.currentThread().getName());
			System.out.printf("temp value : %d %n", start);
		}
	}
	public static void main(String[] args) {
		System.out.println("Main Start");
		Runnable st1 = new SingleThreadExInterface();
		Thread st2 = new Thread(st1,"superman");
		st2.start();
		try {
		st2.join();
		 } catch (InterruptedException ie) {
	            ie.printStackTrace();
	            // 혹은 다른 예외 처리 로직을 작성할 수 있습니다.
		 }
		System.out.println("Main End");
	}
}
