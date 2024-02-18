package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String nome, descricao, categoria, status;
        int nivelPrioridade, escolhaStatus, escolhaCategoria;
        LocalDate dataTermino = null;
        status = null;
        categoria = null;

        System.out.println("Digite o nome da Tarefa:");
        nome = ler.next();
        System.out.println("Digite a descrição da Tarefa:");
        descricao = ler.next();


        System.out.println("Selecione a categoria da Tarefa:");
        escolhaCategoria = ler.nextInt();

        while (true) {
            if (escolhaCategoria < 1 || escolhaCategoria > 3) {
                System.out.println("Categoria inválida!!!");
                System.out.println("Selecione a categoria da Tarefa:");
                escolhaCategoria = ler.nextInt();
            } else {
                break;
            }
        }

        switch (escolhaCategoria) {
            case 1:
                categoria = "1";
                break;
            case 2:
                categoria = "2";
                break;
            case 3:
                categoria = "3";
                break;
        }

        System.out.println("Selecione o status da Tarefa:\n" +
                "1. Todo\n" +
                "2. Doing\n" +
                "3. Done");
        escolhaStatus = ler.nextInt();

        while (true) {
            if (escolhaStatus < 1 || escolhaStatus > 3) {
                System.out.println("Status inválido!!!");
                System.out.println("Selecione o status da Tarefa:\n" +
                        "1. Todo\n" +
                        "2. Doing\n" +
                        "3. Done");
                escolhaStatus = ler.nextInt();
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
        nivelPrioridade = ler.nextInt();

        while (true) {
            if (nivelPrioridade < 1 || nivelPrioridade > 5) {
                System.out.println("Nível de prioridade inválido!!!");
                System.out.println("Digite o nível de prioridade da Tarefa entre 1 a 5 (sendo 1 para tarefa sem prioridade e 5 para tarefa urgente):");
                nivelPrioridade = ler.nextInt();
            } else {
                break;
            }
        }

        System.out.println("Digite a data máxima para o término da Tarefa (dd/mm/aaaa):");
        String dataDigitada = ler.next().trim();

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
                    dataDigitada = ler.next().trim();
                }
            }
        } catch (DateTimeParseException e) {
            System.out.println("Erro não previsto na aplicação!");
            // Aqui você pode lidar com a situação de formato de data inválido, se necessário
        }

        // Obter a data e hora local do computador
        LocalDateTime dataCriacao = LocalDateTime.now();


        TodoList tarefa = new TodoList(nome, descricao, categoria, status, dataTermino, dataCriacao, nivelPrioridade);

        System.out.printf("%s %s %s %s %s %n %s %s", tarefa.getNome(), tarefa.getDescricao(), tarefa.getCategoria(),
                tarefa.getStatus(), tarefa.getNivelPrioridade(), tarefa.getDataTermino(), tarefa.getDataCriacao());

        ler.close();

    }
}
