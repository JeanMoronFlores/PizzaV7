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
        <title>Agregar Dueño</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-8">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center mb-4">Agregar Mascotas</h1>
                            <form action="Ctrl_mascota" >
                                <div class="row">
                                    <div class="col-sm-6">                                  
                                        <input class="form-control" type="text" name="txtNom" placeholder="Nombre de mascota" required> <br>          
                                    </div>
                                    <div class="col-sm-6">
                                        <input class="form-control" type="text" name="txtDue" placeholder="Dueño" required><br>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtEsp" placeholder="Especie" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtRaz" placeholder="raza" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtCol" placeholder="color" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtSex" placeholder="sexo" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">

                                            <input class="form-control" type="text" name="txtEda" placeholder="Edad" required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="txtPes" placeholder="Peso" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Fecha nacimiento:<br>
                                            <input class="form-control" type="date" name="txtFechNac"  required>
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            Fecha registro<br>
                                            <input class="form-control" type="date" name="txtFechReg"  required>
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
                                    <a href="Ctrl_mascota?accion=listar" class="btn btn-dark">Regresar</a>
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

