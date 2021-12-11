package vn.carforyou.model;

public class BrandModel {
	private int brandId;
	private String brandName;
	private String icon;

	public BrandModel() {
		super();
	}

	public BrandModel(int brandId, String brandName, String icon) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.icon = icon;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
