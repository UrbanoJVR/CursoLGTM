#SECURE DEVELOPING PRACTICE
This is an example project to learn good practices on safe development.

##ARCHITECTURE

The project has been built with the following technologies:

    - Maven
    - JEE
    - Spring boot
 
Other dependencies:

    - Gson
    - h2Database

The project has an "App" class that contains the Spring Boot main. Is not necesary in all cases execute Spring.
For example, the vulnerability "noOpener" don´t need any context to work with an API or connect with any DB, etc.
In this case, no more is needed.

But if the example needs anything that Spring can give, a main class will be created inside respective package
to call App Spring main, and contains the needed logic.

##PACKAGES

Open the project with your favourite IDE (we use intelliJ) and open the Java directory > com.autentia.cursolgtm.

Inside this package are the all essential packages of the project.

Each package contains the necessary code to execute a vulnerability.

For example: the package "insecureDeserialization" contains a POJO and main to execute an example and can see how works
this vulnerability

Inside each package there must be a readme.md file explains basics about respective vulnerability and code.
The readme should explain at least these points:

    * When and how this vulnerability occurs
    * How to run this example code
    * What entries should the user write, what outputs should he expect or what actions should he execute
    * Dependencies of that example

##HOW TO ADD NEW VULNERABILITY EXAMPLE
First, if it not yet exists, you must create a new package with a descriptive name to contains all of code files to
your example.

There are two types of vulnerabilities: those that do not need a SPRING context and those that do.

If the vulnerability that you are going to add needs the Spring context, you must create a main inside the package
to up the Spring Boot main context. For example:

    - Name of the package: "myNewVulnerability"
    - Name of the main inside: "myNewVulnerabilityMain"

Code inside the main class:

```java
import com.autentia.App;

public class myNewVulnerabilityMain {

    public static void main(String[] args) {
        App.main(args);
        //My logic here
    }

}
```
When you run this main, you can use te Spring Context. If you need any controller (for example an API), you must create
our controller inside the package and add the @RestController and @RequestMapping("/MyPath") annotations.

IMPORTANT: "/MyPath" must no be equal to any other controller created. Recomendation: use your package name.
