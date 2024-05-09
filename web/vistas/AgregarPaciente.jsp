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
        <title>Agregar Paciente</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container ">
            <div class="col-12">
                <h1 class="text-center">Agregar Paciente</h1>
                <form action="Ctrl_paciente">
                    Nombre:<br>
                    <input class=" form-control" type="text" name="txtNom"><br>
                    Apellido <br>
                    <input class="form-control" type="text" name="txtApe"><br>
                    Dni: <br>
                    <input class="form-control" type="text" name="txtDni"><br>
                    Edad: <br>
                    <input class="form-control" type="text" name="txtEda"><br>
                    Sexo: <br>
                    <input class="form-control" type="text" name="txtSex"><br>
                    Peso: <br>
                    <input class="form-control" type="text" name="txtPes"><br>
                    Estatura: <br>
                    <input class="form-control" type="text" name="txtEsta"><br>
                    Fecha de Nacimiento: <br>
                    <input class="form-control" type="date" name="txtFnac"><br>
                    Fecha de registro: <br>
                    <input class="form-control" type="date" name="txtFreg"><br>
                    Dirección: <br>
                    <input class="form-control" type="text" name="txtDir"><br>
                    Telefono: <br>
                    <input class="form-control" type="text" name="txtTel"><br>
                    Correo: <br>
                    <input class="form-control" type="text" name="txtCor"><br>
                    Estado: <br>
                    <input class="form-control" type="text" name="txtEst"><br>

                    <a href="Ctrl_paciente?accion=listar" class="btn btn-info" >Regresar</a>
                    <input class="btn btn-info" type="submit" name="accion" value="Agregar">


                </form>
            </div>
        </div>
    </body>
</html>
