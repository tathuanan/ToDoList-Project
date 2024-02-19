package organizadores;

import processadores.de.arquivos.CriarTarefa;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException {
        while (true) {
            CriarTarefa novaTarefa = new CriarTarefa();
            Scanner ler = new Scanner(System.in);
            Scanner lerInt = new Scanner(System.in);
            String menuPrincipal, menuListar;
            int escolhaMenuListar, escolhaMenuPrincipal ;

            menuPrincipal = "Bem vindo a aplicação 'TodoList'\n\n" +
                    "Por favor escolha uma opção:\n" +
                    "0. Encerrar a aplicação.\n" +
                    "1. Criar Tarefa.\n" +
                    "2. Listar Tarefas.\n" +
                    "3. Excluir Tarefa.";

            menuListar = "Por favor escolha uma opção:\n" +
                    "0. Voltar ao menu anterior";

            System.out.println(menuPrincipal);
            escolhaMenuPrincipal = lerInt.nextInt();

            switch (escolhaMenuPrincipal) {
                case 0:
                    System.out.println("Encerrando a aplicação...");
                    break;
                case 1:
                    novaTarefa.criarTarefa();
                    break;
                case 2:
                    System.out.println(menuListar);
                    escolhaMenuListar = lerInt.nextInt();
                    switch (escolhaMenuListar) {
                        case 0:
                            break;
                        case 1:
                    }

                case 3:

            }
            if (escolhaMenuPrincipal == 0) {
                ler.close();
                lerInt.close();
                break;
            }
        }

    }
}


