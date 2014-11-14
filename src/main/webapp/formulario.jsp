<%-- 
    Document   : formulario
    Created on : 11-nov-2014, 18:22:56
    Author     : raznara
--%>

<%@page import="net.daw.helper.Aleatorio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
int numero1= Aleatorio.randInt(1, 10);
int numero2= Aleatorio.randInt(1, 10);
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
                    <h2>Numero1: <%=numero1%></h2>
                    <h2>Numero2: <%=numero2%></h2>
                    <form class="form-signin" id="loginForm" action="exe" role="form" method="post">                                    
                        <input type="hidden" name="numero1" value="<%=numero1%>" />
                        <input type="hidden" name="numero2" value="<%=numero2%>" />
                        <input type="hidden" name="op" value="logindesdeformulario" />     
                        <input type="hidden" name="ob" value="usuario" />  
                        <label class="control-label" for="inputLogin" style="margin-top: 15px">Usuario:</label>
                        <input value="" class="form-control"  id="inputLogin" type="text" placeholder="nombre de usuario" required="" autofocus="" name="login" />                                                                            
                        <button class="btn btn-lg btn-primary btn-block" type="submit"  style="margin-top: 15px">Acceder</button>                           
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
