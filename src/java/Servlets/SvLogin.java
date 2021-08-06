package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession(true);

        //Cerrar sesion
        sesion.invalidate();

        //Redirecciono a index.jsp
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//COMO SOLUCIONAR EL TEMA DE CREAR USUARIOS? XQ ME REDIRECCIONA A LOGIN DEBIDO AL METODO DE COMPROBAR INGRESO 

// String usuario = request.getParameter("usuario");
   //     String contra = request.getParameter("contrasenia");
        /*traiga la session y asignar los atributos p abrir en cualquier JSP 
        request.getSession().setAttribute("usuario", usuario);
        request.getSession().setAttribute("contrasenia", contra);
         Controladora control = new Controladora();
        control.crearAltaUsuario(usuario, contra);*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contra = request.getParameter("contrasenia");
       

        Controladora control = new Controladora();

        boolean okNo = control.comprobarIngreso(usuario, contra);

        System.out.println("El valor que devolvió fue: " + okNo);

        if (okNo == true) {

            //obtengi la session y asigno el usuario y contra para validAR
            HttpSession misession = request.getSession(true);

            misession.setAttribute("usuario", usuario);
            misession.setAttribute("contra", contra);

            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
