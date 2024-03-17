
public class InterfaceExam implements CCC {
int a = 10;
	public static void main(String[] args) {
		
	CCC inter = new InterfaceExam();
	
	
	inter.disp();
	inter.disp2();
	// inter.disp3();
	
	}
	
	public void disp3() {
		// TODO Auto-generated method stub
		System.out.println("disp");
	}
	
	@Override
	public void disp() {
		// TODO Auto-generated method stub
		System.out.println("disp");
	}
	@Override
	public void disp2() {
		// TODO Auto-generated method stub
		System.out.println("disp2");
	}

}
