/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsSemaforo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LUIS
 */
public class Semaforo {

    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;

    public void IngresarSemaforo(clsSemaforo se) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into semaforo(semaforos_txt_est,semaforos_txt_origen,semaforos_date_feho,semaforos_do_velpro,sensores_num_cod) values(?,?,?,?,?)");
            pst.setString(1, se.getSemaforos_txt_est());
            pst.setString(2, se.getSemaforos_txt_origen());
            pst.setString(3, se.getSemaforos_date_feho());
            pst.setString(4, se.getSemaforos_do_velpro());
            pst.setString(5, se.getSensores_num_cod());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Semaforo : " + e.getMessage());
        }
    }

    public void IngresarSemaforo1(clsSemaforo se) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into semaforo(semaforos_txt_est,semaforos_txt_origen,semaforos_date_feho,semaforos_do_velpro,operario_num_id,sensores_num_cod) values(?,?,?,?,?,?)");
            pst.setString(1, se.getSemaforos_txt_est());
            pst.setString(2, se.getSemaforos_txt_origen());
            pst.setString(3, se.getSemaforos_date_feho());
            pst.setString(4, se.getSemaforos_do_velpro());
            pst.setString(5, se.getOperario_num_id());
            pst.setString(6, se.getSensores_num_cod());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Semaforo 1 : " + e.getMessage());
        }
    }

    public void IngresarSemaforo2(clsSemaforo se) {
        try {
            PreparedStatement pst = con.prepareStatement("insert into semaforo(semaforos_txt_est,semaforos_txt_origen,semaforos_date_feho,semaforos_do_velpro,sensores_num_cod) values(?,?,?,?,?)");
            pst.setString(1, se.getSemaforos_txt_est());
            pst.setString(2, se.getSemaforos_txt_origen());
            pst.setString(3, se.getSemaforos_date_feho());
            pst.setString(4, se.getSemaforos_do_velpro());
            pst.setString(5, se.getSensores_num_cod());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Semaforo 2 : " + e.getMessage());
        }
    }

    public int ObtenerUltimoSema() {
        int a = 0;
        try {
            PreparedStatement pst = con.prepareStatement("select max(semaforo_num_id) from semaforo");
            rs = pst.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error al Obtener id : " + e.getMessage());
        }
        return a;
    }

    public void AtualizarVel(String a, String b, String c, String d, String e) {
        try {
            PreparedStatement pst = con.prepareStatement("update semaforo set semaforos_txt_est='" + a + "', semaforos_txt_origen='" + b + "', semaforos_date_feho='" + c + "', semaforos_do_velpro ='" + d + "',sensores_num_cod='" + e + "' where semaforo_num_id='" + ObtenerUltimoSema() + "'");
            pst.executeUpdate();
        } catch (Exception g) {
            System.out.println("Errror al Actualizar Datos : " + g.getMessage());
        }
    }

    public void DeleteUltimo() {
        try {
            PreparedStatement pst = con.prepareStatement("Delete from semaforo where semaforo_num_id='" + ObtenerUltimoSema() + "'");
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Eliminar : " + e.getMessage());
        }
    }
}
