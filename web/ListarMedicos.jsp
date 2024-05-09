

<%@page import="Modelo.Veterinario"%>
<%@page import="Dao.VeterinarioDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Veterinario"%>
<%@page import="java.util.List"%>
<%@page import="Dao.VeterinarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar</title>
        <!-- Incluir Font Awesome desde su CDN -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    </head>
    <body>

        <div class="container-fluid">
            <br>

            <h1>ESTE NO SE USA</h1> <br>

            <a class="btn btn-success btn-info" href="Ctrl_Medico?accion=add" >Agregar</a><br>

            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center" width="10">#</th>
                        <th class="text-center" width="10">NOMBRE</th>
                        <th class="text-center" width="10">APELLIDO</th>
                        <th class="text-center" width="10">DNI</th>
                       
                        <th class="text-center" width="10">ESPECIALIDAD</th>
                         <th class="text-center" width="10">CMPV</th>
                        <th class="text-center" width="10">SUELDO</th>
                        <th class="text-center" width="200">DIRECCIÓN</th>
                        <th class="text-center" width="10">TELEFONO</th>
                        <th class="text-center" width="200">CORREO</th>
                        <th class="text-center" width="10">ESTADO</th>
                        <th class="text-center" width="120">BOTONES</th>

                    </tr>                    
                </thead>
                <%
                   VeterinarioDAO dao = new VeterinarioDAO();
                    List<Veterinario> list = dao.ListarMedicos();
                    Iterator<Veterinario> iter = list.iterator();
                    Veterinario med = null;
                    while (iter.hasNext()) {
                        med = iter.next();
                %>    
                <tbody>
                    <tr>
                        <td class="text-center"><%= med.getIdVeterinario()%></td>
                        <td class="text-center"><%= med.getNombre()%></td>
                        
                        <td class="text-center"><%= med.getApellido()%></td>
                        <td class="text-center"><%= med.getDni()%></td>
                        <td class="text-center"><%= med.getIdEspecialidad()%></td>
                        <td class="text-center"><%= med.getCMPV()%></td>
                        <td class="text-center"><%= med.getSueldo()%></td>
                        <td class="text-center"><%= med.getDireccion()%></td>
                        <td class="text-center"><%= med.getTelefono()%></td>
                        <td class="text-center"><%= med.getCorreo()%></td>
                        <td class="text-center"><%= med.getEstado()%></td>


                      
                        <td class="text-center" width="100">
                             <!-- botón agregar mal ubicado 
                            <a class="btn btn-success btn-info" href="Ctrl_Medico?accion=add" ><i class="fa-regular fa-plus"></i></a>-->

                            <a href="Ctrl_Medico?accion=editar&id=<%= med.getIdVeterinario()%>" class="btn btn-success btn-warning"><i class="fa-regular fa-pen-to-square"></i></a> 


                            <a href="Ctrl_Medico?accion=eliminar&id=<%= med.getIdVeterinario()%>" class="btn btn-success btn-danger"><i class="fa-regular fa-trash-can"></i></a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>                
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
