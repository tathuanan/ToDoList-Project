package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TodoList {

    private String nome, descricao, categoria, status;
    private int nivelPrioridade;
    private LocalDateTime dataCriacao;
    private LocalDate dataTermino;

    public TodoList(String nome, String descricao, String categoria, String status, LocalDate dataTermino, LocalDateTime dataCriacao, int nivelPrioridade) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(int nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }
}
