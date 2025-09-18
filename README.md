PROJETO: ESCALONADOR DE PRIORIDADE 'ICEVOS'

DISCIPLINA: Algoritmo e estrtura de dados I | Professor: Dimmy Karson Soares Magalhães

INTEGRANTE: Danilo Campos Fernandes de Oliveira

REPOSITÓRIO
Link para o Repositório: https://github.com/Daadilo?tab=repositories

DESCRIÇÃO DO PROJETO: 
Escalonamento por Prioridades com 3 níveis (Alta, Média, Baixa)
Sistema Anti-inanição para garantir justiça no processamento
Gerenciamento de Recursos com bloqueio/desbloqueio (recurso DISCO)
Lista Ligada Manual implementada do zero (sem Collections)
Simulação Completa de ciclos de CPU

COMPILAÇÃO E EXECUÇÃO:
Java Development Kit (JDK)

Versão Mínima: JDK 8
Versão Recomendada: JDK 11 ou superior
Download: https://www.oracle.com/java/technologies/downloads/

IDE (Opcional, mas Recomendado)

IntelliJ IDEA (usado no desenvolvimento)
Eclipse IDE
Visual Studio Code com extensões Java

Git (Para versionamento)

Download: https://git-scm.com/downloads

🛠️ Verificação de Instalação
Abra o terminal/prompt de comando e execute:
bash# Verificar Java
java -version
javac -version

# Verificar Git (opcional)
git --version
Saída esperada para Java:
java version "11.0.x" 2023-xx-xx
Java(TM) SE Runtime Environment (build 11.0.x+x-LTS)

📦 Como Baixar e Configurar
Opção 1: Download Direto

Acesse: https://github.com/[seu_usuario]/scheduler-icevos-p1
Clique em "Code" → "Download ZIP"
Extraia o arquivo para uma pasta de sua escolha

Opção 2: Clone via Git
bashgit clone https://github.com/[seu_usuario]/scheduler-icevos-p1.git
cd scheduler-icevos-p1
Opção 3: IntelliJ IDEA

File → New → Project from Version Control
Cole a URL: https://github.com/[seu_usuario]/scheduler-icevos-p1.git
Escolha a pasta de destino
Clique em Clone


🚀 Compilação e Execução
Método 1: Linha de Comando
bash# 1. Navegar para pasta do projeto
cd scheduler-icevos-p1

# 2. Compilar todos os arquivos Java
javac *.java

# 3. Executar com arquivo de entrada
java Main processos.txt
Método 2: IntelliJ IDEA

Abrir o projeto no IntelliJ
Configurar Run Configuration:

Run → Edit Configurations
Program arguments: processos.txt
Working directory: Pasta raiz do projeto


Executar: Pressione Ctrl + Shift + F10 ou clique no ▶️

Método 3: Eclipse IDE

Importar projeto: File → Import → General → Existing Projects
Configurar argumentos:

Run → Run Configurations
Arguments tab → Program arguments: processos.txt


Executar: Run → Run As → Java Application


📊 Arquivo de Entrada
Formato: processos.txt
id,nome,prioridade,ciclos_necessarios,recurso_necessario
1,P1,1,5,DISCO
2,P2,2,3,
3,P3,1,4,DISCO
4,P4,3,2,
5,P5,2,6,
