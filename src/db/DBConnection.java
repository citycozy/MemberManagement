package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static db.DBInfo.*;

public class DBConnection {

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(CLASSNAME.getValue());
        return DriverManager.getConnection(
                URL.getValue(), USER.getValue(), PASSWORD.getValue());
    }

}
