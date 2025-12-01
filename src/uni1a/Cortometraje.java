package uni1a;

public class Cortometraje extends ContenidoAudiovisual {

    private String director;
    private int anioEstreno;

    public Cortometraje(String titulo, int duracionEnMinutos, String genero,
                        String director, int anioEstreno) {
        super(titulo, duracionEnMinutos, genero);
        this.director = director;
        this.anioEstreno = anioEstreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del cortometraje:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Director: " + director);
        System.out.println("Año de estreno: " + anioEstreno);
        System.out.println();
    }
}
