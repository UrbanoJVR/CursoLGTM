# ENTIDADES EXTERNAS XML (XXE)

Este ejemplo trata la vulnerabilidad de entidades externas al deserializar un documento XML cuando se envia una 
petición POST con un XML malicioso y no se trata debidamente. Este fichero hará que en el atributo studentLastName del 
objeto añadido se añada el contenido del fichero /etc/passwd, pudiendo recuperarlo al hacer una petición GET de dicho elemento.

## CÓMO EJECUTAR

Este ejemplo necesita el contexto de Spring Boot para levantar una API de ejemplo. Puedes verla en la clase
MarkController.

Este paquete contiene un Main. Con ejecuar este Main llamaremos al main App de Spring Boot y estará listo para funcinar.

Es necesario generar peticiones http GET y POST. Se recomienda usar POSTMAN.

Con Spring corriendo y con POSTMAN abierto, podemos probar el ejemplo.

## CÓMO PROBAR LA VULNERABILIDAD

Para probar este ejemplo vamos a hacer dos peticiones HTTP.

La primera de ellas es una petición POST, por lo que seleccionamos dicha opción y en URL añadimos
http://localhost:8080/mark (suponemos que el servidor va a ejecutarse en la mismo equipo). En caso de que se esté
ejecutando en otro ordenador tendrás que indicar su URL o IP local. A continuación entra en la pestaña Body, dentro de
las opciones selecciona raw y en el  tipo de elemento selecciona text/xml. Después, en el campo de texto pega el XML:

```
   <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
   <!DOCTYPE bar [
   <!ENTITY xxe SYSTEM "file:///etc/passwd">
   ]>
   <mark>
       <mark>0.5</mark>
       <studentLastName>&xxe;</studentLastName>
       <studentName>a</studentName>
   </mark>
```

Una vez hecho el POST solo queda recuperar el objeto añadido. Para ello haremos un GET, por lo que seleccionaremos dicho 
método en Postman y haremos una petición a "localhost:8080/mark/student-last-name".

El servidor nos devolverá el atributo <i>studentLastname</i> de <i>Mark</i> que es el atributo en el que le hemos
indicado, con nuestro XML malicioso, que almacene el contenido der archivo <i>/etc/passwd</i>.

Podemos insertar la vulnerabilidad en cualquier atributo, no solo en el <i>studentLastName</i>, pero debe cumplir el
requisito de ser un String. Evidentemente, si intentamos almacenar el contenido de un fichero en un Integer o Long, por
ejemplo, no funcionará en ningún caso.

Puedes probar también a cambiar el XML del Post y, en lugar de insertarle el archivo passwd, puedes insertarle cualquier
otro indicándole la ruta completa al archivo desde la raíz. Verás que también funciona.

## CÓMO EVITARLA

Si tienes tu propio método de serialización XML debes añadir sentencias que eliminen cualquier tipo de redireccionamiento,
ya sean barras (/) o los puntos (..) para evitar que tu usuario tenga libertad de viajar a través de tu sistema de archivos.

Otra solución es evitar directamente que el usuario pueda introducir la cabecera <!DOCTYPE etc...>, que es lo que hacen
la mayoría de frameworks como SpringBoot en su configuración por defecto.

Pero desde luego, las dos mejores recomendaciones son las siguientes:

    - NUNCA uses métodos deprecated. Al estar obsoletos o ser versiones muy antiguas no van a estar protegidos contra
    las vulnerabilidades más recientes.
    - Utiliza siempre frameworks y librerías adecuadas, en lugar de crear tus propios métodos. Así será más fácil evitar
    que te dejes algo en el tintero. No hay que reinventar la rueda.

## DEPENDENCIAS

Solo es necesario el tomcat embebido de Spring Boot. No hay dependencias insertadas en el POM para este ejemplo.
