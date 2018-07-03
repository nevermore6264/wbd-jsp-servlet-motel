package com.codegym.motel.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost:3306/motel?&useSSL=false";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "123456";

    public static java.sql.Connection getConnection() throws Exception {
        Class.forName(JDBC_DRIVER);
        java.sql.Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return con;
    }
}
