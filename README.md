# Sistema de Contenidos Audiovisuales – Unidad 4 POO

Proyecto desarrollado para la asignatura **Programación Orientada a Objetos**, Unidad 4, a partir del repositorio base entregado por el docente.

El sistema gestiona un catálogo de contenidos audiovisuales (películas, series de TV, documentales, videos de YouTube, cortometrajes) y aplica:

- Manejo de archivos de texto (CSV)
- Código limpio y refactorización
- Principios SOLID
- Patrón arquitectónico MVC
- Pruebas unitarias con **JUnit 5**

## Estructura del proyecto

- `src/uni1a`
  - Modelo de dominio:  
    `ContenidoAudiovisual`, `Pelicula`, `SerieDeTV`, `Documental`,  
    `Actor`, `Temporada`, `Investigador`, `VideoYouTube`, `Cortometraje`
  - Servicio de negocio:  
    `CatalogoContenido`
  - Persistencia:  
    `ContenidoRepository` (interfaz)  
    `ArchivoContenidoRepository` (implementación con archivos CSV)

- `src/poo`
  - Vista en consola: `VistaConsolaContenido`
  - Controlador: `ContenidoControlador`
  - Clase principal: `PruebaAudioVisual` (arranca el MVC)

- `datos/`
  - Archivos CSV:  
    `peliculas.csv`, `actores.csv`, `series.csv`,  
    `temporadas.csv`, `documentales.csv`, `investigadores.csv`

- `test/uni1a`
  - `PeliculaTest`
  - `CatalogoContenidoTest`

## Requisitos

- Java 17+ (probado con JDK 21/25)
- Eclipse IDE o similar
- JUnit 5 (agregado en el **Classpath** del proyecto)

## Cómo ejecutar la aplicación

1. Clonar o descargar este proyecto.
2. Importar en Eclipse como **Existing Java Project**.
3. Verificar que la carpeta `datos/` y los archivos `.csv` existen con la cabecera correcta.
4. Ejecutar la clase:

   `poo.PruebaAudioVisual` → **Run As > Java Application**

5. Usar el menú en consola para:
   - Listar contenidos
   - Agregar películas
   - Buscar por género
   - Guardar en archivos y salir

## Cómo ejecutar las pruebas

En Eclipse:

- Clic derecho sobre `PeliculaTest` o `CatalogoContenidoTest`  
  → **Run As > JUnit Test**

Ambas pruebas deben ejecutarse correctamente (barra verde en la vista JUnit).

## Autor

- Estudiante: **Daniel Morales**
- Universidad Politécnica Salesiana
- Asignatura: Programación Orientada a Objetos – Unidad 4
