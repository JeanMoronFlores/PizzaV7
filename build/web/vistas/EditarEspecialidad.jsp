<%-- 
    Document   : EditarMedico
    Created on : 16 oct. 2023, 04:22:33
    Author     : JEAN
--%>

<%@page import="Modelo.Especialidad"%>
<%@page import="Dao.EspecialidadDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            EspecialidadDAO dao = new EspecialidadDAO();
            int id = Integer.parseInt((String) request.getAttribute("idEspecialidad"));
            Especialidad esp = (Especialidad) dao.Obtener(id);
        %>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center mb-4">Editar Especialidad</h1>
                            <form action="Ctrl_especialidad"> <!--No es ncesario colocar metodo post o get -->
                                ID:<br>
                                <input class="form-control" type="text" name="txtId" readonly value="<%= esp.getIdEspecialidad()%>" ><br> <!--  -->
                                Nobre de especialidad: <br>
                                <input class="form-control" type="text" name="txtNom" value="<%= esp.getNombre()%>"><br>
                                Descripción:<br>
                                <input class="form-control" type="text" name="txtDes" value="<%= esp.getDescripcion()%>"><br>
                                Estado: <br>
                                <select class="form-control" name="txtEst" required>
                                    <option value="1">Activo</option>
                                    <option value="0">Inactivo</option>
                                </select><br>

                                <div class="d-flex justify-content-between">
                                    <a href="Ctrl_especialidad?accion=listar" class="btn btn-dark" >Regresar</a>
                                    <input class="btn btn-dark" type="submit" name="accion" value="Actualizar">

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
