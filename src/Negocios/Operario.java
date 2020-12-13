/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Conexion.DBManager;
import Entidad.clsOperario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author LUIS
 */
public class Operario {
    Connection con = new DBManager().obtenerConexion();
    ResultSet rs;
    
    public ArrayList<clsOperario> ObtenerIdentificador(){
        ArrayList<clsOperario> op = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("select operario_txt_iden from operario");
            rs = pst.executeQuery();
            while(rs.next()){
                clsOperario ope = new clsOperario();
                ope.setOperario_txt_iden(rs.getString("operario_txt_iden"));
                op.add(ope);
            }
        } catch (Exception e) {
            System.out.println("Error al Mostrar Operarios : " + e.getMessage());
        }
        return op;
    }
    public void NuevoOperario(clsOperario op){
        try {
            PreparedStatement pst = con.prepareStatement("insert into operario(operario_txt_nom,operario_txt_ape,operario_txt_iden,operario_txt_pass) values(?,?,?,?)");
            pst.setString(1,op.getOperario_txt_nom());
            pst.setString(2,op.getOperario_txt_ape());
            pst.setString(3,op.getOperario_txt_iden());
            pst.setString(4,op.getOperario_txt_pass());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Ingresar Operario : " + e.getMessage());
        }
    }
    public void ModificarOperario(String a,String b,String c,int d){
            try {
                PreparedStatement pst = con.prepareStatement("update operario set operario_txt_nom='" + a + "', operario_txt_ape='" + b + "', operario_bl_est='" + d + "' where operario_txt_iden='" + c + "'");
                pst.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error al Actualizar Datos : " + e.getMessage());
            }
    }
}
