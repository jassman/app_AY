<%-- 
    Document   : formulario_entrar_DB
    Created on : 24-ene-2015, 17:21:08
    Author     : asus-pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <form class="form-signin" id="loginForm" action="javier" role="form" method="post">                                    
                        <input type="hidden" name="op" value="form_entrar_DB" />     
                        <input type="hidden" name="ob" value="autor" />  
                        <label class="control-label" for="inputLogin" style="margin-top: 15px">Usuario:</label>
                        <input value="" class="form-control"  id="inputLogin" type="text" placeholder="usuario" required="" autofocus="" name="login" />   
                        <input value="" class="form-control"  id="inputLogin" type="text" placeholder="contraseña" required="" autofocus="" name="pass" />
                        <button class="btn btn-lg btn-primary btn-block" type="submit"  style="margin-top: 15px">Acceder</button>                           
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
