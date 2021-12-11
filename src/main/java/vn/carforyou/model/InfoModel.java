package vn.carforyou.model;

public class InfoModel {
	private String email;
	private String phone;
	private String address;

	public InfoModel() {
		super();
	}

	public InfoModel(String email, String phone, String address) {
		super();
		this.email = email;
		this.phone = phone;
		this.address = address;
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

}
