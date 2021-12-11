package vn.carforyou.service.impl;

import java.util.List;

import vn.carforyou.dao.ProductDao;
import vn.carforyou.dao.impl.ProductDaoImpl;
import vn.carforyou.model.ProductModel;
import vn.carforyou.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao pd = new ProductDaoImpl();

	@Override
	public List<ProductModel> getTop6New() {
		// TODO Auto-generated method stub
		return pd.getTop6New();
	}

	@Override
	public List<ProductModel> getTop6Used() {
		// TODO Auto-generated method stub
		return pd.getTop6Used();
	}

	@Override
	public List<ProductModel> getSpecial() {
		// TODO Auto-generated method stub
		return pd.getSpecial();
	}

	@Override
	public int CountPage(String type, String pName, int bID) {
		// TODO Auto-generated method stub
		return pd.CountPage(type, pName, bID);
	}

	@Override
	public List<ProductModel> getListProduct(String type, int index, String sort, String pName, int bID) {
		// TODO Auto-generated method stub
		return pd.getListProduct(type, index, sort, pName, bID);
	}

	@Override
	public ProductModel getProductDetail(int productID) {
		// TODO Auto-generated method stub
		return pd.getProductDetail(productID);
	}

	@Override
	public List<ProductModel> getTop4car(int DealerID) {
		// TODO Auto-generated method stub
		return pd.getTop4car(DealerID);
	}

	@Override
	public ProductModel getProductbyID(String productID) {
		// TODO Auto-generated method stub
		return pd.getProductbyID(productID);
	}

	@Override
	public int totalCar() {
		// TODO Auto-generated method stub
		return pd.totalCar();
	}

	@Override
	public int totalpassCar() {
		// TODO Auto-generated method stub
		return pd.totalpassCar();
	}

	@Override
	public int totalnoPassCar() {
		// TODO Auto-generated method stub
		return pd.totalnoPassCar();
	}

	@Override
	public int totalUser() {
		// TODO Auto-generated method stub
		return pd.totalUser();
	}

	@Override
	public int totalStore() {
		// TODO Auto-generated method stub
		return pd.totalStore();
	}

	@Override
	public int totalBrand() {
		// TODO Auto-generated method stub
		return pd.totalBrand();
	}

	@Override
	public int countPagePassCar() {
		// TODO Auto-generated method stub
		return pd.countPagePassCar();
	}

	@Override
	public List<ProductModel> listPostCarPass(int index) {
		// TODO Auto-generated method stub
		return pd.listPostCarPass(index);
	}

	@Override
	public int countPageNoPassCar() {
		// TODO Auto-generated method stub
		return pd.countPageNoPassCar();
	}

	@Override
	public List<ProductModel> listPostCarNoPass(int index) {
		// TODO Auto-generated method stub
		return pd.listPostCarNoPass(index);
	}

	@Override
	public void deleteProduct(int productID) {
		pd.deleteProduct(productID);

	}

	@Override
	public void insertProduct(ProductModel product) {
		// TODO Auto-generated method stub
		pd.insertProduct(product);

	}

	@Override
	public void changePass(int isPass, int productID) {
		pd.changePass(isPass, productID);

	}

	@Override
	public int countPost(int DeadlerID) {
		// TODO Auto-generated method stub
		return pd.countPost(DeadlerID);
	}

	@Override
	public List<ProductModel> getPostbyDealer(int index, int DealerID) {
		// TODO Auto-generated method stub
		return pd.getPostbyDealer(index, DealerID);
	}

	@Override
	public void editPost(ProductModel product) {
		// TODO Auto-generated method stub
		pd.editPost(product);

	}

}
