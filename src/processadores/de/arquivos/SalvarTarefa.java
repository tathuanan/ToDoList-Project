package processadores.de.arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SalvarTarefa {

    String nomeArquivo;

    public SalvarTarefa(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
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

