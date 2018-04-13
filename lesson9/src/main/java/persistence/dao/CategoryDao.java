package persistence.dao;
import java.sql.*;
import com.mysql.jdbc.Driver;
public class CategoryDao {
    private Connection con = null;
    private Statement stmt = null;

    public CategoryDao() throws Exception{
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
    public boolean addCategory(String name)
    {
        String sql = "INSERT INTO category (name) VALUES ('"+name+"')";
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
    }
    // Удаление страны
    public boolean deleteCategory(int id) throws SQLException
    {
        String sql = "DELETE FROM category WHERE id = "+id;
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
    }

    public void showCategories()
    {
        String sql = "SELECT * FROM category";
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
    }
}
