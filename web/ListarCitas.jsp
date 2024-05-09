<%@page import="Modelo.EstadoCita"%>
<%@page import="Dao.EstadoCitaDAO"%>
<%@page import="Modelo.Servicios"%>
<%@page import="Dao.ServiciosDAO"%>
<%@page import="Modelo.Dueno"%>
<%@page import="Dao.DuenoDAO"%>
<%@page import="Modelo.Mascota"%>
<%@page import="Dao.MascotaDAO"%>
<%@page import="Modelo.Veterinario"%>
<%@page import="Dao.VeterinarioDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Cita"%>
<%@page import="java.util.List"%>
<%@page import="Dao.CitaDAO"%>
<%@ include file="commons/header.jspf"%>
<%@ include file="commons/navigate.jspf"%>
<html>
    <body>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listar CITAS</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    </head>
    <c:if test="${Empleado!=null&&Empleado.perfil=='ADMINISTRADOR'}">
        <div class="ml-4 mt-4 mr-4 mb-4">

            <div class="row">

                <div class="col-sm-12">
                    <h1 class="text-center">CITAS</h1><br>  <a class="btn btn-success btn-dark" href="Ctrl_cita=add" ><i class="fa-solid fa-circle-plus"></i> NUEVA CITA</a><br><br>

                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover" style="width: 100%" id="example">

                                <thead>
                                    <tr>
                                        <th class="text-center" width="10">#</th>
                                        <th class="text-center" width="80">FECHA | HORA </th>
                                        <th class="text-center" width="200">VETERINARIO</th>
                                        <th class="text-center" width="20">MASCOTA</th>
                                        <th class="text-center" width="20">DUEÑO(A)</th>
                                        <th class="text-center" width="100">SERVICIO</th>
                                        <th class="text-center" width="100">DETALLE SERVICIO</th>
                                        <th class="text-center" width="100">OBSERVACIONES</th>
                                        <th class="text-center" width="100">ESTADO</th>
                                        <th class="text-center" width="100">BOTONES</th>


                                    </tr>                    
                                </thead>
                                <%
                                    CitaDAO dao = new CitaDAO();
                                    List<Cita> list = dao.ListarCita();
                                    Iterator<Cita> iter = list.iterator();
                                    Cita cit = null;
                                    while (iter.hasNext()) {
                                        cit = iter.next();
                                        //obtener nombre de veterinario mediante el id
                                        VeterinarioDAO VeterinarioDAO = new VeterinarioDAO();
                                        Veterinario vet = VeterinarioDAO.Obtener(cit.getIdVeterinario());
                                         //obtener nombre de mascota mediante el id
                                        MascotaDAO MascotaDAO = new MascotaDAO();
                                        Mascota mas = MascotaDAO.Obtener(cit.getIdMascota());
                                         //obtener nombre de dueño mediante el id
                                        DuenoDAO DuenoDAO = new DuenoDAO();
                                        Dueno due = DuenoDAO.Obtener(cit.getIdDueno());
                                         //obtener nombre de servicio mediante el id
                                        ServiciosDAO ServiciosDAO = new ServiciosDAO();
                                        Servicios ser = ServiciosDAO.Obtener(cit.getIdServicios());
                                        //obtener nombre de servicio mediante el id
                                        EstadoCitaDAO EstadoCitaDAO = new EstadoCitaDAO();
                                        EstadoCita est = EstadoCitaDAO.Obtener(cit.getIdEstadoCita());
                                %>  
                                <tbody>
                                    <tr>

                                        <td class="text-center"><%=cit.getIdCita()%></td>
                                        <td class="text-center"><%=cit.getFechaCita()%></td>
                                         <!-- solo mostraba el id <td class="text-center"><%=cit.getIdVeterinario()%></td>-->
                                         <!-- mostrará nombre+apellido --><td class="text-center"><%= vet.getNombre()+" "+ vet.getApellido()%></td>
                                        <td class="text-center"><%= mas.getNombre()%></td>
                                        <td class="text-center"><%=due.getNombre()%></td>
                                        <td class="text-center"><%=ser.getNombre()%></td>
                                        <td class="text-center"><%=cit.getDetalleServicios()%></td>
                                        <td class="text-center"><%=cit.getObservaciones()%></td>
                                        <td class="text-center"><%=est.getDescripcion()%></td>
                                        <td class="text-center" width="100">
                                            <!-- botón agregar mal ubicado 
                                            <a class="btn btn-success btn-info" href="Ctrl_especialidad?accion=add" ><i class="fa-regular fa-plus"></i></a>-->

                                            <a href="Ctrl_especialidad?accion=editar&id=<%= cit.getIdCita()%>" class="btn btn-success btn-warning"><i class="fa-regular fa-pen-to-square"></i></a> 
                                            <a href="Ctrl_especialidad?accion=eliminar&id=<%= cit.getIdCita()%>" class="btn btn-success btn-danger"><i class="fa-regular fa-trash-can"></i></a>
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


