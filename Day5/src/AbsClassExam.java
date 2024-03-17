import java.util.Scanner;



abstract class Area {
	public abstract void draw();
}

class Rect extends Area {
	public void draw() {
		System.out.println("rect");
	}
}

class Circle extends Area {

	public void draw() {
		System.out.println("circle");
		
	}

}

class Tri extends Area {

	public void draw() {
		System.out.println("circle");
		
	}

}

public class AbsClassExam {

	public static void main(String[] args) {
		Tri tri = new Tri();
		tri.draw();
		
		
		Circle cir = new Circle();
		cir.draw();
		
		
		Rect rec = new Rect();
		rec.draw();
		

	}

}
