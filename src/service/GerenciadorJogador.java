package service;

import model.tarefas.jogador.Jogador;

public class GerenciadorJogador {
    private Jogador jogador;

    public void criarJogador(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("❌ Nome inválido!");
            return;
        }
        this.jogador = new Jogador(nome);
        System.out.println("🎮 Jogador criado com sucesso: " + nome + "!");
    }

    public Jogador getJogador() {
        return jogador;
    }

    public boolean jogadorExiste() {
        return jogador != null;
    }

    public void mostrarStatus() {
        if (!jogadorExiste()) {
            System.out.println("❌ Nenhum jogador criado ainda!");
            return;
        }
        System.out.println("\n╔═══════════════════════════════╗");
        System.out.println("║    STATUS DO JOGADOR         ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println(jogador.toString());
        System.out.println();
    }

    // CORREÇÃO CRÍTICA: estava adicionando 0 XP!
    public void adicionarXP(int xp) {
        if (!jogadorExiste()) {
            System.out.println("❌ Crie um jogador antes de ganhar XP!");
            return;
        }

        if (xp <= 0) {
            System.out.println("⚠️ XP deve ser maior que zero!");
            return;
        }

        jogador.adicionarXP(xp); // ✅ AGORA SIM ADICIONA O XP CORRETO!
    }

    public void registrarMissaoConcluida(int xpGanho) {
        if (!jogadorExiste()) {
            System.out.println("❌ Crie um jogador antes de concluir missões!");
            return;
        }
        jogador.concluirMissao(xpGanho);
    }
}