# VULNERABILIDAD AL ABRIR NUEVA PESTAÑA

Cuando, en un sitio web HTML, queremos que un enlace \<a href> se abra en una nueva pestaña se utiliza la opción
<target = "_blank">. Esta vulnerabilidad se da cuando el usuario, aemás, no añade las opciones rel = "noopener noreferrer".

De esta forma, la pestaña hija puede tomar cierto control sobre la pestaña padre y ejecutar código en ella, pudiendo
por ejemplo cambiar el sitio y llevar al usuario a un sitio malicioso.

## CÓMO EJECUTAR

Para probar esta vulnerabilidad solo debemos abrir con nuestro navegador el archivo source.html.

## CÓMO PROBAR LA VULNERABILIDAD

El archivo source.html incluye un \<a href> con etiqueta target blank que abrirá en otra pestaña el archivo target.html.
El target contiene código malicioso que editará la pestaña padre y podremos ver cómo la primera ha sido hackeada.

## DEPENDENCIAS

Este ejemplo no necesita dependencias externas.

