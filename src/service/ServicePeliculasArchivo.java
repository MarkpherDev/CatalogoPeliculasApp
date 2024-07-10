package service;

import domain.Pelicula;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServicePeliculasArchivo implements IServicePeliculas {

  private final String NOMBRE_ARCHIVO = "peliculas.txt";

  public ServicePeliculasArchivo() {
    File archivo = new File(NOMBRE_ARCHIVO);
    try {
      if (archivo.exists()) {
        System.out.println("El archivo ya existe...");
      } else {
        PrintWriter salida = new PrintWriter(new FileWriter(archivo));
        salida.close();
        System.out.println("Se ha creado el archivo");
      }
    } catch (Exception e) {
      System.out.println("Ocurrio un error al abrir el archivo: " + e.getMessage());
    }
  }

  @Override
  public void listarPeliculas() {
    // Volvemos a abrir el archivo
    File archivo = new File(NOMBRE_ARCHIVO);
    try {
      System.out.println("Listado de Peliculas...");
      // Abrimos el archivo para lectura
      BufferedReader entrada = new BufferedReader(new FileReader(archivo));
      // Leemos linea a linea el archivo
      String linea;
      linea = entrada.readLine();
      //Leemos todas las lineas
      while (linea != null) {
        Pelicula pelicula = new Pelicula(linea);
        System.out.println(pelicula);
        //Antes de terminar el ciclo volvemos a leer la siguente linea
        linea = entrada.readLine();
      }
      //Cerrar el archivo
      entrada.close();
    } catch (Exception e) {
      System.out.println("Ocurrio un error al leer el archivo: " + e.getMessage());
    }
  }

  @Override
  public void agregarPelicula(Pelicula pelicula) {
    boolean anexar = false;
    File archivo = new File(NOMBRE_ARCHIVO);
    try {
      // Revisamos si el archivo existe
      anexar = archivo.exists();
      PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
      //Agregamos la Pelicula (toString)
      salida.println(pelicula);
      salida.close();
      System.out.println("Se agrego el archivo: " + pelicula);
    } catch (Exception e) {
      System.out.println("Ocurrio un error al agregar Pelicula: " + e.getMessage());
    }
  }

  @Override
  public void buscarPelicula(Pelicula pelicula) {
    File archivo = new File(NOMBRE_ARCHIVO);
    try {
      BufferedReader entrada = new BufferedReader(new FileReader(archivo));
      String lineaTexto;
      lineaTexto = entrada.readLine();
      int indice = 1;
      boolean encontrada = false;
      String peliculaBuscar = pelicula.getNombre();
      while (lineaTexto != null) {
        if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
          encontrada = true;
          break;
        }

        lineaTexto = entrada.readLine();
        indice++;
      }

      if (encontrada) {
        System.out.println("Pelicula " + lineaTexto + " encotrada - linea " + indice);
      } else {
        System.out.println("No se ha encontrado la pelicula: " + pelicula.getNombre());
      }

      entrada.close();
    } catch (Exception e) {
      System.out.println("Ocurrio un error al buscar la pelicula: " + e.getMessage());
    }
  }
}
