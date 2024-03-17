/*
// header - edit "Data/yourJavaHeader" to customize
// contents - edit "EventHandlers/Java file/onCreate" to customize
//
*/

import java.awt.*;

public class CheckBoxEx{
	public static void main(String[] args){
		Frame f=new Frame("체크박스 테스트");
		Panel p=new Panel();
		
		Checkbox ck1=new Checkbox("영화",true);
		Checkbox ck2=new Checkbox("스포츠");	
		Checkbox ck3=new Checkbox("여행");
	
		p.add(ck1);
		p.add(ck2);
		p.add(ck3);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}
}

