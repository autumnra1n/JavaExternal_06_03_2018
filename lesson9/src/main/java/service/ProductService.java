package service;

import persistence.dao.ProductDao;

import java.util.List;
import java.util.Map;

public class ProductService {

    private ProductDao productDao = new ProductDao();

    public void addProduct(String name, int price, int weight, int id){
        productDao.addProduct(name,price,weight,id);
    }

    public void deleteProduct(int id){
        productDao.deleteProduct(id);
    }

    public List showProducts(){
        return productDao.showProducts();
    }

    public Map showProductsWithCategory(){
        return productDao.showProductsWithCategory();
    }

    public Map showProductsWithCategoryByCategoryName(String name){
        return productDao.showProductsWithCategoryByCategoryName(name);
    }
}
