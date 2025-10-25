package model;

public class Tarefa {

    private String nome;
    private Boolean concluida;

    // Construtor (Cria uma nova tarefa)
    public Tarefa(String nome) {
        this.nome = nome;
        this.concluida = false; //comeca nao concluida
    }

    //Metodo para concluir a tarefa
    public void concluir () {
        this.concluida = true;
    }

    //Metodo para mostrar a tarefa
    public void mostrar() {
        String status = concluida ? "Ok" : "Nao concluida";
        System.out.println(status + "A tarefa esta" + nome);
    }

    //Getter para saber se esta concluida
    public boolean estaConcluida() {
        return concluida;
    }

    //Getter para obter o nome da tarefa
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
