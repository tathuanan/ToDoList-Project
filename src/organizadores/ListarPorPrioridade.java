package organizadores;

import processadores.de.arquivos.LerTarefas;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ListarPorPrioridade {
    static LerTarefas lerTarefas = new LerTarefas("TodoList.csv");
    static String tarefa;
    public static void listarPorPrioridade(String prioridade) throws IOException {

        tarefa = null;

        List<HashMap<String, String>> tarefasSalvas = LerTarefas.dadosTarefasSalvas(lerTarefas.buscarCabecalho(),
                lerTarefas.lerTarefasSalvas());

        int contador = 0;
        for (String tarefas : lerTarefas.lerTarefasSalvas()) {
            if (tarefasSalvas.get(contador).get("nivelPrioridade").equals(prioridade)) {
                tarefa = String.format("%s,%s,%s,%s,%s,%s,%s,", tarefasSalvas.get(contador).get("nome"),
                        tarefasSalvas.get(contador).get("descricao"), tarefasSalvas.get(contador).get("nivelPrioridade"),
                        tarefasSalvas.get(contador).get("categoria"), tarefasSalvas.get(contador).get("dataTermino"),
                        tarefasSalvas.get(contador).get("dataCriacao"), tarefasSalvas.get(contador).get("status"));
                System.out.println(tarefa);
            }
            contador++;
        }
        if(tarefa == null){
            System.out.println("A Prioridade selecionada não possui tarefas!!!");
        }
    }
}
