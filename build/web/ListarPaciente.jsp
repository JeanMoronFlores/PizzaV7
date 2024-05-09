
<%@page import="Dao.PacienteDAO"%>
<%@page import="Modelo.Paciente"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar Pacientes</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">


    </head>
    <body>

        <div class="container-fluid">
            <br>

            <h1>Lista de Pacientes</h1><br>
           

            <a class="btn btn-success btn-info" href="Ctrl_paciente?accion=add" >Agregar</a><br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center" width="20">#</th>
                        <th class="text-center" width="200">NOMBRE</th>
                        <th class="text-center" width="200">APELLIDO</th>
                        <th class="text-center" width="20">DNI</th>
                        <th class="text-center" width="20">EDAD</th>
                        <th class="text-center" width="20">SEXO</th>
                        <th class="text-center" width="20">PESO</th>
                        <th class="text-center" width="20">ESTATURA</th>
                        <th class="text-center" width="200">FECHA NACIMIENTOS</th>
                        <th class="text-center" width="200">FECHA REGISTRO</th>
                        <th class="text-center" width="200">DIRECCION</th>
                        <th class="text-center" width="20">TELEFONO</th>
                        <th class="text-center" width="200">CORREO</th>
                        <th class="text-center" width="20">ESTADO</th>
                        <th class="text-center" width="200">BOTONES</th>

                    </tr>                    
                </thead>
                <% PacienteDAO dao = new PacienteDAO();
                    List<Paciente> list = dao.ListarPacientes();
                    Iterator<Paciente> iter = list.iterator();
                    Paciente pac = null;
                    while (iter.hasNext()) {
                        pac = iter.next();
                %>    
                <tbody>
                    <tr>
                        <td class="text-center"><%= pac.getIdPAciente()%></td>
                        <td class="text-center"><%= pac.getNombre()%></td>
                        <td class="text-center"><%= pac.getApellido()%></td>
                        <td class="text-center"><%= pac.getDni()%></td>
                        <td class="text-center"><%= pac.getEdad()%></td>
                        <td class="text-center"><%= pac.getSexo()%></td>
                        <td class="text-center"><%= pac.getPeso()%></td>
                        <td class="text-center"><%= pac.getEstatura()%></td>
                        <td class="text-center"><%= pac.getFech_nac()%></td>
                        <td class="text-center"><%= pac.getFech_reg()%></td>
                        <td class="text-center"><%= pac.getDireccion()%></td>
                        <td class="text-center"><%= pac.getTelefono()%></td>
                        <td class="text-center"><%= pac.getCorreo()%></td>
                        <td class="text-center"><%= pac.getEstado()%></td>




                        <td class="text-center" width="100">
                            <!-- botón agregar mal ubicado 

                            <a class="btn btn-success btn-info" href="Ctrl_paciente?accion=add" ><i class="fa-regular fa-plus"></i></a>-->
                            <a href="Ctrl_paciente?accion=editar&id=<%= pac.getIdPAciente()%>" class="btn btn-success btn-warning"><i class="fa-regular fa-pen-to-square"></i></a> 
                            <a href="Ctrl_paciente?accion=eliminar&id=<%= pac.getIdPAciente()%>" class="btn btn-success btn-danger"><i class="fa-regular fa-trash-can"></i></a>

                        </td>
                    </tr>
                    <% }%>
                </tbody>                
            </table>
        </div>
    </body>
</html>
