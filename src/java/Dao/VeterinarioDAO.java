package Dao;

import Interfaces.Crud_medico;
import Modelo.Veterinario;

import com.app.productos.config.Conexion;//esto esa la conexion a la base de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VeterinarioDAO implements Crud_medico {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Veterinario m = new Veterinario();

    @Override
//implementamos todos los metods que tiene la clase interfaces
    public List ListarMedicos() {
        ArrayList<Veterinario> list = new ArrayList<>();
        String consulta = "select * from tb_veterinario ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Veterinario med = new Veterinario();
                med.setIdVeterinario(rs.getInt("IdVeterinario"));
                med.setNombre(rs.getString("nombre"));
                med.setApellido(rs.getString("apellido"));
                med.setDni(rs.getInt("dni"));
                med.setIdEspecialidad(rs.getInt("idEspecialidad"));
                med.setCMPV(rs.getInt("CPMV"));
                med.setFech_nac(rs.getString("fech_nac"));
                med.setFech_reg(rs.getString("fech_reg"));
                med.setSueldo(rs.getDouble("sueldo"));
                med.setDireccion(rs.getString("direccion"));
                med.setTelefono(rs.getString("telefono"));
                med.setCorreo(rs.getString("correo"));
                med.setEstado(rs.getInt("estado"));

                list.add(med);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede listar datos " + ex);
        }
        return list;
    }

    @Override
    //un solo veterianrio
    public Veterinario Obtener(int id) {
        String consulta = "select * from tb_veterinario where IdVeterinario="+ id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                m.setIdVeterinario(rs.getInt("IdVeterinario"));
                m.setNombre(rs.getString("nombre"));
                m.setApellido(rs.getString("apellido"));
                m.setDni(rs.getInt("dni"));
                m.setIdEspecialidad(rs.getInt("idEspecialidad"));
                m.setCMPV(rs.getInt("CPMV"));
                m.setFech_nac(rs.getString("fech_nac"));
                m.setFech_reg(rs.getString("fech_reg"));
                m.setSueldo(rs.getDouble("sueldo"));
                m.setDireccion(rs.getString("direccion"));
                m.setTelefono(rs.getString("telefono"));
                m.setCorreo(rs.getString("correo"));
                m.setEstado(rs.getInt("estado"));

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "ERROR no se puede obtener datos mediante el id EN EL VETERINARIO DAO " + id + " : " + ex);
        }
        return m;

    }

    @Override
    public boolean Agregar(Veterinario med) {
        String consulta = "insert into tb_veterinario (nombre,apellido,dni,idEspecialidad,CPMV,fech_nac,fech_reg,sueldo,direccion,telefono,correo,estado)values('" + med.getNombre() + "','" + med.getApellido() + "','" + med.getDni() + "','" + med.getIdEspecialidad() + "','" + med.getCMPV()+ "','" + med.getFech_nac()+ "','" + med.getFech_reg()+ "','" + med.getSueldo() + "','" + med.getDireccion() + "','" + med.getTelefono() + "','" + med.getCorreo() + "','" + med.getEstado() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean Editar(Veterinario med) {
//       
        String consulta = "update tb_veterinario set nombre='" + med.getNombre() + "',apellido='" + med.getApellido() + "',dni='" + med.getDni() + "',idEspecialidad='" + med.getIdEspecialidad() + "',CPMV='" + med.getCMPV()+ "',fech_nac='" + med.getFech_nac()+ "',fech_reg='" + med.getFech_reg()+ "',sueldo='" + med.getSueldo() + "',direccion='" + med.getDireccion() + "',telefono='" + med.getTelefono() + "',correo='" + med.getCorreo() + "',estado='" + med.getEstado() + "'where idVeterinario="+ med.getIdVeterinario();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean Eliminar(int id) {
        String consulta = "delete from tb_veterinario where IdVeterinario=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }




}
