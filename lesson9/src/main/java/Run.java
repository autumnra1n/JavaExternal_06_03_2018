package persistence;

import persistence.dao.CategoryDao;
import persistence.dao.ProductDao;
import service.DOMService;
import service.SAXService;
import validation.validator.ValidatorSAXXSD;

import javax.xml.validation.Validator;

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
        DOMService domService = new DOMService();
        domService.createCategoryDocument(1,"daads","C:\\Users\\Michael\\MavensProjectsCources\\lesson9\\src\\main\\resources\\xml\\category.xml");
        ValidatorSAXXSD.validate("C:\\Users\\Michael\\MavensProjectsCources\\lesson9\\src\\main\\resources\\xml\\category.xml","C:\\Users\\Michael\\MavensProjectsCources\\lesson9\\src\\main\\resources\\xml\\category.xsd");
        SAXService.parseDocument("C:\\Users\\Michael\\MavensProjectsCources\\lesson9\\src\\main\\resources\\xml\\category.xml");
    }
}
