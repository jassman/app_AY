
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Examen Servidor Noviembre 2014</h1>    
        <ul>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=usuario&op=entrar">Ejercicio 01 Entrada al Sistema</a> - http://localhost:8081/servidor_nov_2014/javier?ob=usuario&op=entrar</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=usuario&op=salir">Ejercicio 01 Salir del sistema</a> - http://localhost:8081/servidor_nov_2014/javier?ob=usuario&op=salir</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=usuario&op=entrarDB">Ejercicio 01 Entrada al Sistema</a> -http://localhost:8081/servidor_nov_2014/javier?ob=usuario&op=entrarDB</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ganancias&op=getall">Ejercicio 02</a> -http://localhost:8081/servidor_nov_2014/javier?ob=ganancias&op=getall</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ganancias&op=getganancias&idautor=40">Ejercicio 03</a> - http://localhost:8081/servidor_nov_2014/javier?ob=ganancias&op=getganancias&idautor=40</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ganancias&op=suma&id_1=40&id_2=41">Ejercicio 04</a> - http://localhost:8081/servidor_nov_2014/javier?ob=ganancias&op=suma&id_1=40&id_2=41 </li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=disco&op=porgenero&id=4">Ejercicio 05</a> - http://localhost:8081/servidor_nov_2014/javier?ob=disco&op=porgenero&id=4</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=titulo&op=getpage&rpp=3&pag=2">Ejercicio 06</a> - http://localhost:8081/servidor_nov_2014/javier?ob=titulo&op=getpage&rpp=3&pag=2</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=titulo&op=update&id=1&descripcion=laios">Ejercicio 07</a> - http://localhost:8081/servidor_nov_2014/javier?ob=titulo&op=update&id=1&descripcion=laios</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=copyautores&idautor=3">Ejercicio 08</a> - http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=copyautores&idautor=3</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=insert&nombre=barcelona&id=50">Ejercicio 09</a> - http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=insert&nombre=barcelona&idautor=50</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=remove&id=9">Ejercicio 10</a> - http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=remove&$id=9</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=get&id=2">Ejercicio 11</a> - http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=get&$id=2</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ganancias&op=getpage&pag=1&filter=id&filteroperator=like&filtervalue=2">Ejercicio 12</a> - http://localhost:8081/servidor_nov_2014/javier?ob=ganancias&op=getpage&pag=1&filter=id&filteroperator=like&filtervalue=2</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=mezcla&nuero=5">Ejercicio 13</a> - http://localhost:8081/servidor_nov_2014/javier?ob=ciudad&op=mezcla&nuero=5</li>
        </ul>
        <ul>
            <li><a href="http://localhost:8081/servidor_nov_2014/exe?ob=usuario&op=entrar">Ejercicio 01 Entrada al Sistema</a> - http://localhost:8081/servidor_nov_2014/exe?ob=usuario&op=entrar</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/exe?ob=usuario&op=logout">Ejercicio 01 Salir del sistema</a> - http://localhost:8081/servidor_nov_2014/exe?ob=usuario&op=logout</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/exe?ob=genero&op=getall">Ejercicio 02</a> - http://localhost:8081/servidor_nov_2014/exe?ob=genero&op=getall</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/exe?ob=genero&op=getcount">Ejercicio 03</a> - http://localhost:8081/servidor_nov_2014/exe?ob=genero&op=getcount</li>
            <li><a href=" http://localhost:8081/servidor_nov_2014/exe?ob=autor&op=populate">Ejercicio 04</a> - http://localhost:8081/servidor_nov_2014/exe?ob=autor&op=populate</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/exe?ob=disco&op=populate&cantidad=23">Ejercicio 05</a> - http://localhost:8081/servidor_nov_2014/exe?ob=disco&op=populate&cantidad=23</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/exe?ob=disco&op=getpage&rpp=3&pag=2">Ejercicio 06</a> - http://localhost:8081/servidor_nov_2014/exe?ob=disco&op=getpage&rpp=3&pag=2</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/exe?ob=autor&op=removeall">Ejercicio 07</a> - http://localhost:8081/servidor_nov_2014/exe?ob=autor&op=removeall</li>
            <li><a href="http://localhost:8081/servidor_nov_2014/exe?ob=disco&op=changeforeign&id_genero=3&id_genero_new=4">Ejercicio 08</a> - http://localhost:8081/servidor_nov_2014/exe?ob=disco&op=changeforeign&id_genero=3&id_genero_new=4</li>
        </ul>

    </body>
</html> 
