package br.com.orange.api.versaofinal.vacinacao;

import br.com.orange.api.versaofinal.usuario.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private final LocalDateTime dataAplicacao = LocalDateTime.now();

    @Column(nullable = false)
    private String nomeVacina;

    @ManyToOne
    private Usuario usuario;

    public Vacinacao(String nomeVacina, Usuario usuario) {
        this.nomeVacina = nomeVacina;
        this.usuario = usuario;
    }

    @Deprecated
    public Vacinacao() {
    }
}