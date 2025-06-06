package org.example.observer;

import org.example.model.Livro;
import org.example.model.LivroReferencia;

import java.util.ArrayList;
import java.util.List;

public class Emprestimo {
    private List<Observer> observers = new ArrayList<>();
    private Livro livroEmprestado;

    public void adicionarObserver(Observer obs) {
        observers.add(obs);
    }

    public void realizarEmprestimo(Livro livro) {
        if (livro instanceof LivroReferencia) {
            System.out.println("[Emprestimo] Livro de referência não pode ser emprestado.");
            return;
        }

        this.livroEmprestado = livro;
        System.out.println("[Emprestimo] Livro emprestado: " + livro);
    }

    public void finalizarEmprestimo() {
        System.out.println("[Emprestimo] Finalizando empréstimo.");
        for (Observer obs : observers) {
            obs.notificar("Livro devolvido: " + livroEmprestado);
        }
    }
}