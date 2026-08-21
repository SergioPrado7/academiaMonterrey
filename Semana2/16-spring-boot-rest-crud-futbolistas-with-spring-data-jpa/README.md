# ⚽ API REST de Futbolistas - Spring Boot & Spring Data JPA

✏️ **Este es el nombre del proyecto:**
`16-spring-boot-rest-crud-futbolistas-with-spring-data-jpa`

## 📝 Descripción
Este proyecto es una API RESTful desarrollada en Java con Spring Boot. Se basa en ver el contexto deportivo para mostrar **Futbolistas**.

El sistema permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) completas sobre los registros de los jugadores. (Sobre la terminal o las BD correspondientes)

----

## 🔄 ¿Qué cambios se implementaron?
Se realizó una refactorización completa en todas las capas de la aplicación (Arquitectura MVC / Capas):

* **Capa de Entidad (`Entity`):** Se rediseñó la clase para incluir atributos específicos del dominio deportivo, aplicando principios de encapsulamiento:
  * `nombre` y `apellido`
  * `posicion` (ej. Delantero, Portero)
  * `seleccion` (País al que representa)
  * `club` (Equipo actual)
  * `golesTotales` (Registro histórico de goles)
* **Capa de Acceso a Datos (`DAO/Repository`):** Implementación de `FutbolistaRepository` heredando de `JpaRepository` para automatizar las consultas SQL sin escribir código manual.
* **Capa de Servicio (`Service`):** Creación de la interfaz `FutbolistaService` y su implementación para manejar la lógica de negocio.
* **Capa de Controlador (`REST Controller`):** Actualización de los endpoints. La API ahora expone los recursos bajo la ruta `/api/futbolistas`.
* **Configuración de Entorno:** Modificación de `application.properties` para apuntar a la nueva base de datos `futbolistas_directorio` utilizando credenciales específicas (`springfutbolista`). Se adaptó la configuración para permitir conexiones desde contenedores Docker.

----

## 🛠️ Tecnologías Utilizadas
* **Java**
* **Spring Boot**
* **Spring Data JPA** 
* **MySQL**
* **Maven**

----

## 🗄️ Configuración de la Base de Datos

Las instrucciones y el script SQL necesarios para inicializar la base de datos, crear el usuario con los permisos correctos (compatibles con entornos Docker) y generar la tabla con datos de prueba, **se encuentran dentro de los archivos de este proyecto src/main/resources**. 

> **Nota:** Antes de ejecutar la aplicación con Spring Boot, asegúrate de correr el script SQL incluido en tu gestor de base de datos (como phpMyAdmin o MySQL Workbench) para evitar errores de conexión (`ApplicationContext`).

----

## 🚀 Endpoints de la API

| Método HTTP | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/futbolistas` | Obtiene la lista de todos los futbolistas |
| `GET` | `/api/futbolistas/{id}` | Obtiene un futbolista específico por su ID |
| `POST` | `/api/futbolistas` | Agrega un nuevo futbolista |
| `PUT` | `/api/futbolistas` | Actualiza un futbolista existente (reemplazo total) |
| `PATCH` | `/api/futbolistas/{id}` | Actualiza parcialmente a un futbolista |
| `DELETE`| `/api/futbolistas/{id}` | Elimina a un futbolista por su ID |
