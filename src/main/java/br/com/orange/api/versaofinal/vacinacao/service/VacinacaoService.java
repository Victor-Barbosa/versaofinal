package br.com.orange.api.versaofinal.vacinacao.service;

import br.com.orange.api.versaofinal.usuario.Usuario;
import br.com.orange.api.versaofinal.usuario.UsuarioRepository;
import br.com.orange.api.versaofinal.vacinacao.Vacinacao;
import br.com.orange.api.versaofinal.vacinacao.VacinacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VacinacaoService {

    private final VacinacaoRepository vacinacaoRepository;

    private final UsuarioRepository usuarioRepository;

    public VacinacaoService(VacinacaoRepository vacinacaoRepository, UsuarioRepository usuarioRepository) {
        this.vacinacaoRepository = vacinacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscaUsuarioPorEmail(String email) {

        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe Usuario para esse email!"));

    }

    public void salvaVacinacao(Vacinacao novaVacinacao) {
        vacinacaoRepository.save(novaVacinacao);
    }

}
