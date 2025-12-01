package poo;

import java.util.List;
import java.util.Scanner;

import uni1a.ContenidoAudiovisual;

//Muestra los datos y lee entradas
public class VistaConsolaContenido {

    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPrincipal() {
        System.out.println("\n===== MENÚ CONTENIDO AUDIOVISUAL =====");
        System.out.println("1. Listar todos los contenidos");
        System.out.println("2. Agregar una película");
        System.out.println("3. Buscar por género");
        System.out.println("4. Guardar en archivos y salir");
        System.out.print("Seleccione una opción: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return opcion;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarListaContenidos(List<ContenidoAudiovisual> contenidos) {
        if (contenidos.isEmpty()) {
            System.out.println("No hay contenidos registrados.");
            return;
        }
        System.out.println("\n--- CONTENIDOS REGISTRADOS ---");
        for (ContenidoAudiovisual c : contenidos) {
            c.mostrarDetalles();
        }
    }

    public String pedirTexto(String etiqueta) {
        System.out.print(etiqueta + ": ");
        return scanner.nextLine();
    }

    public int pedirEntero(String etiqueta) {
        System.out.print(etiqueta + ": ");
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido para " + etiqueta + ": ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return valor;
    }
}
