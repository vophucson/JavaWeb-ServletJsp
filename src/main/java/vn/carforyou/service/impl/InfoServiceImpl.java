package vn.carforyou.service.impl;

import vn.carforyou.dao.InfoDao;
import vn.carforyou.dao.impl.InfoDaoImpl;
import vn.carforyou.model.InfoModel;
import vn.carforyou.service.InfoService;

public class InfoServiceImpl implements InfoService {
	InfoDao ind = new InfoDaoImpl();

	@Override
	public InfoModel getInfo() {
		// TODO Auto-generated method stub
		return ind.getInfo();
	}

	@Override
	public void editInfo(String email, String phone, String address) {
		ind.editInfo(email, phone, address);

	}

}
