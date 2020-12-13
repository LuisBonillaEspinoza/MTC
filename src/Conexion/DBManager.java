/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author LUIS
 */
public class DBManager {
    public Connection con;
    public java.sql.Statement st;
    public ResultSet rs;
    public DBManager(){
        String driver = "jdbc:mysql://localhost:3306/mtc";
        String user = "root";
        String password = "";
        try {
            con = DriverManager.getConnection(driver,user,password);
            if(con!=null){
                System.out.println("Conexion Ok");
            }
        } catch (Exception e) {
            System.out.println("Error en la conexion : " + e.getMessage());
        }
    }
 public void EjecutarSQL(String sql){
        try{
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
        }
        catch (Exception E){
            System.out.println("Error 2 : " + E.getMessage());
        }
    }
    public Connection obtenerConexion(){
        return con;
    }
}
