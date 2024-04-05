package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomListVO extends TypeVO implements Serializable {

	private static final long serialVersionUID = 6835675812016930981L;
	public List<Integer> port = new ArrayList<Integer>();
	public List<String> roomList = new ArrayList<String>();
}