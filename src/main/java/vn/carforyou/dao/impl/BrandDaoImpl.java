package vn.carforyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.carforyou.connection.DBconnect;
import vn.carforyou.dao.BrandDao;
import vn.carforyou.model.BrandModel;

public class BrandDaoImpl implements BrandDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<BrandModel> getAllBrand() {
		List<BrandModel> list = new ArrayList<BrandModel>();
		String sql = "select * from Brand";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				list.add(new BrandModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {

		}
		return list;
	}

	public int countPageBrand() {
		int page = 0;
		int index = 0;
		String sql = "select COUNT(*) from Brand";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				page = rs.getInt(1);
			}
		} catch (Exception e) {
		}
		index = page / 5;
		if (page % 5 != 0 && page > 5) {
			index++;
		}
		if (page < 5) {
			index = 1;
		}
		return index;
	}

	public List<BrandModel> listBrandAdmin(int index) {
		List<BrandModel> list = new ArrayList<BrandModel>();
		String sql = "select * from Brand\r\n" + "ORDER BY BrandID \r\n" + "OFFSET ? ROWS FETCH NEXT 5 ROWS ONLY";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 5);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BrandModel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (Exception e) {

		}

		return list;
	}

	public void deleteBrand(int brandID) {
		String sql = "delete Brand where BrandID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, brandID);
			ps.executeUpdate();
		} catch (Exception e) {

		}

	}

	public void createBrand(String brandName, String icon) {
		String sql = "insert into Brand values(?,?)";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, brandName);
			ps.setString(2, icon);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public BrandModel getBarndbyid(String brandID) {

		String sql = "select * \r\n" + "from Brand\r\n" + "where BrandID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, brandID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new BrandModel(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (Exception e) {

		}
		return null;
	}

	public void editBrand(BrandModel brand) {
		String sql = "update Brand set BrandName = ?,Icon = ? where BrandID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, brand.getBrandName());
			ps.setString(2, brand.getIcon());
			ps.setInt(3, brand.getBrandId());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

}
