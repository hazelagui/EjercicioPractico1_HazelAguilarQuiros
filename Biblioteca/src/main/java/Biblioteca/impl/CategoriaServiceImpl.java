/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Biblioteca.impl;
import Biblioteca.domain.Categoria;
import Biblioteca.repository.CategoriaRepository;
import Biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepo;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepo.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Categoria obtenerCategoriaPorId(Long id) {
        return categoriaRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public Categoria guardarCategoria(Categoria cat) {
        return categoriaRepo.save(cat);
    }
    
    @Override
    @Transactional
    public void eliminarCategoria(Long id) {
        categoriaRepo.deleteById(id);
    }
}
