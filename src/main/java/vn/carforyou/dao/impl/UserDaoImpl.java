package vn.carforyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.carforyou.connection.DBconnect;
import vn.carforyou.dao.UserDao;
import vn.carforyou.model.UserModel;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public UserModel chechExit(String email) {
		String sql = "select * from Users where userEmail = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {

		}

		return null;
	}

	public void register(String name, String email, String password) {
		String sql = "insert into  Users values(?,?,?,null,null,0,0)";
		System.out.println(sql);
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public UserModel login(String email, String pass) {
		String sql = "select * from Users where userEmail = ? and Password = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {

		}

		return null;
	}

	public UserModel getInfoUser(String userId) {
		String sql = "select * from Users where UserID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {

		}

		return null;
	}

	public void edit(String name, String phone, String address, String userId) {
		String sql = "update Users set UserName = ?,UserPhone = ?,UserAddress = ? where UserID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, address);
			ps.setString(4, userId);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void oldPassword(String pass, int userId) {
		String sql = "update Users set Password = ? where UserID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setInt(2, userId);
			ps.executeUpdate();

		} catch (Exception e) {

		}
	}

	public int countPageUser() {
		int page = 0;
		int index = 0;
		String sql = "select COUNT(*) FROM Users";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				page = rs.getInt(1);
			}
		} catch (Exception e) {
		}
		index = page / 6;
		if (page % 6 != 0 && page > 6) {
			index++;
		}
		if (page < 6) {
			index = 1;
		}
		return index;
	}

	public List<UserModel> listUserAdmin(int index) {
		List<UserModel> list = new ArrayList<UserModel>();
		String sql = "select * from Users\r\n" + "ORDER BY UserID \r\n" + "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public void deleteUser(int userID) {
		String sql = "delete Users where UserID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ps.executeUpdate();
		} catch (Exception e) {

		}

	}

	public void changeAdmin(int userID, int role) {
		String sql = "update Users set isAdmin = ? where UserID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, role);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void changeDealer(int userID, int role) {
		String sql = "update Users set isDealer = ? where UserID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, role);
			ps.setInt(2, userID);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}
}
