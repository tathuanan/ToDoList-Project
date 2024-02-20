package organizadores;

import processadores.de.arquivos.CriarTarefa;
import processadores.de.arquivos.ExcluirTarefa;
import processadores.de.arquivos.LeitorCategorias;
import processadores.de.arquivos.LerTarefas;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void menu() throws IOException {
        LeitorCategorias leitorCategorias;

        try {
            leitorCategorias = new LeitorCategorias("Categorias.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner ler = new Scanner(System.in);
        LerTarefas lerTarefas = new LerTarefas("TodoList.csv");
        String menuPrincipal, menuListar;
        List<String> categoriasSalvas;
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
                    while (escolhaMenuListar < 0 || escolhaMenuListar > 4) {
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
                        case 2:
                            System.out.println("Selecione a Categoria desejada");
                            int numeroCategoria = 1;
                            for (String nome : leitorCategorias.lerCategoriasSalvas()) {
                                System.out.println(numeroCategoria + ". " + nome);
                                numeroCategoria++;
                            }
                            int categoriaSelecionada = Integer.parseInt(ler.nextLine()) - 1;
                            if (categoriaSelecionada <= -1 || categoriaSelecionada > (leitorCategorias.lerCategoriasSalvas().size()) - 1) {
                                System.out.println("Seleção inválida");
                                break;
                            }
                            ListarPorCategoria.listarPorCategoria(leitorCategorias.lerCategoriasSalvas().get(categoriaSelecionada));
                            break;
                        case 3:
                            System.out.println("Selecione o Nivél de Prioridade desejado entre 1 e 5");
                            int nivelPrioridade = Integer.parseInt(ler.nextLine());
                            if (nivelPrioridade < 1 || nivelPrioridade > 5) {
                                System.out.println("Seleção inválida");
                                break;
                            }
                            String nivelPrioridadeStr = String.valueOf(nivelPrioridade);
                            ListarPorPrioridade.listarPorPrioridade(nivelPrioridadeStr);
                            break;
                        case 4:
                            System.out.println("Selecione o Status desejado:\n" +
                                    "1. Todo\n" +
                                    "2. Doing\n" +
                                    "3. Done");
                            int status = Integer.parseInt(ler.nextLine());
                            String statusStr = null;
                            switch (status) {
                                case 1:
                                    statusStr = "Todo";
                                    break;
                                case 2:
                                    statusStr = "Doing";
                                    break;
                                case 3:
                                    statusStr = "Done";
                                    break;
                                default:
                                    System.out.println("Seleção inválida");
                                    break;
                            }
                            if (statusStr != null){
                                ListarPorStatus.listarPorStatus(statusStr);
                            }
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


