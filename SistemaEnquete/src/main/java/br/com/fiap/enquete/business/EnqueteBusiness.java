package br.com.fiap.enquete.business;

import br.com.fiap.enquete.model.Enquete;
import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.model.Resposta;
import br.com.fiap.enquete.model.Usuario;

import java.util.List;

public class EnqueteBusiness {
    //Implmenetacao da Camada de Negócios do sistema


    public void cadastraEnquete(Enquete enquete) throws Exception {
        //RN1: nao posso ter duas enquetes com o mesmo nome

    }

    public void cadastraPergunta(Pergunta pergunta) throws Exception {
        //RN2: nao posso ter duas perguntas em uma mesma enquete com o
        //mesmo enunciado
    }

    public void cadastraResposta(Resposta resposta) throws Exception {
        //RN3: Toda resposta precisa ser de um usuário ativo no momento
        //do cadastramento da resposta - se for implementar esta regra de
        //negócio, crie um UsuarioRepository na aplicacao

    }

    public List<Pergunta> recuperaPerguntas(Enquete enquete) throws Exception {
        return null;
    }

    public List<Resposta> recuperaRespostas(Enquete enquete) throws Exception {
        return null;
    }

    public List<Resposta> recuperaRespostas(Usuario usuario) throws Exception {
        return null;
    }

}
