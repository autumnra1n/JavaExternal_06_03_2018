package persistence.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.model.Category;
import persistence.model.Product;
import utils.QueryManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDao {

    private static final Logger log = LogManager.getLogger(ProductDao.class);
    private static final String ADD_PRODUCT = QueryManager.getProperty("productInsert");
    private static final String DELETE_PRODUCT = QueryManager.getProperty("productDeleteById");
    private static final String SHOW_PRODUCTS = QueryManager.getProperty("productSelectAll");
    private static final String SHOW_PRODUCTS_WITH_CATEGORY = QueryManager.getProperty("productShowAllWithCategory");
    private static final String SHOW_PRODUCTS_WITH_CATEGORY_BY_CATEGORY_NAME = QueryManager.getProperty("showProductsWithCategoryByCategoryName");
    private Savepoint savepoint;

    public boolean addProduct(String name, int price, int weight, int id) {
        try (Connection con = ConnectionPool.getConnection()) {
            con.setAutoCommit(false);
            savepoint = con.setSavepoint("Save");
            try (PreparedStatement preparedStatement = con.prepareStatement(ADD_PRODUCT)) {
                preparedStatement.setString(1,name);
                preparedStatement.setInt(2,price);
                preparedStatement.setInt(3,weight);
                preparedStatement.setInt(4,id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                con.rollback(savepoint);
                System.out.println("ОШИБКА! Категория " + name +
                        " не добавлена!");
                log.error("Error", e);
                System.out.println(" >> " + e.getMessage());
                return false;
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean deleteProduct(int id){
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(DELETE_PRODUCT)) {
                preparedStatement.setInt(1,id);
               return true;
        } catch (SQLException e)        {
            log.error("Error", e);
            System.out.println(
                    "ОШИБКА при удалении продукта с идентификатором "+id);
            System.out.println(" >> "+e.getMessage());
            return false;
        }
    }

    public List showProducts(){
        List <Product> list = new ArrayList<>();
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SHOW_PRODUCTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("СПИСОК Продуктов:");
            while (rs.next())
            {
                int id = rs.getInt("category_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int weight = rs.getInt("weight");
                list.add(new Product(id,name,price,weight));
                System.out.println(" >> "+ id + " - " + name +" "+weight+ " "+price);
            }
            rs.close();
        } catch (SQLException e)
        {
            log.error("Error", e.getCause());
            System.out.println(
                    "ОШИБКА при получении списка продуктов");
            System.out.println(" >> "+e.getMessage());
        }
        return list;
    }

    public Map showProductsWithCategory(){
        Map <Category,Product> map = new HashMap<Category, Product>();
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SHOW_PRODUCTS_WITH_CATEGORY)) {
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("СПИСОК Продуктов и их категорий:");
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int weight = rs.getInt("weight");
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("c.name");
                map.put(new Category(categoryId, categoryName), new Product(id,name,price,weight));
                System.out.println(" >> "+ id + " - " + name +" "+weight+ " "+price +" "+categoryId +" "+categoryName);
            }
            rs.close();
        } catch (SQLException e)
        {
            log.error("Error", e);
            System.out.println(
                    "ОШИБКА при получении списка продуктов");
            System.out.println(" >> "+e.getMessage());
        }
        return map;
    }

    public Map showProductsWithCategoryByCategoryName(String name) {
        Map <Category,Product> map = new HashMap<Category, Product>();
        try (Connection con = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SHOW_PRODUCTS_WITH_CATEGORY_BY_CATEGORY_NAME)) {
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("СПИСОК Продуктов категории:");
            while (rs.next())
            {
                int categoryId = rs.getInt("id");
                String categoryName = rs.getString("c.name");
                int id = rs.getInt("category_id");
                String productName = rs.getString("name");
                int price = rs.getInt("price");
                int weight = rs.getInt("weight");
                map.put(new Category(categoryId, categoryName), new Product(id,productName,price,weight));
                System.out.println(" >> "+ id + " - " + productName +" "+weight+ " "+price +" "+categoryId +" "+categoryName);
            }
            rs.close();
        } catch (SQLException e)
        {
            log.error("Error", e);
            System.out.println(
                    "ОШИБКА при получении списка продуктов");
            System.out.println(" >> "+e.getMessage());
        }
        return map;
    }
}
