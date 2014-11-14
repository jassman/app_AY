# ausiasYield como base para resolver los ejecicios de servidor de noviembre de 2014



## Ejercicio 1: Realizar una autenticación de usuario. 

*url01a: http://localhost:8081/servidor_nov_2014/exe?ob=usuario&op=login*

*url01b: http://localhost:8081/servidor_nov_2014/exe?ob=usuario&op=logout*

* al ejecutar la aplicación y acceder a la url01a se mostrará en la url un formuario jsp con dos números aleatorios del 1 al 10 cada uno. 
* en el mismo formulario habrá un control HTML input type=”text” y un botón de submit.
* al pulsar el botón submit se enviará el contenido del control input type=”text” al controlador de la aplicación llamado “exe”
* si y sólo si el valor enviado coincide con la suma de los dos números aleatorios, se inicia una sesión en Java y, mientras dure, el usuario podrá acceder a obtener el json pedido en el ejercicio 2.
* si y sólo si el valor enviado coincide con la multiplicación de los dos números aleatorios, se inicia una sesión en Java y, mientras dure, el usuario podrá acceder a obtener el json pedido en el ejercicio 3.
* la ejecución de la url01b cerrará la sesión del usuario y ya no se podrá acceder a ejecutar ninguno de los ejercicios 2 o 3, pero sí se podrá volver a loguear el usuario accediendo a la url01a.

## Ejercicio 2: Obtener un json básico. 

*url02: http://localhost:8081/servidor_nov_2014/exe?ob=genero&op=getall*

* la ejecución de la url 2 en un usuario autenticado por suma devuelve un json bien formado con todos los datos de la tabla genero

## Ejercicio 3: Obtener un json básico.

*url03: http://localhost:8081/servidor_nov_2014/exe?ob=genero&op=getcount*

* la ejecución de la url 3 en un usuario autenticado por multiplicación devuelve un json bien formado que contiene el número de registros (todos) que haya en ese momento en la tabla genero

## Ejercicio 4: Creación de registros. 

*url04: http://localhost:8081/servidor_nov_2014/exe?ob=autor&op=populate*

* la ejecución de la url 4 crea 10 autores en la tabla autor combinando de manera aleatoria los nombres de la tabla nombre con los apellidos de la tabla apellido (sin repetir dos veces un mismo nombre o un mismo apellido en la tabla autor)

## Ejercicio 5: Creación de registros.

*url05: http://localhost:8081/servidor_nov_2014/exe?ob=disco&op=populate&cantidad=23*

* la ejecución de la url 5 crea 23 discos en la tabla disco combinando aleatoriamente uno de los títulos de los discos tomados de la tabla titulo con un autor y asignando un género aleatorio a cada disco. El parámetro cantidad puede variar, pero se debe validar que el valor esté entre 1 y 30.

## Ejercicio 6: Obtener un json paginado con claves ajenas. 

*url06: http://localhost:8081/servidor_nov_2014/exe?ob=disco&op=getpage&rpp=3&pag=2*

* la ejecución de la url 6 muestra un json con los resultados de una consulta paginada sobre la tabla disco. En concreto se mostraría la página 2, habiendo 3 registros por página. El número de registros por página y el número de página demandados pueden variar dentro de los topes permitidos por la existencia de registros. En el json deben aparecer las claves ajenas completamente desarrolladas.

## Ejercicio 7: Eliminar registros de una tabla. 

*url07: http://localhost:8081/servidor_nov_2014/exe?ob=autor&op=removeall*

* la ejecución de la url 7 elimina todos los autores en la tabla autor creados en el ejercicio 4

## Ejercicio 8: Modificar registros de una tabla.

*url08: http://127.0.0.1/servidor_nov_2014/exe?ob=disco&op=changeforeign&id_genero=3&id_genero_new=4*

* la ejecución de la url 8 cambia el género de todos los discos de la tabla disco cuyo id de genero sea el 3 por el id de género número 4. Los parámetros id_genero e id_genero_new pueden variar, pero se tiene que validar que el id_genero_new exista en la tabla de genero.

