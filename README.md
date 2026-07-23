<div align="center">
  <img src="src/main/java/imagenes/Gemini_Generated_Image_o197hno197hno197.png" alt="" height="96">

  # ReadingPlan

  *Sistema de escritorio para la gestión y seguimiento personal de lectura de libros*

  [![Java](https://img.shields.io/badge/Java-25-%23ED8B00?style=flat-square&logo=java)](https://openjdk.org)
  [![Maven](https://img.shields.io/badge/Maven-3.9-%23C71A36?style=flat-square&logo=apachemaven)](https://maven.apache.org)
  [![MySQL](https://img.shields.io/badge/MySQL-9.1-%234479A1?style=flat-square&logo=mysql)](https://dev.mysql.com)
  [![JavaFX](https://img.shields.io/badge/JavaFX-25-%2343853D?style=flat-square&logo=openjfx)](https://openjfx.io)
</div>

Aplicación de escritorio para gestionar tu lista de lectura personal. Permite registrar libros, seguir su progreso por estados (planeado, leyendo, leído) y generar reportes de lectura.

> [!NOTE]
> Este proyecto se encuentra en desarrollo activo. La capa de dominio está completa; las capas de persistencia, servicios e interfaz de usuario están en progreso.

## Funcionalidades

- **CRUD completo** de libros con validaciones de negocio
- **Seguimiento por estados** con transiciones controladas y validación de reglas
- **Detalles específicos por estado**: prioridad para planeados, páginas leídas para leyendo, calificación para leídos
- **Búsqueda** por título o autor
- **Reportes** con estadísticas de lectura, progreso y exportación a CSV y JSON

## Mapa de estados

Cada libro solo puede transicionar entre estados siguiendo este flujo:

```
NINGUNO ──> PLANEADO ──> LEYENDO ──> LEIDO
                    ↑           │
                    └───────────┘ (no permitido)
```

| Transición | Regla |
|---|---|
| `NINGUNO → PLANEADO` | Permitido siempre que el libro no tenga estado actual |
| `PLANEADO → LEYENDO` | El libro debe estar en estado Planeado |
| `LEYENDO → LEIDO` | La fecha de finalización debe ser posterior a la fecha de inicio |
| `LEIDO → LEYENDO` | No permitido |
| `LEYENDO/LEIDO → PLANEADO` | No permitido |

## Arquitectura

```
src/main/java/
├── entidades/
│   ├── libro/
│   │   ├── Libro.java            # Entidad principal con validaciones
│   │   └── EstadoLibro.java      # Enum: LEYENDO, LEIDO, PLANEADO
│   └── detalles/
│       ├── DetallesLeyendo.java  # páginas leídas
│       ├── DetallesLeido.java    # fecha final, calificación
│       └── DetallesPlaneado.java # fecha planeada, prioridad
├── interfaz/
│   └── DetallesEstado.java       # Strategy pattern
├── repositorio/
│   ├── InterfazRepositorio.java  # Contrato repositorio
│   └── mysql/
│       ├── ConexionMySQL.java    # Conexión singleton
│       └── LibroRepositorio.java # CRUD MySQL
├── ui/
│   ├── controllers/              # Controladores JavaFX
│   ├── vistas/                   # FXML
│   └── estilos/                  # CSS
└── App.java                      # Entry point
```

## Stack tecnológico

| Capa | Tecnología |
|---|---|
| Lenguaje | Java 25 |
| Build | Maven 3.9 |
| UI | JavaFX 25 |
| Base de datos | MySQL 9.1 |
| Conector | mysql-connector-j 9.1.0 |

### Patrones de diseño

- **Strategy** — `DetallesEstado` como interfaz con implementaciones concretas por estado
- **Repository** — Abstracción de persistencia vía `InterfazRepositorio`
- **Singleton** — `ConexionMySQL` para gestión de conexión a base de datos

## Estado del proyecto

| Capa | Estado | Detalle |
|---|---|---|
| Entidades (modelo de dominio) | Completado | Libro, enum, detalles por estado con validaciones |
| Interfaz repositorio | Pendiente | Esqueleto por implementar |
| Conexión MySQL | Pendiente | Esqueleto por implementar |
| Repositorio MySQL | Pendiente | Esqueleto por implementar |
| Servicios | No iniciado | LibroServicio, ReporteServicio |
| Controladores negocio | No iniciado | LibroControlador, ReporteControlador |
| UI Controladores | Pendiente | 4 clases esqueleto |
| Vistas FXML | Pendiente | 5 archivos vacíos |
| Estilos CSS | Pendiente | Archivo vacío |
| Exportación CSV/JSON | No iniciado | |
| Tests | No iniciado | |

## Getting started

### Requisitos

- Java 25+
- Apache Maven 3.9+
- MySQL 8+
- JavaFX 25 (module-path)

### Compilar

```bash
mvn clean compile
```

> [!WARNING]
> El esquema de base de datos está sujeto a cambios durante el desarrollo. Se planea migrar a un modelo de tablas separadas por estado (Class Table Inheritance).
