/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Dao.PacienteDAO;
import Modelo.Paciente;
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
public class Ctrl_paciente extends HttpServlet {

    String vistalistar = "vistas/ListarPaciente.jsp";
    String vistaagregar = "vistas/AgregarPaciente.jsp";
    String vistaeditar = "vistas/EditarPaciente.jsp";
    Paciente pac = new Paciente();
    PacienteDAO dao = new PacienteDAO();
    int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ctrl_paciente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Ctrl_paciente at " + request.getContextPath() + "</h1>");
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
            String ape = request.getParameter("txtApe");
            String dni = request.getParameter("txtDni");
            String edad = request.getParameter("txtEda");
            String sexo = request.getParameter("txtSex");
            String peso = request.getParameter("txtPes");
            String estatura = request.getParameter("txtEsta");
            String nac = request.getParameter("txtFnac");
            String reg = request.getParameter("txtFreg");
            String dir = request.getParameter("txtDir");
            String tel = request.getParameter("txtTel");
            String cor = request.getParameter("txtCor");
            String est = request.getParameter("txtEst");

            // enviamos los valores
            pac.setNombre(nom);
            pac.setApellido(ape);
            pac.setDni(dni);
            pac.setEdad(edad);
            pac.setSexo(sexo);
            pac.setPeso(peso);
            pac.setEstatura(estatura);
            pac.setFech_nac(nac);
            pac.setFech_reg(reg);
            pac.setDireccion(dir);
            pac.setTelefono(tel);
            pac.setCorreo(cor);
            pac.setEstado(Integer.parseInt(est));
           

            dao.Agregar(pac);
            acceso = vistalistar;

        } else if (action.equalsIgnoreCase("editar")) { //en el url
            request.setAttribute("idPaciente", request.getParameter("id"));
            acceso = vistaeditar;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtId"));
            String nom = request.getParameter("txtNom");
            String ape = request.getParameter("txtApe");
            String dni = request.getParameter("txtDni");
            String edad = request.getParameter("txtEda");
            String sexo = request.getParameter("txtSex");
            String peso = request.getParameter("txtPes");
            String estatura = request.getParameter("txtEsta");
            String nac = request.getParameter("txtFnac");
            String reg = request.getParameter("txtFreg");
            String dir = request.getParameter("txtDir");
            String tel = request.getParameter("txtTel");
            String cor = request.getParameter("txtCor");
            String est = request.getParameter("txtEst");

            pac.setIdPAciente(id);
            pac.setNombre(nom);
            pac.setApellido(ape);
            pac.setDni(dni);
            pac.setEdad(edad);
            pac.setSexo(sexo);
            pac.setPeso(peso);
            pac.setEstatura(estatura);
            pac.setFech_nac(nac);
            pac.setFech_reg(reg);
            pac.setDireccion(dir);
            pac.setTelefono(tel);
            pac.setCorreo(cor);
            pac.setEstado(Integer.parseInt(est));

            dao.Editar(pac); // Llama a la función Editar para actualizar la especialidad.
            acceso = vistalistar; // Redirige de vuelta a la lista de especialidades.

        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            pac.setIdPAciente(id);
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
