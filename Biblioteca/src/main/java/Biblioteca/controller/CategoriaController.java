/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Biblioteca.controller;

import Biblioteca.domain.Categoria;
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
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaSvc;
    
    @GetMapping
    public String listarCategorias(Model modelo) {
        modelo.addAttribute("categorias", categoriaSvc.obtenerTodasLasCategorias());
        return "categorias/listado";
    }
    
    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model modelo) {
        modelo.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model modelo) {
        Categoria cat = categoriaSvc.obtenerCategoriaPorId(id);
        if (cat == null) {
            return "redirect:/categorias";
        }
        modelo.addAttribute("categoria", cat);
        return "categorias/formulario";
    }
    
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaSvc.guardarCategoria(categoria);
        return "redirect:/categorias";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        try {
            categoriaSvc.eliminarCategoria(id);
        } catch (Exception e) {
            return "redirect:/categorias?error=true";
        }
        return "redirect:/categorias";
    }

}
