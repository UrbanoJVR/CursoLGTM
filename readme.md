# PRÁCTICA DE DESARROLLO SEGURO

Este proyecto es un ejemplo para aprender buenas prácticas de programación segura.

## ARQUITECTURA

El proyecto ha sido construido con las siguientes tecnologías:

    - Maven
    - JEE
    - Spring boot
 
Otras dependencias añadidas:

    - Gson
    - h2Database

El proyecto trata diferentes vulnerabilidades con ejemplos. Cada paquete es una vulnerabilidad diferente

Continúa leyendo para conocer cómo se organizan los paquetes y cómo añadir ejepmlos de vulnerabilidades al proyecto.

## PAQUETES

Abre el proyecto con tu IDE favorito (nosotros hemos usado IntelliJ) y abre el directorio Java > com.autentia.cursolgtm.

Dentro de este directorio encontrarás los paquetes esenciales del proyecto.

Cada paquete contiene en su interior el código necesario para ejecutar cada ejemplo de vulnerabilidad.

Por ejemplo: el paquete "insecureDeserialization" contiene un POJO y un main para ejecutar un ejemplo y ver cómo se
produce esta vulnerabilidad.

Dentor de cada paquete, además, debe haber un archivo readme.md que explique lo básico para poder comprender la
vulnerabilidad y el código. Debe tratar, por lo menos, estos puntos:

    * Cuándo y cómo ocurre dicha vulnerabilidad
    * Cómo ejecutar el código de ejemplo propuesto
    * Qué datos debe introducir el usuario, qué respuestas debe esperar o qué acciones debe ejecutar
    * Dependencias del ejepmlo para aclarar su funcionamiento

## CÓMO AÑADIR UN EJEMPLO DE UNA NUEVA VULNERABILIDAD

Primero, si no existe, debes crear un paquete con un nombre descriptivo que contendrá todos tus archivos de código
para tu ejemplo.

Existen dos tipos de vulnerabilidades: las que necesitan del contexto de Spring y las que no.

¿Cuándo necesitas el contexto de Spring? Por ejemplo, cuando quieres conectarte con una Base de Datos o también si
quieres enviar peticiones a una API.

Si quieres levantar el contexto de Spring para poder utilizarlo en tu ejemplo, debes crear dentro de tu paquete una
clase main cuya función principal será llamar a la clase App del proyecto que levanta Spring Boot. Por ejemplo:

    - Nombre del paquete ::::::::::::::::::::::::::::: "miNuevaVulnerabilidad"
    - Nombre de la clase main dentro del paqute :::::: "miNuevaVulnerabilidadMain"

Código dentro de tu Main:

```java
import com.autentia.App;

public class myNewVulnerabilityMain {

    public static void main(String[] args) {
        App.main(args);
        //Mi lógica aquí si es necesaria
    }

}
```

Cuando una persona quiera ejecutar este ejemplo, solo con ejecutar este Main levantará el contexto de Spring. Además del
main puedes necesitar otras dependencias como el controlador de una Api. En este caso, igual que el main, debes crear
tu appController dentro de tu propio paqete con las anotaciones respectivas (@RestController y @RequestMapping) al inicio
de tu clase.

Para evitar problemas con otras vulnerabilidades debes crear en enpoint en una dirección que no exista previamente en
el proyecto. Un buen ejemplo: @RequestMapping("/miNuevaVulnerabilidad"). Así te aseguras de que tu ejemplo solo ataca a
tu contexto y no se confunde con los demás enpoints que se levantarán creados por otros usuarios para otros paquetes
de otras vulnerabilidades.


