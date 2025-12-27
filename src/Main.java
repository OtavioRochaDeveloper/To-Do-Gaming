import model.tarefas.Categoria;
import service.GerenciadorJogador;
import service.ListaDeTarefas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeTarefas lista = new ListaDeTarefas();
        GerenciadorJogador gerenciador = new GerenciadorJogador();
        Scanner scanner = new Scanner(System.in);

        // ===== CRIAR JOGADOR NO INÍCIO =====
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║  🎮 BEM-VINDO AO LIVRO DE MISSÕES    ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.print("\n👤 Digite seu nome de jogador: ");
        String nomeJogador = scanner.nextLine();
        gerenciador.criarJogador(nomeJogador);

        System.out.println("\n🎯 Complete missões para ganhar XP e subir de nível!");
        pausar(scanner);

        int opcao = 0;

        do {
            exibirMenu();

            // Validação de entrada
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Por favor, digite um número válido!");
                scanner.nextLine(); // Limpa entrada inválida
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarMissao(scanner, lista);
                    break;

                case 2:
                    lista.mostrarTarefas();
                    pausar(scanner);
                    break;

                case 3:
                    concluirMissao(scanner, lista, gerenciador);
                    break;

                case 4:
                    removerMissao(scanner, lista);
                    break;

                case 5:
                    editarMissao(scanner, lista);
                    break;

                case 6:
                    gerenciador.mostrarStatus();
                    pausar(scanner);
                    break;

                case 7:
                    lista.exibirEstatisticas();
                    pausar(scanner);
                    break;

                case 0:
                    System.out.println("\n👋 Até logo, " + gerenciador.getJogador().getNome() + "!");
                    System.out.println("📊 Missões concluídas: " + gerenciador.getJogador().getMissoesConcluidas());
                    System.out.println("⭐ Nível final: " + gerenciador.getJogador().getNivel());
                    break;

                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // ===== MENU PRINCIPAL =====
    private static void exibirMenu() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║       📖 LIVRO DE MISSÕES            ║");
        System.out.println("╚═══════════════════════════════════════╝");
        System.out.println("1. ✨ Adicionar nova missão");
        System.out.println("2. 📋 Ver todas as missões");
        System.out.println("3. ✅ Concluir missão");
        System.out.println("4. 🗑️  Remover missão");
        System.out.println("5. ✏️  Editar missão");
        System.out.println("6. 👤 Ver status do jogador");
        System.out.println("7. 📊 Ver estatísticas");
        System.out.println("0. 🚪 Sair");
        System.out.print("\n🎯 Escolha uma opção: ");
    }

    // ===== ADICIONAR MISSÃO =====
    private static void adicionarMissao(Scanner scanner, ListaDeTarefas lista) {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║      ✨ NOVA MISSÃO                  ║");
        System.out.println("╚═══════════════════════════════════════╝");

        System.out.println("\n📁 Categorias disponíveis:");
        Categoria[] categorias = Categoria.getCategoriasPadrao();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println((i + 1) + ". " + categorias[i]);
        }

        System.out.print("\n📝 Digite o nome da missão: ");
        String nome = scanner.nextLine();

        if (nome.trim().isEmpty()) {
            System.out.println("❌ Nome não pode ser vazio!");
            return;
        }

        System.out.print("📄 Digite a descrição da missão: ");
        String descricao = scanner.nextLine();

        System.out.print("📁 Escolha o número da categoria (1-" + categorias.length + "): ");
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Entrada inválida!");
            scanner.nextLine();
            return;
        }

        int catIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (catIndex < 0 || catIndex >= categorias.length) {
            System.out.println("❌ Categoria inválida!");
            return;
        }

        Categoria categoria = categorias[catIndex];

        System.out.println("\n⚔️ Níveis de dificuldade:");
        System.out.println("1 ⭐ Muito Fácil (50 XP)");
        System.out.println("2 ⭐⭐ Fácil (100 XP)");
        System.out.println("3 ⭐⭐⭐ Médio (150 XP)");
        System.out.println("4 ⭐⭐⭐⭐ Difícil (250 XP)");
        System.out.println("5 ⭐⭐⭐⭐⭐ Muito Difícil (400 XP)");

        System.out.print("\n⚔️ Digite a dificuldade (1-5): ");
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Entrada inválida!");
            scanner.nextLine();
            return;
        }

        int dificuldade = scanner.nextInt();
        scanner.nextLine();

        if (dificuldade < 1 || dificuldade > 5) {
            System.out.println("❌ Dificuldade deve ser entre 1 e 5!");
            return;
        }

        lista.adicionarTarefa(nome, descricao, dificuldade, categoria);
        pausar(scanner);
    }

    // ===== CONCLUIR MISSÃO (COM XP!) =====
    private static void concluirMissao(Scanner scanner, ListaDeTarefas lista, GerenciadorJogador gerenciador) {
        if (lista.getClass().isEnum()) {
            System.out.println("❌ Não há missões para concluir!");
            pausar(scanner);
            return;
        }

        lista.mostrarTarefas();

        System.out.print("\n✅ Digite o número da missão concluída: ");
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Entrada inválida!");
            scanner.nextLine();
            pausar(scanner);
            return;
        }

        int indiceC = scanner.nextInt() - 1;
        scanner.nextLine(); // ✅ LIMPA O BUFFER!

        // Conclui a missão e pega o XP ganho
        int xpGanho = lista.concluirTarefas(indiceC);

        // Se ganhou XP, adiciona ao jogador
        if (xpGanho > 0) {
            gerenciador.registrarMissaoConcluida(xpGanho);
        }

        pausar(scanner);
    }

    // ===== REMOVER MISSÃO =====
    private static void removerMissao(Scanner scanner, ListaDeTarefas lista) {
        if (lista.getClass().isEnum()) {
            System.out.println("❌ Não há missões para remover!");
            pausar(scanner);
            return;
        }

        lista.mostrarTarefas();

        System.out.print("\n🗑️ Digite o número da missão que você quer remover: ");
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Entrada inválida!");
            scanner.nextLine();
            pausar(scanner);
            return;
        }

        int indiceR = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpa buffer

        lista.removerTarefa(indiceR);
        pausar(scanner);
    }

    // ===== EDITAR MISSÃO =====
    private static void editarMissao(Scanner scanner, ListaDeTarefas lista) {
        if (lista.getClass().isEnum()) {
            System.out.println("❌ Não há missões para editar!");
            pausar(scanner);
            return;
        }

        lista.mostrarTarefas();

        System.out.print("\n✏️ Digite o número da missão que deseja editar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Entrada inválida!");
            scanner.nextLine();
            pausar(scanner);
            return;
        }

        int indiceE = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpa buffer

        System.out.print("📝 Digite o novo nome da missão: ");
        String novoNome = scanner.nextLine();

        if (novoNome.trim().isEmpty()) {
            System.out.println("❌ Nome não pode ser vazio!");
            pausar(scanner);
            return;
        }

        lista.editarTarefa(indiceE, novoNome);
        pausar(scanner);
    }

    // ===== FUNÇÃO AUXILIAR PARA PAUSAR =====
    private static void pausar(Scanner scanner) {
        System.out.print("\n⏸️  Pressione ENTER para continuar...");
        scanner.nextLine();
    }
}