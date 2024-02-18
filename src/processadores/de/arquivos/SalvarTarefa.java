package processadores.de.arquivos;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalvarTarefa {

    String nomeArquivo;

    public SalvarTarefa(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public List<String> buscarCabecalho() throws IOException{
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
    public void salvarTarefa(String nome, String descricao, int nivelPrioridade, String categoria, LocalDate dataTermino, LocalDateTime dataCriacao, String status ) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            // Persistir as informações da tarefa ao final do arquivo
            String linhaCSV = String.format("%s,%s,%d,%s,%s,%s,%s", nome, descricao, nivelPrioridade, categoria, dataTermino, dataCriacao, status);
            escritor.write(linhaCSV);
            escritor.newLine(); // Adicionar uma nova linha
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}

