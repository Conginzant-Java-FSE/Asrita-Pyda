package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static String url = "jdbc:mysql://localhost:3306/JDBCApplication";
    private static String user = "root";
    private static String password = "MySQL@2024";

    private DBConnection() {}

    public static Connection getConnection()  {

        try {
            return DriverManager.getConnection(url, user, password);
        }catch (SQLException se) {
            throw new RuntimeException(se);
        }

    }

}

//      ------------------------------------------------------
//      |  Layer	     |         Responsibility            |
//      ------------------------------------------------------
//      | Controller     |	        Take input               |
//      |  Service       |        Validate input             |
//      |   Model	     |        data structure             |
//      |   DAO	         |   Save to database(executes sql)  |
//      ------------------------------------------------------
