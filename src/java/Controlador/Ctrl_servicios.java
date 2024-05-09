/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;


import Dao.ServiciosDAO;
import Modelo.Servicios;
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
public class Ctrl_servicios extends HttpServlet {

    String vistalistar = "ListarServicios.jsp";
    String vistaagregar = "vistas/AgregarServicios.jsp";
    String vistaeditar = "vistas/EditarServicios.jsp";
    Servicios ser = new Servicios();
    ServiciosDAO dao = new ServiciosDAO();
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
            String cos = request.getParameter("txtCos");
            String est = request.getParameter("txtEst");
            // enviamos los valores
            ser.setNombre(nom);
            ser.setDescripcion(des);
            ser.setCosto(Double.parseDouble(cos));
            ser.setEstado(Integer.parseInt(est));
            dao.Agregar(ser);
            acceso = vistalistar;

        } else if (action.equalsIgnoreCase("editar")) { //en el url
            request.setAttribute("idServicios", request.getParameter("id"));
            acceso = vistaeditar;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtId"));
            String nom = request.getParameter("txtNom");
            String des = request.getParameter("txtDes"); // Aquí obtén el valor de txtDes correctamente
            String cos = request.getParameter("txtCos");
            String est = request.getParameter("txtEst");

            ser.setIdServicios(id);
            ser.setNombre(nom);
            ser.setDescripcion(des); // Asigna el valor obtenido correctamente aquí
            ser.setCosto(Double.parseDouble(cos));
            ser.setEstado(Integer.parseInt(est));

            dao.Editar(ser);
            acceso = vistalistar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            ser.setIdServicios(id);
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
