package persistence.dao;
import java.sql.*;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import utils.QueryManager;

public class CategoryDao {

    private static final String ADD_CATEGORY = QueryManager.getProperty("addCategory");
    private static final String DELETE_CATEGORY = QueryManager.getProperty("deleteCategory");
    private static final String showCategories = QueryManager.getProperty("showCategories");

    public boolean addCategory(String name) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_CATEGORY)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ОШИБКА! Категория " + name +
                    " не добавлена!");
            System.out.println(" >> " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean deleteCategory(int id) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(
                    "ОШИБКА при удалении категории с идентификатором " + id);
            System.out.println(" >> " + e.getMessage());
            return false;
        }
    }

    public void showCategories() {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(showCategories)) {
            preparedStatement.executeQuery();
            try (ResultSet rs = preparedStatement.executeQuery()){
                System.out.println("СПИСОК Категорий:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    System.out.println(" >> " + id + " - " + name);
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(
                    "ОШИБКА при получении списка категорий");
            System.out.println(" >> " + e.getMessage());
        }
    }
}



