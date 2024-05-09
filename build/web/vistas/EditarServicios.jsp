<%-- 
    Document   : EditarMedico
    Created on : 16 oct. 2023, 04:22:33
    Author     : JEAN
--%>

<%@page import="Modelo.Servicios"%>
<%@page import="Dao.ServiciosDAO"%>
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
            ServiciosDAO dao = new ServiciosDAO();
            int id = Integer.parseInt((String) request.getAttribute("idServicios"));
            Servicios esp = (Servicios) dao.Obtener(id);
        %>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center mb-4">Editar Servicios</h1>
                            <form action="Ctrl_servicios"> <!--No es ncesario colocar metodo post o get -->
                                ID:<br>
                                <input class="form-control" type="text" name="txtId" readonly value="<%= esp.getIdServicios()%>" ><br> <!--  -->
                                Nobre de servicio: <br>
                                <input class="form-control" type="text" name="txtNom" value="<%= esp.getNombre()%>"><br>
                                Descripción:<br>
                                <input class="form-control" type="text" name="txtDes" value="<%= esp.getDescripcion()%>"><br>
                                Costo:<br>
                                <input class="form-control" type="text" name="txtCos" value="<%= esp.getCosto()%>"><br>
                                Estado: <br>
                                <select class="form-control" name="txtEst" required>
                                    <option value="1">Activo</option>
                                    <option value="0">Inactivo</option>
                                </select><br>

                                <div class="d-flex justify-content-between">
                                    <a href="Ctrl_servicios?accion=listar" class="btn btn-dark" >Regresar</a>
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
