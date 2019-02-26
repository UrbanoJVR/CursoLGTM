# Missing error handing

Vulneravilidades en la captura de errores.

### Sin implementar

Cuando mostramos errores al usuario, si no los tratamos adecuadamente, pueden soltar gran cantidad de información sobre
nuestro sistema que puede ser utilizada por atacantes maliciosos, ya que con esa información pueden conocer por dónde
cojeamos.

Cuando se devuelva un error, debe definirse una página o error por defecto que no devuelva más que una simple muestra
del error,como "404 not found". De esta forma evitamos que los mensajes de error por defecto de nuestro sistema ayuden
a un atacante a conocer nuestro sistema de archivos o las tablas de nuestra BD.

Para implementar este ejemplo, debe crearse cualquier tipo de sistema que, al provocar un error a propósito, devuelva
gran cantidad de información. Por ejemplo, si un archivo no existe, muchas veces muestra la ruta de la carpeta completa
donde debería estar el archvivo, y cosas similares. De esta forma, se ve cómo extraer información de un sistema
simplemente provocando errores.

<p><a href="https://www.owasp.org/index.php/Missing_Error_Handling">
Información genériac sobre el error en la wiki oficial de OWASP (página sin completar)</a></p>

<p><a href="https://www.owasp.org/index.php/Improper_Error_Handling">
Wiki de OWASP (2)</a></p>

<p><a href="https://www.owasp.org/index.php/Error_Handling">
Wiki de OWASP (3)</a></p>

