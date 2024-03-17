import java.util.*;
import static java.lang.System.out;


public class MapEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] msg = {"berlin","dortmund","frankfurt","gelsenkirshen","hambrug"};

		HashMap<Integer,String> map =
				new HashMap<Integer,String>(); // HashMap생성
		
		for(int i=0; i<msg.length;i++)
			map.put(i,msg[i]); //맵에 저장
		
		Set<Integer> keys =map.keySet();
		for(Integer n : keys)
			out.println(map.get(n)); //맵에서 읽어 오기
		
	}

}
