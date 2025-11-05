//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Filme f = new Filme();
        f.setTitulo("O Jogo da Imitação");
        f.setId(1);
        f.setDiretor("Morten Tyldum");
        f.setAnoLancamento(2014);
        f.setEstudio("Warner Bros");

        String json = Util.toJson(f);
        System.out.println(json);

        Pessoa p = new Pessoa();
        p.setId(2);
        p.setNome("Eduardo");
        p.setCpf("2343423432");
        p.setTelefone("(11) 83423423");

        json = Util.toJson(p);
        System.out.println(json);
    }
}