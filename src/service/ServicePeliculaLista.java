package service;

import domain.Pelicula;
import java.util.ArrayList;
import java.util.List;

public class ServicePeliculaLista implements IServicePeliculas {

  private final List<Pelicula> peliculas;

  public ServicePeliculaLista() {
    this.peliculas = new ArrayList<>();
  }

  @Override
  public void listarPeliculas() {
    System.out.println("Listado de Peliculas...");
    peliculas.forEach(System.out::println);
  }

  @Override
  public void agregarPelicula(Pelicula pelicula) {
    peliculas.add(pelicula);
    System.out.println("Se agrego la pelicula: " + pelicula);
  }

  @Override
  public void buscarPelicula(Pelicula pelicula) {
    //Regresa el índice de la pelicula encontrada en la lista
    int indice = peliculas.indexOf(pelicula);
    
    if (indice == -1) {
      System.out.println("No se encontro la pelicula: " + pelicula);
    } else {
      System.out.println("Pelicula encontrada en el indice: " + indice);
    }
  }
}
