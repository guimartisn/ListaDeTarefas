package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<String> tarefas = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operacao;

        do {
            displayMenu();
            System.out.println("Escolha uma Opção: ");
            operacao = scanner.nextInt();
            scanner.nextLine();

            switch(operacao){
                case 1:
                    addTarefa(scanner);
                    break;

                case 2:
                    removeTarefa(scanner);
                    break;

                case 3:
                    MarcaConcluido(scanner);
                    break;

                case 4:
                    listarTarefas();
                    break;

                case 0:
                    System.out.println("Saindo da Aplicação");
                    break;

                default:
                    System.out.println("Opção Inválida - Tente novamente.");
            }

        } while (operacao != 0);
    }

    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
        } else {
            System.out.println("\n===== Lista de Tarefas =====");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    private static void MarcaConcluido(Scanner scanner) {
        listarTarefas();
        System.out.print("Digite o número da tarefa concluída: ");
        int index = scanner.nextInt();

        if (index >= 1 && index <= tarefas.size()) {
            String tarefaConcluida = tarefas.get(index - 1);
            tarefas.remove(index - 1);
            System.out.println("Tarefa concluída: " + tarefaConcluida);
        } else {
            System.out.println("Número de tarefa inválido.");
        }
    }

    private static void removeTarefa(Scanner scanner) {
        listarTarefas();
        System.out.print("Digite o número da tarefa a ser removida: ");
        int index = scanner.nextInt();

        if (index >= 1 && index <= tarefas.size()) {
            String removedTask = tarefas.remove(index - 1);
            System.out.println("Tarefa removida: " + removedTask);
        } else {
            System.out.println("Número de tarefa inválido.");
        }
    }

    private static void addTarefa(Scanner scanner) {
        System.out.print("Digite a nova tarefa: ");
        String task = scanner.nextLine();
        tarefas.add(task);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void displayMenu(){
        System.out.println("n======= Lista de Tarefas =======");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Remover Tarefa");
        System.out.println("3. Marcar Tarefa como Concluída");
        System.out.println("4. Listar Tarefas");
        System.out.println("0. Sair");
    }
}