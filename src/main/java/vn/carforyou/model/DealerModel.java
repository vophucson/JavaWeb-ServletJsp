package vn.carforyou.model;

public class DealerModel {
	private int dealerId;
	private String dName;
	private String dInfo;
	private String dAddress;
	private String dPhone;
	private String dEmail;
	private int isPass;
	private String dImage;

	public DealerModel() {
		super();
	}

	public DealerModel(int dealerId, String dName, String dInfo, String dAddress, String dPhone, String dEmail,
			int isPass, String dImage) {
		super();
		this.dealerId = dealerId;
		this.dName = dName;
		this.dInfo = dInfo;
		this.dAddress = dAddress;
		this.dPhone = dPhone;
		this.dEmail = dEmail;
		this.isPass = isPass;
		this.dImage = dImage;
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

	public String getdInfo() {
		return dInfo;
	}

	public void setdInfo(String dInfo) {
		this.dInfo = dInfo;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public String getdPhone() {
		return dPhone;
	}

	public void setdPhone(String dPhone) {
		this.dPhone = dPhone;
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}

	public int getIsPass() {
		return isPass;
	}

	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}

	public String getdImage() {
		return dImage;
	}

	public void setdImage(String dImage) {
		this.dImage = dImage;
	}

}
