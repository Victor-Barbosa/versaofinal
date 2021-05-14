package br.com.orange.api.versaofinal.compartilhado.handler;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private final String titulo;
    private final String detalhe;
    private final String status;
    private final LocalDateTime hora = LocalDateTime.now();

    public String getTitulo() {
        return titulo;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public ExceptionResponse(String titulo, String detalhe, String status) {
        this.titulo = titulo;
        this.detalhe = detalhe;
        this.status = status;

    }
}
