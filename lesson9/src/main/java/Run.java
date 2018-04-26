import persistence.dao.CategoryDao;
import persistence.dao.ProductDao;
import persistence.model.Category;
import service.*;
import validation.validator.ValidatorSAXXSD;

public class Run {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService();
        ProductService productService = new ProductService();
        DOMService domService = new DOMService();
        SAXService saxService = new SAXService();
        categoryService.addCategory("Meat");
        categoryService.addCategory("Water");
        productService.addProduct("Beef",15,16,1);
        productService.addProduct("Sausage", 7, 9,1);
        productService.addProduct("Bonaqua", 5, 5,2);
        productService.addProduct("Cola", 7,5,2);
        System.out.println(productService.showProducts());
        System.out.println(productService.showProductsWithCategory());
        System.out.println(productService.showProductsWithCategoryByCategoryName("Meat"));
        domService.createCategoryDocument(1,"daads","C:\\Users\\Michael\\MavensProjectsCources\\lesson9\\src\\main\\resources\\xml\\category.xml");
        ValidatorSAXXSD.validate("C:\\Users\\Michael\\MavensProjectsCources\\lesson9\\src\\main\\resources\\xml\\category.xml","C:\\Users\\Michael\\MavensProjectsCources\\lesson9\\src\\main\\resources\\xml\\category.xsd");
        saxService.parseDocument("C:\\Users\\Michael\\MavensProjectsCources\\lesson9\\src\\main\\resources\\xml\\category.xml");
    }
}
