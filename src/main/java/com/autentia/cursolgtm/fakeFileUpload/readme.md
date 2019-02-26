# Subida de archvios no controlada

Este ataque consiste simplemente en la libertad del usuario de subir cualquier tipo de fichero al sistema.

Supón un sistema dado en el que el usuario debe adjuntar una serie de documentso en, por ejemplo, formato pdf.

¿Qué pasa si el usuario sube otro tipo de formatos? Y ya no solo eso, ¿el usuario puede insertar en el nombre del archivo
el directorio que le de la gana y crear archivos donde le plazca?

En ciertos sistemas Unix y Linux, si almacenamos un archivo binario con extensión .sh en la carpeta determinada éste se
ejecutará al arrancar. ¿Ves lo que puede llegar a ocasionar este problema?

## Ejemplo a implementar

Simplemente debe pedirse un archivo al usuario, simulando un sistema como el indicado antes, y veremos que podemos subir
cualquier tipo de archivo, lo que provocará, como mínimo, inconsistencias futuras en nuestra BD.

Para controlar esto debemoc comprobar tanto el contentType del archivo como su extensión, y no permitir que el archivo
inserte en el sistema cualquier cosa que no esté definida en las reglas.
