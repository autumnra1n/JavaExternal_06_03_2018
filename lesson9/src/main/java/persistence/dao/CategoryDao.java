package persistence.dao;
import java.sql.*;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class CategoryDao {
    // Добавление страны
    public boolean addCategory(String name)
    {
        String sql = "INSERT INTO category (name) VALUES ('"+name+"')";
        Connection con = null;
        try {
            con = ConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try
        {
            con.createStatement().executeUpdate(sql);
            System.out.println("Категория "+name+
                    " успешно добавлена!");
            return true;
        } catch (SQLException e)
        {
            System.out.println("ОШИБКА! Категория "+name+
                    " не добавлена!");
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
    public boolean deleteCategory(int id) throws SQLException
    {
        String sql = "DELETE FROM category WHERE id = "+id;
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
                System.out.println("Категория с идентификатором "
                        + id +" успешно удалена!");
                return true;
            }
            else
            {
                System.out.println("Категория с идентификатором "
                        + id +" не найдена!");
                return false;
            }
        } catch (SQLException e)
        {
            System.out.println(
                    "ОШИБКА при удалении категории с идентификатором "+id);
            System.out.println(" >> "+e.getMessage());
            return false;
        }
        finally {
            con.close();
        }
    }

    public void showCategories()
    {
        String sql = "SELECT * FROM category";
        Connection con = null;
        try {
            con = ConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try
        {
            ResultSet rs = con.createStatement().executeQuery(sql);
            System.out.println("СПИСОК Категорий:");
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(" >> "+ id + " - " + name);
            }
            rs.close();
        } catch (SQLException e)
        {
            System.out.println(
                    "ОШИБКА при получении списка категорий");
            System.out.println(" >> "+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
