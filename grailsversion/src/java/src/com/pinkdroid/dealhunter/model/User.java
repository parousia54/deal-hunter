package src.com.pinkdroid.dealhunter.model;


public class User {
	String username;
	String password;
	Address businessAddress;
	String businessPhone;
	boolean isVerified;
	public User() {
		super();
	}
	public User(String username, String password, Address businessAddress,
			String businessPhone, boolean isVerified) {
		super();
		this.username = username;
		this.password = password;
		this.businessAddress = businessAddress;
		this.businessPhone = businessPhone;
		this.isVerified = isVerified;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(Address businessAddress) {
		this.businessAddress = businessAddress;
	}
	public String getBusinessPhone() {
		return businessPhone;
	}
	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
}