package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarefa {

    private String nome, descricao, categoria, status;
    private int nivelPrioridade;
    private LocalDateTime dataCriacao;
    private LocalDate dataTermino;

    public Tarefa(String nome, String descricao, String categoria, String status, LocalDate dataTermino, LocalDateTime dataCriacao, int nivelPrioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = status;
        this.dataTermino = dataTermino;
        this.dataCriacao = dataCriacao;
        this.nivelPrioridade = nivelPrioridade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getStatus() {
        return status;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }
}
