package br.com.orange.api.versaofinal.vacinacao;

import br.com.orange.api.versaofinal.usuario.Usuario;
import br.com.orange.api.versaofinal.vacinacao.service.VacinacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/vacinacao")
public class VacinacaoController {

    private final VacinacaoService vacinacaoService;

    public VacinacaoController(VacinacaoService vacinacaoService) {
        this.vacinacaoService = vacinacaoService;
    }

    @PostMapping
    public ResponseEntity<String> novaVacinacao (@Valid @RequestBody CadastraVacinacaoRequest request){

        //Busca usuario pelo email, caso não encontre joga uma exceção.
        Usuario usuario = vacinacaoService.buscaUsuarioPorEmail(request.getEmailUsuario());

        Vacinacao novaVacinacao = request.toModel(usuario);
        vacinacaoService.salvaVacinacao(novaVacinacao);
        return ResponseEntity.status(201).body("Vacinação concluída");
    }
}