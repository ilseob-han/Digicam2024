
public class AnonymousInnerClass {

	private int a;
	public void dispInter() {
		new AAA () {

			@Override
			public void disp() {

					System.out.println(a);
				}
			}.disp();;
			
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnonymousInnerClass inter = new AnonymousInnerClass();
		inter.dispInter();

	}

}
