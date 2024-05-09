/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Dao.MascotaDAO;
import Modelo.Mascota;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JEAN
 */
public class Ctrl_mascota extends HttpServlet {

    String vistalistar = "ListarMascotas.jsp";
    String vistaagregar = "vistas/AgregarMascotas.jsp";
    String vistaeditar = "vistas/EditarMascota.jsp";
    Mascota pac = new Mascota();
    MascotaDAO dao = new MascotaDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ctrl_mascota</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ctrl_mascota at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            String due = request.getParameter("txtDue");
            String esp = request.getParameter("txtEspecie");
            String raz = request.getParameter("txtRaza");
            String col = request.getParameter("txtColor");
            String sexo = request.getParameter("txtSex");
            String edad = request.getParameter("txtEda");
            String peso = request.getParameter("txtPes");
            String fech_nac = request.getParameter("txtFnac");
            String fech_reg = request.getParameter("txtFreg");
            String est = request.getParameter("txtEst");
            // enviamos los valores
            pac.setNombre(nom);
            pac.setIdDueno(Integer.parseInt(due));
            pac.setEspecie(esp);
            pac.setRaza(raz);
            pac.setColor(col);
            pac.setSexo(sexo);
            pac.setEdad(edad);
            pac.setPeso(peso);
            pac.setFech_nac(fech_nac);
            pac.setFech_reg(fech_reg);
            pac.setEstado(Integer.parseInt(est));

            dao.Agregar(pac);
            acceso = vistalistar;

        } else if (action.equalsIgnoreCase("editar")) { //en el url
            request.setAttribute("idMascota", request.getParameter("id"));
            acceso = vistaeditar;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtId"));

            String nom = request.getParameter("txtNom");
            String due = request.getParameter("txtIdDueño");
            String esp = request.getParameter("txtEspecie");
            String raz = request.getParameter("txtRaza");
            String col = request.getParameter("txtColor");
            String sexo = request.getParameter("txtSex");
            String edad = request.getParameter("txtEda");
            String peso = request.getParameter("txtPes");
            String fech_nac = request.getParameter("txtFnac");
            String fech_reg = request.getParameter("txtFreg");
            String est = request.getParameter("txtEst");
            // enviamos los valores
            //el error de no anctualizar era que faltaba la línea siguiente (enviar el id)
            pac.setIdMascota(id);
            pac.setNombre(nom);
            pac.setIdDueno(Integer.parseInt(due));
            pac.setEspecie(esp);
            pac.setRaza(raz);
            pac.setColor(col);
            pac.setSexo(sexo);
            pac.setEdad(edad);
            pac.setPeso(peso);
            pac.setFech_nac(fech_nac);
            pac.setFech_reg(fech_reg);
            pac.setEstado(Integer.parseInt(est));
            dao.Editar(pac); // Llama a la función Editar para actualizar la especialidad.
            acceso = vistalistar; // Redirige de vuelta a la lista de especialidades.

        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            pac.setIdMascota(id);
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
