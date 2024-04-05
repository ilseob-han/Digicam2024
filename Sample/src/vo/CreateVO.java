package vo;

import java.io.Serializable;

public class CreateVO extends TypeVO implements Serializable {

	private static final long serialVersionUID = -5957375119826327685L;
	private String rName;

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}
}