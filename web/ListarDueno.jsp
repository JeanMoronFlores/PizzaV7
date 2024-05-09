<%@page import="Modelo.Dueno"%>
<%@page import="Dao.DuenoDAO"%>
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
        <title>listar due�os</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    </head>
    <c:if test="${Empleado!=null&&Empleado.perfil=='ADMINISTRADOR'}">
        <div class="ml-4 mt-4 mr-4 mb-4">

            <div class="row">

                <div class="col-sm-12">
                    <h1 class="text-center">DUE�OS</h1><a class="btn btn-success btn-dark" href="Ctrl_dueno?accion=add" ><i class="fa-solid fa-circle-plus"></i> NUEVO DUE�O</a><br><br>

                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover" style="width: 100%" id="example">
                                <thead>
                                    <tr>

                                        <th class="text-center" width="10">#</th>
                                        <th class="text-center" width="80">NOMBRE</th>
                                        <th class="text-center" width="200">APELLIDO</th>
                                        <th class="text-center" width="200">DNI</th>
                                        <th class="text-center" width="200">EDAD</th>
                                        <th class="text-center" width="200">SEXO</th>
                                        <th class="text-center" width="200">FEC. NACIMIENTO</th>
                                        <th class="text-center" width="200">FEC. REGISTRO</th>
                                        <th class="text-center" width="200">DIRECCI�N</th>
                                        <th class="text-center" width="200">TEL�FONO</th>
                                        <th class="text-center" width="200">CORREO</th>
                                        <th class="text-center" width="20">ESTADO</th>
                                        <th class="text-center" width="100">BOTONES</th>

                                    </tr>                    
                                </thead>
                                <%
                                    DuenoDAO dao = new DuenoDAO();
                                    List<Dueno> list = dao.ListarDueno();
                                    Iterator<Dueno> iter = list.iterator();
                                    Dueno due = null;
                                    while (iter.hasNext()) {
                                        due = iter.next();
                                %>  
                                <tbody>
                                    <tr>
                                        <td class="text-center"><%= due.getIdDueno()%></td>
                                        <td class="text-center"><%= due.getNombre()%></td>
                                        <td class="text-center"><%= due.getApellido()%></td>
                                        <td class="text-center"><%= due.getDni()%></td>
                                        <td class="text-center"><%= due.getEdad()%></td>
                                        <td class="text-center"><%= due.getSexo()%></td>
                                        <td class="text-center"><%= due.getFech_nac()%></td>
                                        <td class="text-center"><%= due.getFech_reg()%></td>
                                        <td class="text-center"><%= due.getDireccion()%></td>
                                        <td class="text-center"><%= due.getTelefono()%></td>
                                        <td class="text-center"><%= due.getCorreo()%></td>
                                        <td class="text-center">
                                            <% if (due.getEstado() == 1) { %>
                                            Activo
                                            <% } else { %>
                                            Inactivo
                                            <% }%></td>


                                        <td class="text-center" width="100">
                                            <!-- bot�n agregar mal ubicado 
                                            <a class="btn btn-success btn-info" href="Ctrl_especialidad?accion=add" ><i class="fa-regular fa-plus"></i></a>-->

                                            <a href="Ctrl_dueno?accion=editar&id=<%= due.getIdDueno()%>" class="btn btn-success btn-warning"><i class="fa-regular fa-pen-to-square"></i></a> 
                                            <a href="Ctrl_dueno?accion=eliminar&id=<%= due.getIdDueno()%>" class="btn btn-success btn-danger"><i class="fa-regular fa-trash-can"></i></a>
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


