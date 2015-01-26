<%-- 
    Document   : formulario
    Created on : 11-nov-2014, 18:22:56
    Author     : raznara
--%>

<%@page import="net.daw.helper.Aleatorio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String palabra = Aleatorio.randString();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <img class="pull-left" src="fonts/user.png" alt="user image" style="padding: 20px 10px 5px 0" />
                    <h1>Formulario de entrada al sistema</h1>
                    <h2>Clave: <%=palabra%></h2>
                    <form class="form-signin" id="loginForm" action="javier" role="form" method="post">                                    
                        <input type="hidden" name="palabra" value="<%=palabra%>" />
                        <input type="hidden" name="op" value="form_entrar" />     
                        <input type="hidden" name="ob" value="usuario" />  
                        <label class="control-label" for="inputLogin" style="margin-top: 15px">Usuario:</label>
                        <input value="" class="form-control"  id="inputLogin" type="text" placeholder="repite la palabra" required="" autofocus="" name="palabra_usuario" />                                                                            
                        <button class="btn btn-lg btn-primary btn-block" type="submit"  style="margin-top: 15px">Acceder</button>                           
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
