package org.example;

public class ListaProcessos {
    private class Node {
        Processo processo;
        Node proximo;

        Node(Processo processo) {
            this.processo = processo;
            this.proximo = null;
        }
    }

    private Node cabeca;
    private Node cauda;

    public ListaProcessos() {
        this.cabeca = null;
        this.cauda = null;
    }

    public void adicionarFinal(Processo processo) {
        Node novoNo = new Node(processo);
        if (cabeca == null) {
            cabeca = cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            cauda = novoNo;
        }
    }

    public Processo removerInicio() {
        if (cabeca == null) return null;

        Processo processo = cabeca.processo;
        cabeca = cabeca.proximo;
        if (cabeca == null) cauda = null;

        return processo;
    }

    public boolean estaVazia() {
        return cabeca == null;
    }

    public void percorrerLista() {
        Node atual = cabeca;
        if (atual == null) {
            System.out.println("| Lista vazia");
            return;
        }
        while (atual != null) {
            System.out.println("| " + atual.processo);
            atual = atual.proximo;
        }
    }

    public void imprimir() {
        Node atual = cabeca;
        System.out.print("[");
        while (atual != null) {
            System.out.print(atual.processo.toString());
            if (atual.proximo != null) System.out.print(", ");
            atual = atual.proximo;
        }
        System.out.print("]");
    }
}
