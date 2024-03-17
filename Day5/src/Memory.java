public abstract class Memory {

	protected int []arr;
	protected int top;
	
	public Memory() {
		arr = new int[5];
		top = 0;
	}
	
	public void push(int data) {
		arr[top++] = data;
	}
	
	
	public void print() {
		for (int i=0; i<5; i++)
		{System.out.print(arr[i]+", ");}
		{System.out.println();}
	}
	
	public void full() {
		int z =0;
		for (int i=0; i<5; i++)
		if(arr[i] > 0) {z=z+1;}
		if(z==5) {System.out.println("full memory");}
	}
	
	public abstract int pop();
	
}