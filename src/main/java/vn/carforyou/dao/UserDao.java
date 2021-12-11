package vn.carforyou.dao;

import java.util.List;

import vn.carforyou.model.UserModel;

public interface UserDao {
	UserModel chechExit(String email);

	void register(String name, String email, String password);

	UserModel login(String email, String pass);

	UserModel getInfoUser(String userId);

	void edit(String name, String phone, String address, String userId);

	void oldPassword(String pass, int userId);

	int countPageUser();

	List<UserModel> listUserAdmin(int index);

	void deleteUser(int userID);

	void changeAdmin(int userID, int role);

	void changeDealer(int userID, int role);
}
