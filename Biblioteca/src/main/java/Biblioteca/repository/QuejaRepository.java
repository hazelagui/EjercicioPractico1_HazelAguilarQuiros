/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Biblioteca.repository;

import Biblioteca.domain.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 *
 * @author hazelagx
 */
@Repository
public interface QuejaRepository extends JpaRepository<Queja, Long> {
    List<Queja> findByTratado(Boolean tratado);
    List<Queja> findByTipo(Queja.TipoQueja tipo);
}