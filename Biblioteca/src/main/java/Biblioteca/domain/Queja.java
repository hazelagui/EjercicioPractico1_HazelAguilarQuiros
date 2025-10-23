/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 *
 * @author hazelagx
 */
@Data
@Entity
@Table(name = "queja")
public class Queja implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre_cliente", length = 150)
    private String nombreCliente;
    
    @Column(length = 200)
    private String email;
    
    @Column(length = 30)
    private String telefono;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoQueja tipo = TipoQueja.CONSULTA;
    
    @Column(length = 200)
    private String asunto;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;
    
    @Column(nullable = false)
    private Boolean tratado = false;
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
    
    public enum TipoQueja {
        QUEJA, SUGERENCIA, CONSULTA
    } 
}
