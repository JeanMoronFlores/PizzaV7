/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import Interfaces.Crud_mascota;
import com.app.productos.config.Conexion;

/**
 *
 * @author JEAN
 */
public class MascotaDAO implements Crud_mascota {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Mascota p = new Mascota();

    @Override
    
    /*deberia cambiarse a ListarMascota para saber a que se ahce*/
    public List ListarMascota() {
        ArrayList<Mascota> list = new ArrayList<>();
        String consulta = "select * from tb_mascota";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mascota pac = new Mascota();
                pac.setIdMascota(rs.getInt("idMascota"));
                pac.setNombre(rs.getString("nombre"));
                pac.setIdDueno(rs.getInt("idDueño"));
                pac.setEspecie(rs.getString("especie"));
                pac.setRaza(rs.getString("raza"));
                pac.setColor(rs.getString("color"));
                pac.setSexo(rs.getString("sexo"));
                pac.setEdad(rs.getString("edad"));
                pac.setPeso(rs.getString("peso"));
                pac.setFech_nac(rs.getString("fech_nac"));
                pac.setFech_reg(rs.getString("fech_reg"));
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
    public Mascota Obtener(int id) {
        String consulta = "select * from tb_mascota where IdMascota=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdMascota(rs.getInt("idMascota"));
                p.setNombre(rs.getString("nombre"));
                p.setIdDueno(rs.getInt("idDueño"));
                p.setEspecie(rs.getString("especie"));
                p.setRaza(rs.getString("raza"));
                p.setColor(rs.getString("color"));
                p.setSexo(rs.getString("sexo"));
                p.setEdad(rs.getString("edad"));
                p.setPeso(rs.getString("peso"));
                p.setFech_nac(rs.getString("fech_nac"));
                p.setFech_reg(rs.getString("fech_reg"));
                p.setEstado(rs.getInt("estado"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede obtener datos mediante el id en MascotaID " + id + " : " + ex);
        }
        return p;

    }

    @Override
    public boolean Agregar(Mascota pac) {
        String consulta = "insert into tb_mascota (nombre,idDueño,especie,raza,color,sexo,edad,peso,fech_nac,fech_reg,estado)"
                + "values('" + pac.getNombre() + "','" + pac.getIdDueno()+ "','" + pac.getEspecie()+ "','" + pac.getRaza()+ "','" + pac.getColor()+ "','" + pac.getSexo()+ "','" + pac.getEdad() + "','" + pac.getPeso()+ "','" + pac.getFech_nac() + "','" + pac.getFech_reg() + "','" + pac.getEstado() + "')";
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
    public boolean Editar(Mascota pac) {
        String consulta = "UPDATE tb_mascota SET nombre='" + pac.getNombre() + "', idDueño=" + pac.getIdDueno()+ ", especie='" + pac.getEspecie() + "', raza='" + pac.getRaza() + "', color='" + pac.getColor() + "', sexo='" + pac.getSexo() + "', edad='" + pac.getEdad() + "', peso='" + pac.getPeso() + "', fech_nac='" + pac.getFech_nac() + "', fech_reg='" + pac.getFech_reg() + "', estado=" + pac.getEstado() + " WHERE IdMascota=" + pac.getIdMascota();

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
        String consulta = "delete from tb_mascota where IdMascota=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
        }
        return false;

    }

}
