<%-- 
    Document   : EditarMedico
    Created on : 16 oct. 2023, 04:22:33
    Author     : JEAN
--%>

<%@page import="Modelo.Veterinario"%>
<%@page import="Dao.VeterinarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar veterinario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>


        <%
            VeterinarioDAO dao = new VeterinarioDAO();
            int id = Integer.parseInt((String) request.getAttribute("idVeterinario"));
            Veterinario med = (Veterinario) dao.Obtener(id);
        %>


        <!-- comment  <div class="container">
             <div class="row justify-content-center">
                 <div class="col-sm-8">
                     <div class="card">
                         <div class="card-body">
                             <h1 class="text-center mb-4">Editar Veterinario</h1>
                             <form action="Ctrl_Veterinario" >
                                 ID:<br>
                                 <input class="form-control" type="text" name="txtId" readonly value="<%= med.getIdVeterinario()%>" required> <br>          
                                 Nombre:<br>
                                 <input class="form-control" type="text" name="txtNom" value="<%= med.getNombre()%>" required><br>
                                 Apellido: <br>
                                 <input class="form-control" type="text" name="txtApe" value="<%= med.getApellido()%>" required><br>
                                 DNI: <br>
                                 <input class="form-control" type="text" name="txtDni" value="<%= med.getDni()%>" required><br>
                                 Especialidad: <br>
                                 <input class="form-control" type="text" name="txtEsp" value="<%= med.getIdEspecialidad()%>" required><br>
                                 CMPV: <br>
                                 <input class="form-control" type="text" name="txtCMPV" value="<%= med.getCMPV()%>" required><br>
                                 Fecha Nacimiento: <br>
                                 <input class="form-control" type="date" name="txtFechNac" value="<%= med.getFech_nac()%>" required><br>
                                 Fecha Registro:  <br>
                                 <input class="form-control" type="date" name="txtFechReg" value="<%= med.getFech_reg()%>" required><br>
                                 Sueldo: <br>
                                 <input class="form-control" type="text" name="txtSue" value="<%= med.getSueldo()%>" required><br>
                                 Dirección: <br>
                                 <input class="form-control" type="text" name="txtDir" value="<%= med.getDireccion()%>" required><br>
                                 Télefono: <br>
                                 <input class="form-control" type="text" name="txtTel" value="<%= med.getTelefono()%>" required><br>
                                 Correo: <br>
                                 <input class="form-control" type="text" name="txtCor" value="<%= med.getCorreo()%>" required><br>
                                 Estado: <br>
                                 <input class="form-control" type="text" name="txtEst" value="<%= med.getEstado()%>" required><br>
                                 <div class="d-flex justify-content-between">
                                     <input class="btn btn-dark" type="submit" name="accion" value="Actualizar">
                                     <a href="Ctrl_Veterinario?accion=listar" class="btn btn-dark">Regresar</a>
                                 </div>
                             </form>
                         </div>
                     </div>
                 </div>
             </div>
         </div> -->


        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-8">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center mb-4">Editar Veterinario</h1>
                            <form action="Ctrl_Veterinario" >
                                <div class="row">
                                    <div class="col-sm-6">     
                                        ID:<br>
                                        <input class="form-control" type="text" name="txtId" readonly value="<%= med.getIdVeterinario()%>" required> <br>          
                                    </div>
                                    <div class="col-sm-6">
                                        Nombre:<br>
                                        <input class="form-control" type="text" name="txtNom" value="<%= med.getNombre()%>" required><br>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Apellido: <br>
                                            <input class="form-control" type="text" name="txtApe" value="<%= med.getApellido()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            DNI: <br>
                                            <input class="form-control" type="text" name="txtDni" value="<%= med.getDni()%>" required><br>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Especialidad: <br>
                                            <input class="form-control" type="text" name="txtEsp" value="<%= med.getIdEspecialidad()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            CMPV: <br>
                                            <input class="form-control" type="text" name="txtCMPV" value="<%= med.getCMPV()%>" required><br>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Fecha Nacimiento: <br>
                                            <input class="form-control" type="date" name="txtFechNac" value="<%= med.getFech_nac()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        Fecha Registro:  <br>
                                        <input class="form-control" type="date" name="txtFechReg" value="<%= med.getFech_reg()%>" required><br>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Sueldo: <br>
                                            <input class="form-control" type="text" name="txtSue" value="<%= med.getSueldo()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Dirección: <br>
                                            <input class="form-control" type="text" name="txtDir" value="<%= med.getDireccion()%>" required><br>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Télefono: <br>
                                            <input class="form-control" type="text" name="txtTel" value="<%= med.getTelefono()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Correo: <br>
                                            <input class="form-control" type="text" name="txtCor" value="<%= med.getCorreo()%>" required><br>

                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Estado: <br>
                                            <select class="form-control" name="txtEst" required>
                                                <option value="1">Activo</option>
                                                <option value="0">Inactivo</option>
                                            </select><br>
                                        </div>
                                    </div>

                                </div>

                                <div class="d-flex justify-content-between">
                                    <a href="Ctrl_Veterinario?accion=listar" class="btn btn-dark">Regresar</a>
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
