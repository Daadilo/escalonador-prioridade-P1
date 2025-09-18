package org.example;

public class Scheduler {
    private ListaProcessos listaAlta;
    private ListaProcessos listaMedia;
    private ListaProcessos listaBaixa;
    private ListaProcessos listaBloqueados;
    private int numeroCiclo;
    private int contadorAlta;
    private int contadorMedia;

    public Scheduler() {
        this.listaAlta = new ListaProcessos();
        this.listaMedia = new ListaProcessos();
        this.listaBaixa = new ListaProcessos();
        this.listaBloqueados = new ListaProcessos();
        this.numeroCiclo = 1;
        this.contadorAlta = 0;
        this.contadorMedia = 0;
    }

    public void adicionarProcesso(Processo processo) {
        if (processo.getPrioridade() == 1) {
            listaAlta.adicionarFinal(processo);
        } else if (processo.getPrioridade() == 2) {
            listaMedia.adicionarFinal(processo);
        } else if (processo.getPrioridade() == 3) {
            listaBaixa.adicionarFinal(processo);
        } else {
            System.out.println("A prioridade é invalida para o processo");
        }
    }

    public void executarCiclo() {
        // Desbloqueio
        if (!listaBloqueados.estaVazia()) {
            Processo desbloqueado = listaBloqueados.removerInicio();
            System.out.println("Desbloqueando processo: " + desbloqueado.getNome());
            adicionarProcesso(desbloqueado);
        }

        Processo processoAtual = null;

        // Anti-inanição: força baixa após 5 médias
        if (contadorMedia >= 5 && !listaBaixa.estaVazia()) {
            processoAtual = listaBaixa.removerInicio();
            contadorMedia = 0;
        }

        // Anti-inanição: força média/baixa após 5 altas
        if (processoAtual == null && contadorAlta >= 5) {
            if (!listaMedia.estaVazia()) {
                processoAtual = listaMedia.removerInicio();
                contadorAlta = 0;
            } else if (!listaBaixa.estaVazia()) {
                processoAtual = listaBaixa.removerInicio();
                contadorAlta = 0;
            }
        }

        // Execução normal: Alta → Média → Baixa
        if (processoAtual == null) {
            if (!listaAlta.estaVazia()) {
                processoAtual = listaAlta.removerInicio();
                contadorAlta++;
                contadorMedia = 0;
            } else if (!listaMedia.estaVazia()) {
                processoAtual = listaMedia.removerInicio();
                contadorMedia++;
                contadorAlta = 0;
            } else if (!listaBaixa.estaVazia()) {
                processoAtual = listaBaixa.removerInicio();
                contadorAlta = 0;
                contadorMedia = 0;
            } else {
                System.out.println("Nenhum processo para executar no ciclo " + numeroCiclo);
                numeroCiclo++;
                return;
            }
        }

        // Verificar bloqueio por DISCO
        if (processoAtual != null) {
            if (processoAtual.getRecursoN() != null &&
                    processoAtual.getRecursoN().equalsIgnoreCase("DISCO") &&
                    !processoAtual.isRequisitado()) {
                processoAtual.setRequisitado(true);
                listaBloqueados.adicionarFinal(processoAtual);
                System.out.println("Processo " + processoAtual.getNome() + " está bloqueado aguardando recurso.");
                processoAtual = null;
            }
        }

        // Executar processo
        if (processoAtual != null) {
            System.out.println("\n| Ciclo numero: " + numeroCiclo + " | Executando processo: " + processoAtual.getNome());
            System.out.println("|");
            processoAtual.setCiclosNecessarios(processoAtual.getCiclosNecessarios() - 1);

            if (processoAtual.getCiclosNecessarios() > 0) {
                adicionarProcesso(processoAtual);
            } else {
                System.out.println("| O processo " + processoAtual.getNome() + " foi finalizado.");
            }
        }

        // Imprimir estado
        System.out.println("| Estado das listas no final do ciclo: " + numeroCiclo);
        System.out.print("| Alta: \n");
        listaAlta.percorrerLista();
        System.out.print("| Média: \n");
        listaMedia.percorrerLista();
        System.out.print("| Baixa: \n");
        listaBaixa.percorrerLista();
        System.out.print("| Bloqueados: \n");
        listaBloqueados.percorrerLista();
        System.out.println("\n+========================================+");

        numeroCiclo++;
    }

    public void executarTodos() {
        while (!listaAlta.estaVazia() || !listaMedia.estaVazia() ||
                !listaBaixa.estaVazia() || !listaBloqueados.estaVazia()) {
            executarCiclo();
        }
        System.out.println("|Todos os processos foram concluídos.");
        System.out.println("+========================================+");
    }
}
