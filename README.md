# Sistema de Gestión de Citas Médicas 🏥

[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen.svg)](https://spring.io/projects/spring-boot)

Sistema web para gestionar citas médicas en un hospital, desarrollado con Spring Boot siguiendo el patrón MVC y arquitectura hexagonal con enfoque DDD.

## Características principales ✨

- Registro y gestión de doctores
- Administración de consultorios
- Sistema de citas médicas con validaciones
- API RESTful completa
- Base de datos H2 embebida
- Carga inicial de datos automatizada

## Tecnologías utilizadas 🛠️

- **Backend**: Spring Boot 3.2.0
- **Lenguaje**: Java 21
- **Base de datos**: H2 (embebida)
- **Arquitectura**: Hexagonal + DDD
- **Patrón**: MVC

## Estructura del proyecto 📂

src/  
├── main/  
│ ├── java/  
│ │ └── com/  
│ │ └── hospital/  
│ │ ├── application/ # Capa de aplicación  
│ │ ├── domain/ # Lógica de negocio  
│ │ ├── infrastructure/ # Adaptadores e infraestructura  
│ │ └── HospitalApplication.java  
│ └── resources/  
│ ├── static/  
│ └── templates/  
└── test/ # Pruebas

## Configuración inicial ⚙️

1. Clonar el repositorio
2. Asegurarse de tener Java 21 instalado
3. Inicializar la clase ConsultorioApplication

La base de datos H2 estará disponible en:
🔗 http://localhost:8080/h2-console
Usuario: sa
Contraseña: (sin contraseña)


## API Endpoints

### 1. Crear nueva cita
```http
PUT /api/cita/nueva

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
PUT /api/cita/nueva

{
    "idConsultorio": 1,
    "idDoctor": 1,
    "fechaConsulta": "2025-05-09",
    "horaConsulta": "05:40:00",
    "nombrePaciente": "Pedro"
}
```
