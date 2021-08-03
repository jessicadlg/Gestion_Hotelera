<%-- 
    Document   : altaEmpleado
    Created on : 3/08/2021, 01:46:34 PM
    Author     : 003578613
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <form action="SvEmpleado" method="post">
                                        <div class="form-row">
                                            <div class="col-md-12 mb-3">
                                                <label for="dni">DNI:</label>
                                                <input name="dni" type="text" class="form-control" id="dni" placeholder="" value="" required>
                                            </div>
                                            <div class="col-md-6 mb-3">
                                                <label for="nombre">Nombre:</label>
                                                <input name="nombre" type="text" class="form-control" id="nombre" placeholder="" value=""
                                                       required>
                                            </div>
                                            <div class="col-md-6 mb-3">
                                                <label for="apellido">Apellido</label>
                                                <input name="apellido" type="text" class="form-control" id="apellido" placeholder=""
                                                       value="" required>
                                            </div>
                                            <div class="col-md-12 mb-3">
                                                <label for="fechaNac">Fecha nacimiento:</label>
                                                <input name="fechaNac" type="date" class="form-control" id="fecha_nacimiento"
                                                       required>          
                                            </div>

                                            <div class="col-md-12 mb-3">
                                                <label for="direccion">Dirección:</label>
                                                <select name="direccion" id="direccion" class="form-control">
                                                    <option value="">Ingrese una opcion..</option>
                                                    <option value="Morón">Morón</option>
                                                    <option value="Capital">Capital</option>
                                                    <option value="Caballito">Caballito</option>
                                                </select>
                                            </div>
                                            <div class="col-md-12 mb-3">
                                                <label for="cargo">Cargo:</label>
                                                <select name="cargo" id="cargo"  class="form-control">
                                                    <option value="">Ingrese su cargo..</option>
                                                    <option value="Maestro">Maestro</option>
                                                    <option value="Desarrollador">Desarrollador</option>
                                                    <option value="Ingeniero">Ingeniero</option>
                                                </select>
                                            </div>
                                            <div class="mx-auto">
                                                <button class="btn  mb-3" type="submit">Enviar</button>
                                            </div>
                                        </div>
                                    </form>
    </body>
</html>
