package processadores.de.arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCategorias {
    String nomeArquivo;

    public LeitorCategorias(String nomeArquivo) throws IOException {
        this.nomeArquivo = nomeArquivo;
    }

    public List<String> lerCategoriasSalvas() throws IOException {
        List<String> categoriasSalvas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                categoriasSalvas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return categoriasSalvas;
    }

}

