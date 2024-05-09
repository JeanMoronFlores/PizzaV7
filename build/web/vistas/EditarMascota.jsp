<%-- 
    Document   : EditarMedico
    Created on : 16 oct. 2023, 04:22:33
    Author     : JEAN
--%>

<%@page import="Modelo.Mascota"%>
<%@page import="Dao.MascotaDAO"%>
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
            MascotaDAO dao = new MascotaDAO();
            int id = Integer.parseInt((String) request.getAttribute("idMascota"));
            Mascota mas = (Mascota) dao.Obtener(id);
        %>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center mb-4">Editar Mascota</h1>
                            <form action="Ctrl_mascota"> <!--No es ncesario colocar metodo post o get -->
                                ID:<br>
                                <input class="form-control" type="text" name="txtId" readonly value="<%= mas.getIdMascota()%>" ><br> <!--  -->
                                Nobre Mascota: <br>
                                <input class="form-control" type="text" name="txtNom" value="<%= mas.getNombre()%>"><br>
                                Dueño:<br>
                                <input class="form-control" type="text" name="txtDes" value="<%= mas.getIdDueno()%>"><br>
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
