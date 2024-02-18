package aplicacao;

import processadores.de.arquivos.CriarTarefa;

import java.io.IOException;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        while (true){
            CriarTarefa tarefas = new CriarTarefa();
            tarefas.criarTarefa();
            break;
        }
    }
}
