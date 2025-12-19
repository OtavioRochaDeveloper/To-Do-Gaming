package model.tarefas;

public class Tarefa {

    private String nome;
    private String descricao;
    private Boolean concluida;
    private Categoria categoria;
    private int dificuldade;

    // Construtor (Cria uma nova tarefa)
    public Tarefa(String nome, String descricao, int dificuldade, Categoria categoria) {
        this.nome = nome;
        this.concluida = false; //comeca nao concluida
        this.descricao = descricao;
        this.dificuldade = dificuldade;
        this.categoria = categoria;
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

    public String getDescricao() {
        return descricao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    //Getter para obter o nome da tarefa
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
