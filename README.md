# Máquina de Banho de Pet 

Exercício do bootcamp de Java sobre Programação Orientada a Objetos. O programa simula uma máquina de banho de pet com controle de água e shampoo, rodando por um menu no terminal.

## Como rodar

1. Compile os arquivos da pasta `ex011`.
2. Execute a classe `MenuBanho`, que contém o método `main`.
3. Escolha as opções digitando o número no terminal.

## Estrutura

- `Banho.java`: classe com as regras da máquina.
- `MenuBanho.java`: menu interativo que usa a classe `Banho`.

## Regras da máquina

- Capacidade máxima: 30L de água e 10L de shampoo (a máquina começa cheia).
- O abastecimento é sempre de 2L por vez e só acontece se o abastecimento inteiro couber.
- Cada banho gasta 10L de água e 2L de shampoo.
- Só cabe um pet por vez, e o mesmo pet não pode tomar banho duas vezes.
- Se o pet sair sujo, a máquina fica suja. Ela precisa ser limpa antes de receber outro pet.
- A limpeza gasta 3L de água e 1L de shampoo e só pode ser feita sem pet dentro e com a máquina suja.

## O que pratiquei

- Encapsulamento (atributos privados e getters).
- Validações com mensagem de erro para o usuário.
- Constantes com `static final` no lugar de números soltos.
- Menu com `switch` e tratamento de entrada inválida.

## Observação

Exercício feito por mim, com revisão e dicas de IA durante os ajustes.
