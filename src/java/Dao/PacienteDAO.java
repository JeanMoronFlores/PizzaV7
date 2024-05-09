/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interfaces.Crud_pacientes;
import Modelo.Paciente;
import com.app.productos.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAN
 */
public class PacienteDAO implements Crud_pacientes {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Paciente p = new Paciente();

    @Override
    public List ListarPacientes() {
        ArrayList<Paciente> list = new ArrayList<>();
        String consulta = "select * from tb_paciente";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setIdPAciente(rs.getInt("idPaciente"));
                pac.setNombre(rs.getString("nombre"));
                pac.setApellido(rs.getString("apellido"));
                pac.setDni(rs.getString("dni"));
                pac.setEdad(rs.getString("edad"));
                pac.setSexo(rs.getString("sexo"));
                pac.setPeso(rs.getString("peso"));
                pac.setEstatura(rs.getString("estatura"));
                pac.setImc(rs.getString("imc"));
                pac.setFech_nac(rs.getString("fech_nac"));
                pac.setFech_reg(rs.getString("fech_reg"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setTelefono(rs.getString("telefono"));
                pac.setCorreo(rs.getString("correo"));
                pac.setEstado(rs.getInt("estado"));
                list.add(pac);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede listar datos " + ex);
        }
        return list;
    }

    @Override
    public Paciente Obtener(int id) {
        String consulta = "select * from tb_paciente where IdPAciente=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdPAciente(rs.getInt("idPaciente"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDni(rs.getString("dni"));
                p.setEdad(rs.getString("edad"));
                p.setSexo(rs.getString("sexo"));
                p.setPeso(rs.getString("peso"));
                p.setEstatura(rs.getString("estatura"));
                p.setImc(rs.getString("imc"));
                p.setFech_nac(rs.getString("fech_nac"));
                p.setFech_reg(rs.getString("fech_reg"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreo(rs.getString("correo"));
                p.setEstado(rs.getInt("estado"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede obtener datos mediante el id " + id + " : " + ex);
        }
        return p;

    }

    @Override
    public boolean Agregar(Paciente pac) {
        String consulta = "insert into tb_paciente (nombre,apellido,dni,edad,sexo,peso,estatura,imc,fech_nac,fech_reg,direccion,telefono,correo,estado)values('" + pac.getNombre() + "','" + pac.getApellido() + "','" + pac.getDni() + "','" + pac.getEdad() + "','" + pac.getSexo() + "','" + pac.getPeso() + "','" + pac.getEstatura() + "','" + pac.getImc() + "','" + pac.getFech_nac() + "','" + pac.getFech_reg() + "','" + pac.getDireccion() + "','" + pac.getTelefono() + "','" + pac.getCorreo() + "','" + pac.getEstado() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede agregar datos " + ex);

        }
        return false;

    }

    @Override
    public boolean Editar(Paciente pac) {
        String consulta = "update tb_paciente set nombre='" + pac.getNombre() + "',apellido='" + pac.getApellido() + "',dni='" + pac.getDni() + "',edad='" + pac.getEdad() + "',sexo='" + pac.getSexo() + "',peso='" + pac.getPeso() + "',estatura='" + pac.getEstatura() + "',imc='" + pac.getImc() + "',fech_nac='" + pac.getFech_nac() + "',fech_reg='" + pac.getFech_reg() + "',direccion='" + pac.getDireccion() + "',telefono='" + pac.getTelefono() + "',correo='" + pac.getCorreo() + "' where IdPaciente=" + pac.getIdPAciente();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede editar datos " + ex);
        }
        return false;

    }

    @Override
    public boolean Eliminar(int id) {
        String consulta = "delete from tb_paciente where IdPaciente=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        return false;

    }

}
