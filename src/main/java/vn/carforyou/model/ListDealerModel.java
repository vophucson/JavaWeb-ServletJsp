package vn.carforyou.model;

public class ListDealerModel {
	private int dealerId;
	private String dName;
	private String dAddress;
	private String dImage;
	private int countCar;

	public ListDealerModel() {
		super();
	}

	public ListDealerModel(int dealerId, String dName, String dAddress, String dImage, int countCar) {
		super();
		this.dealerId = dealerId;
		this.dName = dName;
		this.dAddress = dAddress;
		this.dImage = dImage;
		this.countCar = countCar;
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

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	public String getdImage() {
		return dImage;
	}

	public void setdImage(String dImage) {
		this.dImage = dImage;
	}

	public int getCountCar() {
		return countCar;
	}

	public void setCountCar(int countCar) {
		this.countCar = countCar;
	}

}
