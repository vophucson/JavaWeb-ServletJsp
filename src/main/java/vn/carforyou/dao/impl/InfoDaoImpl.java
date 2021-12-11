package vn.carforyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.carforyou.connection.DBconnect;
import vn.carforyou.dao.InfoDao;
import vn.carforyou.model.InfoModel;

public class InfoDaoImpl implements InfoDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public InfoModel getInfo() {
		String sql = "select * from Information";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new InfoModel(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {

		}

		return null;
	}

	public void editInfo(String email, String phone, String address) {
		String sql = "update Information set email = ?,phone = ?,address =?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, phone);
			ps.setString(3, address);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
