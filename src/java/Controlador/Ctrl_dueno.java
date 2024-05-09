/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DuenoDAO;
import Modelo.Dueno;
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
public class Ctrl_dueno extends HttpServlet {

    String vistalistar = "ListarDueno.jsp";
    String vistaagregar = "vistas/AgregarDueno.jsp";
    String vistaeditar = "vistas/EditarDueno.jsp";
    Dueno due = new Dueno();
    DuenoDAO dao = new DuenoDAO();
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
            //GUARDAMOS VALORES
            String nom = request.getParameter("txtNom");
            String ape = request.getParameter("txtApe");
            String dni = request.getParameter("txtDni");
            String eda = request.getParameter("txtEda");
            String sex = request.getParameter("txtSex");
            String fc = request.getParameter("txtFechNac");
            String fg = request.getParameter("txtFechReg");
            String dir = request.getParameter("txtDir");
            String tel = request.getParameter("txtTel");
            String cor = request.getParameter("txtCor");
            String est = request.getParameter("txtEst");
            // enviamos los valores
            due.setNombre(nom);
            due.setApellido(ape);
            due.setDni(Integer.parseInt(dni));
            due.setEdad(Integer.parseInt(eda));
            due.setSexo(sex);
            due.setFech_nac(fc);
            due.setFech_reg(fg);
            due.setDireccion(dir);
            due.setTelefono(tel);
            due.setCorreo(cor);
            due.setEstado(Integer.parseInt(est));
            dao.Agregar(due);
            acceso = vistalistar;

        } else if (action.equalsIgnoreCase("editar")) { //en el url
            request.setAttribute("idDueno", request.getParameter("id"));
            acceso = vistaeditar;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtId"));
            String nom = request.getParameter("txtNom");
            String ape = request.getParameter("txtApe");
            String dni = request.getParameter("txtDni");
            String eda = request.getParameter("txtEda");
            String sex = request.getParameter("txtSex");
            String fc = request.getParameter("txtFechNac");
            String fg = request.getParameter("txtFechReg");
            String dir = request.getParameter("txtDir");
            String tel = request.getParameter("txtTel");
            String cor = request.getParameter("txtCor");
            String est = request.getParameter("txtEst");

            // enviamos los valores
            //el error de no anctualizar era que faltaba la línea siguiente (enviar el id)
            due.setIdDueno(id);
            due.setNombre(nom);
            due.setApellido(ape);
            due.setDni(Integer.parseInt(dni));
            due.setEdad(Integer.parseInt(eda));
            due.setSexo(sex);
            due.setFech_nac(fc);
            due.setFech_reg(fg);
            due.setDireccion(dir);
            due.setTelefono(tel);
            due.setCorreo(cor);
            due.setEstado(Integer.parseInt(est));
            dao.Editar(due);
            acceso = vistalistar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            due.setIdDueno(id);
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
