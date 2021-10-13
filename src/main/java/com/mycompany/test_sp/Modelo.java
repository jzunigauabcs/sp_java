/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test_sp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jzuniga
 */
public class Modelo {
    public void guardarUsuario(String username, String password) throws SQLException {
        DB db = new DB();
        Connection conn = null;
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            String procedure = "{CALL SP_SAVE_USER(?, ?)}";
            CallableStatement cstm = conn.prepareCall(procedure);
            cstm.setString(1, username);
            cstm.setString(2, password);
            cstm.execute();
            conn.commit();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            conn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            conn.rollback();
        } finally {
            if(conn != null) {
                    conn.setAutoCommit(true);
                    db.close();
            }
        }
    }
}
