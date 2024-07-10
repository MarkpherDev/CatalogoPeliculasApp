package presentation;

import domain.Pelicula;
import java.util.Scanner;
import service.IServicePeliculas;
import service.ServicePeliculasArchivo;

public class CatalogoPeliculasApp {

  public static void main(String[] args) {
    boolean salir = false;
    Scanner consola = new Scanner(System.in);

    //IServicePeliculas servicePeliculas = new ServicePeliculaLista();
    IServicePeliculas servicePeliculas = new ServicePeliculasArchivo();

    while (!salir) {
      try {
        int opcion = mostrarMenu(consola);
        salir = ejecutarOpciones(opcion, consola, servicePeliculas);
      } catch (Exception e) {
        System.out.println("Ocurrio un error: " + e.getMessage());
      } finally {
        System.out.println();
      }
    }
  }

  private static int mostrarMenu(Scanner consola) {
    System.out.print("""
        *** Catalogo de Peliculas ***
        1. Agregar Peliculas
        2. Listar Peliculas
        3. Buscar Peliculas
        4. Salir
        Escoja una opcion:\s""");
    return Integer.parseInt(consola.nextLine());
  }

  private static boolean ejecutarOpciones(int opcion, Scanner consola,
      IServicePeliculas servicePeliculas) {
    boolean salir = false;
    switch (opcion) {
      case 1 -> {
        System.out.print("Introduzca el nombre de la Pelicula: ");
        String nombrePelicula = consola.nextLine();
        servicePeliculas.agregarPelicula(new Pelicula(nombrePelicula));
      }
      case 2 -> servicePeliculas.listarPeliculas();
      case 3 -> {
        System.out.print("Introduce la Pelicula a Buscar: ");
        String buscar = consola.nextLine();
        servicePeliculas.buscarPelicula(new Pelicula(buscar));
      }
      case 4 -> {
        System.out.println("Hasta pronto!!!!");
        salir = true;
      }
      default -> System.out.println("Opcion no reconocida: " + opcion);
    }

    return salir;
  }
}