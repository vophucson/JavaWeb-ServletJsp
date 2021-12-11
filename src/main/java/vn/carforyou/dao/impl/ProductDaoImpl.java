package vn.carforyou.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.carforyou.connection.DBconnect;
import vn.carforyou.dao.ProductDao;
import vn.carforyou.model.BrandModel;
import vn.carforyou.model.DealerModel;
import vn.carforyou.model.ProductModel;

public class ProductDaoImpl implements ProductDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<ProductModel> getTop6New() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select top 6 ProductID,ProductName,Price,imageLink,BrandName,dName,dPhone,TotalKM,YearModel,Localtion from Product,Brand,DealerInfo\r\n"
				+ "where Product.BrandID = Brand.BrandID and Product.DealerID = DealerInfo.DealerID and Product.isPass = 1 and TypeCar = N'Mới' order by NEWID()";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(5));
				DealerModel dealer = new DealerModel();
				dealer.setdName(rs.getString(6));
				dealer.setdPhone(rs.getString(7));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setPrice(rs.getBigDecimal(3));
				product.setImage(rs.getString(4));
				product.setTotalKm(rs.getInt(8));
				product.setYearModel(rs.getInt(9));
				product.setLocaltion(rs.getString(10));
				product.setBrand(brand);
				product.setDealer(dealer);
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;
	}

	public List<ProductModel> getTop6Used() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select top 6 ProductID,ProductName,Price,imageLink,BrandName,dName,dPhone,TotalKM,YearModel,Localtion from Product,Brand,DealerInfo\r\n"
				+ "where Product.BrandID = Brand.BrandID and Product.DealerID = DealerInfo.DealerID and Product.isPass = 1 and TypeCar = N'Cũ' order by NEWID()";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(5));
				DealerModel dealer = new DealerModel();
				dealer.setdName(rs.getString(6));
				dealer.setdPhone(rs.getString(7));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setPrice(rs.getBigDecimal(3));
				product.setImage(rs.getString(4));
				product.setTotalKm(rs.getInt(8));
				product.setYearModel(rs.getInt(9));
				product.setLocaltion(rs.getString(10));
				product.setBrand(brand);
				product.setDealer(dealer);
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;
	}

	public List<ProductModel> getSpecial() {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select top 3 ProductID,ProductName,Price,imageLink,BrandName,dName,dPhone,TotalKM,YearModel,FuelType,Transmission,Engine,Seats,TypeCar,Localtion from Product,Brand,DealerInfo\r\n"
				+ "where Product.BrandID = Brand.BrandID and Product.DealerID = DealerInfo.DealerID and Product.isPass = 1 order by Price desc,ProductID desc";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			list.clear();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(5));
				DealerModel dealer = new DealerModel();
				dealer.setdName(rs.getString(6));
				dealer.setdPhone(rs.getString(7));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setPrice(rs.getBigDecimal(3));
				product.setImage(rs.getString(4));
				product.setTotalKm(rs.getInt(8));
				product.setYearModel(rs.getInt(9));
				product.setFuelType(rs.getString(10));
				product.setTransmission(rs.getString(11));
				product.setEngine(rs.getInt(12));
				product.setSeats(rs.getInt(13));
				product.setTypeCar(rs.getString(14));
				product.setLocaltion(rs.getString(15));
				product.setBrand(brand);
				product.setDealer(dealer);
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;
	}

	public int CountPage(String type, String pName, int bID) {
		int page = 0;
		int index = 0;
		String sql = "";
		switch (type) {
		case "used":
			sql = "select count(*) from Product where TypeCar = N'Cũ'  and isPass =1 and DealerID is not null and BrandID is not null";
			break;
		case "new":
			sql = "select count(*) from Product where TypeCar = N'Mới'  and isPass =1 and DealerID is not null and BrandID is not null";
			break;
		case "searchname":
			sql = "select count(*) from Product where ProductName Like ? and isPass =1 and DealerID is not null and BrandID is not null";
			break;
		case "brand":
			sql = "select count(*) from Product where BrandID = ? and isPass =1 and DealerID is not null and BrandID is not null";
		}
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			if (type.equals("searchname")) {
				ps.setString(1, "%" + pName + "%");
			}
			if (type.equals("brand")) {
				ps.setInt(1, bID);
			}
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

	public List<ProductModel> getListProduct(String type, int index, String sort, String pName, int bID) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = null;
		String typeSort = null;
		if (sort.equals("no")) {
			typeSort = "ORDER BY ProductID desc \r\n";
		}
		if (sort.equals("lowtotop")) {
			typeSort = "ORDER BY Price asc\r\n";
		}
		if (sort.equals("toptolow")) {
			typeSort = "ORDER BY Price desc\r\n";
		}
		switch (type) {
		case "used":
			sql = "select ProductID,ProductName,Price,imageLink,BrandName,TotalKM,YearModel,FuelType,Transmission,Engine,Seats,TypeCar,Localtion,DealerID \r\n"
					+ "from Product,Brand\r\n"
					+ "where Product.BrandID = Brand.BrandID and TypeCar = N'Cũ' and isPass = 1 and DealerID is not null \r\n"
					+ typeSort + "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
			break;
		case "new":
			sql = "select ProductID,ProductName,Price,imageLink,BrandName,TotalKM,YearModel,FuelType,Transmission,Engine,Seats,TypeCar,Localtion,DealerID \r\n"
					+ "from Product,Brand\r\n"
					+ "where Product.BrandID = Brand.BrandID and TypeCar = N'Mới' and isPass = 1 and DealerID is not null \r\n"
					+ typeSort + "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
			break;
		case "searchname":
			sql = "select ProductID,ProductName,Price,imageLink,BrandName,TotalKM,YearModel,FuelType,Transmission,Engine,Seats,TypeCar,Localtion,DealerID \r\n"
					+ "from Product,Brand\r\n"
					+ "where Product.BrandID = Brand.BrandID  and isPass = 1 and ProductName Like ? and DealerID is not null \r\n"
					+ typeSort + "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
			break;
		case "brand":
			sql = "select ProductID,ProductName,Price,imageLink,BrandName,TotalKM,YearModel,FuelType,Transmission,Engine,Seats,TypeCar,Localtion,DealerID \r\n"
					+ "from Product,Brand\r\n"
					+ "where Product.BrandID = Brand.BrandID  and isPass = 1 and Product.BrandID = ? and DealerID is not null  \r\n"
					+ typeSort + "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
			break;
		}
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			if (type.equals("used") || type.equals("new")) {
				ps.setInt(1, (index - 1) * 6);
			}
			if (type.equals("searchname")) {
				ps.setString(1, "%" + pName + "%");
				ps.setInt(2, (index - 1) * 6);

			}
			if (type.equals("brand")) {
				ps.setInt(1, bID);
				ps.setInt(2, (index - 1) * 6);
			}
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
				product.setEngine(rs.getInt(10));
				product.setSeats(rs.getInt(11));
				product.setTypeCar(rs.getString(12));
				product.setLocaltion(rs.getString(13));
				DealerModel dealer = new DealerModel();
				dealer.setDealerId(rs.getInt(14));
				product.setDealer(dealer);
				product.setBrand(brand);
				list.add(product);
			}
		} catch (Exception e) {

		}

		return list;
	}

	public ProductModel getProductDetail(int productID) {
		String sql = "select ProductID,ProductName,Price,imageLink,BrandName,TotalKM,YearModel,FuelType,Transmission,Engine,Seats,TypeCar,Localtion,DealerInfo.DealerID,dName,dAddress,dPhone,dEmail,dImage,Description,Product.BrandID \r\n"
				+ "from Product,Brand,DealerInfo\r\n"
				+ "where Product.BrandID = Brand.BrandID and ProductID = ? and Product.DealerID = DealerInfo.DealerID";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);
			rs = ps.executeQuery();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(5));
				brand.setBrandId(rs.getInt(21));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setPrice(rs.getBigDecimal(3));
				product.setImage(rs.getString(4));
				product.setTotalKm(rs.getInt(6));
				product.setYearModel(rs.getInt(7));
				product.setFuelType(rs.getString(8));
				product.setTransmission(rs.getString(9));
				product.setEngine(rs.getInt(10));
				product.setSeats(rs.getInt(11));
				product.setTypeCar(rs.getString(12));
				product.setLocaltion(rs.getString(13));
				DealerModel dealer = new DealerModel();
				dealer.setDealerId(rs.getInt(14));
				dealer.setdName(rs.getString(15));
				dealer.setdAddress(rs.getString(16));
				dealer.setdPhone(rs.getString(17));
				dealer.setdEmail(rs.getString(18));
				dealer.setdImage(rs.getString(19));
				product.setDes(rs.getString(20));
				product.setDealer(dealer);
				product.setBrand(brand);
				return product;
			}
		} catch (Exception e) {

		}
		return null;

	}

	public List<ProductModel> getTop4car(int DealerID) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select ProductID,ProductName,Price,imageLink,BrandName,TotalKM,YearModel,FuelType,Transmission,Engine,Seats,TypeCar,Localtion \r\n"
				+ "from Product,Brand where  Product.BrandID = Brand.BrandID and DealerID = ? and Product.isPass =1 \r\n"
				+ "ORDER BY NEWID() \r\n" + "";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, DealerID);
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
				product.setEngine(rs.getInt(10));
				product.setSeats(rs.getInt(11));
				product.setTypeCar(rs.getString(12));
				product.setLocaltion(rs.getString(13));
				product.setBrand(brand);
				list.add(product);
			}
		} catch (Exception e) {

		}
		return list;
	}

	public ProductModel getProductbyID(String productID) {
		ProductModel detail = new ProductModel();
		String sql = "select ProductID,ProductName,Price,imageLink,TotalKM,YearModel,Localtion,dName,dPhone,BrandName,TypeCar \r\n"
				+ "from Product,Brand,DealerInfo where  Product.BrandID  = Brand.BrandID and DealerInfo.DealerID = Product.DealerID  and ProductID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, productID);
			rs = ps.executeQuery();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(10));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setPrice(rs.getBigDecimal(3));
				product.setImage(rs.getString(4));
				product.setTotalKm(rs.getInt(5));
				product.setYearModel(rs.getInt(6));
				product.setLocaltion(rs.getString(7));
				DealerModel dealer = new DealerModel();
				dealer.setdName(rs.getString(8));
				dealer.setdPhone(rs.getString(9));
				product.setTypeCar(rs.getString(11));
				product.setDealer(dealer);
				product.setBrand(brand);
				detail = product;
			}
		} catch (Exception e) {
		}
		return detail;
	}

	public int totalCar() {
		String sql = "select COUNT(*) from Product\r\n" + "where BrandID is NOT NULL and DealerID is not null ";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public int totalpassCar() {
		String sql = "select COUNT(*) from Product\r\n"
				+ "where BrandID is NOT NULL and DealerID is not null and isPass = 1";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public int totalnoPassCar() {
		String sql = "select COUNT(*) from Product\r\n"
				+ "where BrandID is NOT NULL and DealerID is not null and isPass = 0";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public int totalUser() {
		String sql = "select COUNT(*) from Users";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public int totalStore() {
		String sql = "select COUNT(*) from DealerInfo ";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public int totalBrand() {
		String sql = "select COUNT(*) from Brand";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {

		}
		return 0;
	}

	public int countPagePassCar() {
		int page = 0;
		int index = 0;
		String sql = "select COUNT(*) from Product where isPass = 1 and BrandID is NOT NULL and DealerID is not null";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				page = rs.getInt(1);
			}

		} catch (Exception e) {
		}
		index = page / 8;
		if (page % 8 != 0 && page > 8) {
			index++;
		}
		if (page < 8) {
			index = 1;
		}
		return index;
	}

	public List<ProductModel> listPostCarPass(int index) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select ProductID,BrandName,ProductName,dName\r\n" + "from DealerInfo,Product,Brand\r\n"
				+ "where Product.DealerID = DealerInfo.DealerID and Product.BrandID = Brand.BrandID and Product.isPass = 1\r\n"
				+ "ORDER BY ProductID \r\n" + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 8);
			rs = ps.executeQuery();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(2));
				DealerModel dealer = new DealerModel();
				dealer.setdName(rs.getString(4));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(3));
				product.setBrand(brand);
				product.setDealer(dealer);
				list.add(product);
			}

		} catch (Exception e) {
		}
		return list;
	}

	public int countPageNoPassCar() {
		int page = 0;
		int index = 0;
		String sql = "select COUNT(*) from Product where isPass = 0 and BrandID is NOT NULL and DealerID is not null";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				page = rs.getInt(1);
			}

		} catch (Exception e) {
		}
		index = page / 8;
		if (page % 8 != 0 && page > 8) {
			index++;
		}
		if (page < 8) {
			index = 1;
		}
		return index;
	}

	public List<ProductModel> listPostCarNoPass(int index) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select ProductID,BrandName,ProductName,dName\r\n" + "from DealerInfo,Product,Brand\r\n"
				+ "where Product.DealerID = DealerInfo.DealerID and Product.BrandID = Brand.BrandID and Product.isPass = 0\r\n"
				+ "ORDER BY ProductID \r\n" + "OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 8);
			rs = ps.executeQuery();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(2));
				DealerModel dealer = new DealerModel();
				dealer.setdName(rs.getString(4));
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(3));
				product.setBrand(brand);
				product.setDealer(dealer);
				list.add(product);
			}

		} catch (Exception e) {
		}
		return list;
	}

	public void deleteProduct(int productID) {
		String sql = "delete Product where ProductID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, productID);
			ps.executeUpdate();
		} catch (Exception e) {

		}

	}

	public void insertProduct(ProductModel product) {
		String sql = "insert into Product Values(?,?,?,?,?,?,?,?,?,?,?,?,0,?,?)";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getpName());
			ps.setBigDecimal(2, product.getPrice());
			ps.setString(3, product.getImage());
			ps.setInt(4, product.getBrand().getBrandId());
			ps.setInt(5, product.getDealer().getDealerId());
			ps.setInt(6, product.getTotalKm());
			ps.setInt(7, product.getYearModel());
			ps.setString(8, product.getFuelType());
			ps.setString(9, product.getTransmission());
			ps.setInt(10, product.getEngine());
			ps.setInt(11, product.getSeats());
			ps.setString(12, product.getTypeCar());
			ps.setString(13, product.getDes());
			ps.setString(14, product.getLocaltion());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void changePass(int isPass, int productID) {
		String sql = "update Product set isPass = ? where ProductID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, isPass);
			ps.setInt(2, productID);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public int countPost(int DealerID) {
		String sql = "select COUNT(*) From Product where DealerID = ? and BrandID is not null";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, DealerID);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (Exception e) {
		}
		return 0;

	}

	public List<ProductModel> getPostbyDealer(int index, int DealerID) {
		List<ProductModel> list = new ArrayList<ProductModel>();
		String sql = "select ProductID,ProductName,BrandName,imageLink,isPass\r\n" + "from Product,Brand\r\n"
				+ "where Product.BrandID = Brand.BrandID and DealerID = ? \r\n" + "ORDER BY ProductID \r\n"
				+ "OFFSET ? ROWS FETCH NEXT 6 ROWS ONLY";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, DealerID);
			ps.setInt(2, (index - 1) * 6);
			rs = ps.executeQuery();
			while (rs.next()) {
				BrandModel brand = new BrandModel();
				brand.setBrandName(rs.getString(3));
				ProductModel product = new ProductModel();
				product.setBrand(brand);
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setImage(rs.getString(4));
				product.setIsPass(rs.getInt(5));
				list.add(product);
			}

		} catch (Exception e) {
		}
		return list;
	}

	public void editPost(ProductModel product) {
		String sql = "update Product set ProductName = ?,Price = ?,imageLink = ?,BrandID = ?,TotalKM = ?,Engine =?,YearModel = ?,FuelType = ?,Transmission = ?,Seats = ?,Localtion = ?,Description = ?,TypeCar = ? where ProductID = ?";
		try {
			conn = new DBconnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getpName());
			ps.setBigDecimal(2, product.getPrice());
			ps.setString(3, product.getImage());
			ps.setInt(4, product.getBrand().getBrandId());
			ps.setInt(5, product.getTotalKm());
			ps.setInt(6, product.getEngine());
			ps.setInt(7, product.getYearModel());
			ps.setString(8, product.getFuelType());
			ps.setString(9, product.getTransmission());
			ps.setInt(10, product.getSeats());
			ps.setString(11, product.getLocaltion());
			ps.setString(12, product.getDes());
			ps.setString(13, product.getTypeCar());
			ps.setInt(14, product.getProductId());
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

}