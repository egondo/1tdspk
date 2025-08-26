import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExemploArquivo {

    public static void main(String[] args) {

        File f = new File("dados.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("{'nome': 'FIAP', 'data': '2000-12-3'}\n");
            bw.write("{'nome': 'Starbucks', 'data':'1989-05-07'}");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gravando msg de erro no arquivo de log");
            //throw new RuntimeException(e);
        }
        System.out.println("Arquivo gravado com sucesso");



    }

}
