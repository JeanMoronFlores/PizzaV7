<%-- 
    Document   : EditarMedico
    Created on : 16 oct. 2023, 04:22:33
    Author     : JEAN
--%>

<%@page import="Modelo.Dueno"%>
<%@page import="Dao.DuenoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Dueños</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>


        <%
            DuenoDAO dao = new DuenoDAO();
            int id = Integer.parseInt((String) request.getAttribute("idDueno"));
            Dueno due = (Dueno) dao.Obtener(id);
        %>
        <!--<h1 class="text-center mb-4">Editar Dueños</h1>
         comment 
        <form action="Ctrl_dueno">
            ID:<br>

            Nombre:<br>
            <input class="form-control" type="text" name="txtNom <input class="form-control" type="text" name="txtId" readonly value="<%= due.getIdDueno()%>" required ><br>" value="<%= due.getNombre()%>" required><br>
            Apellido: <br>
            <input class="form-control" type="text" name="txtApe" value="<%= due.getApellido()%>" required><br>
            DNI: <br>
            <input class="form-control" type="text" name="txtDni" value="<%= due.getDni()%>" required><br>
            Edad: <br>
            <input class="form-control" type="text" name="txtEsp" value="<%= due.getEdad()%>" required><br>
            Sexo: <br>
            <input class="form-control" type="text" name="txtCMPV" value="<%= due.getSexo()%>" required><br>
            Fecha Nacimiento: <br>
            <input class="form-control" type="date" name="txtFechNac" value="<%= due.getFech_nac()%>" required><br>
            Fecha Registro:  <br>
            <input class="form-control" type="date" name="txtFechNac" value="<%= due.getFech_reg()%>" required><br>
            Dirección: <br>
            <input class="form-control" type="text" name="txtDir" value="<%= due.getDireccion()%>" required><br>
            Télefono: <br>
            <input class="form-control" type="text" name="txtTel" value="<%= due.getTelefono()%>" required><br>
            Correo: <br>
            <input class="form-control" type="text" name="txtCor" value="<%= due.getCorreo()%>" required><br>
            Estado: <br>
            <input class="form-control" type="text" name="txtEst" value="<%= due.getEstado()%>" required><br>


            <input class="btn btn-dark" type="submit" name="accion" value="Actualizar">

            <a href="Ctrl_dueno?accion=listar" class="btn btn-dark" class="btn btn-info">Regresar</a>

        </form>-->



        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-8">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center mb-4">Editar Dueños</h1>
                            <form action="Ctrl_dueno" >
                                <div class="row">
                                    <div class="col-sm-6">     
                                        ID:<br>
                                        <input class="form-control" type="text" name="txtId" readonly value="<%= due.getIdDueno()%>" required> <br>          
                                    </div>
                                    <div class="col-sm-6">
                                        Nombre:<br>
                                        <input class="form-control" type="text" name="txtNom" value="<%= due.getNombre()%>" required><br>  
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Apellido: <br>
                                            <input class="form-control" type="text" name="txtApe" value="<%= due.getApellido()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            DNI: <br>
                                            <input class="form-control" type="text" name="txtDni" value="<%= due.getDni()%>" required><br>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Edad: <br>
                                            <input class="form-control" type="text" name="txtEda" value="<%= due.getEdad()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Sexo: <br>
                                            <input class="form-control" type="text" name="txtSex" value="<%= due.getSexo()%>" required><br>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Fecha Nacimiento: <br>
                                            <input class="form-control" type="date" name="txtFechNac" value="<%= due.getFech_nac()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        Fecha Registro:  <br>
                                        <input class="form-control" type="date" name="txtFechReg" value="<%= due.getFech_reg()%>" required><br>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Dirección: <br>
                                            <input class="form-control" type="text" name="txtDir" value="<%= due.getDireccion()%>" required><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Teléfono: <br>
                                            <input class="form-control" type="text" name="txtTel" value="<%= due.getTelefono()%>" required><br>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Correo: <br>
                                            <input class="form-control" type="text" name="txtCor" value="<%= due.getCorreo()%>" required><br>
                                        </div>
                                    </div>
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
                                    <a href="Ctrl_dueno?accion=listar" class="btn btn-dark">Regresar</a>
                                    <input class="btn btn-success" type="submit" name="accion" value="Actualizar">

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
