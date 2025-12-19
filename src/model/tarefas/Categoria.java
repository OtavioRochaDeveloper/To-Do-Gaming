package model.tarefas;

public class Categoria {
    private String nome;
    private String descricao;
    private String icone;

    public static final Categoria Trabalho = new Categoria("Trabalho", "Tarefas relacionadas", "🏢");
    public static final Categoria Pessoal = new Categoria("Pessoal", "Tarefas Pessoais", "🏠");
    public static final Categoria Estudos  = new Categoria("Estudos", "Tarefas Academicas", "📚");
    public static final Categoria Saude = new Categoria("Saude", "Exercicios", "💪");
    public static final Categoria Lazer = new Categoria("Lazer", "Entretenimento", "👾");


    public Categoria(String nome, String descricao, String icone) {
        this.nome = nome;
        this.descricao = descricao;
        this.icone = icone;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIcone() {
        return icone;
    }

    @Override
    public String toString(){
        return icone + " " + nome + " - " + descricao;
    }

    public static Categoria[] getCategoriasPadrao() {
        return new Categoria[]{Trabalho,Pessoal,Estudos,Saude,Lazer};
    }

    public static Categoria buscaPorNome(String nome){
        for (Categoria cat : getCategoriasPadrao()) {
            if (cat.getNome().equalsIgnoreCase(nome)) {
                return cat;
            }
        }
        return null;
    }
}
