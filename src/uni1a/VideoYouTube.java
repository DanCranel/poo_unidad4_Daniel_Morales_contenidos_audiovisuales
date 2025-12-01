package uni1a;

public class VideoYouTube extends ContenidoAudiovisual {

    private String canal;
    private String url;
    private int likes;

    public VideoYouTube(String titulo, int duracionEnMinutos, String genero,
                        String canal, String url, int likes) {
        super(titulo, duracionEnMinutos, genero);
        this.canal = canal;
        this.url = url;
        this.likes = likes;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del video de YouTube:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Canal: " + canal);
        System.out.println("URL: " + url);
        System.out.println("Likes: " + likes);
        System.out.println();
    }
}
