<%@page import="Modelo.Dueno"%>
<%@page import="Modelo.Mascota"%>
<%@page import="Dao.DuenoDAO"%>
<%@page import="Dao.MascotaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="Dao.EspecialidadDAO"%>
<%@ include file="commons/header.jspf"%>
<%@ include file="commons/navigate.jspf"%>
<html>
    <body>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar dueños</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    </head>
    <c:if test="${Empleado!=null&&Empleado.perfil=='ADMINISTRADOR'}">
        <div class="ml-4 mt-4 mr-4 mb-4">

            <div class="row">

                <div class="col-sm-12">
                    <h1 class="text-center">Mascotas</h1><a class="btn btn-success btn-dark" href="Ctrl_mascota?accion=add" ><i class="fa-solid fa-circle-plus"></i> NUEVA MASCOTA</a><br><br>

                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover" style="width: 100%" id="example">
                                <thead>
                                    <tr>

                                        <th class="text-center" width="10">#</th>
                                        <th class="text-center" width="80">NOMBRE</th>
                                        <th class="text-center" width="80">DUEÑO</th>
                                        <th class="text-center" width="200">ESPECIE</th>
                                        <th class="text-center" width="200">RAZA</th>
                                        <th class="text-center" width="200">COLOR</th>
                                        <th class="text-center" width="200">SEXO</th>
                                        <th class="text-center" width="200">EDAD</th>
                                        <th class="text-center" width="200">PESO</th>
                                        <th class="text-center" width="200">FEC. NACIMIENTO</th>
                                        <th class="text-center" width="200">FEC. REGISTRO</th>
                                        <th class="text-center" width="20">ESTADO</th>
                                        <th class="text-center" width="100">BOTONES</th>

                                    </tr>                    
                                </thead>
                                <%
                                    MascotaDAO dao = new MascotaDAO();
                                    List<Mascota> list = dao.ListarMascota();
                                    Iterator<Mascota> iter = list.iterator();
                                    Mascota mas = null;
                                    while (iter.hasNext()) {
                                        mas = iter.next();
                                         //obtener nombre de dueño mediante el id
                                        DuenoDAO duenoDAO = new DuenoDAO();

                                        Dueno due = duenoDAO.Obtener(mas.getIdDueno());
                                        
                                %>  
                                <tbody>
                                    <tr>
                                        <td class="text-center"><%= mas.getIdMascota()%></td>
                                        <td class="text-center"><%= mas.getNombre()%></td>
                                     <!-- solo mostraba el id   <td class="text-center"><%= mas.getIdDueno()%></td>-->
                                     <!-- muestra el nombre segun el id -->  <td class="text-center"><%= due.getNombre()+" "+ due.getApellido()%></td>
                                        <td class="text-center"><%= mas.getEspecie()%></td>
                                        <td class="text-center"><%= mas.getRaza()%></td>
                                        <td class="text-center"><%= mas.getColor()%></td>
                                        <td class="text-center"><%= mas.getSexo()%></td>
                                        <td class="text-center"><%= mas.getEdad()%></td>
                                        <td class="text-center"><%= mas.getPeso()%> kg</td>
                                        <td class="text-center"><%= mas.getFech_nac()%></td>
                                        <td class="text-center"><%= mas.getFech_reg()%></td>
                                        <td class="text-center">  
                                            <% if (mas.getEstado() == 1) { %>
                                            Activo
                                            <% } else { %>
                                            Inactivo
                                            <% }%></td>


                                        <td class="text-center" width="100">
                                            <!-- botón agregar mal ubicado 
                                            <a class="btn btn-success btn-info" href="Ctrl_especialidad?accion=add" ><i class="fa-regular fa-plus"></i></a>-->

                                            <a href="Ctrl_mascota?accion=editar&id=<%= mas.getIdMascota()%>" class="btn btn-success btn-warning"><i class="fa-regular fa-pen-to-square"></i></a> 
                                            <a href="Ctrl_mascota?accion=eliminar&id=<%= mas.getIdMascota()%>" class="btn btn-success btn-danger"><i class="fa-regular fa-trash-can"></i></a>
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


