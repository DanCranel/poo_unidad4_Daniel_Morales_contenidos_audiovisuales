package uni1a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//Implementacion del repositorio
public class ArchivoContenidoRepository implements ContenidoRepository {

    private static final String DELIMITADOR = ";";

    private static final String RUTA_PELICULAS = "datos/peliculas.csv";
    private static final String RUTA_ACTORES = "datos/actores.csv";
    private static final String RUTA_SERIES = "datos/series.csv";
    private static final String RUTA_TEMPORADAS = "datos/temporadas.csv";
    private static final String RUTA_DOCUMENTALES = "datos/documentales.csv";
    private static final String RUTA_INVESTIGADORES = "datos/investigadores.csv";

    @Override
    public List<ContenidoAudiovisual> cargarTodo() throws IOException {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();

        Map<String, Pelicula> mapaPeliculas = cargarPeliculas(contenidos);
        cargarActores(mapaPeliculas);

        Map<String, SerieDeTV> mapaSeries = cargarSeries(contenidos);
        cargarTemporadas(mapaSeries);

        Map<String, Documental> mapaDocumentales = cargarDocumentales(contenidos);
        cargarInvestigadores(mapaDocumentales);

        return contenidos;
    }

    @Override
    public void guardarTodo(List<ContenidoAudiovisual> contenidos) throws IOException {
        guardarPeliculasYActores(contenidos);
        guardarSeriesYTemporadas(contenidos);
        guardarDocumentalesEInvestigadores(contenidos);
    }

    // =====================
    // MÉTODOS PRIVADOS CSV
    // =====================

