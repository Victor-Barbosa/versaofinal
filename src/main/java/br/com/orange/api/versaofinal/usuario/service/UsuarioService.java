package br.com.orange.api.versaofinal.usuario.service;

import br.com.orange.api.versaofinal.usuario.Usuario;
import br.com.orange.api.versaofinal.usuario.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void validaUsuarioExistente(String cpf, String email) {
        if(usuarioRepository.existsByCpf(cpf)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe Usuario com esse CPF Cadastrado");
        }
        if (usuarioRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe Usuario com esse Email Cadastrado");
        }
    }

    public void salvaUsuario(Usuario novoUsuario) {
        usuarioRepository.save(novoUsuario);
    }

}
