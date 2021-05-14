
package br.com.orange.api.versaofinal.vacinacao;

import br.com.orange.api.versaofinal.usuario.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CadastraVacinacaoRequest {

    @NotBlank
    private final String nomeVacina;

    @NotBlank
    @Email
    private final String emailUsuario;

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public CadastraVacinacaoRequest(String nomeVacina, String emailUsuario) {
        this.nomeVacina = nomeVacina;
        this.emailUsuario = emailUsuario;
    }


    // esse metodo recebe um Usuario e devolve uma Vacinação
    public Vacinacao toModel(Usuario usuario) {
        return new Vacinacao(nomeVacina, usuario);
    }
}