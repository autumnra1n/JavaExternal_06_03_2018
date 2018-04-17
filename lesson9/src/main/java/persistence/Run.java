package persistence;

import persistence.dao.CategoryDao;
import persistence.dao.ProductDao;

public class Run {
    public static void main(String[] args) {
        try {
            CategoryDao categoryDao = new CategoryDao();
            ProductDao productDao = new ProductDao();
            categoryDao.addCategory("Meat");
            categoryDao.addCategory("Water");
            productDao.addProduct("Beef",15,16, 1);
            productDao.addProduct("Sausage", 7, 9, 1);
            productDao.addProduct("Bonaqua", 5, 5,2);
            productDao.addProduct("Cola", 7,5,2);
            System.out.println(productDao.showProducts());
            System.out.println(productDao.showProductsWithCategory());
            System.out.println(productDao.showProductsWithCategoryByCategoryName("Meat"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
