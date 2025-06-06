package org.example.infra;

import org.example.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDatabase {
    private static BibliotecaDatabase instancia;
    private List<Livro> livros;

    private BibliotecaDatabase() {
        livros = new ArrayList<>();
        System.out.println("[Singleton] Instância da base de dados criada.");
    }

    public static BibliotecaDatabase getInstance() {
        if (instancia == null) {
            instancia = new BibliotecaDatabase();
        }
        return instancia;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("[Database] Livro adicionado: " + livro);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void listarLivros() {
        System.out.println("[Database] Listando livros...");
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (int i = 0; i < livros.size(); i++) {
                System.out.println((i + 1) + " - " + livros.get(i));
            }
        }
    }
}
