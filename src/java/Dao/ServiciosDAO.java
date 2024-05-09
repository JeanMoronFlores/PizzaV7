/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interfaces.Crud_servicios;
import Modelo.Servicios;

import com.app.productos.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAN
 */
public class ServiciosDAO implements Crud_servicios{

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Servicios s = new Servicios();

    @Override
    public List ListarServicios() {
        ArrayList<Servicios> list = new ArrayList<>();
        String consulta = "select * from tb_servicios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servicios ser = new Servicios();
                ser.setIdServicios(rs.getInt("IdServicios"));
                ser.setNombre(rs.getString("nombre"));
                ser.setDescripcion(rs.getString("descripcion"));
                ser.setCosto (rs.getDouble("costo"));
                ser.setEstado(rs.getInt("estado"));
                list.add(ser);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede listar datos desde ServiciosDAO" + ex);
        }
        return list;
    }

    @Override
    public Servicios Obtener(int id) {
        String consulta = "select * from tb_servicios where IdServicios="+ id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                s.setIdServicios(rs.getInt("IdServicios"));
                s.setNombre(rs.getString("nombre"));
                s.setDescripcion(rs.getString("descripcion"));
                s.setCosto (rs.getDouble("costo"));
                s.setEstado(rs.getInt("estado"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede obtener datos mediante el id " + id + " : " + ex);
        }
        return s;
    }

    @Override
    public boolean Agregar(Servicios ser) {
       String consulta = "insert into tb_servicios (nombre,descripcion,costo,estado) values ('" + ser.getNombre()+ "','" + ser.getDescripcion() + "','" + ser.getCosto()+ "','" + ser.getEstado() + "')";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
           
                    
        }
        return false;
    }

    @Override
    public boolean Editar(Servicios ser) {
         String consulta = "update tb_servicios set nombre='"+ ser.getNombre()+ "',descripcion='" + ser.getDescripcion() + "',costo='"+ ser.getCosto()+ "',estado='" + ser.getEstado() + "' where IdServicios=" + ser.getIdServicios();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null,
                    "ERROR no se puede editar datos desde la ServiciosDAO " + ex);
        }
        return false;
    }
    

    @Override
    public boolean Eliminar(int id) {
        String consulta = "delete from tb_servicios where IdServicios="+ id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        return false;
    }
}
