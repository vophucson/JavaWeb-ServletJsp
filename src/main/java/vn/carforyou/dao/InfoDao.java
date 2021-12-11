package vn.carforyou.dao;

import vn.carforyou.model.InfoModel;

public interface InfoDao {
	InfoModel getInfo();

	void editInfo(String email, String phone, String address);
}
