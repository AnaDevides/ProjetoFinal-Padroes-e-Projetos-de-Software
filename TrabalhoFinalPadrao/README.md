----Sistema de Controle de Biblioteca----

----Objetivo----

Desenvolver uma aplicação Java aplicando três padrões de projeto distintos, de forma correta e
contextualizada, demonstrando sua utilidade no design orientado a objetos.

----Tema Escolhido----

Sistema de Controle de Biblioteca

----Padrões de Projeto Aplicados----

1. Singleton - BibliotecaDatabase
Propósito: Garante que haja apenas uma instância da "base de dados" na aplicação.
Utilidade: Centraliza o gerenciamento de livros, simulando uma base de dados.
Onde é aplicado: Na classe BibliotecaDatabase , com um construtor privado e método
estático getInstance()

3. Factory Method - LivroFactory
Propósito: Cria objetos Livro de diferentes tipos sem expor a lógica de instanciação.
Utilidade: Facilita a criação de livros comuns ou de referência sem modificar o código cliente.
Onde é aplicado: Na classe LivroFactory , que retorna instâncias de LivroComum ou
LivroReferencia com base em um parâmetro.

4. Observer - Usuario e Emprestimo
Propósito: Permite que objetos sejam notificados automaticamente quando um evento ocorre.
Utilidade: Usuários são notificados quando um empréstimo é finalizado.
Onde é aplicado: Na classe Emprestimo , que armazena observadores e os notifica com
mensagens de devolução.

----Arquitetura Geral----

Main : Ponto de entrada da aplicação.

BibliotecaDatabase : Gerencia os livros (Singleton).

Livro , LivroComum , LivroReferencia : Hierarquia de livros.

LivroFactory : Cria livros conforme o tipo.

Usuario : Representa um observador (Observer).

Emprestimo : Controla o empréstimo de livros e notifica os usuários.

----UML SIMPLIFICADO----

![image](https://github.com/user-attachments/assets/8e824824-fdca-4400-a7c7-5170ed4b37b6)

