/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Dao.EspecialidadDAO;
import Modelo.Especialidad;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JEAN
 */
public class Ctrl_especialidad extends HttpServlet {

    String vistalistar = "ListarEspecialidad.jsp";
    String vistaagregar = "vistas/AgregarEspecialidad.jsp";
    String vistaeditar = "vistas/EditarEspecialidad.jsp";
    Especialidad esp = new Especialidad();
    EspecialidadDAO dao = new EspecialidadDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")) {//en el url
            acceso = vistalistar;
        } else if (action.equalsIgnoreCase("add")) { //en el url
            acceso = vistaagregar;
        } else if (action.equalsIgnoreCase("Agregar")) { //boton Agregar

            String nom = request.getParameter("txtNom");
            String des = request.getParameter("txtDes");
            String est = request.getParameter("txtEst");
            // enviamos los valores
            esp.setNombre(nom);
            esp.setDescripcion(des);
            esp.setEstado(Integer.parseInt(est));
            dao.Agregar(esp);
            acceso = vistalistar;

        } else if (action.equalsIgnoreCase("editar")) { //en el url
            request.setAttribute("idEspecialidad", request.getParameter("id"));
            acceso = vistaeditar;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtId"));
            String nom = request.getParameter("txtNom");
            String des = request.getParameter("txtDes"); // Aquí obtén el valor de txtDes correctamente
            String est = request.getParameter("txtEst");

            esp.setIdEspecialidad(id);
            esp.setNombre(nom);
            esp.setDescripcion(des); // Asigna el valor obtenido correctamente aquí
            esp.setEstado(Integer.parseInt(est));

            dao.Editar(esp);
            acceso = vistalistar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            esp.setIdEspecialidad(id);
            dao.Eliminar(id);
            acceso = vistalistar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
