package vn.carforyou.service.impl;

import java.util.List;

import vn.carforyou.dao.BrandDao;
import vn.carforyou.dao.impl.BrandDaoImpl;
import vn.carforyou.model.BrandModel;
import vn.carforyou.service.BrandService;

public class BrandServiceImpl implements BrandService {
	BrandDao bd = new BrandDaoImpl();

	@Override
	public List<BrandModel> getAllBrand() {
		// TODO Auto-generated method stub
		return bd.getAllBrand();
	}

	@Override
	public int countPageBrand() {
		// TODO Auto-generated method stub
		return bd.countPageBrand();
	}

	@Override
	public List<BrandModel> listBrandAdmin(int index) {
		// TODO Auto-generated method stub
		return bd.listBrandAdmin(index);
	}

	@Override
	public void deleteBrand(int brandID) {
		// TODO Auto-generated method stub
		bd.deleteBrand(brandID);

	}

	@Override
	public void createBrand(String brandName, String icon) {
		// TODO Auto-generated method stub
		bd.createBrand(brandName, icon);

	}

	@Override
	public BrandModel getBarndbyid(String brandID) {
		// TODO Auto-generated method stub
		return bd.getBarndbyid(brandID);
	}

	@Override
	public void editBrand(BrandModel brand) {
		bd.editBrand(brand);

	}

}
