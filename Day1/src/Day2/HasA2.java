class A{
	private int a; 
	
	public A() {
		
	}
	public void setA(int a) { this.a = a; }
	public int getA() { return a; }
}

public class HasA {

	private String name;
	private A age; 
	
	public HasA() {
		name =""; 
		age = new A(); 
	}
	
	public void setName(String name) { this.name = name; }
	public void setAge(int age) { this.age.setA(age); } //this.age = age; }
	                              // this.age.a = age; 
	public String getName() { return name; }
	public int getAge() { return this.age.getA(); }
	
	public static void main(String[] args) {
		
		HasA has = new HasA(); 
		has.setName("Superman");
		has.setAge(100000);
		
		System.out.println(has.getName());
		System.out.println(has.getAge());
		

	}

}