# Hospital-Appointment-System
Sistema web para gestionar citas médicas en un hospital, desarrollado con Spring Boot  siguiendo el patrón MVC. Permite registrar doctores, consultorios y gestionar citas con validaciones específicas.

Debido a falta de tiempo, se realizó un APIRestfull, falta la parte del renderizado y maquetado con Thymeleaf.
Para la base se utiliza H2 (accesible desde localhost:puerto/h2-console) y se indicó una clase para la carga inicial
de datos dentro de infrastrcuture->init.
La arquitectura utilizada es la hexagonal con enfoque en el DDD.

# Testeo de la API

Ruta: PUT -> localhost:puerto/api/cita/nueva
RequestBody:
{
    "idConsultorio": 1,
    "idDoctor": 1,
    "fechaConsulta": "2025-05-09",
    "horaConsulta": "05:40:00",
    "nombrePaciente": "Pedro"
}


Ruta: PATCH -> localhost:puerto/api/cita/{idCita}/actualizar
PathVariable: 1
RequestBody:
{
    "idConsultorio": 2,
    "idDoctor": 1,
    "fechaConsulta": "2025-05-09",
    "horaConsulta": "05:40:00",
    "nombrePaciente": "Pedro"
}