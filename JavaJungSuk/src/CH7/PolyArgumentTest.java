package CH7;
import java.util.*;
class Product {
	int price;
	int bonusPoint;

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}

class Tv extends Product {
	Tv() {
		// 조상클래스의 생성자 Product(int Price)를 호출한다.
		super(100); // tv가격을 100만원으로 한다.
		// Object클래스의 toString()을 오버라이딩 한다.
	}

	public String toString() {
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		// 조상클래스의 생성자 Product(int Price)를 호출한다.
		super(200);
		// Object클래스의 toString()을 오버라이딩 한다.
	}

	public String toString() {
		return "Computer";
	}
}

class Audio extends Product {
	Audio() {
		// 조상클래스의 생성자 Product(int Price)를 호출한다.
		super(50);
		// Object클래스의 toString()을 오버라이딩 한다.
	}

	public String toString() {
		return "Audio";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	//Product[] item = new Product[10];
	Vector item = new Vector();
	int i = 0;

	void buy(Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		//item[i++] = p;
		item.add(p); //제품을 vector에 저장한다.
		System.out.println(p + "을/를 구입하셨습니다.");
	}

	void refund(Product p) {
		if(item.remove(p)) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하셨습니다.");
		}
		else {
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	void summary() { // 구입한 물품에 대한 정보를 요약해서 보여준다.
		int sum = 0; // 구입한 물품의 가격 합계
		String itemList = ""; // 구입한 물품 목록
		
		if(item.isEmpty())
		{
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for (int i = 0; i < item.size(); i++) {
//			if (item[i] == null)
//				break;
			Product p = (Product)item.get(i);
			sum += p.price;
			itemList += (i==0)?"" + p : "," + p; 
			System.out.println(itemList);
		}
		System.out.println("구입하신 물품의 총금액은"+sum+"만원입니다.");
		System.out.println("구입하신 제품은"+itemList+"입니다.");
	}
}

public class PolyArgumentTest {

	public static void main(String[] args) {

		Buyer b = new Buyer();
		Tv tv = new Tv();
		Computer com = new Computer();
		Audio audio = new Audio();

		b.buy(tv);
		b.buy(com);
		b.buy(audio);
		b.refund(com);
		b.summary();
		
	}

}


String
