/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interfaces.Crud_cita;
import Modelo.Cita;
import com.app.productos.config.Conexion;//conexión a la BBDD
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
public class CitaDAO implements Crud_cita {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cita c = new Cita();

    @Override
    public List ListarCita() {
        ArrayList<Cita> list = new ArrayList<>();
        String consulta = "select * from tb_cita";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cita cit = new Cita();
                cit.setIdCita(rs.getInt("IdCita"));
                cit.setFechaCita(rs.getString("fechaCita"));
                cit.setIdVeterinario(rs.getInt("IdVeterinario"));
                cit.setIdMascota(rs.getInt("IdMascota"));
                cit.setIdDueno(rs.getInt("IdDueño"));
                cit.setIdServicios(rs.getInt("IdServicios"));
                cit.setDetalleServicios(rs.getString("detalleServicios"));

                cit.setObservaciones(rs.getString("observaciones"));
                cit.setIdEstadoCita(rs.getInt("IdEstadoCita"));
                list.add(cit);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede listar datos desde CitaDAO" + ex);
        }
        return list;
    }

    @Override
    public Cita Obtener(int id) {
        String consulta = "select * from tb_cita where IdCita=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setIdCita(rs.getInt("IdCita"));
                c.setFechaCita(rs.getString("fechaCita"));
                c.setIdCita(rs.getInt("IdVeterinario"));
                c.setIdCita(rs.getInt("IdMascota"));
                c.setIdCita(rs.getInt("IdDueño"));
                c.setIdCita(rs.getInt("IdServicios"));
                c.setFechaCita(rs.getString("detalleServicios"));
                c.setFechaCita(rs.getString("observaciones"));
                c.setIdCita(rs.getInt("IdEstadoCita"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede obtener datos mediante el id " + id + " : " + ex);
        }
        return c;
    }

    @Override
    public boolean Agregar(Cita cit) {
        String consulta = "insert into tb_cita (fechaCita,IdVeterinario,IdMascota,IdDueño,IdServicios,detalleServicios,observaciones,IdEstadoCita) values ('" + cit.getIdCita() + "','" + cit.getFechaCita() + "','" + cit.getIdVeterinario() + "','" + cit.getIdCita() + "','" + cit.getIdDueno() + "','" + cit.getIdServicios() + "','" + cit.getDetalleServicios() + "','" + cit.getObservaciones() + "','" + cit.getIdEstadoCita() + "')";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {

        }
        return false;
    }

    @Override
    public boolean Editar(Cita cit) {
        String consulta = "update tb_cita set fechaCita='" + cit.getFechaCita() + "',IdVeterinario='" + cit.getIdVeterinario() + "',IdMascota='" + cit.getIdMascota() + "',IdDueño='" + cit.getIdDueno() + "',IdServicios='" + cit.getIdMascota() + "' ,detalleServicios='" + cit.getIdMascota() + "',observaciones='" + cit.getIdMascota() + "',IdEstadoCita='" + cit.getIdMascota() + "'where IdCita=" + cit.getIdCita();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede editar datos desde la EspecialidadDAO " + ex);
        }
        return false;
    }

    @Override
    public boolean Eliminar(int id) {
        String consulta = "delete from tb_especialidad where IdEspecialidad=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        return false;
    }

}
