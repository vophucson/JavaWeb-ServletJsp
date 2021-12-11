package vn.carforyou.model;

public class DealerAdminModel {
	private int dealerId;
	private String dName;
	private int isPass;
	private String userName;
	private String userEmail;
	private String userPhone;

	public DealerAdminModel() {
		super();
	}

	public DealerAdminModel(int dealerId, String dName, int isPass, String userName, String userEmail,
			String userPhone) {
		super();
		this.dealerId = dealerId;
		this.dName = dName;
		this.isPass = isPass;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getIsPass() {
		return isPass;
	}

	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}
