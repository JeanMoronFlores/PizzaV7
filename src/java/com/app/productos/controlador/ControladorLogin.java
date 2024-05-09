package com.app.productos.controlador;

import com.app.productos.interfaces.IEmpleado;
import com.app.productos.modelo.Empleado;
import com.app.productos.modeloDAO.EmpleadoDAO;
import com.app.productos.config.Conexion; // Importa la clase Conexion
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

public class ControladorLogin extends HttpServlet {

    private final IEmpleado empDAO = new EmpleadoDAO();
    private final Conexion conexion = new Conexion(); // Instancia de la clase Conexion

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();

        switch (accion) {
            case "Login":
                String user = request.getParameter("txtUser");
                String pass = request.getParameter("txtPass");

                // Utiliza la conexión para obtener el empleado
                Empleado e = empDAO.getEmpleadoUserPass(user, pass, conexion.getConnection());

                if (e != null) {
                    session.setAttribute("Empleado", e);
                    if (e.getPerfil().equals("ADMINISTRADOR")) {
                        request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                    } else {
                        request.setAttribute("Mensaje", "El Perfil no es Administrador");
                        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
            case "Salir":
                session.setAttribute("Empleado", new Empleado());
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
