# SQL injection

<b>SIN IMPLEMENTAR</b>

Cuando hacemos una petición get en la que insertamos como qery los atributos, es posible insertar consultas que no están
definidas, saltándonos así las normas del sistema y pudiendo acceder a tablas de la BD a las que no deberíamos.

El ejemplo a implementar debe ser algo como una API (utiliza el contexto de spring boot que ya viene dado en el proyecto)
en la que el usuario haga consultas a una tabla a través de un get. Crea tu propio controlador dentro de este paquete.

Algo de documentación sobre la vulnerabilidad y ejemplos:

https://www.w3schools.com/sql/sql_injection.asp

https://es.wikipedia.org/wiki/Inyecci%C3%B3n_SQL

https://www.youtube.com/watch?v=qzE07kZ6CHk

https://www.youtube.com/watch?v=h-9rHTLHJTY

IMPORTANTE: si usas Spring boot es posible que automáticamente detecte esas consultas maliciosas y las bloquee. Deberás
juguetear con la seguridad para deshabilitar esto o crear tus própios métodos de concatenación de consultas a través
de los parámetros recibidos en la URL.
