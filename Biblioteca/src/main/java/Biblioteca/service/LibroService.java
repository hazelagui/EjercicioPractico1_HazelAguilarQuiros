/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Biblioteca.service;

import Biblioteca.domain.Libro;
import java.util.List;
/**
 *
 * @author hazelagx
 */
public interface LibroService {
    List<Libro> obtenerTodosLosLibros();
    Libro obtenerLibroPorId(Long id);
    Libro guardarLibro(Libro lib);
    void eliminarLibro(Long id);
    List<Libro> obtenerLibrosPorCategoria(Long categoriaId);
    List<Libro> obtenerLibrosDisponibles();
}