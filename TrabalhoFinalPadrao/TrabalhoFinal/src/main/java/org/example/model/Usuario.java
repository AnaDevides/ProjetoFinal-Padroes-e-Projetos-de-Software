package org.example.model;

import org.example.observer.Observer;

public class Usuario implements Observer {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public void notificar(String mensagem) {
        System.out.println("[Notificação] " + nome + ": " + mensagem);
    }
}