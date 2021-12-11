package vn.carforyou.model;

public class UserModel {
	private int userId;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String address;
	private int isAdmin;
	private int isDealer;

	public UserModel() {
		super();
	}

	public UserModel(int userId, String userName, String password, String email, String phone, String address,
			int isAdmin, int isDealer) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.isAdmin = isAdmin;
		this.isDealer = isDealer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getIsDealer() {
		return isDealer;
	}

	public void setIsDealer(int isDealer) {
		this.isDealer = isDealer;
	}

}
