

class Tv {
	boolean power;
	int channel;

	void power() {
		power = !power;
	}

	void channelUp() {
		++channel;
	}

	void channelDown() {
		--channel;
	}

}

class CaptionTv extends Tv {
	boolean caption;

	void displayCaption(String text) {
		if (caption) {
			System.out.println(text);
		}
	}
}

public class CaptionTvTest {
	public static void main(String[] args) {

		CaptionTv ctv = new CaptionTv();

		System.out.println(ctv);
		ctv.channel = 10;
		ctv.channelUp();
		ctv.displayCaption("Hello, World");
		ctv.caption = true; // 자막을 켠다.
		ctv.displayCaption("Hello, World");
		System.out.println(ctv.channel);

		System.out.println(ctv.power);
	}

}
