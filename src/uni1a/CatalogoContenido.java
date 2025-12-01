package uni1a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//gestiona el catalogo de contenido
public class CatalogoContenido {

    private final ContenidoRepository repository;
    private final List<ContenidoAudiovisual> contenidos = new ArrayList<>();

    public CatalogoContenido(ContenidoRepository repository) {
        this.repository = repository;
    }

    public void cargarDesdeArchivos() throws IOException {
        contenidos.clear();
        contenidos.addAll(repository.cargarTodo());
    }

    public void guardarEnArchivos() throws IOException {
        repository.guardarTodo(contenidos);
    }

    public List<ContenidoAudiovisual> listarTodo() {
        return Collections.unmodifiableList(contenidos);
    }

    public void agregarContenido(ContenidoAudiovisual contenido) {
        contenidos.add(contenido);
    }

    // Ejemplo de búsqueda para mostrar OCP
    public List<ContenidoAudiovisual> buscarPorGenero(String genero) {
        List<ContenidoAudiovisual> resultado = new ArrayList<>();
        for (ContenidoAudiovisual c : contenidos) {
            if (c.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
