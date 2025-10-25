import service.ListaDeTarefas;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        ListaDeTarefas lista = new ListaDeTarefas();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n=== Livro de missoes ===");
            System.out.println("1. Adicionar nova missao");
            System.out.println("2. Ver todas as missoes");
            System.out.println("3. Concluir missao");
            System.out.println("4. Remover missao");
            System.out.println("5. Editar missao");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opcao");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome da missao: ");
                    String nome = scanner.nextLine();
                    lista.adicionarTarefa(nome);
                    break;
                case 2:
                    lista.mostrarTarefas();
                    break;
                case 3:
                    System.out.println("Digite o numero da missao concluida: ");
                    int indiceC = scanner.nextInt() - 1;
                    lista.concluirTarefas(indiceC);
                    break;
                case 4:
                    System.out.println("Digite o numero da missao que voce quer remover");
                    int indiceR = scanner.nextInt() - 1;
                    lista.removerTarefa(indiceR);
                    break;
                case 5:
                    System.out.println("Digite o numero da missao que deseja editar: ");
                    int indiceE = scanner.nextInt() - 1;
                    System.out.println("Digite o novo nome da missao: ");
                    String novoNome = scanner.nextLine();
                    lista.editarTarefa(indiceE, novoNome);
                    break;
                default:
                    System.out.println("Opcao invalida");
            }

        } while (opcao != 0);

        scanner.close();
    }
}