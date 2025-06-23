package utc2.apartmentManage.db;

import java.sql.*;

public class databaseConnect {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                databaseConfig.URL,
                databaseConfig.USER,
                databaseConfig.PASSWORD
        );
    }
}

