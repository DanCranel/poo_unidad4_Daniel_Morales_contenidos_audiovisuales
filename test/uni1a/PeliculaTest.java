package uni1a;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//test pelicula
public class PeliculaTest {

    @Test
    void agregarActor_debeIncrementarCantidadDeActores() {
        Pelicula peli = new Pelicula("Avatar", 120, "Acción", "20th Century Studios");

        // Empezamos csin actores
        assertEquals(0, peli.getActores().size());

        Actor actor = new Actor("Sam Worthington", "Australia", 47);
        peli.agregarActor(actor);

        // Se agrega 1 al empezar
        assertEquals(1, peli.getActores().size());
        assertEquals("Sam Worthington", peli.getActores().get(0).getNombre());
    }
}
