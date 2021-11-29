# SchoolSOAPWebService-2

## Descripción


Proyecto para cumplir con los siguientes requerimientos:

 ><cite>Prueba Entrevista Programador Java-React</cite>
 >
><cite>Se desea que realice una interfaz de usuario de React que permita registrar datos de estudiantes en una base de datos mediante un Web API de cualquier tecnología Java. También que dicha interfaz permita consultar los datos registrados. </cite>
>
><cite>En la consulta, que podría filtrarse por nombre, se desea obtener el nombre, la >identificación, la fecha de nacimiento, la edad, el sexo y grado académico de los estudiantes.</cite>
>
><cite>Además, se quiere que permita registrar y consultar nombre, identificación, fecha de nacimiento de los padres o tutores de los estudiantes, almacenando el año de nacimiento en la forma textual.</cite>

Desarrollo hecho en `Java 8`, utilizando `Spring Boot 2.6.0`, `Maven 2.8.4`,`MySQL 8.0.27`, `WSDL4J 1.6.3`, `JAXB API`, `MojoHaus JAXB2 Maven Plugin 2.5.0`.

## Estructura

Cada directorio en el proyecto está destinado para lo siguiente:

### src/main/java
* **`com.site.ws`**: Contiene el archivo inicializador servicio web.

* **`com.site.ws.config`**:  Contiene el archivo de configuración del servicio web y donde se especifica la ubicación del archivo `school.wsdl`.

* **`com.site.ws.endpoint`**: URLs para las peticiones.

* **`com.site.ws.entity`**: Clases enidades para la persistencia de datos.

* **`com.site.ws.repository`**: Alojar las interfaces para las operaciones CRUD, pero que actualemtente sólo se especifican la insersión y consulta a la base de datos (Cumpliendo los requerimientos).

* **`com.site.ws.service`**: Clases para la implementación de las operaciones con la base de datos. 

### src/main/resource
  

>Esta directorio contiene el archivo de propiedades para tratar el DataSource y propiedades de Hibernate.
>
>Incluye también los archivos **`db_mysql_ddl.sql`** y **`db_mysql_ddl.sql`** para la creación de la base de datos y la insersión de datos iniciales para las pruebas. Deben ejecutasrse directamente en la base de datos (Manual)

* **`xsd`**: Carpeta que contiene el archivo **`school.xsd`** para la generación automática de la clases para operaciones CRUD alojadas en `target/generated-source/jaxb` y la exportacion del **`school.wsdl`**.


## Ejecución

- Configurar las credenciales de la base de datos, localizadas en el archivo `com.site.ws.config.AppConfig.java`
- Abrir un administrador de base de datos MySQL/MariaDB y ejecutar los siguientes script:
  - Crear la base de datos utilizando el archivo `db_mysql_ddl.sql`
  - Insertar datos iniciales utilizando el archivo `db_mysql_dml.sql`
- Correr en la terminal el proyecto (o Maven) `mvn spring-boot:run` para iniciar el servicio
- Probar con un `cliente SOAP` utilizando el WSDL ubicado en **`http://localhost:8080/ws/school.wsdl`**
