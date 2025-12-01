package uni1a;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

//utilizacion de repositorio falso
public class CatalogoContenidoTest {

    @Test
    void buscarPorGenero_debeRetornarSoloCoincidencias() throws Exception {
        // Repositorio falso implementando la interfaz ContenidoRepository
        ContenidoRepository repoFalso = new ContenidoRepository() {
            @Override
            public List<ContenidoAudiovisual> cargarTodo() {
                List<ContenidoAudiovisual> lista = new java.util.ArrayList<>();
                lista.add(new Pelicula("P1", 100, "Acción", "Estudio A"));
                lista.add(new Pelicula("P2", 90, "Comedia", "Estudio B"));
                lista.add(new Pelicula("P3", 110, "Acción", "Estudio C"));
                return lista;
            }

            @Override
            public void guardarTodo(List<ContenidoAudiovisual> contenidos) {
                // No hace nada en este mock
            }
        };

        CatalogoContenido catalogo = new CatalogoContenido(repoFalso);
        catalogo.cargarDesdeArchivos();

        List<ContenidoAudiovisual> accion = catalogo.buscarPorGenero("Acción");

        assertEquals(2, accion.size()); // Debe encontrar 2 contenidos de acción
    }
}
