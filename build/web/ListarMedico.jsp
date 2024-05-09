<%@page import="Modelo.Veterinario"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="Dao.VeterinarioDAO"%>
<%@page import="Dao.EspecialidadDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ include file="commons/header.jspf"%>
<%@ include file="commons/navigate.jspf"%>
<html>
    <body>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Veterinarios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    </head>
    <c:if test="${Empleado!=null&&Empleado.perfil=='ADMINISTRADOR'}">
        <div class="ml-4 mt-4 mr-4 mb-4">
            <div class="row">

                <div class="col-sm-12">
                    <h1 class="text-center">VETERINARIOS</h1><br>  <a class="btn btn-success btn-dark" href="Ctrl_Veterinario?accion=add" ><i class="fa-solid fa-circle-plus"></i> NUEVO VETERINARIO</a><br><br>

                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover" style="width: 100%" id="example">

                                <thead>
                                    <tr>
                                        <th class="text-center" width="10">#</th>
                                        <th class="text-center" width="100">NOMBRE</th>
                                        <th class="text-center" width="100">APELLIDO</th>
                                        <th class="text-center" width="10">DNI</th>
                                        <th class="text-center" width="10">ESPECIALIDAD</th>
                                        <th class="text-center" width="10">CMPV</th>
                                        <th class="text-center" width="10">F.CUMPLEAÑOS</th>
                                        <th class="text-center" width="10">F.REGISTRO</th>
                                        <th class="text-center" width="10">SUELDO</th>
                                        <th class="text-center" width="50">DIRECCIÓN</th>
                                        <th class="text-center" width="10">TELEFONO</th>
                                        <th class="text-center" width="400">CORREO</th>
                                        <th class="text-center" width="10">ESTADO</th>
                                        <th class="text-center" width="100">BOTONES</th>

                                    </tr>                    
                                </thead>
                                <%
                                    VeterinarioDAO dao = new VeterinarioDAO();
                                    List<Veterinario> list = dao.ListarMedicos();
                                    Iterator<Veterinario> iter = list.iterator();
                                    Veterinario med = null;
                                    while (iter.hasNext()) {
                                        med = iter.next();

                                        //obtener nombre de especialidad mediante el id
                                        EspecialidadDAO especialidadDAO = new EspecialidadDAO();
                                        Especialidad esp = especialidadDAO.Obtener(med.getIdEspecialidad());
                                %>   
                                <tbody>
                                <td class="text-center"><%= med.getIdVeterinario()%></td>
                                <td class="text-center"><%= med.getNombre()%></td>
                                <td class="text-center"><%= med.getApellido()%></td>
                                <td class="text-center"><%= med.getDni()%></td>
                               <!-- Mostraba el Id solamente <td class="text-center"><%= med.getIdEspecialidad()%></td>-->
                                <!-- muestra el nombre segun el id --> <td class="text-center"><%= esp.getNombre()%></td>
                                <td class="text-center"><%= med.getCMPV()%></td>
                                <td class="text-center"><%= med.getFech_nac()%></td>
                                <td class="text-center"><%= med.getFech_reg()%></td>
                                <td class="text-center"><%= med.getSueldo()%></td>
                                <td class="text-center"><%= med.getDireccion()%></td>
                                <td class="text-center"><%= med.getTelefono()%></td>
                                <td class="text-center"><%= med.getCorreo()%></td>
                                <!-- <td class="text-center"><%= med.getEstado()%></td>-->
                                <td class="text-center">
                                    <% if (med.getEstado() == 1) { %>
                                    Activo
                                    <% } else { %>
                                    Inactivo
                                    <% }%>
                                </td>
                                <td class="text-center" width="100">
                                    <!-- botón agregar mal ubicado 
                                   <a class="btn btn-success btn-info" href="Ctrl_Medico?accion=add" ><i class="fa-regular fa-plus"></i></a>-->

                                    <a href="Ctrl_Veterinario?accion=editar&id=<%= med.getIdVeterinario()%>" class="btn btn-success btn-warning"><i class="fa-regular fa-pen-to-square"></i></a> 


                                    <a href="Ctrl_Veterinario?accion=eliminar&id=<%= med.getIdVeterinario()%>" class="btn btn-success btn-danger"><i class="fa-regular fa-trash-can"></i></a>
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
    <!-- Bootstrap JS (debe incluirse al final del cuerpo para un mejor rendimiento) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</c:if>
<%@ include file="commons/footer.jspf"%>


