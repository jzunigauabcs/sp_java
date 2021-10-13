/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_sp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jzuniga
 */
public class DB {
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "t00r";
    private final String DB_NAME = "TEST_SP";
    private final String QUERY_PARAMS = "?serverTimezone=UTC";
    
    private Connection conn;

    public DB() {
        this.conn = null;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        this.conn = DriverManager.getConnection(URL+DB_NAME+QUERY_PARAMS, DB_USER, DB_PASSWORD);
        return this.conn;
    }
    
    public void close() throws SQLException {
        this.conn.close();
    }
}
