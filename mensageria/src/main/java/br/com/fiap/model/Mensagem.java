package br.com.fiap.model;

public class Mensagem {

    private String assunto;
    private String mensagem;
    private String tipo;
    private String destinatario;


    public Mensagem(String assunto, String mensagem, String tipo, String destinatario) {
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
}
