/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dika.db;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException; //kalo eror ini hapus
import java.sql.Connection;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author 10 Pro
 */
public class KoneksiDatabase {
    private static Connection conn;
    private static Properties propert = new Properties();
    
    public static Connection getKoneksi() throws SQLException{
        if(conn == null){
            
            try {
                propert.load(new FileInputStream("C:\\Users\\gilan\\OneDrive\\Dokumen\\NetBeansProjects\\UAS_PBD\\src\\dika\\db\\konfigurasiDatabase.properties"));
            } catch (IOException ex) {
                System.err.println("error mengambil file"+ex);
            
                System.err.println("error membaca file"+ex);
            }
                
                conn = DriverManager.getConnection(propert.getProperty("jdbc.url"),propert.getProperty("jdbc.username"),propert.getProperty("jdbc.password"));  
        }
        return conn;
    }
    
    public static void main (String[] args) throws SQLException{
        if(getKoneksi().equals(conn)){
            System.out.print("sukses terkoneksi");
        }
    }
}
