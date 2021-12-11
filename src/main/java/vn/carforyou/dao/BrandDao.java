package vn.carforyou.dao;

import java.util.List;

import vn.carforyou.model.BrandModel;

public interface BrandDao {
	List<BrandModel> getAllBrand();

	int countPageBrand();

	List<BrandModel> listBrandAdmin(int index);

	void deleteBrand(int brandID);

	void createBrand(String brandName, String icon);

	BrandModel getBarndbyid(String brandID);

	void editBrand(BrandModel brand);
}
