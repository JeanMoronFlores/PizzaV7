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
        <title>Agregar Especialidad</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <h1 class="text-center mb-4">Agregar Especialidad</h1>
                            <form action="Ctrl_especialidad"> <!--No es ncesario colocar metodo post o get -->

                                <input class="form-control" type="text" name="txtNom" placeholder="Nombre" required ><br>

                                <input class="form-control" type="text" name="txtDes" placeholder="Descripción" required><br>

                                <!-- comment  <input class="form-control" type="text" name="txtEst" placeholder="Estado" required><br>-->
                                <select class="form-control" name="txtEst" required>
                                    <option value="1">Activo</option>
                                    <option value="0">Inactivo</option>
                                </select><br>


                                <div class="d-flex justify-content-between">
                                    <a href="Ctrl_especialidad?accion=listar" class="btn btn-dark" >Regresar</a>
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
