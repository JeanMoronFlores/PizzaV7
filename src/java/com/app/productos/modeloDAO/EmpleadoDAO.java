package com.app.productos.modeloDAO;

import com.app.productos.interfaces.IEmpleado;
import com.app.productos.modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class EmpleadoDAO implements IEmpleado {

    private static final Logger LOG = Logger.getGlobal();

    @Override
    public Empleado getEmpleadoUserPass(String user, String pass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Empleado getEmpleadoUserPass(String user, String pass, Connection con) {
        Empleado empleado = null;
        String sql = "SELECT e.i_num_id_emp, e.c_dni, e.c_nombres, e.c_correo, u.c_user, u.c_perfil "
                + "FROM empleado e INNER JOIN usuario u ON e.i_num_id_user = u.i_num_id_user "
                + "WHERE u.c_user = ? AND u.c_password = ?";
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, user);
                ps.setString(2, pass);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        empleado = new Empleado();
                        empleado.setId(rs.getInt("e.i_num_id_emp"));
                        empleado.setDni(rs.getString("e.c_dni"));
                        empleado.setNombres(rs.getString("e.c_nombres"));
                        empleado.setCorreo(rs.getString("e.c_correo"));
                        empleado.setUser(rs.getString("u.c_user"));
                        empleado.setPerfil(rs.getString("u.c_perfil"));
                    }
                }
            }
        } catch (SQLException e) {
            LOG.info("Error getEmpleadoUserPass:" + e.toString());
        }
        return empleado;
    }
}
