<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="Dao.EspecialidadDAO"%>
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
                    <h1 class="text-center">ESPECILIDAD</h1><br>  <a class="btn btn-success btn-dark" href="Ctrl_especialidad?accion=add" ><i class="fa-solid fa-circle-plus"></i> NUEVA ESPECIALIDAD</a><br><br>

                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover" style="width: 100%" id="example">

                                <thead>
                                    <tr>


                                        <th class="text-center" width="10">#</th>
                                        <th class="text-center" width="80">NOMBRE</th>
                                        <th class="text-center" width="200">DESCRIPCIÓN</th>
                                        <th class="text-center" width="20">ESTADO</th>
                                        <th class="text-center" width="100">BOTONES</th>

                                    </tr>                    
                                </thead>
                                <%
                                    EspecialidadDAO dao = new EspecialidadDAO();
                                    List<Especialidad> list = dao.ListarEspecialidades();
                                    Iterator<Especialidad> iter = list.iterator();
                                    Especialidad esp = null;
                                    while (iter.hasNext()) {
                                        esp = iter.next();
                                %>  
                                <tbody>
                                    <tr>
                                        <td class="text-center"><%= esp.getIdEspecialidad()%></td>
                                        <td class="text-center"><%= esp.getNombre()%></td>
                                        <td class="text-center"><%= esp.getDescripcion()%></td>
                                        <td class="text-center">
                                            <% if (esp.getEstado() == 1) { %>
                                            Activo
                                            <% } else { %>
                                            Inactivo
                                            <% }%>
                                        </td>

                                        <td class="text-center" width="100">
                                            <!-- botón agregar mal ubicado 
                                            <a class="btn btn-success btn-info" href="Ctrl_especialidad?accion=add" ><i class="fa-regular fa-plus"></i></a>-->

                                            <a href="Ctrl_especialidad?accion=editar&id=<%= esp.getIdEspecialidad()%>" class="btn btn-success btn-warning"><i class="fa-regular fa-pen-to-square"></i></a> 
                                            <a href="Ctrl_especialidad?accion=eliminar&id=<%= esp.getIdEspecialidad()%>" class="btn btn-success btn-danger"><i class="fa-regular fa-trash-can"></i></a>
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


