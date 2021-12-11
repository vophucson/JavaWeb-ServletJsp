package vn.carforyou.dao;

import java.util.List;

import vn.carforyou.model.DealerAdminModel;
import vn.carforyou.model.DealerModel;
import vn.carforyou.model.ListDealerModel;
import vn.carforyou.model.ProductModel;

public interface DealerDao {
	DealerModel getDealerDetail(int dealerID);

	int CountPage();

	List<ListDealerModel> geListDealerModels(int index, String sort);

	int CountPageDetail(int dealerID);

	List<ProductModel> getProductbyDealer(int index, int dealerID);

	int CountPageAdmin();

	List<DealerAdminModel> listDealerAdmin(int index);

	void deleteDealer(int dealerID);

	DealerModel getDealerInfobyid(int dealerID);

	void createStore(DealerModel dealer);

	void editStore(DealerModel dealer);

	void changeStore(int isPass, int dealerID);
}
