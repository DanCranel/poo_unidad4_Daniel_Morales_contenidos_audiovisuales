package uni1a;

public class Documental extends ContenidoAudiovisual {

    private String tema;
    // asociación: un documental tiene un investigador principal
    private Investigador investigadorPrincipal;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Investigador getInvestigadorPrincipal() {
        return investigadorPrincipal;
    }

    public void setInvestigadorPrincipal(Investigador investigadorPrincipal) {
        this.investigadorPrincipal = investigadorPrincipal;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + tema);

        if (investigadorPrincipal != null) {
            System.out.println("Investigador principal: " + investigadorPrincipal);
        }

        System.out.println();
    }
}
