
public class ClassCastExceptionExample {

	public static void main(String[] args) {
        try {
            Parent parent = new Parent();
            Child child = (Child) parent; // 부모 클래스를 자식 클래스로 형변환 시도
            child.method(); // 이 코드는 실행되지 않음
        } catch (ClassCastException e) {
            System.out.println("형변환 할 수 없는 타입입니다: " + e.getMessage());
        }
    }
}

class Parent {
    // 부모 클래스
}

class Child extends Parent {
    // 자식 클래스
	void method(){
		System.out.println("Child method 실행");
	}
}