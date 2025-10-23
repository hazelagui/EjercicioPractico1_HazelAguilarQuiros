/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca.impl;

import Biblioteca.domain.Queja;
import Biblioteca.repository.QuejaRepository;
import Biblioteca.service.QuejaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class QuejaServiceImpl implements QuejaService {
    
    @Autowired
    private QuejaRepository quejaRepo;
    
    @Override
    @Transactional(readOnly = true)
    public List<Queja> obtenerTodasLasQuejas() {
        return quejaRepo.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public Queja obtenerQuejaPorId(Long id) {
        return quejaRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional
    public Queja guardarQueja(Queja qj) {
        return quejaRepo.save(qj);
    }
    
    @Override
    @Transactional
    public void eliminarQueja(Long id) {
        quejaRepo.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Queja> obtenerQuejasPendientes() {
        return quejaRepo.findByTratado(false);
    }
}
