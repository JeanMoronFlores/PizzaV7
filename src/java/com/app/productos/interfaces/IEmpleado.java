
package com.app.productos.interfaces;

import com.app.productos.modelo.Empleado;
import java.sql.Connection;

public interface IEmpleado {
    public Empleado getEmpleadoUserPass(String user,String pass);

    public Empleado getEmpleadoUserPass(String user, String pass, Connection connection);
}
