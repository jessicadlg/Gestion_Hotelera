<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="assets/css/styles.css">
        <link rel="shortcut icon" href="#" />
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <title>Gestion de Reservas-Login</title>
    </head>
    <body>
        <header class="mb-5">
            <h1 class="text-center p-3">Gestión Hotelera</h1>
        </header>
        <div class="col-lg-8 mx-auto  ">
            <div class="card shadow-lg p-3 mx-auto mb-5 bg-white ">
                <div class="card-header text-center">Inicio de sesión</div>
                <div class="card-body">
                    <form  action="SvLogin" method="post" novalidate>
                        <div class="form-row">
                            <div class="col-md-12 mx-auto mb-3">
                                <label for="usuario">Usuario</label>
                                <input name="usuario" type="text" class="form-control"  required>
                            </div>
                            <div class="col-md-12 mx-auto mb-3">
                                <label for="contrasenia">Contraseña</label>
                                <input name="contrasenia" type="password" class="form-control" required>
                            </div>
                        </div>
                        <div class="d-flex justify-content-center">
                            <button class="btn" type="submit">Enviar</button>
                        </div>
                    </form>
                </div>
            </div> 
        </div>       
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>