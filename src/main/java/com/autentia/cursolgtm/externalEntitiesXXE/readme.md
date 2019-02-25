# XML EXTERNAL ENTITIES (XXE)

Este ejemplo trata la vulnerabilidad de entidades externas al deserializar un documento XML cuando se envia una 
petición POST con un XML malicioso y no se trata debidamente. Este fichero hará que en el atributo studentLastName del 
objeto añadido se añada el contenido del fichero /etc/passwd, pudiendo recuperarlo al hacer una petición GET de dicho elemento.

## PROBANDO LA VULNERABILIDAD

Para probar este ejemplo vamos a hacer dos peticiones HTTP, para lo cual utilizaremos Postman.

La primera de ellas es una petición POST, por lo que selecciona dicha opción y en URL añade http://localhost:8080/mark si el servidor va a ejecutarse en la mismo equipo. En caso de que se esté ejecutando en 
otro ordenador tendrás que indicar su URL. A continuación entra en la pestaña Body, dentro de las opciones selecciona
 raw y en el  tipo de elemento selecciona text/xml. Después, en el campo de texto pega el XML:

```<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
   <!DOCTYPE bar [
   <!ENTITY xxe SYSTEM "file:///etc/passwd">
   ]>
   <mark>
       <mark>0.5</mark>
       <studentLastName>&xxe;</studentLastName>
       <studentName>a</studentName>
   </mark>
```

Antes de enviar la petición POST asegúrate de haber iniciado el servidor. Esto lo puedes hacer iniciando el main de 
la clase App como en el de la clase ExternalEntitiesXXEMain que se encuentra en este mismo paquete (com.autentia.cursolgtm.externalEntitiesXXE).

Una vez hecho el POST queda recuperar el objeto añadido. Para ello haremos un GET, por lo que seleccionaremos dicho 
método en Postman y haremos una petición a la misma URL.

Si nos fijamos en lo que devuelve el servidor veremos cómo en el campo studentLastName tenemos el contenido del 
fichero /etc/passwd del sistema del servidor, lo cual evidencia una vulnerabilidad importante en nuestro código.

