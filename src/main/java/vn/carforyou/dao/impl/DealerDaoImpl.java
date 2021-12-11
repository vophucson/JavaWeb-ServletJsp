package vn.carforyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.carforyou.connection.DBconnect;
import vn.carforyou.dao.DealerDao;
import vn.carforyou.model.BrandModel;
import vn.carforyou.model.DealerAdminModel;
import vn.carforyou.model.DealerModel;
import vn.carforyou.model.ListDealerModel;
import vn.carforyou.model.ProductModel;

public class DealerDaoImpl implements DealerDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public DealerModel getDealerDetail(int dealerID) {
		DealerModel detail = new DealerModel();
		String sql = "select * from DealerInfo where DealerId = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dealerID);
			rs = ps.executeQuery();
			while (rs.next()) {
				detail = new DealerModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8));

			}
		} catch (Exception e) {

		}

		return detail;
	}

	public int CountPage() {
		int page = 0;
		int index = 0;
		String sql = "select count(*) from DealerInfo where isPass = 1";
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

	public List<ListDealerModel> geListDealerModels(int index, String sort) {
		List<ListDealerModel> list = new ArrayList<ListDealerModel>();
		String typeSort = null;
		if (sort.equals("no")) {
			typeSort = "ORDER BY DealerID \r\n";
		}
		if (sort.equals("lowtotop")) {
			typeSort = "ORDER BY countcar asc \r\n";
		}
		if (sort.equals("toptolow")) {
			typeSort = "ORDER BY countcar desc \r\n";
		}
		String sql = "select DealerInfo.DealerID,dName,dAddress,dImage,COUNT(ProductID) as countcar\r\n"
				+ "from DealerInfo left join (select DealerID,ProductID\r\n"
				+ "from Product where isPass = 1) A on A.DealerID = DealerInfo.DealerID\r\n" + "where isPass = 1\r\n"
				+ "GROUP BY DealerInfo.DealerID,dName,dAddress,dImage\r\n" + typeSort
				+ "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 6);
			rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				list.add(new ListDealerModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5)));

			}
		} catch (Exception e) {

		}
		return list;

	}

	public int CountPageDetail(int dealerID) {
		int page = 0;
		int index = 0;
		String sql = "select COUNT(*) from Product where isPass = 1 and DealerID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dealerID);
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

	public List<ProductModel> getProductbyDealer(int index, int dealerID) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select ProductID,ProductName,Price,imageLink,BrandName,TotalKM,YearModel,FuelType,Transmission,TypeCar,Localtion \r\n"
				+ "from Product,Brand\r\n"
				+ "where Product.BrandID = Brand.BrandID  and Product.isPass = 1 and DealerID = ? \r\n"
				+ "ORDER BY ProductID desc \r\n" + "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dealerID);
			ps.setInt(2, (index - 1) * 6);
			rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(5));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setPrice(rs.getBigDecimal(3));
				product.setImage(rs.getString(4));
				product.setTotalKm(rs.getInt(6));
				product.setYearModel(rs.getInt(7));
				product.setFuelType(rs.getString(8));
				product.setTransmission(rs.getString(9));
				product.setTypeCar(rs.getString(10));
				product.setLocaltion(rs.getString(11));
				product.setBrand(brand);
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;
	}

	public int CountPageAdmin() {
		int page = 0;
		int index = 0;
		String sql = "select count(*) from DealerInfo";
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

	public List<DealerAdminModel> listDealerAdmin(int index) {
		List<DealerAdminModel> list = new ArrayList<DealerAdminModel>();
		String sql = "select DealerID,dName,isPass,UserName,UserEmail,UserPhone\r\n" + "from DealerInfo,Users \r\n"
				+ "where DealerInfo.DealerID = Users.UserID\r\n" + "ORDER BY DealerID \r\n"
				+ "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DealerAdminModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}

		} catch (Exception e) {
		}
		return list;
	}

	public void deleteDealer(int dealerID) {
		String sql = "delete DealerInfo where DealerID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dealerID);
			ps.executeUpdate();
		} catch (Exception e) {

		}

	}

	public DealerModel getDealerInfobyid(int dealerID) {
		String sql = "select * from DealerInfo where DealerID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dealerID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new DealerModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getString(8));

			}
		} catch (Exception e) {

		}

		return null;
	}

	public void createStore(DealerModel dealer) {
		String sql = "insert into DealerInfo values(?,?,?,?,?,?,0,?)";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dealer.getDealerId());
			ps.setString(2, dealer.getdName());
			ps.setString(3, dealer.getdInfo());
			ps.setString(4, dealer.getdAddress());
			ps.setString(5, dealer.getdPhone());
			ps.setString(6, dealer.getdEmail());
			ps.setString(7, dealer.getdImage());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void editStore(DealerModel dealer) {
		String sql = "update DealerInfo set dName =?,dInfo = ?,dAddress =?,dPhone =?,dEmail =?,dImage =? where DealerID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(7, dealer.getDealerId());
			ps.setString(1, dealer.getdName());
			ps.setString(2, dealer.getdInfo());
			ps.setString(3, dealer.getdAddress());
			ps.setString(4, dealer.getdPhone());
			ps.setString(5, dealer.getdEmail());
			ps.setString(6, dealer.getdImage());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void changeStore(int isPass, int dealerID) {
		String sql = "update DealerInfo set isPass = ? where DealerID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, isPass);
			ps.setInt(2, dealerID);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}
}
