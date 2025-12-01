package poo;

import java.io.IOException;
import java.util.List;

import uni1a.CatalogoContenido;
import uni1a.Pelicula;
import uni1a.ContenidoAudiovisual;


//Controlador: coordina Vista y Modelo.
 
public class ContenidoControlador {

    private final CatalogoContenido catalogo;
    private final VistaConsolaContenido vista;

    public ContenidoControlador(CatalogoContenido catalogo, VistaConsolaContenido vista) {
        this.catalogo = catalogo;
        this.vista = vista;
    }

    public void iniciar() {
        try {
            catalogo.cargarDesdeArchivos();
            vista.mostrarMensaje("Datos cargados correctamente desde archivos.\n");
        } catch (IOException e) {
            vista.mostrarMensaje("No se pudieron cargar los datos: " + e.getMessage());
        }

        boolean continuar = true;
        while (continuar) {
            int opcion = vista.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    listarContenidos();
                    break;
                case 2:
                    agregarPelicula();
                    break;
                case 3:
                    buscarPorGenero();
                    break;
                case 4:
                    continuar = false;
                    guardarYSalir();
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void listarContenidos() {
        List<ContenidoAudiovisual> lista = catalogo.listarTodo();
        vista.mostrarListaContenidos(lista);
    }

    private void agregarPelicula() {
        String titulo = vista.pedirTexto("Título de la película");
        int duracion = vista.pedirEntero("Duración en minutos");
        String genero = vista.pedirTexto("Género");
        String estudio = vista.pedirTexto("Estudio");

        Pelicula peli = new Pelicula(titulo, duracion, genero, estudio);
        catalogo.agregarContenido(peli);

        vista.mostrarMensaje("Película agregada correctamente.");
    }

    private void buscarPorGenero() {
        String genero = vista.pedirTexto("Ingrese el género a buscar");
        List<ContenidoAudiovisual> resultados = catalogo.buscarPorGenero(genero);
        if (resultados.isEmpty()) {
            vista.mostrarMensaje("No se encontraron contenidos para el género: " + genero);
        } else {
            vista.mostrarListaContenidos(resultados);
        }
    }

    private void guardarYSalir() {
        try {
            catalogo.guardarEnArchivos();
            vista.mostrarMensaje("Datos guardados correctamente. ¡Hasta pronto!");
        } catch (IOException e) {
            vista.mostrarMensaje("Error al guardar los datos: " + e.getMessage());
        }
    }
}
