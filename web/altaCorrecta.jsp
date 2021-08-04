

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta correcta</title>
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
        <h1>Realizado correctamente!</h1>
        <a href="index.jsp" class="btn" type="submit">Volver</a>

    </body>
</html>
