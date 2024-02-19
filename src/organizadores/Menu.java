package organizadores;

import processadores.de.arquivos.CriarTarefa;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException {
        Scanner ler = new Scanner(System.in);
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

        while (true) {
            System.out.println(menuPrincipal);
            escolhaMenuPrincipal = Integer.parseInt(ler.nextLine());

            switch (escolhaMenuPrincipal) {
                case 0:
                    System.out.println("Encerrando a aplicação...");
                    break;
                case 1:
                    CriarTarefa.criarTarefa();
                    break;
                case 2:
                    System.out.println(menuListar);
                    escolhaMenuListar = Integer.parseInt(ler.nextLine());
                    switch (escolhaMenuListar) {
                        case 0:
                            break;
                        case 1:
                            break;
                    }
                    break;
                case 3:
                    break;
                default:
                    break;
            }

            if (escolhaMenuPrincipal == 0) {
                ler.close();
                break;
            }
        }

    }
}


