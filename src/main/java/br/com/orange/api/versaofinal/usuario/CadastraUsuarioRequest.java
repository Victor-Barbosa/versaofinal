package br.com.orange.api.versaofinal.usuario;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CadastraUsuarioRequest {

    @NotBlank(message = "Nome precisa ter no mínimo 3 caracteres")
    @Length(min = 3)
    private String nome;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    @Length(min = 5)
    private String email;

    @NotNull
    private LocalDate dataNascimento;

    public CadastraUsuarioRequest(String nome, String cpf, String email, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }


    public Usuario toModel() {
        return new Usuario(nome, cpf, email, dataNascimento);
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
