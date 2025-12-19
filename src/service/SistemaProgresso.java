package service;

public class SistemaProgresso {

    // XP base por dificuldade
    private static final int[] XP_POR_DIFICULDADE = {0, 50, 100, 150, 250, 400};

    public int calcularXP(int dificuldade) {
        if (dificuldade < 1 || dificuldade > 5) {
            System.out.println("⚠️ Dificuldade inválida! Usando dificuldade 1.");
            return XP_POR_DIFICULDADE[1];
        }
        return XP_POR_DIFICULDADE[dificuldade];
    }

    // Bônus por streak (missões concluídas consecutivas)
    public int calcularBonusStreak(int diasConsecutivos) {
        return diasConsecutivos * 10; // +10 XP por dia de streak
    }

    // Bônus por categoria (pode dar mais XP para categorias específicas)
    public int calcularBonusCategoria(String nomeCategoria) {
        switch (nomeCategoria.toLowerCase()) {
            case "estudos":
                return 20; // Incentivar estudos
            case "saude":
                return 15; // Incentivar saúde
            default:
                return 0;
        }
    }
}