package model.tarefas.jogador;

public class Jogador {
    private String nome;
    private int experiencia;
    private int nivel;
    private int missoesConcluidas;
    private static final int XP_BASE_LEVEL_UP = 100;

    public Jogador(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.experiencia = 0;
        this.missoesConcluidas = 0;
    }

    // Adiciona XP e verifica level up automaticamente
    public void adicionarXP(int quantidade) {
        this.experiencia += quantidade;
        verificarLevelUp();
    }

    // Verifica se o jogador subiu de nível (pode subir múltiplos níveis de uma vez)
    private void verificarLevelUp() {
        int xpNecessario = calcularXPNecessario();

        while (this.experiencia >= xpNecessario) {
            this.nivel++;
            this.experiencia -= xpNecessario;
            System.out.println("🎉 Parabens! Você subiu para o nivel " + this.nivel + "!");
            xpNecessario = calcularXPNecessario();
        }
    }

    // Cálculo progressivo: cada nível fica mais difícil
    private int calcularXPNecessario() {
        return XP_BASE_LEVEL_UP + (nivel - 1) * 20; // Nível 1: 100 XP, Nível 2: 120 XP, etc.
    }

    // Chamado quando uma missão é concluída
    public void concluirMissao(int xpGanho) {
        this.missoesConcluidas++;
        adicionarXP(xpGanho);
        System.out.println("✅ Missão concluída! +"+xpGanho+" XP");
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getMissoesConcluidas() {
        return missoesConcluidas;
    }

    public int getExperiencia() {
        return experiencia;
    }

    // Retorna o XP necessário para o próximo nível
    public int getXPProximoNivel() {
        return calcularXPNecessario();
    }

    @Override
    public String toString() {
        int xpProximo = calcularXPNecessario();
        double porcentagem = (experiencia * 100.0) / xpProximo;

        return String.format(
                "👤 Jogador: %s\n" +
                        "⭐ Nivel: %d\n" +
                        "💫 Experiencia: %d/%d XP (%.1f%%)\n" +
                        "✅ Missões Concluidas: %d",
                nome, nivel, experiencia, xpProximo, porcentagem, missoesConcluidas
        );
    }
}