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
        int contador = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                categoriasSalvas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        for (String nome : categoriasSalvas) {
            System.out.println(contador + ". " + nome);
            contador++;
        }
        return categoriasSalvas;
    }

}

