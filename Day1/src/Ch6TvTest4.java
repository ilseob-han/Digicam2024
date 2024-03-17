class TvTest4 {

	public static void main(String[] args) {
		Tv[] tvArr = new Tv[3];
		
		for (int i =0; i<tvArr.length;i++) {
			tvArr[i]=new Tv();
			tvArr.channel = i+10;
			
		}

	}
}

class Tv {
		String color;
		boolean power;
		int channel;
		
		void power() {power =! power;}
		void channelUp() {++channel;}
		void channelDown() {--channel;}
		
	}
	
	

