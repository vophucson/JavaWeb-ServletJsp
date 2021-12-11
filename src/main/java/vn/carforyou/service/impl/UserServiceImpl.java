package vn.carforyou.service.impl;

import java.util.List;

import vn.carforyou.dao.UserDao;
import vn.carforyou.dao.impl.UserDaoImpl;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();

	@Override
	public UserModel chechExit(String email) {
		// TODO Auto-generated method stub
		return ud.chechExit(email);
	}

	@Override
	public void register(String name, String email, String password) {
		ud.register(name, email, password);

	}

	@Override
	public UserModel login(String email, String pass) {
		// TODO Auto-generated method stub
		return ud.login(email, pass);
	}

	@Override
	public UserModel getInfoUser(String userId) {
		// TODO Auto-generated method stub
		return ud.getInfoUser(userId);
	}

	@Override
	public void edit(String name, String phone, String address, String userId) {
		ud.edit(name, phone, address, userId);

	}

	@Override
	public void oldPassword(String pass, int userId) {
		ud.oldPassword(pass, userId);

	}

	@Override
	public int countPageUser() {
		// TODO Auto-generated method stub
		return ud.countPageUser();
	}

	@Override
	public List<UserModel> listUserAdmin(int index) {
		// TODO Auto-generated method stub
		return ud.listUserAdmin(index);
	}

	@Override
	public void deleteUser(int userID) {
		// TODO Auto-generated method stub
		ud.deleteUser(userID);

	}

	@Override
	public void changeAdmin(int userID, int role) {
		// TODO Auto-generated method stub
		ud.changeAdmin(userID, role);

	}

	@Override
	public void changeDealer(int userID, int role) {
		// TODO Auto-generated method stub
		ud.changeDealer(userID, role);

	}

}
