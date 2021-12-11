package vn.carforyou.model;

import java.math.BigDecimal;

public class ProductModel {
	private int productId;
	private String pName;
	private BigDecimal price;
	private String image;
	private BrandModel brand;
	private DealerModel dealer;
	private int totalKm;
	private int yearModel;
	private String fuelType;
	private String transmission;
	private int engine;
	private int seats;
	private String typeCar;
	private int isPass;
	private String des;
	private String localtion;

	public ProductModel() {
		super();
	}

	public ProductModel(int productId, String pName, BigDecimal price, String image, BrandModel brand, DealerModel dealer,
			int totalKm, int yearModel, String fuelType, String transmission, int engine, int seats, String typeCar,
			int isPass, String des, String localtion) {
		super();
		this.productId = productId;
		this.pName = pName;
		this.price = price;
		this.image = image;
		this.brand = brand;
		this.dealer = dealer;
		this.totalKm = totalKm;
		this.yearModel = yearModel;
		this.fuelType = fuelType;
		this.transmission = transmission;
		this.engine = engine;
		this.seats = seats;
		this.typeCar = typeCar;
		this.isPass = isPass;
		this.des = des;
		this.localtion = localtion;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BrandModel getBrand() {
		return brand;
	}

	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}

	public DealerModel getDealer() {
		return dealer;
	}

	public void setDealer(DealerModel dealer) {
		this.dealer = dealer;
	}

	public int getTotalKm() {
		return totalKm;
	}

	public void setTotalKm(int totalKm) {
		this.totalKm = totalKm;
	}

	public int getYearModel() {
		return yearModel;
	}

	public void setYearModel(int yearModel) {
		this.yearModel = yearModel;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getEngine() {
		return engine;
	}

	public void setEngine(int engine) {
		this.engine = engine;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getTypeCar() {
		return typeCar;
	}

	public void setTypeCar(String typeCar) {
		this.typeCar = typeCar;
	}

	public int getIsPass() {
		return isPass;
	}

	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getLocaltion() {
		return localtion;
	}

	public void setLocaltion(String localtion) {
		this.localtion = localtion;
	}

}
