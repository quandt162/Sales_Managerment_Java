/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Love Jav
 */
public class connectionDB {
    private static Connection conn = null;
    public static Connection getConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }catch(ClassNotFoundException ex){
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null,ex);
        }
        try{
            conn = DriverManager.getConnection("jdbc:sqlserver://REDDEVIL\\REDDEVIL:1433;user=sa;password=123456;database=SELL_STORE");
        }catch(SQLException e){
            Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null,e);
            System.out.println(e.toString());
        }
        return conn;
    }
    public void CloseConnection(){
        if(conn != null){
            try {
                if(!conn.isClosed())
                    conn.close();
                conn =null;
            } catch (SQLException ex) {
                Logger.getLogger(connectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
