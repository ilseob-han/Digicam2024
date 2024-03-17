package FrameEx;

//FrameEx1 과 차이점은 상속여부!! (자료구조 시험문제)

import java.awt.*; 

public class FramEx2 extends Frame{
	public FramEx2() {
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String argap[]) {
		FramEx2 fe = new FramEx2();
	}
}