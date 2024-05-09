<%-- 
    Document   : EditarMedico
    Created on : 16 oct. 2023, 04:22:33
    Author     : JEAN
--%>

<%@page import="Modelo.Paciente"%>
<%@page import="Dao.PacienteDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <%
        PacienteDAO dao = new PacienteDAO();
        int id = Integer.parseInt((String) request.getAttribute("idPaciente"));
        Paciente pac = (Paciente) dao.Obtener(id);
    %>
    <body>
        <div class="container">
            <div class="col-4">

                <h1>Editar Paciente</h1>

                <form action="Ctrl_paciente">
                    ID:<br>
                    <input class="form-control" type="text" name="txtId" readonly value="<%= pac.getIdPAciente()%>" ><br>
                    Nombre:<br>
                    <input class="form-control" type="text" name="txtNom" value="<%= pac.getNombre()%>"><br>
                    Apellido: <br>
                    <input class="form-control" type="text" name="txtApe" value="<%= pac.getApellido()%>">
                    Dni: <br>
                    <input class="form-control" type="text" name="txtDni" value="<%= pac.getDni()%>">
                    Edad: <br>
                    <input class="form-control" type="text" name="txtEda" value="<%= pac.getEdad()%>">
                    Sexo: <br>
                    <input class="form-control" type="text" name="txtSex" value="<%= pac.getSexo()%>">
                    Peso: <br>
                    <input class="form-control" type="text" name="txtPes" value="<%= pac.getPeso()%>">
                    Estatura: <br>
                    <input class="form-control" type="text" name="txtEsta" value="<%= pac.getEstatura()%>">
                    Fecha nacimiento: <br>
                    <input class="form-control" type="date" name="txtFnac" value="<%= pac.getFech_nac()%>">
                    Fecha de registro: <br>
                    <input class="form-control" type="date" name="txtFreg" value="<%= pac.getFech_reg()%>">
                    Dirección: <br>
                    <input class="form-control" type="text" name="txtDir" value="<%= pac.getDireccion()%>">
                    Telefono: <br>
                    <input class="form-control" type="text" name="txtTel" value="<%= pac.getTelefono()%>">
                    Correo:  <br>
                    <input class="form-control" type="text" name="txtCor" value="<%= pac.getCorreo()%>">
                    Estado: <br>
                    <select class="form-control" name="txtEst" required>
                        <option value="1">Activo</option>
                        <option value="0">Inactivo</option>
                    </select><br>


                    <br>
                    <input class="btn btn-info" type="submit" name="accion" value="Actualizar">

                    <a href="Ctrl_paciente?accion=listar" class="btn btn-info">Regresar</a>

                </form>

            </div>
        </div>
    </body>
</html>
