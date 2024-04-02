package GUI;

import java.sql.Timestamp;

public class UserInfo {
    private String userID;
    private String userName;
    private String password;
    private String email;
    private String mobilePhone;
    private Timestamp signUpTime;
    private String userStatus;

    public UserInfo(String userID, String userName, String password, String email, String mobilePhone, Timestamp signUpTime, String userStatus) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.signUpTime = signUpTime;
        this.userStatus = userStatus;
    }

    // Getter와 Setter 메서드들
    // 예시:
    public String getUserID() {
        return userID;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Timestamp getSignUpTime() {
		return signUpTime;
	}

	public void setSignUpTime(Timestamp signUpTime) {
		this.signUpTime = signUpTime;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
    
    

    // 다른 getter와 setter도 마찬가지로 구현합니다.
}
