package vn.carforyou.service.impl;

import java.util.List;

import vn.carforyou.dao.DealerDao;
import vn.carforyou.dao.impl.DealerDaoImpl;
import vn.carforyou.model.DealerAdminModel;
import vn.carforyou.model.DealerModel;
import vn.carforyou.model.ListDealerModel;
import vn.carforyou.model.ProductModel;
import vn.carforyou.service.DealerService;

public class DealerServiceImpl implements DealerService {
	DealerDao dd = new DealerDaoImpl();

	@Override
	public DealerModel getDealerDetail(int dealerID) {
		// TODO Auto-generated method stub
		return dd.getDealerDetail(dealerID);
	}

	@Override
	public int CountPage() {
		// TODO Auto-generated method stub
		return dd.CountPage();
	}

	@Override
	public List<ListDealerModel> geListDealerModels(int index, String sort) {
		// TODO Auto-generated method stub
		return dd.geListDealerModels(index, sort);
	}

	@Override
	public int CountPageDetail(int dealerID) {
		// TODO Auto-generated method stub
		return dd.CountPageDetail(dealerID);
	}

	@Override
	public List<ProductModel> getProductbyDealer(int index, int dealerID) {
		// TODO Auto-generated method stub
		return dd.getProductbyDealer(index, dealerID);
	}

	@Override
	public int CountPageAdmin() {
		// TODO Auto-generated method stub
		return dd.CountPageAdmin();
	}

	@Override
	public List<DealerAdminModel> listDealerAdmin(int index) {
		// TODO Auto-generated method stub
		return dd.listDealerAdmin(index);
	}

	@Override
	public void deleteDealer(int dealerID) {
		// TODO Auto-generated method stub
		dd.deleteDealer(dealerID);

	}

	@Override
	public DealerModel getDealerInfobyid(int dealerID) {
		// TODO Auto-generated method stub
		return dd.getDealerInfobyid(dealerID);
	}

	@Override
	public void createStore(DealerModel dealer) {
		// TODO Auto-generated method stub
		dd.createStore(dealer);

	}

	@Override
	public void editStore(DealerModel dealer) {
		// TODO Auto-generated method stub
		dd.editStore(dealer);
	}

	@Override
	public void changeStore(int isPass, int dealerID) {
		dd.changeStore(isPass, dealerID);

	}

}
