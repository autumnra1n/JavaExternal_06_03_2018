package persistence.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.model.Category;
import persistence.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDao {

    private static final Logger log = LogManager.getLogger(ProductDao.class);
    private Savepoint savepoint1;

    // Добавление страны
    public boolean addProduct(String name, int price, int weight, int id){
        String sql = "INSERT INTO product (name, price, weight, id) VALUES ('"+name+"', '"+price+"', '"+weight+"', '"+id+"')";
        Connection con = null;
        try {
            con = ConnectionPool.getConnection();
            savepoint1 = con.setSavepoint("Savepoint1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            con.setAutoCommit(false);
            int c = con.createStatement().executeUpdate(sql);
            System.out.println("Продукт "+name+
                    " успешно добавлен!");
            log.info("Result Set of adding "+ c);
            con.commit();
            return true;
        }
        catch (SQLException e)
        {
            try {
                con.rollback(savepoint1);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("ОШИБКА! Категория "+name+
                    " не добавлена!");
            log.error("Error", e);
            System.out.println(" >> "+e.getMessage());
            return false;
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // Удаление страны
    public boolean deleteProduct(int id) throws SQLException
    {
        String sql = "DELETE FROM product WHERE product_id = "+id;
        Connection con = null;
        try {
            con = ConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try
        {
            int c = con.createStatement().executeUpdate(sql);
            if (c>0)
            {
                System.out.println("Продукт с идентификатором "
                        + id +" успешно удален!");
                log.info("Result Set of delete"+ c);
                return true;
            }
            else
            {
                System.out.println("Продукт с идентификатором "
                        + id +" не найден!");
                return false;
            }
        } catch (SQLException e)
        {
            log.error("Error", e);
            System.out.println(
                    "ОШИБКА при удалении продукта с идентификатором "+id);
            System.out.println(" >> "+e.getMessage());
            return false;
        }
        finally {
            con.close();
        }
    }

    public List showProducts()
    {
        String sql = "SELECT * FROM product";
        List<Product> list = new ArrayList<Product>();
        Connection con = null;
        try {
            con = ConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try
        {
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("СПИСОК Продуктов:");
            while (rs.next())
            {
                int id = rs.getInt("product_id");
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
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                log.error("Error", e);
                e.printStackTrace();
            }
        }
        return list;
    }

    public Map showProductsWithCategory() throws SQLException {
        String sql = "SELECT * FROM product p JOIN category c ON  p.id = c.id";
        Map <Category,Product> map = new HashMap<Category, Product>();
        Connection con = null;
        try {
            con = ConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try
        {
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("СПИСОК Продуктов и их категорий:");
            while (rs.next())
            {
                int id = rs.getInt("product_id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int weight = rs.getInt("weight");
                int categoryId = rs.getInt("id");
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
        finally {
            con.close();
        }
        return map;
    }

    public Map showProductsWithCategoryByCategoryName(String name)
    {
        String sql = "SELECT * FROM product p JOIN category c ON  p.id = c.id WHERE c.name = '"+name+"'";
        Map <Category,Product> map = new HashMap<Category, Product>();
        Connection con = null;
        try {
            con = ConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try
        {
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("СПИСОК Продуктов категории:");
            while (rs.next())
            {
                int categoryId = rs.getInt("id");
                String categoryName = rs.getString("c.name");
                int id = rs.getInt("product_id");
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
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                log.error("Error", e.getCause());
                e.printStackTrace();
            }
        }
        return map;
    }
}
