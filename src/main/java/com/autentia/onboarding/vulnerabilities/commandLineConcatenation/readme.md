# Command line concatenation by user value

### Sin implementar

<a href="https://lgtm.com/projects/g/adityasharad/lgtm-workshop/snapshot/6882c9d3b33c0f03977d270fa7976d6826a079bd/files/src/activemq/activemq-tooling/activemq-perf-maven-plugin/src/main/java/org/apache/activemq/tool/sampler/plugins/LinuxCpuSamplerPlugin.java?sort=name&dir=ASC&mode=heatmap#x298c8ea7e2d6f6f5:1">
Muestra de este error en LGTM</a>

Cuando se ejecuta un comando del sistema desde nuestro programa, si es el usuario quien debe escribir ciertos parámetros,
corremos el peligro de que nos pueda concatenar comandos indeseados.

Debe realizarse un ejemplo enel que el usuario introduzca los parámetros de un comando (ya sea input por consola o como
mejor se considere) y muestre cómo el usuario puede manipular la secuencia de comandos introduciendo en él parámetros
maliciosos que puedan ejecutar sencencias indieadas a su gusto, poniendo en peligro la integridad y seguridad de nuestro
sistema.
