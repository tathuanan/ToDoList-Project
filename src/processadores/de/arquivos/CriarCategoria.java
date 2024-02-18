package processadores.de.arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CriarCategoria {

    String nomeArquivo;

    public CriarCategoria(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    public void salvarCategoria(String nomeCategoria) {
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            // Escrever a variável no final do arquivo
            escritor.write(nomeCategoria);
            escritor.flush();
            escritor.newLine(); // Adicionar uma nova linha
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}