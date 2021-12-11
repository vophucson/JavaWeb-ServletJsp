package vn.carforyou.service;

import java.util.List;

import vn.carforyou.model.ProductModel;

public interface ProductService {
	List<ProductModel> getTop6New();

	List<ProductModel> getTop6Used();

	List<ProductModel> getSpecial();

	int CountPage(String type, String pName, int bID);

	List<ProductModel> getListProduct(String type, int index, String sort, String pName, int bID);

	ProductModel getProductDetail(int productID);

	List<ProductModel> getTop4car(int DealerID);

	ProductModel getProductbyID(String productID);

	int totalCar();

	int totalpassCar();

	int totalnoPassCar();

	int totalUser();

	int totalStore();

	int totalBrand();

	int countPagePassCar();

	List<ProductModel> listPostCarPass(int index);

	int countPageNoPassCar();

	List<ProductModel> listPostCarNoPass(int index);

	void deleteProduct(int productID);

	void insertProduct(ProductModel product);

	void changePass(int isPass, int productID);

	int countPost(int DeadlerID);

	List<ProductModel> getPostbyDealer(int index, int DealerID);

	void editPost(ProductModel product);
}
