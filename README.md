# TALLER DE MICROSERVICIOS

En este taller se implementó un sistema de publicación de posts de hasta 140 caracteres, similar al funcionamiento de Twitter. El sistema está construido utilizando Quarkus, un framework de Java diseñado para aplicaciones nativas en la nube. 
Se ha implementado como un monolito inicialmente, luego dividido en tres microservicios independientes utilizando AWS Lambda.

## Diseño de la aplicación 

La aplicación está diseñada para cumplir con los requisitos especificados en el enunciado del taller y proporcionar una experiencia de usuario fluida y satisfactoria.
El primer paso para el desarrollo de este laboratorio, fue la implementación de un monolito haciendo uso del
frameworj Quarkus.  A continuación, se describen los principales componentes y características de la aplicación:

- Se implementaron tres entidades fundamentales para el sistema: `Post`, `Stream` y `User`. 

- La clase `Post` representa cada publicación realizada en el sistema, con atributos que incluyen el propietario y el contenido del post. 

- La clase `Stream` encapsula una colección de posts, ofreciendo métodos para agregar y obtener posts. 

- La clase `User` proporciona la estructura necesaria para representar a los usuarios del sistema, incluyendo atributos como el nombre de usuario y la contraseña. Estos objetos User son fundamentales para identificar a los propietarios de los posts.

- La clase `PostController` es un controlador REST diseñado para manejar las solicitudes relacionadas con la entidad `Post`.
  Dentro de esta clase, se encuentra el método `savePost`,  el cual se encarga de recibir las solicitudes de los usuarios para publicar posts en el sistema y guardar la información en la capa de persistencia correspondiente. 

- La clase `StreamController` es un controlador REST diseñado para manejar las solicitudes relacionadas con la obtención de posts desde el sistema. Esta clase incluye el método `getPosts`, el cual se encarga de recuperar los posts almacenados en el sistema y devolverlos en formato JSON como respuesta a la solicitud.

- La clase `UserController` es un controlador REST diseñado para manejar las solicitudes relacionadas con la gestión de usuarios en el sistema

-  Para el monolito en Quarkus, se implementó la capa de persistencia en las clases Services de cada uno de los controladores. Para el despliegue en AWS, se hace uso de una base de datos Mongo.

## Guía de Inicio

Las siguientes instrucciones le permitirán descargar una copia y ejecutar la aplicación en su máquina local.

### Prerrequisitos

- Java versión 8 OpenJDK
- Maven
- Git

1. Ubíquese sobre el directorio donde desea realizar la descarga y ejecute el siguiente comando:

```shell script
  git clone https://github.com/Mateo0laya/AREP-Lab8-Microservices.git 
```
2. Navegue al directorio del proyecto:

```shell script
  cd AREP-Lab8-Microservices
```

3. Ejecute el siguiente comando para compilar el código:

```shell script
  mvn compile
```

4. Para iniciar el servidor, ejecute el siguiente comando:
```shell script
  mvn compile quarkus:dev
```

## Probando la Aplicación.

Ingrese a la siguiente URL para ingresar a el cliente: `http://localhost:8080/index.html`.

![img.png](img/img.png)

Ingrese la mensaje a postear:

![image](https://github.com/Mateo0laya/AREP-Lab8-Microservices/assets/63562181/dce40e6a-816c-4c33-86f0-b7f4af652dd0)

De clic en el botón `Postear`,  podrá observar que los mensajes se muestran en la parte inferior.

![image](https://github.com/Mateo0laya/AREP-Lab8-Microservices/assets/63562181/48eda60a-5e4b-4289-ad2d-2cfe5f708ba8)

# Despliegue en Amazon Web Services

A continuación, se describe la arquitectura de la aplicación en Amazon Web Services (AWS). La aplicación se despliega en la infraestructura de la nube de AWS para garantizar escalabilidad, disponibilidad y seguridad.

## Arquitectura

![image](https://github.com/Mateo0laya/AREP-Lab8-Microservices/assets/63562181/c0b57c98-eecd-4592-bf3c-4b620216a969)

## Funciones Lambda

Se desplegaron dos microservicios utilizando funciones Lambda de AWS. Estos microservicios establecen conexión con una base de datos MongoDB para almacenar y gestionar los datos de la aplicación.
Para cada uno de los microservicios, se compiló el proyecto ubicado en la rama `cloud` del repositorio para generar un JAR con todas las dependencias necesarias para su despliegue en AWS Lambda.

`post-function`: Esta función Lambda implementa la lógica para almacenar los posts en la base de datos MongoDB. Cuando se invoca, recibe un nuevo post como entrada y lo guarda en la base de datos para su posterior recuperación y visualización. Es responsable de asegurar que los posts enviados por los usuarios se almacenen correctamente en la base de datos para su uso posterior. Se mapeó el método `savePost` de la clase `PostController` para este microservicio.

![image](https://github.com/Mateo0laya/AREP-Lab8-Microservices/assets/63562181/a87a4660-76fa-4e39-ab0f-1e6afebbb29b)

`stream-function`: Esta función Lambda se encarga de proporcionar información sobre los posts almacenados en la base de datos MongoDB. Se mapeó el método `getPosts` de la clase `StreamController` para este microservicio. Al ser invocado, este método recupera los posts de la base de datos y los devuelve como respuesta al cliente que realizó la solicitud.

![image](https://github.com/Mateo0laya/AREP-Lab8-Microservices/assets/63562181/9dbe887a-be0d-4cb7-aaf9-0885c8bee974)

El uso de funciones Lambda de AWS permite una arquitectura sin servidor, escalable y de alto rendimiento.

### Pruebas

`post-function`: Se envía un nuevo post en formato JSON. Este será tomado por la clase tras la consulta y registrado en la base de datos. Si la ejecución es correcta, devolverá una respuesta HTTP con código 201.

![image](https://github.com/Mateo0laya/AREP-Lab8-Microservices/assets/63562181/b1a98bae-910b-4e99-804b-5ea96cda049b)

`stream-function`: No requiere input. Obtiene todos los registros de la base de datos.

![image](https://github.com/Mateo0laya/AREP-Lab8-Microservices/assets/63562181/af531544-2d46-4ab0-9127-c4d18021d264)


## Amazon S3

Utilizamos Amazon S3 para almacenar nuestros archivos estáticos, como HTML, CSS, JavaScript e imágenes. Esto nos permite distribuir y servir estos archivos de manera eficiente a través de internet para nuestra aplicación web. Creamos un bucket `bucket-not-twitter` para nuestra aplicación:

![image](https://github.com/Mateo0laya/AREP-Lab8-Microservices/assets/63562181/5a035e79-5483-4e95-9c13-778e0ddd88ff)









## Construido Con. 

- Maven - Administrador de dependencias


  
## Autores 

## Versión
1.0.0
