package service;

import domain.Pelicula;

public interface IServicePeliculas {

  void listarPeliculas();

  void agregarPelicula(Pelicula pelicula);

  void buscarPelicula(Pelicula pelicula);
}
