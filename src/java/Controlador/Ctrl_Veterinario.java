package Controlador;

import Dao.VeterinarioDAO;
import Modelo.Veterinario;
import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JEAN
 */
//@WebServlet(name = "Ctrl_Veterinario", urlPatterns = {"/Ctrl_Medico"})
public class Ctrl_Veterinario extends HttpServlet {

    String vistalistar = "ListarMedico.jsp";
    String vistaagregar = "vistas/AgregarMedico.jsp";
    String vistaeditar = "vistas/EditarMedico.jsp";
    Veterinario med = new Veterinario();
    VeterinarioDAO dao = new VeterinarioDAO();
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
            String ape = request.getParameter("txtApe");
            String dni = request.getParameter("txtDni");
            String esp = request.getParameter("txtEsp");
            String cmpv = request.getParameter("txtCMPV");
            String fc = request.getParameter("txtFechNac");
            String fg = request.getParameter("txtFechReg");
            String sue = request.getParameter("txtSue");
            String dir = request.getParameter("txtDir");
            String tel = request.getParameter("txtTel");
            String cor = request.getParameter("txtCor");
            String est = request.getParameter("txtEst");
            // enviamos los valores
            med.setNombre(nom);
            med.setApellido(ape);
            med.setDni(Integer.parseInt(dni));
            med.setIdEspecialidad(Integer.parseInt(esp));
            med.setCMPV(Integer.parseInt(cmpv));
            med.setFech_nac(fc);
            med.setFech_reg(fg);
            med.setSueldo(Double.parseDouble(sue));
            med.setDireccion(dir);
            med.setTelefono(tel);
            med.setCorreo(cor);
            med.setEstado(Integer.parseInt(est));
            dao.Agregar(med);
            acceso = vistalistar;

        } else if (action.equalsIgnoreCase("editar")) { //en el url
            request.setAttribute("idVeterinario", request.getParameter("id"));
            acceso = vistaeditar;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtId"));
            String nom = request.getParameter("txtNom");
            String ape = request.getParameter("txtApe");
            String dni = request.getParameter("txtDni");
            String esp = request.getParameter("txtEsp");
            String cmpv = request.getParameter("txtCMPV");
            String fc = request.getParameter("txtFechNac");
            String fg = request.getParameter("txtFechReg");
            String sue = request.getParameter("txtSue");
            String dir = request.getParameter("txtDir");
            String tel = request.getParameter("txtTel");
            String cor = request.getParameter("txtCor");
            String est = request.getParameter("txtEst");
            //esto es lo que faltaba enviar el id en
            med.setIdVeterinario(id);
            med.setNombre(nom);
            med.setApellido(ape);
            med.setDni(Integer.parseInt(dni));
            med.setIdEspecialidad(Integer.parseInt(esp));
            med.setCMPV(Integer.parseInt(cmpv));
            med.setFech_nac(fc);
            med.setFech_reg(fg);
            med.setSueldo(Double.parseDouble(sue));
            med.setDireccion(dir);
            med.setTelefono(tel);
            med.setCorreo(cor);
            med.setEstado(Integer.parseInt(est));

            dao.Editar(med);
            acceso = vistalistar;

        } else if (action.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            med.setIdVeterinario(id);
            dao.Eliminar(id);
            acceso = vistalistar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
