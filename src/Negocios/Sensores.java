/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsSensores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LUIS
 */
public class Sensores {

    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;

    public void IngresarVelocidades(clsSensores sen) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into sensores(sensores_num_vel1,sensores_num_vel2,sensores_num_vel3,sensores_num_vel4,sensores_num_vel5,sensores_num_vel6) values(?,?,?,?,?,?)");
            pst.setString(1, sen.getSensores_num_ve11());
            pst.setString(2, sen.getSensores_num_vel2());
            pst.setString(3, sen.getSensores_num_vel3());
            pst.setString(4, sen.getSensores_num_vel4());
            pst.setString(5, sen.getSensores_num_vel5());
            pst.setString(6, sen.getSensores_num_vel6());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Velocidades : " + e.getMessage());
        }
    }

    public int ObtenerUltimoId() {
        int a = 0;
        try {
            PreparedStatement pst = con.prepareStatement("select max(sensores_num_id ) from sensores");
            rs = pst.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error al Obtener id : " + e.getMessage());
        }
        return a;
    }

}
