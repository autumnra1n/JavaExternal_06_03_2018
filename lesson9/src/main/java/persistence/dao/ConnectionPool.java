package persistence.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    public static Connection getConnection() throws SQLException {
        return DataSourceFactory.getMySQLDataSource().getConnection();
    }
}
