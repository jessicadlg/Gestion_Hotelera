<%@page import="Logica.Reserva"%>
<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Huesped"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
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
                                <h3>Panel de administracion</h3>
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
                                        <a class="dropdown-item"  href="login.jsp"><i class="fa fa-sign-out pull-right"></i> Cerrar sessión</a>
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
                        <div class="col-md-12">
                            <div class="card strpied-tabled-with-hover">
                                <div class="card-header ">
                                    <h4 class="card-title">Listado de reservas</h4>
                                </div>
                                <div class="card-body table-full-width table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                        <th>Fecha de reserva</th>
                                        <th>Checkin</th>
                                        <th>Checkout</th>
                                        <th>Id Huesped</th>
                                        <th>Cantidad de personas</th>
                                        <th>Id habitación</th>
                                         <th>Id empleado</th>
                                        <th class="text-center">Acciones</th>
                                        </thead>
                                        <tbody>
                                            <% Controladora control = new Controladora();
                                                List<Reserva> listaReservas = control.traerReservas();
                                                for (Reserva res : listaReservas) { %>
                                            <tr>
                                                <%SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
                                                    String feC = sdf.format(res.getFechaDeCarga());%>
                                                <td><%=feC%></td>
                                                <%String feI = sdf.format(res.getCheckIn());%>
                                                <td><%=feI%></td>
                                                <%String feS = sdf.format(res.getCheckOut());%>
                                                <%--SIGUIENTE INTENTO TRAER UN HUESPED--%> <td><%=feS%></td>
                                                <%long idHue = res.getHuesped().getId_numero();%>
                                                <td><%=idHue%></td>
                                                <%int cantP = res.getCantidadPersonas();%>
                                                <td><%=cantP%></td>
                                                <%int idHabi = res.getHabitacion().getId_numHab();%>
                                                <td><%=idHabi%></td>
                                                 <%int idUsu = res.getUsuario().getId_usuario();%>
                                                <td><%=idUsu%></td>
                                                <td></td>

                                                <%int id = res.getId_reserva();%> 

                                                <td class="align-middle">
                                                    <form name="borrarForm" action="SvEliminar" method="POST"> 
                                                        <input type="hidden" name="id_numero" value="<%=id%>">
                                                        <button type="submit" class="btn btn-danger btn-sm m-1"  onclick="alert('Eliminado correctamente')" data-title="Delete"><i class="fa fa-trash-o"></i> Eliminar </button>
                                                    </form>
                                                    <form name="editarForm" action="SvEditar" method="POST">
                                                        <input type="hidden" name="id_numero" value="<%=id%>">
                                                        <button type="submit" class="btn btn-info btn-sm m-1" data-title="Edit"><i class="fa fa-pencil"></i> Editar </button>
                                                    </form>
                                                </td>
                                            </tr>   
                                            <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div >
    <!-- /page content -->

</div>
</div>


<!-- footer content -->
<footer class="footer">
    <div class="container-fluid">
        <p class="copyright text-center">
            ©
            <script>
                document.write(new Date().getFullYear())
            </script>
            creado por<a href=""> Jessica Delgado</a>
        </p>
    </div>
</footer>
<!-- /footer content -->
</div>
</div>

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


