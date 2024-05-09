/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author JEAN
 */
import Modelo.Dueno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.app.productos.config.Conexion;
import Interfaces.Crud_dueno;

public class DuenoDAO implements Crud_dueno {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Dueno d = new Dueno();

    @Override
    public List ListarDueno() {
        ArrayList<Dueno> list = new ArrayList<>();
        String consulta = "SELECT * FROM tb_dueño";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Dueno dueño = new Dueno();
                dueño.setIdDueno(rs.getInt("idDueño"));
                dueño.setNombre(rs.getString("nombre"));
                dueño.setApellido(rs.getString("apellido"));
                dueño.setDni(rs.getInt("dni"));
                dueño.setEdad(rs.getInt("edad"));
                dueño.setSexo(rs.getString("sexo"));
                dueño.setFech_nac(rs.getString("fech_nac"));
                dueño.setFech_reg(rs.getString("fech_reg"));
                dueño.setDireccion(rs.getString("direccion"));
                dueño.setTelefono(rs.getString("telefono"));
                dueño.setCorreo(rs.getString("correo"));
                dueño.setEstado(rs.getInt("estado"));
                list.add(dueño);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR al listar los dueños desde El DueñoDAO " + ex);
        }
        return list;
    }

    @Override
    public Dueno Obtener(int id) {
        String consulta = "SELECT * FROM tb_dueño WHERE idDueño=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                d.setIdDueno(rs.getInt("idDueño"));
                d.setNombre(rs.getString("nombre"));
                d.setApellido(rs.getString("apellido"));
                d.setDni(rs.getInt("dni")); // Cambiado a getInt()
                d.setEdad(rs.getInt("edad")); // Cambiado a getInt()
                d.setSexo(rs.getString("sexo"));
                d.setFech_nac(rs.getString("fech_nac"));
                d.setFech_reg(rs.getString("fech_reg"));
                d.setDireccion(rs.getString("direccion"));
                d.setTelefono(rs.getString("telefono"));
                d.setCorreo(rs.getString("correo"));
                d.setEstado(rs.getInt("estado"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR al obtener el dueño: " + ex);
        }
        return d;
    }

    @Override
    public boolean Agregar(Dueno dueño) {
        String consulta = "INSERT INTO tb_dueño (nombre, apellido, dni, edad, sexo, fech_nac, fech_reg, direccion, telefono, correo, estado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.setString(1, dueño.getNombre());
            ps.setString(2, dueño.getApellido());
            ps.setInt(3, dueño.getDni());
            ps.setInt(4, dueño.getEdad());
            ps.setString(5, dueño.getSexo());
            ps.setString(6, dueño.getFech_nac());
            ps.setString(7, dueño.getFech_reg());
            ps.setString(8, dueño.getDireccion());
            ps.setString(9, dueño.getTelefono());
            ps.setString(10, dueño.getCorreo());
            ps.setInt(11, dueño.getEstado());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR al agregar el dueño desde el DAO: " + ex);
            return false;
        }
    }

    @Override
    public boolean Editar(Dueno due) {
        String consulta = "update tb_dueño set nombre='"+ due.getNombre()+ "', apellido='"+ due.getApellido()+ "', dni='"+ due.getDni()+ "', edad='"+ due.getEdad()+ "', sexo='"+ due.getSexo() +"', fech_nac='"+ due.getFech_nac()+ "', fech_reg='"+ due.getFech_reg()+ "', direccion='"+ due.getDireccion()+ "', telefono='"+ due.getTelefono()+ "', correo='"+ due.getCorreo()+ "', estado='"+ due.getEstado()+ "' where IdDueño=" + due.getIdDueno();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                    "ERROR al editar el dueño: " + ex);
            
        }
        return false;
    }

    @Override
    public boolean Eliminar(int id) {
        String consulta = "DELETE FROM tb_dueño WHERE idDueño=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERROR al eliminar el dueño: " + ex);
            return false;
        }
    }
}
