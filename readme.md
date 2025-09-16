# 📌 Gestión de Horas API

API REST desarrollada con **Spring Boot** para gestionar usuarios y registrar horas trabajadas en proyectos. Este proyecto está orientado a mostrar buenas prácticas en desarrollo backend con Java y servir como base para sistemas de control de tiempos.

## 🚀 Características principales

- CRUD completo de usuarios con validaciones básicas
- Arquitectura modular con **Controladores, Servicios y Repositorios**
- Uso de **JPA/Hibernate** para persistencia en base de datos relacional
- Endpoints REST documentados y fáciles de probar con Postman o cURL
- Configuración inicial para pruebas unitarias con **JUnit**

## 🛠️ Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL** (base de datos)
- **Maven**
- **JUnit 5**

## 📂 Estructura básica

```
src/main/java/com/capimonte/gestion-horas-api/
├── controller/    # Controladores REST
├── model/         # Entidades JPA
├── repository/    # Repositorios Spring Data
└── service/       # Lógica de negocio
```

## ⚡ Ejecución local

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/danielLeivaV/gestion-horas-api.git
   ```

2. **Configurar application.properties** con tu base de datos PostgreSQL

3. **Compilar y ejecutar:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acceder a los endpoints:**
   ```bash
   GET  http://localhost:8080/api/usuarios
   POST http://localhost:8080/api/usuarios
   ```
   ## pruebas provisorias

   https://github.com/danielLeivaV/gestion-horas-api/tree/main/src/requests

## 📈 Próximos pasos

- Implementar autenticación y roles con Spring Security
- Completar pruebas de integración
- Documentar la API con Swagger/OpenAPI
