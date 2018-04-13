package persistence.dao;

import persistence.model.Category;
import persistence.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDao {

    private Connection con = null;
    private Statement stmt = null;

    public ProductDao() throws Exception{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/products";
        con = DriverManager.getConnection(url,"root","c1a2t3r4u5n6");
    }

    // Завершение работы
    public void stop() throws SQLException
    {
        con.close();
    }

    // Добавление страны
    public boolean addProduct(String name, int price, int weight, int id)
    {
        String sql = "INSERT INTO product (name, price, weight, id) VALUES ('"+name+"', '"+price+"', '"+weight+"', '"+id+"')";
        try
        {
            con.createStatement().executeUpdate(sql);
            System.out.println("Продукт "+name+
                    " успешно добавлен!");
            return true;
        } catch (SQLException e)
        {
            System.out.println("ОШИБКА! Категория "+name+
                    " не добавлена!");
            System.out.println(" >> "+e.getMessage());
            return false;
        }
    }
    // Удаление страны
    public boolean deleteProduct(int id) throws SQLException
    {
        String sql = "DELETE FROM product WHERE product_id = "+id;
        try
        {
            int c = stmt.executeUpdate(sql);
            if (c>0)
            {
                System.out.println("Продукт с идентификатором "
                        + id +" успешно удален!");
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
            System.out.println(
                    "ОШИБКА при удалении продукта с идентификатором "+id);
            System.out.println(" >> "+e.getMessage());
            return false;
        }
    }

    public List showProducts()
    {
        String sql = "SELECT * FROM product";
        List<Product> list = new ArrayList<Product>();
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
            System.out.println(
                    "ОШИБКА при получении списка продуктов");
            System.out.println(" >> "+e.getMessage());
        }
        return list;
    }

    public Map showProductsWithCategory()
    {
        String sql = "SELECT * FROM product p JOIN category c ON  p.id = c.id";
        Map <Category,Product> map = new HashMap<Category, Product>();
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
            System.out.println(
                    "ОШИБКА при получении списка продуктов");
            System.out.println(" >> "+e.getMessage());
        }
        return map;
    }

    public Map showProductsWithCategoryByCategoryName(String name)
    {
        String sql = "SELECT * FROM product p JOIN category c ON  p.id = c.id WHERE c.name = '"+name+"'";
        Map <Category,Product> map = new HashMap<Category, Product>();
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
            System.out.println(
                    "ОШИБКА при получении списка продуктов");
            System.out.println(" >> "+e.getMessage());
        }
        return map;
    }
}
