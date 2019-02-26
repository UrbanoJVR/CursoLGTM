# Path file manipulation

<b>SIN IMPLEMENTAR</b>

Este ataque es parecido al de subir archivos falos, que puedes encontrar en el paquete <i>fakeFileUpload</i> pero esta
vez no se trata solamente deque insertemos un archivo adecuado o no, sino de que además podamos insertarlo donde nos
plazca.

Normalmente, el nombre del fichero es un string. En ese string los usuarios normales insertan "miArchivo.extension".

Pero podemos insertar por ejemplo sentencias ../../ para viajar entre carpetas o otras como carpeta1/carpeta2/carpeta...
y toquetear el sistema de archivos de forma indeseada.

Simplemente el ejemplo a crear debe ser uno en el que el usuario suba un archivo cuyo nombre contenga sentencias como
las ejemplificadas anteriormente y ver cómo es posible tocar donde no debemos si el sistema no controla el nombre del
archivo.
