package br.com.fiap.futebol.service;

import br.com.fiap.futebol.model.Partida;
import br.com.fiap.futebol.model.Time;
import br.com.fiap.futebol.repository.ConnectionFactory;
import br.com.fiap.futebol.repository.PartidaRepository;
import br.com.fiap.futebol.repository.TimeRepository;

import java.sql.Connection;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        try {
            Connection con = new ConnectionFactory().getConnection();
            PartidaRepository pr = new PartidaRepository(con);
            TimeRepository tr = new TimeRepository(con);

            Time pal = new Time();
            pal.setNome("Sociedade Esportiva Palmeiras");
            Time cor = new Time();
            cor.setNome("Sport Club Corinthians");

            Partida p = new Partida();
            p.setCasa(cor);
            p.setVisitante(pal);
            p.setLocal("Neo Química Arena");
            p.setGolsCasa(2);
            p.setGolsVisitante(2);
            p.setDataHora(LocalDateTime.of(2025, 9, 1, 16, 0));

            //colocando o resultado da partida nos times
            pal.setEmpates(1);
            cor.setEmpates(1);
            pal.setGolsContra(2);
            pal.setGolsPro(2);
            cor.setGolsContra(2);
            cor.setGolsPro(2);

            tr.save(pal);
            tr.save(cor);
            pr.save(p);

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
