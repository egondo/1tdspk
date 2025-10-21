package br.com.fiap.enquete.model;

import java.time.LocalDateTime;

public class Resposta {

    private long id;
    private Pergunta pergunta;
    private LocalDateTime dataHora;
    private String valorResposta;
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getValorResposta() {
        return valorResposta;
    }

    public void setValorResposta(String valorResposta) {
        this.valorResposta = valorResposta;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
