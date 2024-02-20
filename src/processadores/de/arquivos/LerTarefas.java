package processadores.de.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LerTarefas {
    String nomeArquivo;

    public LerTarefas(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public static List<HashMap<String, String>> dadosTarefasSalvas(List<String> cabecalhos, List<String> linhas) {
        List<HashMap<String, String>> dadosTarefasSalvas = new ArrayList<>();
        for (String linha : linhas) {
            String[] valores = linha.split(",");
            int contador = 0;
            HashMap<String, String> valoresMapeados = new HashMap<>();
            for (String valor : valores) {
                valoresMapeados.put(cabecalhos.get(contador), valor);
                contador++;
            }
            dadosTarefasSalvas.add(valoresMapeados);
        }
        return dadosTarefasSalvas;
    }

    public List<String> lerTarefasSalvas() throws IOException {
        List<String> tarefasSalvas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            br.readLine();
            String linha = null;
            while ((linha = br.readLine()) != null) {
                tarefasSalvas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return tarefasSalvas;
    }

    public List<String> buscarCabecalho() throws IOException {
        String linha = lerPrimeiraLinha(nomeArquivo);
        String[] cabecalho = linha.split(",");
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
