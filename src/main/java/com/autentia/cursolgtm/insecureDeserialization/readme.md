# DESERIALIZACIÓN INSEGURA

Este ejemplo muestra cómo es posible manipular el contenido de un objeto serializado a Json de forma que su contenido
al ser deserializado cambiará.

## CÓMO EJECUTAR

Al ejecutar el main nos preguntará si queremos guardar o cargar el archivo. Según el número que introduzcamos en consola
ejecutara una u otra operación.

AVISO: la apicación no está preparada para excepciones. Si introduces un carácter no numérico la aplicación se romperá.

## CÓMO PROBAR LA VULNERABILIDAD

El usuario debe hacerlo de la siguiente manera:

Primero debemos seleccionar la opción de guardar para crear el archivo. Después, volvemos a iniciar el Main y esta vez
elegimos la opción 2) cargar el archivo.

Nos mostrará una comparación entre el objeto que se guardó (que está hardcodeado) y el objeto leído. Veremos que es lo
mismo. Ahora, modificamos cualquier parámetro del archivo "myCar.txt" generado. Tras esto, volvemos a ejecutar la opción
2 y veremos que esta vez el archivo deserializado ha sido modificado ya que hemos editado el archvo.

## CÓMO EVITARLA

Normalmente, la norma que mejor funciona con este tipo de fallos, es utilizar un framework oficial o una librería
adecuada para la serialización y deserialización que solvente este problema. Lo de siempre: no reinventes la rueda,
porque algo te dejarás en el tintero.

Si es necesario que tú implementes tu propio método, lo que puedes hacer es crear un hash del objeto antes de serializarlo
y guardar este hash en una ubicación oculta. Al deserializar el archivo, comprueba que el hash es el mismo y, si no es
así, significa que algo ha cambiado.

## DEPENDENCIAS

Para convertir el objeto a json y viceversa utilizamos la dependencia Gson, incluída ya previamente en el POM.

