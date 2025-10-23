/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Biblioteca.service;

import Biblioteca.domain.Queja;
import java.util.List;
/**
 *
 * @author hazelagx
 */
public interface QuejaService {
    List<Queja> obtenerTodasLasQuejas();
    Queja obtenerQuejaPorId(Long id);
    Queja guardarQueja(Queja qj);
    void eliminarQueja(Long id);
    List<Queja> obtenerQuejasPendientes();
}
