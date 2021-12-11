package vn.carforyou.service;

import vn.carforyou.model.InfoModel;

public interface InfoService {
	InfoModel getInfo();

	void editInfo(String email, String phone, String address);
}
