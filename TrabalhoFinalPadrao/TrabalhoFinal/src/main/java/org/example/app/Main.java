package org.example.app;

import org.example.factory.LivroFactory;
import org.example.infra.BibliotecaDatabase;
import org.example.model.Livro;
import org.example.model.Usuario;
import org.example.observer.Emprestimo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BibliotecaDatabase db = BibliotecaDatabase.getInstance();
        Emprestimo emprestimo = new Emprestimo();
        Usuario usuarioPadrao = new Usuario("Usuário Padrão");
        emprestimo.adicionarObserver(usuarioPadrao);

        int opcao;

        do {
            System.out.println("\n--- MENU BIBLIOTECA ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Finalizar Empréstimo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Tipo (comum/referencia): ");
                    String tipo = scanner.nextLine();

                    try {
                        Livro novoLivro = LivroFactory.criarLivro(tipo, titulo, autor);
                        db.adicionarLivro(novoLivro);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    db.listarLivros();
                    break;

                case 3:
                    db.listarLivros();
                    System.out.print("Escolha o número do livro para empréstimo: ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();

                    List<Livro> livros = db.getLivros();
                    if (idx >= 1 && idx <= livros.size()) {
                        emprestimo.realizarEmprestimo(livros.get(idx - 1));
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    emprestimo.finalizarEmprestimo();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
