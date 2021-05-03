package br.com.orange.api.versaofinal.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> cadastraUsuario(@Valid @RequestBody CadastraUsuarioRequest request) {
        if(usuarioRepository.existsByCpf(request.getCpf())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe Usuario com esse CPF Cadastrado");
        }
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ja existe Usuario com esse Email Cadastrado");
        }
        Usuario novaUsuario = request.toModel();
        usuarioRepository.save(novaUsuario);
        return ResponseEntity.status(201).body("Usuario cadastrado!");
    }
}
