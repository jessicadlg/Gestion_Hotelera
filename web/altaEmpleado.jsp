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

        <title>Gesti�n hotelera </title>

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

    <body class="nav-md">
        <%
            HttpSession misession = request.getSession();
            String usu = (String) misession.getAttribute("usuario");
            if (usu == null) {
                response.sendRedirect("login.jsp");
            } else {
        %>
        <% }%>
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;">
                            <a href="index.jsp" class="site_title"><i class="fa fa-building-o"></i> <span>Hotel Paisajes</span></a>
                        </div>

                        <div class="clearfix"></div>

                        <!-- menu info panel izq -->
                        <div class="profile clearfix">
                            <div class="profile_pic">
                                <img src="assets/images/img.jpg" alt="..." class="img-circle profile_img">
                            </div>
                            <div class="profile_info">
                                <span>Bienvenido,</span>
                                <h2><%=request.getSession().getAttribute("usuario")%></h2>
                            </div>
                        </div>
                        <!-- /menu profile quick info -->

                        <br />

                        <!-- sidebar menu -->
                        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                            <div class="menu_section">
                                <h3>Panel de administraci�n</h3>
                                <ul class="nav side-menu">
                                    <li><a><i class="fa fa-user"></i> Empleados <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="altaEmpleado.jsp">Registrar empleados</a></li>
                                            <li><a href="verEmpleados.jsp">Ver empleados</a></li>
                                        </ul>
                                    </li>

                                    <li><a><i class="fa fa-home"></i> Reservas <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="altaReserva.jsp">Registrar reservas</a></li>
                                            <li><a href="verReservas.jsp">Ver reservas</a></li>

                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-star"></i> Habitaciones <span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="altaHabitacion.jsp">Registrar habitacion</a></li>
                                            <li><a href="verHabitaciones.jsp">Ver habitaciones</a></li>
                                        </ul>
                                    </li>
                                    <li><a><i class="fa fa-users"></i>Huesped<span class="fa fa-chevron-down"></span></a>
                                        <ul class="nav child_menu">
                                            <li><a href="altaHuesped.jsp">Registro de huesped</a></li>
                                            <li><a href="verHuespedes.jsp">Ver huesped</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!-- /sidebar menu -->

                    </div>
                </div>

                <!-- top navigation -->
                <div class="top_nav">
                    <div class="nav_menu">
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>
                        <nav class="nav navbar-nav">
                            <ul class=" navbar-right">
                                <li class="nav-item dropdown open" style="padding-left: 15px;">
                                    <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown"
                                       data-toggle="dropdown" aria-expanded="false">
                                        <img src="assets/images/img.jpg" alt=""><%=request.getSession().getAttribute("usuario")%>
                                    </a>
                                    <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="javascript:;">Completar perfil</a>
                                        <a class="dropdown-item" href="javascript:;">
                                            <span class="badge bg-red pull-right">50%</span>
                                            <span>Configuraciones</span>
                                        </a>
                                        <a class="dropdown-item" href="#;">Ayuda</a>
                                        <a class="dropdown-item"  href="login.jsp"><i class="fa fa-sign-out pull-right"></i> Cerrar sessi�n</a>
                                    </div>
                                </li>
                                <ul class="dropdown-menu list-unstyled msg_list" role="menu" aria-labelledby="navbarDropdown1">
                                    <li class="nav-item">
                                        <a class="dropdown-item">
                                            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                            <span>
                                                <span>John Smith</span>
                                                <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                                Film festivals used to be do-or-die moments for movie makers. They were where...
                                            </span>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="dropdown-item">
                                            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                            <span>
                                                <span>John Smith</span>
                                                <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                                Film festivals used to be do-or-die moments for movie makers. They were where...
                                            </span>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="dropdown-item">
                                            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                            <span>
                                                <span>John Smith</span>
                                                <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                                Film festivals used to be do-or-die moments for movie makers. They were where...
                                            </span>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="dropdown-item">
                                            <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                            <span>
                                                <span>John Smith</span>
                                                <span class="time">3 mins ago</span>
                                            </span>
                                            <span class="message">
                                                Film festivals used to be do-or-die moments for movie makers. They were where...
                                            </span>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <div class="text-center">
                                            <a class="dropdown-item">
                                                <strong>See All Alerts</strong>
                                                <i class="fa fa-angle-right"></i>
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->

                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 mx-auto">
                            <div class="card shadow-lg p-3 mb-5 bg-white ">
                                <div class="card-header text-center">Registro de empleado</div>
                                <div class="card-body">
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
                                                <label for="direccion">Direcci�n:</label>
                                                <select name="direccion" id="direccion" class="form-control">
                                                    <option value="" selected disabled="disabled">Ingrese una opcion..</option>
                                                    <option value="Mor�n">Mor�n</option>
                                                    <option value="Capital">Capital</option>
                                                    <option value="Caballito">Caballito</option>
                                                </select>
                                            </div>
                                            <div class="col-md-12 mb-3">
                                                <label for="cargo">Cargo:</label>
                                                <select name="cargo" id="cargo"  class="form-control">
                                                    <option value="">Ingrese su cargo..</option>
                                                    <option value="Encargado">Encargado</option>
                                                    <option value="Mantenimiento">Mantenimiento</option>
                                                    <option value="Limpieza">Limpieza</option>
                                                    <option value="Cocinero">Cocinero</option> 
                                                    <option value="Limpieza">Limpieza</option> 
                                                    <option value=" RRHH"> RRHH</option>
                                                    <option value="Recepcionista">Recepcionista</option>
                                                </select>
                                            </div>
                                            <div class="mx-auto">
                                                <button class="btn btn-secondary" type="submit">Enviar</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>    
                        </div>  
                    </div>
                </div>
                <!-- /page content -->

            </div>
        </div>


        <!-- footer content -->
        <footer class="footer">
            <div class="container-fluid">
                <p class="copyright text-center">
                    �
                    <script>
                        document.write(new Date().getFullYear())
                    </script>
                    creado por<a href=""> Jessica Delgado</a>
                </p>
            </div>
        </footer>
        <!-- /footer content -->
        <!-- jQuery -->
        <script src="assets/vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="assets/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <!-- FastClick -->
        <script src="assets/vendors/fastclick/lib/fastclick.js"></script>
        <!-- NProgress -->
        <script src="assets/vendors/nprogress/nprogress.js"></script>
        <!-- Chart.js -->
        <script src="assets/vendors/Chart.js/dist/Chart.min.js"></script>
        <!-- gauge.js -->
        <script src="assets/vendors/gauge.js/dist/gauge.min.js"></script>
        <!-- bootstrap-progressbar -->
        <script src="assets/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
        <!-- iCheck -->
        <script src="assets/vendors/iCheck/icheck.min.js"></script>
        <!-- Skycons -->
        <script src="assets/vendors/skycons/skycons.js"></script>
        <!-- Flot -->
        <script src="assets/vendors/Flot/jquery.flot.js"></script>
        <script src="assets/vendors/Flot/jquery.flot.pie.js"></script>
        <script src="assets/vendors/Flot/jquery.flot.time.js"></script>
        <script src="assets/vendors/Flot/jquery.flot.stack.js"></script>
        <script src="assets/vendors/Flot/jquery.flot.resize.js"></script>
        <!-- Flot plugins -->
        <script src="assets/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
        <script src="assets/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
        <script src="assets/vendors/flot.curvedlines/curvedLines.js"></script>
        <!-- DateJS -->
        <script src="assets/vendors/DateJS/build/date.js"></script>
        <!-- JQVMap -->
        <script src="assets/vendors/jqvmap/dist/jquery.vmap.js"></script>
        <script src="assets/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
        <script src="assets/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
        <!-- bootstrap-daterangepicker -->
        <script src="assets/vendors/moment/min/moment.min.js"></script>
        <script src="assets/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

        <!-- Custom Theme Scripts -->
        <script src="assets/build/js/custom.min.js"></script>
    </body>
</html>


