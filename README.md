# Sistema de Gestión de Citas Médicas 🏥

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)

Sistema web para gestionar citas médicas en un hospital, desarrollado con Spring Boot siguiendo el patrón APIRestfull y arquitectura hexagonal con enfoque DDD.

## Características principales ✨

- Registro y gestión de doctores
- Administración de consultorios
- Sistema de citas médicas con validaciones
- API RESTful completa
- Base de datos H2 embebida
- Carga inicial de datos automatizada

## Tecnologías utilizadas 🛠️

- **Backend**: Spring Boot 3.4.5
- **Lenguaje**: Java 21
- **Base de datos**: H2 (embebida)
- **Arquitectura**: Hexagonal + DDD
- **Patrón**: APIRestfull

## Estructura del proyecto 📂

src/  
├── main/  
└──── java.com.kosmos.consultorio/  
    ├── application/ # Capa de puertos  
    ├── domain/ # Lógica de negocio  
    ├── infrastructure/ # Infraestructura y persistencia  
    ├── interfaces/ # Capa de adaptadores a clientes  
    └── ConsultorioApplication.java  # Clase de entrada a al app

## Configuración inicial ⚙️

1. Clonar el repositorio
2. Asegurarse de tener Java 21 instalado
3. Inicializar la clase ConsultorioApplication

La base de datos H2:

Usuario: sa  
Contraseña: (sin contraseña)  

🔗 http://localhost:7000/h2-console  

## API Endpoints

### 1. Crear nueva cita
```http
PUT /api/cita

{
    "idConsultorio": 1,
    "idDoctor": 1,
    "fechaConsulta": "2025-05-09",
    "horaConsulta": "05:40:00",
    "nombrePaciente": "Pedro"
}
```

### 2. Actualizar cita
```http
PATCH /api/cita/{idCita}

{
    "idConsultorio": 1,
    "idDoctor": 1,
    "fechaConsulta": "2025-05-09",
    "horaConsulta": "05:40:00",
    "nombrePaciente": "Pedro"
}
```

### 3. Borrar cita
```http
DELETE /api/cita/{idCita}
```

### 4. Buscar cita
```http
//Todos los parámetros son opcionales, reemplazar {} por el valor a buscar
DELETE /api/cita?idDoctor={id}&idConsultorio={id}&fecha={YYYY-MM-DD}&hora={hh:mm:ss}&nombrePaciente={nombrePaciente}
```
