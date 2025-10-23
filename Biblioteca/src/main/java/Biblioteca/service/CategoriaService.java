/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Biblioteca.service;
import Biblioteca.domain.Categoria;
import java.util.List;

/**
 *
 * @author hazelagx
 */
public interface CategoriaService {
    List<Categoria> obtenerTodasLasCategorias();
    Categoria obtenerCategoriaPorId(Long id);
    Categoria guardarCategoria(Categoria cat);
    void eliminarCategoria(Long id);
}
