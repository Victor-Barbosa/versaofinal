package br.com.orange.api.versaofinal.usuario;

import br.com.orange.api.versaofinal.usuario.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> cadastraUsuario(@Valid @RequestBody CadastraUsuarioRequest request) {
        // metodo responsavel por verificar se existe usuario cadastrado com cpf ou email no sistema
        usuarioService.validaUsuarioExistente(request.getCpf(), request.getEmail());

        Usuario novoUsuario = request.toModel();
        usuarioService.salvaUsuario(novoUsuario);
        return ResponseEntity.status(201).body("Usuario cadastrado!");
    }
}
