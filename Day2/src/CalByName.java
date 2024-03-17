
public class CalByName 


extends Day2First {


	public static void main(String []args){
		
		CallByName.disp2();
		
		CallByName cbn = new CallByName();
		
		cbn.disp1();
		cbn.disp2();
		
		int num = 100;
		
		num = cbn.disp3(num);
		System.out.println(num);
		
		
		String str = new String("Suberman");
		//System.out.println(str);
		
	    cbn.disp4(str);
	}
	
	public void disp4(String s) {
		System.out.println(s);
	}
		
	public int disp3(int num) {
		System.out.println(num);
		num++;
		System.out.println(num);
	
		return num;
	}
	
	
	public void disp1() {// call by name
		System.out.println("Call by name1");
	}


	public static void disp2() { // call by name
		System.out.println("Call by name2");
}
}