package model.tarefas.progresso;

import model.tarefas.Tarefa;
import java.util.List;

public class Estatisticas {
    private int totalMissoes;
    private int missoesConcluidas;
    private int missoesPendentes;
    private int xpTotal;
    private int missoesPorCategoria; // Pode expandir para um Map<Categoria, Integer>

    // Calcula estatísticas a partir da lista de tarefas
    public void calcularEstatisticas(List<Tarefa> tarefas, int xpAcumulado) {
        this.totalMissoes = tarefas.size();
        this.missoesConcluidas = (int) tarefas.stream()
                .filter(Tarefa::estaConcluida)
                .count();
        this.missoesPendentes = totalMissoes - missoesConcluidas;
        this.xpTotal = xpAcumulado;
    }

    public void exibir() {
        System.out.println("\n╔═══════════════════════════════╗");
        System.out.println("║   📊 ESTATISTICAS DO JOGO    ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println("📋 Total de missões: " + totalMissoes);
        System.out.println("✅ Concluidas: " + missoesConcluidas);
        System.out.println("⏳ Pendentes: " + missoesPendentes);
        System.out.println("💫 XP Total Ganho: " + xpTotal);

        if (totalMissoes > 0) {
            double taxa = (missoesConcluidas * 100.0) / totalMissoes;
            System.out.println("📈 Taxa de Conclusão: " + String.format("%.1f%%", taxa));
        }
        System.out.println("═══════════════════════════════");
    }

    // Getters
    public int getTotalMissoes() {
        return totalMissoes;
    }

    public int getMissoesConcluidas() {
        return missoesConcluidas;
    }

    public int getMissoesPendentes() {
        return missoesPendentes;
    }

    public int getXpTotal() {
        return xpTotal;
    }
}