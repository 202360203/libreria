# API de Gestión de Librería

## Descripción de la API

Esta API RESTful está desarrollada en **Spring Boot** para la gestión integral de una librería. Permite administrar de manera eficiente el catálogo de libros, el registro de usuarios y el control de préstamos de libros asociados a dichos usuarios, facilitando la automatización de procesos bibliotecarios.


## Tecnologías Utilizadas

- **Java** (versión 17 o superior recomendada)

- **Spring Boot** (Framework principal)

- **Spring Data JPA** (Persistencia y manejo de base de datos)

- **Maven** (Gestor de dependencias y construcción)

- **Base de datos relacional** (configurada vía Spring JPA)


## Pasos de Instalación y Ejecución

1. **Clonar o descargar el repositorio** en tu máquina local.

2. **Navegar al directorio del proyecto** (donde se encuentra el archivo `pom.xml` y el wrapper de Maven):

```
cd libreria
```

3. **Compilar y ejecutar la aplicación** utilizando el Maven Wrapper incluido:

   - En sistemas Linux/macOS:

   - ```
./mvnw spring-boot:run
```

   - En sistemas Windows (CMD o PowerShell):

   - ```
mvnw.cmd spring-boot:run
```

4. La aplicación se iniciará por defecto en el puerto `8080`.


## Variables de Entorno Necesarias

La aplicación se configura principalmente a través de `application.properties`. Puedes sobreescribir o definir las siguientes variables de entorno si utilizas un entorno de producción o una base de datos externa:

- `SPRING_DATASOURCE_URL`: URL de conexión a la base de datos (por defecto configurada en `application.properties`).

- `SPRING_DATASOURCE_USERNAME`: Nombre de usuario para la base de datos.

- `SPRING_DATASOURCE_PASSWORD`: Contraseña para la base de datos.

- `SERVER_PORT`: Puerto en el que correrá la aplicación (opcional, por defecto `8080`).


## Listado de Endpoints

### Libros (`/api/libros` o controlador correspondiente)

- `GET /libros`: Obtiene el listado completo de libros.

- `POST /libros`: Registra un nuevo libro.

- `GET /libros/{id}`: Obtiene los detalles de un libro específico por su ID.

- `DELETE /libros/{id}`: Elimina un libro del catálogo.

### Usuarios (`/api/usuarios`)

- `GET /usuarios`: Obtiene el listado de todos los usuarios registrados.

- `POST /usuarios`: Crea un nuevo usuario.

- `GET /usuarios/{id}`: Obtiene la información de un usuario por su ID.

### Préstamos (`/api/prestamos`)

- `GET /prestamos`: Lista todos los préstamos registrados.

- `POST /prestamos`: Registra un nuevo préstamo de libro a un usuario.


## Ejemplos de Peticiones y Respuestas

### 1. Registrar un Libro

- **Petición:** `POST /libros`

- **Cuerpo (JSON):**

- ```
{
  "titulo": "Cien años de soledad",
  "autor": "Gabriel García Márquez",
  "isbn": "978-0307474728"
}
```

- **Respuesta Exitosa (201 Created):**

- ```
{
  "id": 1,
  "titulo": "Cien años de soledad",
  "autor": "Gabriel García Márquez",
  "isbn": "978-0307474728"
}
```

