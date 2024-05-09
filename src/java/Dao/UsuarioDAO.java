/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interfaces.Validar;
import Modelo.Usuario;
import com.app.productos.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author JEAN
 */
public class UsuarioDAO implements Validar {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    @Override
    public int validar(Usuario use) {
        String consulta = "select * from tb_usuario where usuario=? and password=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(consulta);
            /**ps.executeUpdate(); */
            ps.setString(1, use.getUsuario());
            ps.setString(2, use.getPassword());
            rs = ps.executeQuery(); // Cambiar a executeQuery() para obtener resultados
            while (rs.next()) {
                r = r + 1;
                use.setUsuario(rs.getString("usuario"));
                use.setPassword(rs.getString("password"));
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;
    }

}
