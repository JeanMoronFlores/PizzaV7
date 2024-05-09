<%-- 
    Document   : AgregarMedico
    Created on : 16 oct. 2023, 04:22:23
    Author     : JEAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar MAscota</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-8">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center mb-4">Agregar Dueños</h1>
                            <form action="Ctrl_dueno" >
                                <div class="row">
                                    <div class="col-sm-6">                                  
                                        <input class="form-control" type="text" name="txtNom" placeholder="Nombre" required> <br>          
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="txtApe" placeholder="Apellido" required><br>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtDni" placeholder="DNI" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtEda" placeholder="Edad" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">

                                        <div class="form-group">
                                            Fecha nacimiento:<br>
                                            <input class="form-control" type="date" name="txtFechNac" placeholder="a" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Fecha registro:<br>
                                            <input class="form-control" type="date" name="txtFechReg" placeholder="b" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtSex" placeholder="Sexo" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">

                                            <input class="form-control" type="text" name="txtDir" placeholder="Dirección" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">

                                            <input class="form-control" type="text" name="txtTel" placeholder="Teléfono" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtCor" placeholder="Correo">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <select class="form-control" name="txtEst" required>
                                                <option value="1">Activo</option>
                                                <option value="0">Inactivo</option>
                                            </select><br>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">

                                    </div>
                                </div>

                                <div class="d-flex justify-content-between">
                                    <a href="Ctrl_dueno?accion=listar" class="btn btn-dark">Regresar</a>
                                    <input class="btn btn-dark" type="submit" name="accion" value="Agregar">

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

