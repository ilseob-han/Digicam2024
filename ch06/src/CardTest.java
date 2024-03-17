class CardTest {
	public static void main(String args[]) {

		int x = 3;

		Card c1 = new Card();
		c1.setKind("Diamond");
		c1.setNumber(2);

		Card c2 = new Card();
		c2.setKind("Spade");
		c2.setNumber(4);


		System.out.println(x);
		System.out.println(c2.getKind());
//		Card.width = 1000;
		System.out.println(c2.getHeight());
		System.out.println(c1.getHeight());
		c1.setHeight(1000);
		System.out.println(c2.getHeight());
		System.out.println(c1.getHeight());


	}
}

class Card {
	private String kind; // ī���� ���� - �ν��Ͻ� ����
	private int number; // ī���� ���� - �ν��Ͻ� ����
	private static int width = 100; // ī���� �� - Ŭ���� ����
	private static int height = 250; // ī���� ���� - Ŭ���� ����

	Card() {};
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getNumber() {
		return number;
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		Card.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int height) {
		Card.height = height;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
