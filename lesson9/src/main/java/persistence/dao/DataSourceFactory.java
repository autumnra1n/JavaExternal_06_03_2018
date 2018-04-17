package persistence.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

public class DataSourceFactory {

    public static DataSource getMySQLDataSource() {
        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setURL("jdbc:mysql://localhost:3306/products");
        mysqlDS.setUser("root");
        mysqlDS.setPassword("c1a2t3r4u5n6");
        return mysqlDS;
    }
}
