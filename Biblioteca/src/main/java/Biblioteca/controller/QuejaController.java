/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Biblioteca.controller;
import Biblioteca.domain.Queja;
import Biblioteca.service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author hazelagx
 */
@Controller
@RequestMapping("/quejas")
public class QuejaController {
    @Autowired
    private QuejaService quejaSvc;
    
    @GetMapping
    public String mostrarFormulario(Model modelo) {
        modelo.addAttribute("queja", new Queja());
        return "quejas/formulario";
    }
    
    @PostMapping("/enviar")
    public String enviarQueja(@ModelAttribute Queja queja) {
        quejaSvc.guardarQueja(queja);
        return "redirect:/quejas/exito";
    }
    
    @GetMapping("/exito")
    public String mostrarExito() {
        return "quejas/exito";
    }
    
    @GetMapping("/listado")
    public String listarQuejas(Model modelo) {
        modelo.addAttribute("quejas", quejaSvc.obtenerTodasLasQuejas());
        return "quejas/listado";
    }

}
