package org.example.factory;

import org.example.model.Livro;
import org.example.model.LivroComum;
import org.example.model.LivroReferencia;

public class LivroFactory {
    public static Livro criarLivro(String tipo, String titulo, String autor) {
        switch (tipo.toLowerCase()) {
            case "comum": return new LivroComum(titulo, autor);
            case "referencia": return new LivroReferencia(titulo, autor);
            default: throw new IllegalArgumentException("Tipo de livro desconhecido: " + tipo);
        }
    }
}