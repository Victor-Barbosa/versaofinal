package br.com.orange.api.versaofinal.vacinacao;

import br.com.orange.api.versaofinal.usuario.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovaVacinacaoRequest {

    @NotBlank
    private String nomeVacina;

    @NotBlank
    @Email
    private String emailUsuario;

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public NovaVacinacaoRequest(String nomeVacina, String emailUsuario) {
        this.nomeVacina = nomeVacina;
        this.emailUsuario = emailUsuario;
    }


    public Vacinacao toModel(Usuario usuario) {
         return new Vacinacao(nomeVacina, usuario);
    }
}
