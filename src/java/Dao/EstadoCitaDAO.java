/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Interfaces.Crud_estadocita;
import Modelo.EstadoCita;

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
public class EstadoCitaDAO implements Crud_estadocita {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    EstadoCita e = new EstadoCita();

//    @Override
//    public List ListarEspecialidades() {
//        ArrayList<Especialidad> list = new ArrayList<>();
//        String consulta = "select * from tb_especialidad";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(consulta);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Especialidad esp = new Especialidad();
//                esp.setIdEspecialidad(rs.getInt("IdEspecialidad"));
//                esp.setNombre(rs.getString("nombre"));
//                esp.setDescripcion(rs.getString("descripcion"));
//                esp.setEstado(rs.getInt("estado"));
//                list.add(esp);
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null,
//                    "ERROR no se puede listar datos desde EspecialidadDAO" + ex);
//        }
//        return list;
//    }

    @Override
    public EstadoCita Obtener(int id) {
        String consulta = "select * from tb_estado_cita where IdEstadoCita="+ id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                e.setIdEstadoCita(rs.getInt("IdEstadoCita"));
                e.setDescripcion(rs.getString("descripcion"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede obtener datos mediante el id " + id + " : " + ex);
        }
        return e;
    }

//    @Override
//    public boolean Agregar(Especialidad esp) {
//       String consulta = "insert into tb_especialidad (nombre,descripcion,estado) values ('" + esp.getNombre()+ "','" + esp.getDescripcion() + "','" + esp.getEstado() + "')";
//
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(consulta);
//            ps.executeUpdate();
//        } catch (Exception ex) {
//           
//                    
//        }
//        return false;
//    }

//    @Override
//    public boolean Editar(Especialidad esp) {
//         String consulta = "update tb_especialidad set nombre='"+ esp.getNombre()+ "',descripcion='" + esp.getDescripcion() + "',estado='" + esp.getEstado() + "' where IdEspecialidad=" + esp.getIdEspecialidad();
//        try {
//            con=cn.getConnection();
//            ps=con.prepareStatement(consulta);
//            ps.executeUpdate();
//        } catch (Exception ex) {
//             JOptionPane.showMessageDialog(null,
//                    "ERROR no se puede editar datos desde la EspecialidadDAO " + ex);
//        }
//        return false;
//    }
    

//    @Override
//    public boolean Eliminar(int id) {
//        String consulta = "delete from tb_especialidad where IdEspecialidad="+ id;
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(consulta);
//            ps.executeUpdate();
//        } catch (Exception ex) {
//        }
//        return false;
//    }

    @Override
    public List ListarEstadoCita() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Agregar(EstadoCita est) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Editar(EstadoCita est) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
