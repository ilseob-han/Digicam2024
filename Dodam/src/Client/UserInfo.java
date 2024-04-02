package Client;

import java.sql.Timestamp;

public class UserInfo {

	String userID;
	String userName;
	String password;
	String email;
	String mobilePhone;
	Timestamp signUp_time;
	Timestamp withdrawal_time;
	String userStatus;
	UserInfo next;
		
	
	public UserInfo() {
		
	}
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public Timestamp getSignUp_time() {
		return signUp_time;
	}
	public void setSignUp_time(Timestamp signUp_time) {
		this.signUp_time = signUp_time;
	}
	public Timestamp getWithdrawal_time() {
		return withdrawal_time;
	}
	public void setWithdrawal_time(Timestamp withdrawal_time) {
		this.withdrawal_time = withdrawal_time;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public UserInfo getNext() {
		return next;
	}
	public void setNext(UserInfo next) {
		this.next = next;
	}

	

}
