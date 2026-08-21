# 🎤 API REST de Cantantes - Spring Boot & Spring Data MongoDB

✏️ **Este es el nombre del segundo proyecto:**
`16-spring-boot-rest-crud-cantantes-mongodb`

## 📝 Descripción
Este proyecto es una API RESTful desarrollada en Java con Spring Boot. Se basa en el contexto de la industria musical para gestionar **Cantantes**.
El sistema permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) completas sobre los registros de los artistas. (Sobre la terminal mediante scripts de automatización o la BD correspondiente).

## 🔄 ¿Qué cambios se implementaron?
Se realizó un cambio completo en todas las capas de la aplicación, migrando la arquitectura para soportar una base de datos orientada a documentos (NoSQL):

* **Capa de Entidad (Document):** Se rediseñó la clase utilizando la anotación `@Document` (en lugar de `@Entity`) para incluir atributos específicos del dominio musical:
  * `id` (Generado automáticamente por MongoDB como un String/ObjectId)
  * `nombre`
  * `nacionalidad`
  * `popularidad` (Nivel del 1 al 100)
  * `ganancias` (En millones)
  * `albumMasVendido`
* **Capa de Acceso a Datos (Repository):** Implementación de `CantanteRepository` heredando de `MongoRepository` para automatizar las consultas directas a la base de datos sin escribir código manual.
* **Capa de Servicio (Service):** Creación de la interfaz `CantanteService` y su implementación para manejar la lógica de negocio.
* **Capa de Controlador (REST Controller):** Actualización de los endpoints. La API ahora expone los recursos bajo la ruta `/api/cantantes`.
* **Configuración de Entorno:** Modificación de `application.properties` para cambiar el puerto del servidor al `8081` (para no chocar con otros proyectos) y apuntar a la URI de MongoDB `cantantes_directorio`.

## 🛠️ Tecnologías Utilizadas
* Java
* Spring Boot
* Spring Data MongoDB
* MongoDB (NoSQL)
* Maven

## 🗄️ Configuración de la Base de Datos
A diferencia de los proyectos con bases de datos relacionales, MongoDB no requiere un script SQL de creación de tablas. La base de datos `cantantes_directorio` y la colección `cantantes` se generan dinámicamente al momento de realizar la primera inserción (POST).

**Nota:** Antes de ejecutar la aplicación, asegúrate de tener tu servidor/contenedor de MongoDB corriendo en el puerto `27017`. Dentro de la carpeta `guias` de este proyecto, se incluyen archivos con los comandos necesarios para realizar pruebas *End-to-End* automatizadas sobre la API usando Bash o PowerShell.

## 🚀 Endpoints de la API

| Método HTTP | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/cantantes` | Obtiene la lista de todos los cantantes |
| `GET` | `/api/cantantes/{id}` | Obtiene un cantante específico por su ID |
| `POST` | `/api/cantantes` | Agrega un nuevo cantante |
| `PUT` | `/api/cantantes` | Actualiza un cantante existente (reemplazo total) |
| `PATCH` | `/api/cantantes/{id}` | Actualiza parcialmente a un cantante |
| `DELETE`| `/api/cantantes/{id}` | Elimina a un cantante por su ID |