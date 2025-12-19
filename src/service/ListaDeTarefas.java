package service;

import model.tarefas.Categoria;
import model.tarefas.Tarefa;
import java.util.ArrayList;

public class ListaDeTarefas {
    private ArrayList<Tarefa> tarefas = new ArrayList<>();

    //adiciona uma nova tarefa
    public void adicionarTarefa(String nome, String descricao, int dificuldade, Categoria Categoria) {
        Tarefa nova = new Tarefa(nome, descricao, dificuldade, Categoria);
        tarefas.add(nova);
        System.out.println("Nova missao adicionada: " + nome);
    }

    // Mostrar todas as tarefas
    public void mostrarTarefas() {
        for (int i = 0; i < tarefas.size(); i++){
            System.out.println((i + 1) + ". ");
            tarefas.get(i).mostrar();
            System.out.println("\n suas missoes:");
        }
    }

    //conclui uma tarefa (Marcar como feita)
    public void concluirTarefas(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.get(indice).concluir();
            System.out.println("Missao Concluida: " + tarefas.get(indice).getNome());
        } else {
            System.out.println("Missao nao encontrada");
        }
    }

    // remove uma tarefa
    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            System.out.println("Missao Removida: " + tarefas.get(indice).getNome());
            tarefas.remove(indice);
        } else {
            System.out.println("Missao nao encontrada");
        }
    }

    //Editar uma tarefa 
    public void editarTarefa(int indice, String nome) {
        if (indice >= 0 && indice < tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice);
            System.out.println("Missao renoemada de " + tarefa.getNome() + "Para " + nome + "'");
            tarefa.setNome(nome);
        } else {
            System.out.println("Missao nao encontrada! ");
        }


    }

}
