# 🎮 Livro de Missões - To-Do List Gamificado

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

> Um sistema de gerenciamento de tarefas gamificado desenvolvido em Java puro, onde cada missão concluída rende XP e faz você subir de nível! 🚀

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Como Executar](#-como-executar)
- [Como Usar](#-como-usar)
- [Conceitos de POO Aplicados](#-conceitos-de-poo-aplicados)
- [Melhorias Futuras](#-melhorias-futuras)
- [Autor](#-autor)
- [Licença](#-licença)

---

## 🎯 Sobre o Projeto

O **Livro de Missões** é uma aplicação de linha de comando que transforma o gerenciamento de tarefas em uma experiência gamificada. Desenvolvido como projeto de estudo para praticar e consolidar os conceitos fundamentais de **Programação Orientada a Objetos (POO)** em Java.

### 🌟 Diferenciais

- ✨ **Sistema de XP e Níveis**: Ganhe experiência ao completar missões
- 🏆 **Progressão por Dificuldade**: Missões mais difíceis rendem mais XP
- 📊 **Estatísticas Detalhadas**: Acompanhe seu progresso e desempenho
- 🎨 **Categorias Personalizadas**: Organize suas tarefas por tipo
- 💪 **XP Progressivo**: Cada nível requer mais experiência que o anterior

---

## ⚡ Funcionalidades

### 🎮 Sistema de Jogador
- [x] Criação de perfil de jogador personalizado
- [x] Sistema de experiência (XP) e níveis
- [x] Contador de missões concluídas
- [x] Barra de progresso visual para o próximo nível
- [x] Level up automático com mensagens motivacionais

### 📝 Gerenciamento de Tarefas
- [x] Adicionar novas missões com nome, descrição e dificuldade
- [x] Listar todas as missões (pendentes e concluídas)
- [x] Concluir missões e ganhar XP
- [x] Remover missões
- [x] Editar nome das missões
- [x] Sistema de categorias com ícones

### 📊 Sistema de Progresso
- [x] Cálculo de XP baseado em dificuldade (1-5 estrelas)
- [x] Estatísticas gerais (total, concluídas, pendentes)
- [x] Taxa de conclusão percentual
- [x] XP total acumulado
- [x] Visualização de status do jogador

### 🎨 Interface
- [x] Menu interativo com emojis
- [x] Validação de entradas do usuário
- [x] Mensagens de feedback claras
- [x] Sistema de pause entre operações
- [x] Design visual com bordas decorativas

---

## 🛠️ Tecnologias Utilizadas

- **Java SE** (versão 8 ou superior)
- **Collections Framework** (ArrayList)
- **Scanner** para entrada de dados
- **Paradigma**: Programação Orientada a Objetos

---

## 📁 Estrutura do Projeto

```
📦 livro-de-missoes/
├── 📂 src/
│   ├── 📄 Main.java                          # Classe principal com menu
│   ├── 📂 model/
│   │   └── 📂 tarefas/
│   │       ├── 📄 Tarefa.java                # Modelo de tarefa
│   │       ├── 📄 Categoria.java             # Categorias com ícones
│   │       ├── 📂 jogador/
│   │       │   └── 📄 Jogador.java           # Sistema de jogador e XP
│   │       └── 📂 progresso/
│   │           └── 📄 Estatisticas.java      # Cálculos estatísticos
│   └── 📂 service/
│       ├── 📄 ListaDeTarefas.java            # Gerenciamento de tarefas
│       ├── 📄 GerenciadorJogador.java        # Controle do jogador
│       └── 📄 SistemaProgresso.java          # Cálculo de XP
└── 📄 README.md
```

### 📦 Descrição dos Pacotes

#### `model.tarefas`
Contém as classes de domínio que representam as entidades principais:
- **Tarefa**: Representa uma missão com nome, descrição, categoria, dificuldade e status
- **Categoria**: Define categorias predefinidas com ícones e descrições

#### `model.tarefas.jogador`
- **Jogador**: Gerencia o perfil do jogador, XP, nível e missões concluídas

#### `model.tarefas.progresso`
- **Estatisticas**: Calcula e exibe estatísticas do progresso do jogador

#### `service`
Contém a lógica de negócio e serviços:
- **ListaDeTarefas**: CRUD de tarefas e integração com sistema de XP
- **GerenciadorJogador**: Controla criação e ações do jogador
- **SistemaProgresso**: Calcula XP baseado em dificuldade

---

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 8 ou superior instalado
- IDE Java (Eclipse, IntelliJ IDEA, NetBeans) ou compilador via terminal

### Opção 1: Via IDE

1. Clone ou baixe o projeto
2. Importe o projeto na sua IDE favorita
3. Execute a classe `Main.java`

### Opção 2: Via Terminal

```bash
# 1. Navegue até a pasta src
cd caminho/para/projeto/src

# 2. Compile todos os arquivos Java
javac Main.java model/tarefas/*.java model/tarefas/jogador/*.java model/tarefas/progresso/*.java service/*.java

# 3. Execute o programa
java Main
```

---

## 💡 Como Usar

### 1️⃣ Início do Programa

Ao iniciar, você será solicitado a criar seu perfil de jogador:

```
╔═══════════════════════════════════════╗
║  🎮 BEM-VINDO AO LIVRO DE MISSÕES    ║
╚═══════════════════════════════════════╝

👤 Digite seu nome de jogador: SeuNome
🎮 Jogador criado com sucesso: SeuNome!
```

### 2️⃣ Menu Principal

```
╔═══════════════════════════════════════╗
║       📖 LIVRO DE MISSÕES            ║
╚═══════════════════════════════════════╝
1. ✨ Adicionar nova missão
2. 📋 Ver todas as missões
3. ✅ Concluir missão
4. 🗑️  Remover missão
5. ✏️  Editar missão
6. 👤 Ver status do jogador
7. 📊 Ver estatísticas
0. 🚪 Sair
```

### 3️⃣ Adicionar Missão

Escolha a opção **1** e siga os passos:

```
📁 Categorias disponíveis:
1. 💼 Trabalho - Tarefas relacionadas ao trabalho
2. 🏠 Pessoal - Tarefas pessoais
3. 📚 Estudos - Tarefas academicas
4. 💪 Saude - Exercicios e saude
5. 🎮 Lazer - Entretenimento

📝 Digite o nome da missão: Estudar POO em Java
📄 Digite a descrição da missão: Revisar conceitos de herança e polimorfismo
📁 Escolha o número da categoria: 3

⚔️ Níveis de dificuldade:
1 ⭐ Muito Fácil (50 XP)
2 ⭐⭐ Fácil (100 XP)
3 ⭐⭐⭐ Médio (150 XP)
4 ⭐⭐⭐⭐ Difícil (250 XP)
5 ⭐⭐⭐⭐⭐ Muito Difícil (400 XP)

⚔️ Digite a dificuldade (1-5): 4
```

### 4️⃣ Concluir Missão e Ganhar XP

Escolha a opção **3**:

```
✅ Missao Concluida: Estudar POO em Java
💫 Você ganhou 250 XP!
✅ Missão concluída! +250 XP
🎉 Parabens! Você subiu para o nivel 2!
```

### 5️⃣ Ver Status do Jogador

Escolha a opção **6**:

```
╔═══════════════════════════════╗
║    STATUS DO JOGADOR         ║
╚═══════════════════════════════╝
👤 Jogador: SeuNome
⭐ Nivel: 2
💫 Experiencia: 50/120 XP (41.7%)
✅ Missões Concluidas: 3
```

### 6️⃣ Ver Estatísticas

Escolha a opção **7**:

```
╔═══════════════════════════════╗
║   📊 ESTATISTICAS DO JOGO    ║
╚═══════════════════════════════╝
📋 Total de missões: 5
✅ Concluidas: 3
⏳ Pendentes: 2
💫 XP Total Ganho: 450
📈 Taxa de Conclusão: 60.0%
```

---

## 🎓 Conceitos de POO Aplicados

### 1. **Encapsulamento** 🔒
```java
public class Jogador {
    private String nome;           // Atributos privados
    private int experiencia;
    
    public String getNome() {      // Getters públicos
        return nome;
    }
}
```

### 2. **Abstração** 🎭
```java
public class Tarefa {
    public void concluir() {       // Método abstrai a lógica
        this.concluida = true;
    }
}
```

### 3. **Composição** 🧩
```java
public class ListaDeTarefas {
    private ArrayList<Tarefa> tarefas;      // Lista contém Tarefas
    private SistemaProgresso sistema;        // Composição de serviços
}
```

### 4. **Responsabilidade Única** 📌
- `Jogador`: Gerencia apenas dados do jogador
- `ListaDeTarefas`: Gerencia apenas tarefas
- `SistemaProgresso`: Calcula apenas XP
- `GerenciadorJogador`: Orquestra ações do jogador

### 5. **Reutilização de Código** ♻️
```java
private static void pausar(Scanner scanner) {
    System.out.print("\n⏸️  Pressione ENTER para continuar...");
    scanner.nextLine();
}
```

### 6. **Validação e Tratamento de Erros** ✅
```java
if (!scanner.hasNextInt()) {
    System.out.println("❌ Entrada inválida!");
    scanner.nextLine();
    return;
}
```

---

## 🎮 Sistema de XP e Progressão

### Tabela de XP por Dificuldade

| Dificuldade | Estrelas | XP Ganho |
|-------------|----------|----------|
| 1 | ⭐ | 50 XP |
| 2 | ⭐⭐ | 100 XP |
| 3 | ⭐⭐⭐ | 150 XP |
| 4 | ⭐⭐⭐⭐ | 250 XP |
| 5 | ⭐⭐⭐⭐⭐ | 400 XP |

### Progressão de Níveis

O XP necessário para subir de nível aumenta progressivamente:

```
Nível 1 → 2: 100 XP
Nível 2 → 3: 120 XP
Nível 3 → 4: 140 XP
Nível 4 → 5: 160 XP
...
Fórmula: 100 + (nivel - 1) * 20
```
## 👨‍💻 Autor

**Otavio da Rocha Custodio**

- GitHub: [@OtavioRochaDeveloper][(https://github.com/OtavioRochaDeveloper/)]
- LinkedIn: [Otavio Rocha][(https://www.linkedin.com/in/otavio-rocha-developer/)]
- Email: otaviorocha36@gmail.com

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 🙏 Agradecimentos

- Comunidade Java pela documentação completa
- Inspiração em sistemas gamificados como Habitica e Duolingo
- Projeto desenvolvido para fins educacionais

---

## 📸 Screenshots

### Menu Principal
```
╔═══════════════════════════════════════╗
║       📖 LIVRO DE MISSÕES            ║
╚═══════════════════════════════════════╝
```

### Status do Jogador
```
👤 Jogador: Aventureiro
⭐ Nivel: 5
💫 Experiencia: 75/180 XP (41.7%)
✅ Missões Concluidas: 12
```

---

## 🤝 Contribuindo

Contribuições são sempre bem-vindas! Para contribuir:

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/NovaFuncionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/NovaFuncionalidade`)
5. Abra um Pull Request

---

## 📞 Suporte

Se você encontrar algum bug ou tiver alguma sugestão, por favor:

1. Abra uma [issue](https://github.com/OtavioRochaDeveloper/To-Do-Gaming)
2. Descreva o problema ou sugestão detalhadamente
3. Aguarde o feedback

---

<div align="center">

### ⭐ Se este projeto te ajudou, considere dar uma estrela!

**Feito com ❤️ e muito ☕ em Java**

[⬆ Voltar ao topo](#-livro-de-missões---to-do-list-gamificado)

</div>
