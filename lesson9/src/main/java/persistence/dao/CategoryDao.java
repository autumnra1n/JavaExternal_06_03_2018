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
public class ImmutableUser {
    private final String username;
    private final String password;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Date creationDate;
    private ImmutableUser(UserBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.creationDate = builder.creationDate;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.email = builder.email;
    }
    public static class UserBuilder {
        private final String username;
        private final String password;
        private final Date creationDate;
        private String firstname;
        private String lastname;
        private String email;
        public UserBuilder(String username, String password) {
            this.username = username;
            this.password = password;
            this.creationDate = new Date();
        }
        public UserBuilder firstName(String firsname) {
            this.firstname = firsname;
            return this;
        }
        public UserBuilder lastName(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }
        public ImmutableUser build() {
            return new ImmutableUser(this);
        }
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public Date getCreationDate() {
        return new Date(creationDate.getTime());
    }


    public static void main(String[] args) {
        ImmutableUser user = new ImmutableUser.UserBuilder("shekhar", "password")
                .firstName("shekhar")
                .lastName("gulati")
                .email("shekhargulati84@gmail.com")
                .build();
    }
}