    private Map<String, Pelicula> cargarPeliculas(List<ContenidoAudiovisual> contenidos) throws IOException {
        Map<String, Pelicula> resultado = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_PELICULAS))) {
            String linea = br.readLine(); // cabecera
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR);
                if (partes.length < 4) {
                    continue; // línea inválida
                }
                String titulo = partes[0];
                int duracion = Integer.parseInt(partes[1]);
                String genero = partes[2];
                String estudio = partes[3];

                Pelicula peli = new Pelicula(titulo, duracion, genero, estudio);
                contenidos.add(peli);
                resultado.put(titulo, peli);
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer " + RUTA_PELICULAS + ": " + e.getMessage());
            throw e;
        }

        return resultado;
    }

    private void cargarActores(Map<String, Pelicula> mapaPeliculas) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ACTORES))) {
            String linea = br.readLine(); // cabecera
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR);
                if (partes.length < 4) {
                    continue;
                }
                String tituloPelicula = partes[0];
                String nombre = partes[1];
                String nacionalidad = partes[2];
                int edad = Integer.parseInt(partes[3]);

                Pelicula peli = mapaPeliculas.get(tituloPelicula);
                if (peli != null) {
                    peli.agregarActor(new Actor(nombre, nacionalidad, edad));
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer " + RUTA_ACTORES + ": " + e.getMessage());
            throw e;
        }
    }

    private Map<String, SerieDeTV> cargarSeries(List<ContenidoAudiovisual> contenidos) throws IOException {
        Map<String, SerieDeTV> resultado = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_SERIES))) {
            String linea = br.readLine(); // cabecera
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR);
                if (partes.length < 4) {
                    continue;
                }
                String titulo = partes[0];
                int duracion = Integer.parseInt(partes[1]);
                String genero = partes[2];
                int temporadas = Integer.parseInt(partes[3]);

                SerieDeTV serie = new SerieDeTV(titulo, duracion, genero, temporadas);
                contenidos.add(serie);
                resultado.put(titulo, serie);
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer " + RUTA_SERIES + ": " + e.getMessage());
            throw e;
        }

        return resultado;
    }

    private void cargarTemporadas(Map<String, SerieDeTV> mapaSeries) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_TEMPORADAS))) {
            String linea = br.readLine(); // cabecera
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR);
                if (partes.length < 3) {
                    continue;
                }
                String tituloSerie = partes[0];
                int numero = Integer.parseInt(partes[1]);
                int episodios = Integer.parseInt(partes[2]);

                SerieDeTV serie = mapaSeries.get(tituloSerie);
                if (serie != null) {
                    serie.agregarTemporada(new Temporada(numero, episodios));
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer " + RUTA_TEMPORADAS + ": " + e.getMessage());
            throw e;
        }
    }

    private Map<String, Documental> cargarDocumentales(List<ContenidoAudiovisual> contenidos) throws IOException {
        Map<String, Documental> resultado = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_DOCUMENTALES))) {
            String linea = br.readLine(); // cabecera
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR);
                if (partes.length < 4) {
                    continue;
                }
                String titulo = partes[0];
                int duracion = Integer.parseInt(partes[1]);
                String genero = partes[2];
                String tema = partes[3];

                Documental doc = new Documental(titulo, duracion, genero, tema);
                contenidos.add(doc);
                resultado.put(titulo, doc);
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer " + RUTA_DOCUMENTALES + ": " + e.getMessage());
            throw e;
        }

        return resultado;
    }

    private void cargarInvestigadores(Map<String, Documental> mapaDocumentales) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_INVESTIGADORES))) {
            String linea = br.readLine(); // cabecera
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR);
                if (partes.length < 4) {
                    continue;
                }
                String tituloDocumental = partes[0];
                String nombre = partes[1];
                String especialidad = partes[2];
                String institucion = partes[3];

                Documental doc = mapaDocumentales.get(tituloDocumental);
                if (doc != null) {
                    doc.setInvestigadorPrincipal(
                            new Investigador(nombre, especialidad, institucion)
                    );
                }
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer " + RUTA_INVESTIGADORES + ": " + e.getMessage());
            throw e;
        }
    }

    // =========================
    // MÉTODOS PARA ESCRIBIR CSV
    // =========================

    private void guardarPeliculasYActores(List<ContenidoAudiovisual> contenidos) throws IOException {
        try (
                BufferedWriter bwPelis = new BufferedWriter(new FileWriter(RUTA_PELICULAS));
                BufferedWriter bwActores = new BufferedWriter(new FileWriter(RUTA_ACTORES))
        ) {
            bwPelis.write("titulo;duracion;genero;estudio");
            bwPelis.newLine();

            bwActores.write("tituloPelicula;nombre;nacionalidad;edad");
            bwActores.newLine();

            for (ContenidoAudiovisual c : contenidos) {
                if (c instanceof Pelicula) {
                    Pelicula p = (Pelicula) c;
                    bwPelis.write(String.join(DELIMITADOR,
                            p.getTitulo(),
                            String.valueOf(p.getDuracionEnMinutos()),
                            p.getGenero(),
                            p.getEstudio()
                    ));
                    bwPelis.newLine();

                    for (Actor a : p.getActores()) {
                        bwActores.write(String.join(DELIMITADOR,
                                p.getTitulo(),
                                a.getNombre(),
                                a.getNacionalidad(),
                                String.valueOf(a.getEdad())
                        ));
                        bwActores.newLine();
                    }
                }
            }
        }
    }

    private void guardarSeriesYTemporadas(List<ContenidoAudiovisual> contenidos) throws IOException {
        try (
                BufferedWriter bwSeries = new BufferedWriter(new FileWriter(RUTA_SERIES));
                BufferedWriter bwTemps = new BufferedWriter(new FileWriter(RUTA_TEMPORADAS))
        ) {
            bwSeries.write("titulo;duracion;genero;temporadas");
            bwSeries.newLine();

            bwTemps.write("tituloSerie;numero;episodios");
            bwTemps.newLine();

            for (ContenidoAudiovisual c : contenidos) {
                if (c instanceof SerieDeTV) {
                    SerieDeTV s = (SerieDeTV) c;
                    bwSeries.write(String.join(DELIMITADOR,
                            s.getTitulo(),
                            String.valueOf(s.getDuracionEnMinutos()),
                            s.getGenero(),
                            String.valueOf(s.getTemporadas())
                    ));
                    bwSeries.newLine();

                    for (Temporada t : s.getListaTemporadas()) {
                        bwTemps.write(String.join(DELIMITADOR,
                                s.getTitulo(),
                                String.valueOf(t.getNumero()),
                                String.valueOf(t.getCantidadEpisodios())
                        ));
                        bwTemps.newLine();
                    }
                }
            }
        }
    }

    private void guardarDocumentalesEInvestigadores(List<ContenidoAudiovisual> contenidos) throws IOException {
        try (
                BufferedWriter bwDocs = new BufferedWriter(new FileWriter(RUTA_DOCUMENTALES));
                BufferedWriter bwInv = new BufferedWriter(new FileWriter(RUTA_INVESTIGADORES))
        ) {
            bwDocs.write("titulo;duracion;genero;tema");
            bwDocs.newLine();

            bwInv.write("tituloDocumental;nombre;especialidad;institucion");
            bwInv.newLine();

            for (ContenidoAudiovisual c : contenidos) {
                if (c instanceof Documental) {
                    Documental d = (Documental) c;
                    bwDocs.write(String.join(DELIMITADOR,
                            d.getTitulo(),
                            String.valueOf(d.getDuracionEnMinutos()),
                            d.getGenero(),
                            d.getTema()
                    ));
                    bwDocs.newLine();

                    if (d.getInvestigadorPrincipal() != null) {
                        Investigador i = d.getInvestigadorPrincipal();
                        bwInv.write(String.join(DELIMITADOR,
                                d.getTitulo(),
                                i.getNombre(),
                                i.getEspecialidad(),
                                i.getInstitucion()
                        ));
                        bwInv.newLine();
                    }
                }
            }
        }
    }
}
