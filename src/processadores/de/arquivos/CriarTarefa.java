package processadores.de.arquivos;

import aplicacao.Tarefa;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class CriarTarefa {
    static Scanner ler = new Scanner(System.in);
    static LeitorCategorias leitorCategorias;

    static {
        try {
            leitorCategorias = new LeitorCategorias("Categorias.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static SalvarTarefa salvarTarefa = new SalvarTarefa("TodoList.csv");
    static CriarCategoria novaCategoria = new CriarCategoria("Categorias.txt");

    static String nome, descricao, categoria, status;
    static int escolhaStatus;
    static int escolhaCategoria, nivelPrioridade;
    static LocalDate dataTermino;

    public CriarTarefa() {
    }

    public static void criarTarefa() throws IOException {
        escolhaCategoria = -2;

        System.out.println("Digite o nome da Tarefa:");
        nome = ler.nextLine();
        System.out.println("Digite a descrição da Tarefa:");
        descricao = ler.nextLine();

        while (escolhaCategoria == -2) {
            System.out.println("Selecione a categoria da Tarefa:");
            System.out.println("0. Criar categoria");
            List<String> categoriasSalvas = leitorCategorias.lerCategoriasSalvas();
            int numeroCategoria = 1;
            for (String nome : categoriasSalvas) {
                System.out.println(numeroCategoria + ". " + nome);
                numeroCategoria++;
            }
            escolhaCategoria = Integer.parseInt(ler.nextLine());
            escolhaCategoria -= 1;

            while (true) {
                if (escolhaCategoria < -1 || escolhaCategoria > categoriasSalvas.size() - 1) {
                    System.out.println("Opção inválida!!!");
                    System.out.println("Selecione a categoria da Tarefa:");
                    System.out.println("0. Criar categoria");
                    categoriasSalvas = leitorCategorias.lerCategoriasSalvas();
                    escolhaCategoria = Integer.parseInt(ler.nextLine());
                    escolhaCategoria -= 1;
                } else if (escolhaCategoria == -1) {
                    System.out.println("Digite o nome da categoria que você deseja criar:");
                    categoria = ler.nextLine();
                    novaCategoria.salvarCategoria(categoria);
                    break;
                } else {
                    categoria = categoriasSalvas.get(escolhaCategoria);
                    break;
                }
            }
        }

        System.out.println("Selecione o status da Tarefa:\n" +
                "1. Todo\n" +
                "2. Doing\n" +
                "3. Done");
        escolhaStatus = Integer.parseInt(ler.nextLine());

        while (true) {
            if (escolhaStatus < 1 || escolhaStatus > 3) {
                System.out.println("Status inválido!!!");
                System.out.println("Selecione o status da Tarefa:\n" +
                        "1. Todo\n" +
                        "2. Doing\n" +
                        "3. Done");
                escolhaStatus = Integer.parseInt(ler.nextLine());
            } else {
                break;
            }
        }

        switch (escolhaStatus) {
            case 1:
                status = "Todo";
                break;
            case 2:
                status = "Doing";
                break;
            case 3:
                status = "Done";
                break;
        }

        System.out.println("Digite o nível de prioridade da Tarefa entre 1 a 5 (sendo 1 para tarefa sem prioridade e 5 para tarefa urgente):");
        nivelPrioridade = Integer.parseInt(ler.nextLine());

        while (true) {
            if (nivelPrioridade < 1 || nivelPrioridade > 5) {
                System.out.println("Nível de prioridade inválido!!!");
                System.out.println("Digite o nível de prioridade da Tarefa entre 1 a 5 (sendo 1 para tarefa sem prioridade e 5 para tarefa urgente):");
                nivelPrioridade = Integer.parseInt(ler.nextLine());
            } else {
                break;
            }
        }

        System.out.println("Digite a data máxima para o término da Tarefa (dd/mm/aaaa):");
        String dataDigitada = ler.nextLine().trim();

        // Criar um objeto DateTimeFormatter para analisar a data
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            while (true) {
                try {
                    dataTermino = LocalDate.parse(dataDigitada, formatacao);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data inválido!");
                    System.out.println("Digite a data (dd/mm/aaaa):");
                    dataDigitada = ler.nextLine().trim();
                }
            }
        } catch (DateTimeParseException e) {
            System.out.println("Erro de formato de data não previsto na aplicação!");
            // Aqui você pode lidar com a situação de formato de data inválido, se necessário
        }

        // Obter a data e hora local do computador
        LocalDateTime dataCriacao = LocalDateTime.now();


        Tarefa tarefa = new Tarefa(nome, descricao, categoria, status, dataTermino, dataCriacao, nivelPrioridade);

        salvarTarefa.salvarTarefa(tarefa.getNome(), tarefa.getDescricao(), tarefa.getNivelPrioridade(), tarefa.getCategoria(),
                tarefa.getDataTermino(), tarefa.getDataCriacao(), tarefa.getStatus());
    }
}