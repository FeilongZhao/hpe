package com.hpe.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBHelper {
    
    static String URL = "jdbc:mysql://localhost:3306/life_assistant?useUnicode=true&characterEncoding=UTF-8";
    static String DRIVER = "com.mysql.jdbc.Driver";
    static String ROOT = "root";
    static String PASSWORD = "";
    static Connection connection = null;
    
    public static Connection getConnection() throws SQLException {
        
        return (Connection) DriverManager.getConnection(URL, ROOT, PASSWORD);
    }
    

}
