package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main processos.txt");
            return;
        }
        try {
            Scheduler scheduler = new Scheduler();
            carregarProcessos(args[0], scheduler);
            System.out.println("=== INICIANDO ESCALONADOR iCEVOS ===");
            scheduler.executarTodos();
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    private static void carregarProcessos(String nomeArquivo, Scheduler scheduler) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            System.out.println("Carregando processos de: " + nomeArquivo);
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;

                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                int prioridade = Integer.parseInt(dados[2]);
                int ciclos = Integer.parseInt(dados[3]);
                String recurso = dados.length > 4 && !dados[4].isEmpty() ? dados[4] : null;

                Processo processo = new Processo(id, nome, prioridade, ciclos, recurso);
                scheduler.adicionarProcesso(processo);
                System.out.println("Carregado: " + processo);
            }
        }
    }
}
