package org.example;

public class Processo {
    private int id;
    private String nome;
    private int prioridade;
    private int ciclosNecessarios;
    private String recursoN;
    private boolean requisitado;
    private int prioridadeOriginal;

    public Processo(int id, String nome, int prioridade, int ciclosNecessarios, String recursoN) {
        this.id = id;
        this.nome = nome;
        this.prioridade = prioridade;
        this.ciclosNecessarios = ciclosNecessarios;
        this.recursoN = recursoN;
        this.requisitado = false;
        this.prioridadeOriginal = prioridade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public int getCiclosNecessarios() {
        return ciclosNecessarios;
    }

    public String getRecursoN() {
        return recursoN;
    }

    public boolean isRequisitado() {
        return requisitado;
    }

    public int getPrioridadeOriginal() {
        return prioridadeOriginal;
    }

    public void setCiclosNecessarios(int ciclos) {
        this.ciclosNecessarios = ciclos;
    }

    public void setRequisitado(boolean requisitado) {
        this.requisitado = requisitado;
    }

    @Override
    public String toString() {
        return String.format("P%d(%s,Pri:%d,Ciclos:%d)", id, nome, prioridade, ciclosNecessarios);
    }
}
