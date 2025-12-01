package poo;

import uni1a.ArchivoContenidoRepository;
import uni1a.CatalogoContenido;
import uni1a.ContenidoRepository;

public class PruebaAudioVisual {
    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("  SISTEMA DE CONTENIDOS AUDIOVISUALES");
        System.out.println("          (Patrón MVC)               ");
        System.out.println("=====================================\n");

        ContenidoRepository repository = new ArchivoContenidoRepository();
        CatalogoContenido catalogo = new CatalogoContenido(repository);
        VistaConsolaContenido vista = new VistaConsolaContenido();
        ContenidoControlador controlador = new ContenidoControlador(catalogo, vista);

        controlador.iniciar();
    }
}
