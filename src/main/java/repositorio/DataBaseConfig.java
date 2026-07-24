package repositorio;

import java.sql.*;

import javax.sql.DataSource;

public class DataBaseConfig {

    private static DataSource dataSource = DataBaseConfig.createDataSource();

    public static DataSource createDataSource() {

        return dataSource;
    }
}
