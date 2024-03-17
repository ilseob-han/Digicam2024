
public class ch7CastignTest1P358 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();
		car =fe; // car = (car)fe; 에서 형변환이 생략된 형태
		//car.water();	//컴파일 오류 Car 타입 참조변수로 water를 호출할 수 없다.
		fe2 = (FireEngine) car;
		fe2.water();

	}

}

class Car {
	String color;
	int door;
	
	void drive() {
		System.out.println("drive brrrr");
	}
	
	void stop() {
		System.out.println("stop!");
	}
}


class FireEngine extends Car {
	void water(){
		System.out.println("water!");
	}
}




