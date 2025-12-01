package uni1a;

import java.io.IOException;
import java.util.List;

public interface ContenidoRepository {

    List<ContenidoAudiovisual> cargarTodo() throws IOException;

    void guardarTodo(List<ContenidoAudiovisual> contenidos) throws IOException;
}
