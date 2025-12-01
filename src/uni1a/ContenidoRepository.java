package uni1a;

import java.io.IOException;
import java.util.List;
//contenido del repositorio
public interface ContenidoRepository {

    List<ContenidoAudiovisual> cargarTodo() throws IOException;

    void guardarTodo(List<ContenidoAudiovisual> contenidos) throws IOException;
    
}
