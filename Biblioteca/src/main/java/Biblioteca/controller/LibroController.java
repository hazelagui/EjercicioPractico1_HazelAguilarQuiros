/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Biblioteca.controller;

import Biblioteca.domain.Libro;
import Biblioteca.service.LibroService;
import Biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author hazelagx
 */
@Controller
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroSvc;
    
    @Autowired
    private CategoriaService categoriaSvc;
    
    @GetMapping
    public String listarLibros(Model modelo) {
        modelo.addAttribute("libros", libroSvc.obtenerTodosLosLibros());
        return "libros/listado";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo) {
        modelo.addAttribute("libro", new Libro());
        modelo.addAttribute("categorias", categoriaSvc.obtenerTodasLasCategorias());
        return "libros/formulario";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        Libro lib = libroSvc.obtenerLibroPorId(id);
        if (lib == null) {
            return "redirect:/libros";
        }
        modelo.addAttribute("libro", lib);
        modelo.addAttribute("categorias", categoriaSvc.obtenerTodasLasCategorias());
        return "libros/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroSvc.guardarLibro(libro);
        return "redirect:/libros";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroSvc.eliminarLibro(id);
        return "redirect:/libros";
    }

}
