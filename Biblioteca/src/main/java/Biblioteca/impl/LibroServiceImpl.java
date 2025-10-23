/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca.impl;
import Biblioteca.domain.Libro;
import Biblioteca.repository.LibroRepository;
import Biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {
    
    @Autowired
    private LibroRepository libroRepo;
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepo.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Libro obtenerLibroPorId(Long id) {
        return libroRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public Libro guardarLibro(Libro lib) {
        return libroRepo.save(lib);
    }
    
    @Override
    @Transactional
    public void eliminarLibro(Long id) {
        libroRepo.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> obtenerLibrosPorCategoria(Long categoriaId) {
        return libroRepo.findByCategoria_Id(categoriaId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> obtenerLibrosDisponibles() {
        return libroRepo.findByDisponible(true);
    }
}