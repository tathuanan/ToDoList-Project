package processadores.de.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LerTarefas {

    String nomeArquivo;

    public LerTarefas(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }
    public List<String> buscarCabecalho() throws IOException {
        String linha = lerPrimeiraLinha(nomeArquivo);
        String [] cabecalho = linha.split(",");
        List<String> values = new ArrayList<String>();
        values = Arrays.asList(cabecalho);
        return values;
    }

    static String lerPrimeiraLinha(String path) throws IOException {
        try (BufferedReader quebra = new BufferedReader(new FileReader(path))) {
            return quebra.readLine();
        }
    }
}
