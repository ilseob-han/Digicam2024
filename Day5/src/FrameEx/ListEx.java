/*
// header - edit "Data/yourJavaHeader" to customize
// contents - edit "EventHandlers/Java file/onCreate" to customize
//
*/

import java.awt.*;

public class ListEx{
	public static void main(String[] arsg){

		Frame f=new Frame("리스트 테스트");
		Panel p=new Panel();
		
		List list1=new List(3,true);
		
		list1.add("서울");
		list1.add("대구");
		list1.add("대전");
		list1.add("부산");
		
		p.add(list1);
		
		f.add(p);
		
		f.setSize(300,100);
		f.setVisible(true);
	}
}

