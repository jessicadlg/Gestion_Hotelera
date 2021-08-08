
<%@page import="Logica.Persona"%>
<%@page import="Logica.Empleado"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
        <link rel="stylesheet" href="assets/css/styles.css">
        <!--     Fonts and icons     -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
        <!-- CSS Files -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
        <title>Formulario de modificaci�n</title>
    </head>
    <body>
        <%
            HttpSession misession = request.getSession();
            String usu = (String) misession.getAttribute("usuario");
            if (usu == null) {
                response.sendRedirect("login.jsp");
            } else {
        %>

        <% }%>
        <div class="wrapper">
            <div class="sidebar">
                <div class="sidebar-wrapper">
                    <ul class="nav">
                        <li class="nav-item">
                            <a href="#" class="nav-link">
                                <i class="nc-icon nc-zoom-split"></i>
                                <span class="d-lg-block">&nbsp;Search</span>
                            </a>
                        </li>
                        <div class="division"> </div>
                        <li class="nav-item active">
                            <a class="nav-link m-3" href="index.jsp">  
                                <p>Panel de administraci�n</p>
                            </a>
                        </li>

                        <li>
                            <a class="nav-link" href="./user.html">
                                <i class="nc-icon nc-circle-09"></i>
                                <p>Perfil de Usuario</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./tabla.jsp">

                                <i class="nc-icon nc-grid-45"></i>
                                <p>Ver tablas</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./altaHuesped.jsp">
                                <i class="nc-icon nc-single-02"></i>
                                <p>Registro Huesped</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./icons.html">
                                <i class="nc-icon nc-notes"></i>
                                <p>Registro Empleado</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./maps.html">
                                <i class="nc-icon nc-istanbul"></i>
                                <p>Registro Habitaci�n</p>
                            </a>
                        </li>
                        <li>
                            <a class="nav-link" href="./notifications.html">
                                <i class="nc-icon nc-bell-55"></i>
                                <p>Reservas</p>
                            </a>
                        </li>
                        <i class="nc-icon nc-paper-2"></i>
                    </ul>
                </div>
            </div>
            <div class="main-panel">
                <!-- Navbar -->
                <nav class="navbar navbar-expand-lg">
                    <div class="container-fluid">
                        <div class="title">
                            <a href="index.jsp" class="simple-text">Hotel Paisajes</a>
                        </div>
                        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"  aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                            <span class="navbar-toggler-bar burger-lines"></span>
                        </button> 
                        <div class="collapse navbar-collapse justify-content-end" id="navigation">

                            <!-- Topbar Navbar -->
                            <ul class="navbar-nav ml-auto">
                                <!-- Nav Item - User Information -->
                                <li class="nav-item dropdown no-arrow">
                                    <a class="nav-link" href="#>
                                       <span class=" no-icon mr-2 d-none d-lg-inline text-gray-600 small"></span>
                                        <p><%=request.getSession().getAttribute("usuario")%></p>
                                    </a>
                                </li>    
                                <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <span class="no-icon"> <img class="img-profile rounded-circle" src="assets/img/undraw_profile_1.svg" alt=""></span>
                                    </a>
                                    <!-- Dropdown - User Information -->
                                    <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                         aria-labelledby="userDropdown">
                                        <a class="dropdown-item" href="#">
                                            Mi perfil

                                        </a>
                                        <a class="dropdown-item" href="#">
                                            Configuraciones
                                        </a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item"  href="login.jsp" data-toggle="modal" data-target="#logoutModal">
                                            Cerrar sesi�n
                                        </a>
                                    </div>
                                </li>    
                            </ul>
                        </div>
                    </div> 
                </nav>
                <!-- End Navbar -->
                <div class="content">
                    <div class="container-fluid">
                        <div class="col-lg-12 mx-auto">
                            <div class="card shadow-lg p-3 mb-5 bg-white ">
                                <div class="card-header text-center">Datos del empleado</div>
                                <div class="card-body">
                                    <form action="SvEditar" method="get">
                                        <!--  //traigo con la session-->
                                        <%
                                            Empleado emp = (Empleado) misession.getAttribute("empleado");
                                            //Persona per = (Persona) misession.getAttribute("persona");
                                            {%>
                                        <div class="form-row">
                                            <div class="col-md-12 mb-3">
                                                <label for="dni">DNI:</label>
                                                <input name="dni" type="text" class="form-control" id="dni"  value="<%=emp.getDNI()%>" required>
                                            </div>
                                            <div class="col-md-6 mb-3">
                                                <label for="nombre">Nombre:</label>
                                                <input name="nombre" type="text" class="form-control" id="nombre" placeholder="" value="<%=emp.getNombre()%>"
                                                       required>
                                            </div>
                                            <div class="col-md-6 mb-3">
                                                <label for="apellido">Apellido</label>
                                                <input name="apellido" type="text" class="form-control" id="apellido" value="<%=emp.getApellido()%>" required>
                                            </div>
                                            <div class="col-md-12 mb-3">
                                                <label for="fechaNac">Fecha nacimiento:</label>
                                                <input name="fechaNac" type="date" class="form-control" id="fecha_nacimiento" value="<%=emp.getFechaNac()%>"  required>          
                                            </div>

                                            <div class="col-md-12 mb-3">
                                                <label for="direccion">Direcci�n:</label>
                                                <select name="direccion" id="direccion" class="form-control" >
                                                    <option value="">Ingrese una opcion..</option>
                                                    <option value="Mor�n">Mor�n</option>
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
                                            <input type="hidden" name="id_numero" value="<%=emp.getId_numero()%>">

                                            <div class="mx-auto mb-3">
                                                <button class="btn btn-info  mb-3" type="submit">Modificar</button>
                                            </div>
                                        </div>
                                             <%}%>
                                    </form>
                                </div>
                            </div>    
                        </div>  
                    </div>
                </div>
            </div>
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
        </div>
    </body>
    <!--   Core JS Files   -->
    <script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
    <script src="assets/js/core/popper.min.js" type="text/javascript"></script>
    <script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
    <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
    <script src="assets/js/plugins/bootstrap-switch.js"></script>

    <!--  Chartist Plugin  
    <script src="../assets/js/plugins/chartist.min.js"></script>-->
    <!--  Notifications Plugin    
    <script src="../assets/js/plugins/bootstrap-notify.js"></script>-->
    <!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
    <script src="assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
    <!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>
    <script type="text/javascript">
                            $(document).ready(function () {
                                // Javascript method's body can be found in assets/js/demos.js
                                demo.initDashboardPageCharts();

                                demo.showNotification();

                            });
    </script>
</html>
