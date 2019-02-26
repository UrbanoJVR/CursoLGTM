# PRÁCTICA DE DESARROLLO SEGURO

Este proyecto es un ejemplo para aprender buenas prácticas de programación segura.

Consiste en un conjunto de ejemplos de las vulnerabilidades más conocidas.

## ARQUITECTURA

El proyecto ha sido construido con las siguientes tecnologías:

    - Maven
    - JEE
    - Spring boot
 
Otras dependencias añadidas:

    - Gson
    - h2Database

Cada paquete es una vulnerabilidad diferente

Continúa leyendo para conocer cómo se organizan los paquetes y cómo añadir ejepmlos de vulnerabilidades al proyecto.

## PAQUETES

Abre el proyecto con tu IDE favorito (nosotros hemos usado IntelliJ) y abre el directorio src > main > java > com >
autentia > cursolgtm

Dentro de este directorio encontrarás los paquetes esenciales del proyecto.

Cada paquete contiene en su interior el código necesario para ejecutar cada ejemplo de vulnerabilidad.

Por ejemplo: el paquete "insecureDeserialization" contiene un POJO y un main para ejecutar un ejemplo y ver cómo se
produce esta vulnerabilidad.

## README para cada ejemplo

Dentro de cada paquete, además, debe haber un archivo readme.md que explique lo básico para poder comprender la
vulnerabilidad y el código. Debe tratar, por lo menos, estos puntos:

    * Cuándo y cómo ocurre dicha vulnerabilidad
    * Cómo ejecutar el código de ejemplo propuesto
    * Qué datos debe introducir el usuario, qué respuestas debe esperar o qué acciones debe ejecutar
    * Recomendaciones para protegerse contra dicha vulnerabilidad en entornos reales
    * Dependencias del ejemplo para aclarar su funcionamiento

## CÓMO IMPLEMENTAR UN EJEMPLO DE UNA NUEVA VULNERABILIDAD

### Verifica antes su existencia

Ante de nada, ve al final de este documento y revisa la lista de vulnerabilidades implementadas para asegurarte de que
no está ya implementada. Si no está implementada, revisa la lista de vulnerabilidades que no están implementadas y,
si existe ahí, crea tu ejemplo dentro del paquete indicado. Si ni siquiera existe el paquete sin implementar, revisa
entonces el último apartado de nuevas ideas para saber cómo insertar un nuevo ejemplo no existente en el proyecto.

### Cómo implementarla

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
tu appController dentro de tu propio paqete con las anotaciones respectivas (@RestController, @RequestMapping,
@GetMapping, @PostMapping, etc) al inicio de tu clase.

Para evitar problemas con otras vulnerabilidades debes crear cada enpoint en una dirección que no exista previamente en
el proyecto. Un buen ejemplo: @RequestMapping("/miNuevaVulnerabilidad"). Así te aseguras de que tu ejemplo solo ataca a
tu contexto y no se confunde con los demás enpoints que se levantarán creados por otros usuarios para otros paquetes
de otras vulnerabilidades.

### Documenta tu ejemplo

Al terminar tu ejemplo, cuando ya es totalmente funcional, debes documentarlo adecuadamente con un readme apropiado que
contenga los puntos citados arriba en el apartado donde se explica el readme para que todo quede bien claro y el que
venga después pueda entender, ejecutar y aprender de tu vulnerabilidad.

## EJEMPLOS QUE YA HAN SIDO IMPLEMENTADOS

Estos ejemplos ya están en funcionamiento. Siguen toda la normativa citada hasta ahora: cada uno contiene todo su
código en su respectivo paquete, incluyendo un readme apropiado. Para probarlos, solo viaja hasta el paquete que te
indicamos en la lista.

Es importante que cuando se inserte un nuevo ejemplo se añada a esta lista siguiendo un orden ALFABÉTICO.

A continuación se indica qué paquetes contienen ya un ejempo en funcionamiento. Se indica el nombre
de la vulnerabilidad (en negrita) y a continuación el paquete en el que está contenido todo lo necesario sobre ella.
Todos los paquetes citados están en com.autentia.cursolgtm:

- <b>Deserialización insegura de objetos :</b> insecureDeserialization
- <b>Entidades Externas (XXE) :</b> externalEntitiesXXE
- <b>Target Blank con enlaces a nueva pestaña :</b> noOpener

## EJEMPLOS QUE NO ESTÁN IMPLEMENTADOS

Corresponde a ejemplos cuyo paquete para su inserión ha sido creado pero todavía nadie los ha implementado ni explicado.
Cada paquete por implementar contiene un readme explicando en qué consiste la vulnerabilidad y pistas para su
implementación, así como enlaces a fuentes para ayudar a la comprensión y creación del ejemplo si es necesario.

Para implementar un ejemplo nuevo deben serguirse las normas citadas anteriormente. Recalcamos una vez más la
importancia de dejar todo bien claro para los usuarios posteriores.

Es muy importante tambíen que al haber acabado todo esto edites este readme eliminando el ejemplo que hayas terminado
de la lista de ejemplos sin implementar e insertándolo en la lista anterior de ejemplos implementados. <b>No olvides
respetar el orden alfabético</b>.

Se sigue el convenio de la lista anterior: el nombre de la vulnerabilidad en negrita y después el nombre del paquete
donde se debe ubicar el ejemplo a crear.

- <b>Captura inapropiada de errores:</b> badErrorCapture
- <b>Concatenación insegura de comandos :</b> commandLineConcatenation
- <b>Contraseñas inseguras no controladas :</b> passwordControl
- <b>Cross site :</b> crossite
- <b>Injección de javascript :</b> javascriptInjection
- <b>Subida de archivos falsos no controlada :</b> fakeFileUpload


## NUEVAS IDEAS

¿Conoces una vulnerabilidad que todavía no está en la lista de vulnerabilidades no implementadas? Puedes añadirla,
aunque no la implementes. Como mínimo, sigue los siguientes pasos:

 1) Crea el paquete con un nombre apropiado dentro de com.autentia.cursolgtm
 2) Dentro de ese paquete inserta un readme lo más explicado posible que contenga la explicación de la vunlerabilidad
 y fuentes externas para su comprensión, así como recomendaciones para el ejemplo que se debe implementar
 3) Inserta en la lista anterior de "<i>ejemplos que no están implementados</i>" el nombre de tu vulnerabilidad y el
 paquete correspondiente. Asegúrate de seguir el mismo convenio: <b>Nombre de tu vulnerabilidad :</b> nombreDelPaquete.
 Y tampoco olvides respetar el orden alfabético.
 4) <b>[OPCIONAL]</b>: Si, finalmente, no solo añades el paquete sino que implementas un ejemplo, revísalo para
 asegurarte de que cumple con todos los requisitos, añádelo a la lista de ejemplos implementados y elmínalo de la
 lista de ejemplos no implementados.

# AUTORES

¿Dudas, problemas? Contacta con:

- Urbano Villanueva <a href="https://github.com/UrbanoJVR">@UrbanoJVR</a>
- Alejandro Platero <a href="https://github.com/ebksei">@ebksei</a>

# COLABORADORES

¿Has añadido una vulnerabilidad? Iserta tu nombre en esta lista:

- 
