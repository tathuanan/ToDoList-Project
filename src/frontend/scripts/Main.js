let hoje = new Date();
const dd = String(hoje.getDate()).padStart(2, '0');
const mm = String(hoje.getMonth() + 1).padStart(2, '0');
const aaaa = hoje.getFullYear();
hoje = aaaa + '-' + mm + '-' + dd;

const tarefas = [];
let id = 1;
const taskName = document.getElementById('taskName');
const category = document.getElementById('category');
const priority = document.getElementById('priority');
const status = document.getElementById('status');
const createDate = document.getElementById('createDate');
const deadLine = document.getElementById('deadLine');
const description = document.getElementById('description');
const createTaskButton = document.getElementById('createTaskButton');

createDate.value = hoje;
deadLine.value = hoje;

function addTask() {

    let index = createTaskButton.getAttribute('data-index');

    if (createTaskButton.innerText === "Criar Tarefa") {
        tarefas.push({
            id: id,
            nome: taskName.value,
            categoria: category.value,
            prioridade: priority.value,
            status: status.value,
            dataCriacao: createDate.value,
            dataTermino: deadLine.value,
            descricao: description.value
        });

        id ++;

    } else if (createTaskButton.innerText === "Alterar Tarefa") {
        tarefas[index] = {
            id: tarefas[index].id,
            nome: taskName.value,
            categoria: category.value,
            prioridade: priority.value,
            status: status.value,
            dataCriacao: tarefas[index].dataCriacao,
            dataTermino: deadLine.value,
            descricao: description.value
        };

        createTaskButton.innerText = "Criar Tarefa";
    }

/*    taskName.value = '';
    category.value = '';
    priority.value = '';
    status.value = '';
    createDate.value = hoje;
    deadLine.value = hoje;
    description.value = '';*/

    listTask(tarefas)
}

document.getElementById('form-task').addEventListener('submit',function(event) {
    event.preventDefault();
});

function listTask(tarefas) {

    tarefas.sort((a, b) => b.prioridade - a.prioridade);

    let corpoTabela = document.querySelector('#tableTask tbody');
    corpoTabela.innerHTML = '';

    for (let i = 0; i < tarefas.length; i++) {
        let tarefa = tarefas[i];
        let linha = document.createElement('tr');

        linha.innerHTML = `
            <td>${tarefa.id}</td>
            <td>${tarefa.nome}</td>
            <td>${tarefa.categoria}</td>
            <td>${tarefa.prioridade}</td>
            <td>${tarefa.status}</td>
            <td>${tarefa.dataCriacao}</td>
            <td>${tarefa.dataTermino}</td>
            <td class="description">${tarefa.descricao}</td>
            <td>
                <a class="btn btn-primary" onclick="editTask(${i})">Editar</a> 
                <a class="btn btn-danger" onclick="deleteTask(${i})">Deletar</a>
            </td>
        `;

        corpoTabela.appendChild(linha);
    }
}

function deleteTask(index) {
    tarefas.splice(index, 1);
    listTask(tarefas);
}

function editTask(index) {

    taskName.value = tarefas[index].nome;
    category.value = tarefas[index].categoria;
    priority.value = tarefas[index].prioridade;
    status.value = tarefas[index].status;
    createDate.value = tarefas[index].dataCriacao;
    deadLine.value = tarefas[index].dataTermino;
    description.value = tarefas[index].descricao;

    createTaskButton.innerText = "Alterar Tarefa";

    createTaskButton.setAttribute('data-index', index);

    listTask(tarefas);

}
