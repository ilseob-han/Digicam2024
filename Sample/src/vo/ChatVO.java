package vo;

import java.io.Serializable;

public class ChatVO extends TypeVO implements Serializable {

	private static final long serialVersionUID = -507330558705119015L;
	private String name;
	private String msg;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}