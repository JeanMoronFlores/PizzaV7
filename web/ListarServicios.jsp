<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Servicios"%>
<%@page import="java.util.List"%>
<%@page import="Dao.ServiciosDAO"%>
<%@ include file="commons/header.jspf"%>
<%@ include file="commons/navigate.jspf"%>
<html>
    <body>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar especialidades</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    </head>
    <c:if test="${Empleado!=null&&Empleado.perfil=='ADMINISTRADOR'}">
        <div class="ml-4 mt-4 mr-4 mb-4">

            <div class="row">

                <div class="col-sm-12">
                    <h1 class="text-center">SERVICIOS</h1><br>  <a class="btn btn-success btn-dark" href="Ctrl_servicios?accion=add"><i class="fa-solid fa-circle-plus"></i> NUEVO SERVICIO</a><br><br>

                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover" style="width: 100%" id="example">

                                <thead>
                                    <tr>

                                        <th class="text-center" width="10">#</th>
                                        <th class="text-center" width="80">NOMBRE</th>
                                        <th class="text-center" width="200">DESCRIPCIÓN</th>
                                        <th class="text-center" width="200">COSTO</th>
                                        <th class="text-center" width="20">ESTADO</th>
                                        <th class="text-center" width="100">BOTONES</th>

                                    </tr>                    
                                </thead>
                                <%
                                    ServiciosDAO dao = new ServiciosDAO();
                                    List<Servicios> list = dao.ListarServicios();
                                    Iterator<Servicios> iter = list.iterator();
                                    Servicios ser = null;
                                    while (iter.hasNext()) {
                                        ser = iter.next();
                                %>  
                                <tbody>
                                    <tr>
                                        <td class="text-center"><%= ser.getIdServicios()%></td>
                                        <td class="text-center"><%= ser.getNombre()%></td>
                                        <td class="text-center"><%= ser.getDescripcion()%></td>
                                        <td class="text-center"><%= ser.getCosto()%></td>
                                        <td class="text-center">  
                                            <% if (ser.getEstado() == 1) { %>
                                            Activo
                                            <% } else { %>
                                            Inactivo
                                            <% }%></td>


                                        <td class="text-center" width="100">
                                            <!-- botón agregar mal ubicado 
                                            <a class="btn btn-success btn-info" href="Ctrl_servicios?accion=add" ><i class="fa-regular fa-plus"></i></a>-->

                                            <a href="Ctrl_servicios?accion=editar&id=<%= ser.getIdServicios()%>" class="btn btn-success btn-warning"><i class="fa-regular fa-pen-to-square"></i></a> 
                                            <a href="Ctrl_servicios?accion=eliminar&id=<%= ser.getIdServicios()%>" class="btn btn-success btn-danger"><i class="fa-regular fa-trash-can"></i></a>
                                        </td>
                                    </tr>
                                    <% }%>
                                </tbody> 
                            </table>
                        </div>
                    </div>
                </div>
            </div>      
        </div>

    </html>

</body>

</c:if>
<%@ include file="commons/footer.jspf"%>


