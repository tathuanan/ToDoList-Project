package organizadores;

import processadores.de.arquivos.CriarTarefa;
import processadores.de.arquivos.ExcluirTarefa;
import processadores.de.arquivos.LerTarefas;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException {
        Scanner ler = new Scanner(System.in);
        LerTarefas lerTarefas = new LerTarefas("TodoList.csv");
        String menuPrincipal, menuListar;
        int escolhaMenuListar, escolhaMenuPrincipal;

        System.out.println("Bem vindo a aplicação 'ToDoList'\n");

        menuPrincipal = "Por favor escolha uma opção:\n\n" +
                "0. Encerrar a aplicação.\n" +
                "1. Criar Tarefa.\n" +
                "2. Listar Tarefas.\n" +
                "3. Excluir Tarefa.";

        menuListar = "Por favor escolha uma opção:\n\n" +
                "0. Voltar ao menu anterior\n" +
                "1. Listar todas as Tarefas\n" +
                "2. Listar tarefas por Categoria\n" +
                "3. Listar tarefas por Prioridade\n" +
                "4. Listar tarefas por Status";

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
                    while (escolhaMenuListar < 0 || escolhaMenuListar > 1) {
                        System.out.println("Opção inválida, por favor escolha uma opção válida.\n");
                        System.out.println(menuListar);
                        escolhaMenuListar = Integer.parseInt(ler.nextLine());
                    }
                    switch (escolhaMenuListar) {
                        case 0:
                            break;
                        case 1:
                            int contador = 1;
                            for (String tarefas : lerTarefas.lerTarefasSalvas()) {
                                System.out.println(contador + ". " + tarefas);
                                contador++;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    StringBuilder stringBuilder = new StringBuilder();
                    int contador = 1;
                    stringBuilder.append("0. Cancelar a operação\n");
                    for (String tarefa : lerTarefas.lerTarefasSalvas()) {
                        stringBuilder.append(contador).append(". ").append(tarefa).append("\n");
                        contador++;
                    }

                    String resultado = stringBuilder.toString();
                    ExcluirTarefa.excluirTarefa("TodoList.csv", resultado);
                    break;
                default:
                    System.out.println("Opção inválida, por favor escolha uma opção válida.\n");
                    break;
            }

            if (escolhaMenuPrincipal == 0) {
                ler.close();
                break;
            }
        }

    }
}


