package br.com.fiap.enquete.business;

import br.com.fiap.enquete.model.Enquete;
import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.model.Resposta;
import br.com.fiap.enquete.model.Usuario;
import br.com.fiap.enquete.repository.ConexaoFactory;
import br.com.fiap.enquete.repository.EnqueteRepository;
import br.com.fiap.enquete.repository.PerguntaRepository;
import br.com.fiap.enquete.util.PerguntaTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnqueteBusiness {
    //Implmenetacao da Camada de Negócios do sistema


    public void cadastraEnquete(Enquete enquete) throws Exception {
        //RN1: nao posso ter duas enquetes com o mesmo nome
        //RN4: data de criacao da enquete nao pode ser nula
        try(Connection con = new ConexaoFactory().getConexao()) {
            if (enquete.getData() == null) {
                enquete.setData(LocalDate.now());
            }
            EnqueteRepository er = new EnqueteRepository(con);
            er.save(enquete);
        }
        catch (SQLException sql) {
            sql.printStackTrace();
            throw new Exception("Deu erro no cadastro da enquete");
        }

    }

    public void cadastraPergunta(Pergunta pergunta) throws Exception {
        //RN2: nao posso ter duas perguntas em uma mesma enquete com o
        //mesmo enunciado
        try(Connection con = new ConexaoFactory().getConexao()) {
            PerguntaRepository pr = new PerguntaRepository(con);
            Pergunta p = pr.findByEnqueteEnunciado(pergunta.getEnquete(), pergunta.getEnunciado());
            if (p != null) {
                throw new Exception("Já existe pergunta com o enunciado!");
            }
            else
                pr.save(pergunta);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void cadastraResposta(Resposta resposta) throws Exception {
        //RN3: Toda resposta precisa ser de um usuário ativo no momento
        //do cadastramento da resposta - se for implementar esta regra de
        //negócio, crie um UsuarioRepository na aplicacao

    }

    public List<PerguntaTO> recuperaPerguntas(Enquete enquete) throws Exception {
        List<PerguntaTO> lista = new ArrayList<>();
        try(Connection con = new ConexaoFactory().getConexao()) {
            PerguntaRepository pr = new PerguntaRepository(con);
            lista = pr.findByEnquete(enquete);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        return lista;
    }

    public List<Resposta> recuperaRespostas(Enquete enquete) throws Exception {
        return null;
    }

    public List<Resposta> recuperaRespostas(Usuario usuario) throws Exception {
        return null;
    }

}
