<%@page import="Logica.Usuario"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="images/favicon.ico" type="image/ico" />
        <link rel="stylesheet" href="assets/css/styles.css">

        <title>Gestión hotelera </title>

        <!-- Bootstrap -->
        <link href="assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="assets/vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- iCheck -->
        <link href="assets/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

        <!-- bootstrap-progressbar -->
        <link href="assets/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- JQVMap -->
        <link href="assets/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet" />
        <!-- bootstrap-daterangepicker -->
        <link href="assets/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

        <!-- Custom Theme Style -->
        <link href="assets/build/css/custom.min.css" rel="stylesheet">
    </head>

    <body class="login">
        <header class="mb-5">
            <h1 class="text-center p-3">Gestión Hotelera</h1>
        </header>
        <div>
            <a class="hiddenanchor" id="signup"></a>
            <a class="hiddenanchor" id="signin"></a>

            <div class="login_wrapper">
                <div class="animate form login_form">
                    <section class="login_content">
                        <form>
                           <% for (Usuario usu : listaUsuarios) {

                            if (usu.getUser()!= null) {%>
                            <h1>Inicio de sesión</h1>
                            <div>
                                <input type="text" class="form-control" placeholder="Username" required="" />
                            </div>
                            <div>
                                <input type="password" class="form-control" placeholder="Password" required="" />
                            </div>
                            <div>
                                <div class="mx-auto">
                                    <button class="btn btn-secondary  mb-3" type="submit">Enviar</button>
                                </div>               
                            </div>
                            <div class="separator">
                                <p class="change_link">Nuevo en el sitio?
                                    <a href="login.jsp" class="to_register"> Crea tu usuario </a>
                                </p>
                                }else{
                                
                                }


                            </div>
                        </form>
                    </section>
                </div>

            </div>
        </div>
    </body>
</html>
  