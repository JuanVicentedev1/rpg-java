package tech.buildrun.TaskFlow;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciadorTarefa gerenciadorTarefa = new GerenciadorTarefa();

        System.out.println("Bem vindo ao TaskFlow!");

        boolean finalizarTaskflow = false;
        do {
            menu();

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    adicionarTarefa(sc, gerenciadorTarefa);
                    break;
                case 2:
                    removerTarefa(sc, gerenciadorTarefa);
                    break;
                case 3:
                    gerenciadorTarefa.imprimirTarefas();
                    break;
                case 4:
                    tarefaConcluida(sc, gerenciadorTarefa);
                    break;
                case 5:
                    procurarTarefa(sc, gerenciadorTarefa);
                    break;
                case 6:
                    finalizarTaskflow = true;
                    break;


            }

        }while (!finalizarTaskflow);
    }

    private static void procurarTarefa(Scanner sc, GerenciadorTarefa gerenciadorTarefa) {
        System.out.println("Digite a descrição:");
        String descricao = sc.nextLine();
        gerenciadorTarefa.procurarTarefa(descricao);
    }

    private static void tarefaConcluida(Scanner sc, GerenciadorTarefa gerenciadorTarefa) {
        System.out.println("Digite o ID:");
        String id = sc.nextLine();
        gerenciadorTarefa.finalizarTarefa(id);
    }

    private static void removerTarefa(Scanner sc, GerenciadorTarefa gerenciadorTarefa) {
        System.out.println("Digite o ID:");
        String id = sc.nextLine();
        sc.nextLine();

        gerenciadorTarefa.removerTarefa(id);
    }

    private static void adicionarTarefa(Scanner sc, GerenciadorTarefa gerenciadorTarefa) {
        System.out.println("Digite o ID:");
        String id = sc.nextLine();
        sc.nextLine();
        System.out.println("Digite a descrição: ");
        String descricao = sc.nextLine();
        gerenciadorTarefa.adicionarTarefa(id, descricao);
    }

    private static void menu() {
        System.out.println("========================");
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Remover Tarefa por ID");
        System.out.println("3. Listar Tarefas");
        System.out.println("4. Marcar Tarefa como Concluída");
        System.out.println("5. Procurar Tarefa");
        System.out.println("6. Sair Escolha uma opção: ");
        System.out.println("========================");
    }
}
