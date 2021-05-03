package br.com.orange.api.versaofinal.vacinacao;

import br.com.orange.api.versaofinal.usuario.Usuario;
import br.com.orange.api.versaofinal.usuario.UsuarioRepository;
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
@RequestMapping("/api/vacinacao")
public class VacinacaoController {

    @Autowired
    private VacinacaoRepository vacinacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> novaVacinacao (@Valid @RequestBody NovaVacinacaoRequest request){

       Usuario usuario = usuarioRepository.findByEmail(request.getEmailUsuario())
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                       "Não existe usuario com esse mail cadastrado"));

        Vacinacao novaVacinacao = request.toModel(usuario);
        vacinacaoRepository.save(novaVacinacao);
        return ResponseEntity.status(201).body("Vacinação concluída");
    }
}
