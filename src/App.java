import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static List<Personagens> personagensList = new ArrayList<>(); // Lista de personagens

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personagens player = SaveManager.carregarPersonagem(); // Carregar personagem salvo, se existir

        if (player == null) {
            System.out.println("Nenhuma personagem salva encontrada. Começando um novo jogo...");
        }

        // Loop do menu principal
        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Escolher Personagem");
            System.out.println("2. Lutar contra um inimigo");
            System.out.println("3. Explorar a Dungeon");
            System.out.println("4. Ver status do jogador");
            System.out.println("5. Editar nível do personagem");
            System.out.println("6. Mudar classe do personagem");
            System.out.println("7. Banir Personagem");
            System.out.println("8. Restaurar Personagem");
            System.out.println("9. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    player = escolherPersonagem(scanner);
                    personagensList.add(player); // Adiciona o novo personagem à lista
                    SaveManager.salvarPersonagem(player);
                    break;
                case 2:
                    if (player == null) {
                        System.out.println("Escolha um personagem primeiro!");
                    } else {
                        Monstros inimigo = escolherInimigo();
                        System.out.println("Você encontrou um inimigo! " + inimigo.getNome());
                        Batalha batalha = new Batalha(player, inimigo);
                        batalha.startBattle();
                        SaveManager.salvarPersonagem(player);
                    }
                    break;
                case 3:
                    if (player == null) {
                        System.out.println("Escolha um personagem primeiro!");
                    } else {
                        explorarDungeon(scanner, player);
                    }
                    break;
                case 4:
                    if (player == null) {
                        System.out.println("Nenhum personagem escolhido ainda!");
                    } else {
                        mostrarStatus(player);
                    }
                    break;
                case 5:
                    if (player == null) {
                        System.out.println("Escolha um personagem primeiro!");
                    } else {
                        editarNivel(scanner, player);
                        SaveManager.salvarPersonagem(player);
                    }
                    break;
                case 6:
                    if (player == null) {
                        System.out.println("Escolha um personagem primeiro!");
                    } else {
                        mudarClasse(scanner, player);
                        SaveManager.salvarPersonagem(player);
                    }
                    break;
                case 7:
                    if (player == null) {
                        System.out.println("Escolha um personagem primeiro!");
                    } else {
                        banirPersonagem(scanner, player);
                    }
                    break;
                case 8:
                    if (player == null) {
                        System.out.println("Escolha um personagem primeiro!");
                    } else {
                        restaurarPersonagem(scanner, player);
                    }
                    break;
                case 9:
                    System.out.println("Obrigado por jogar!");
                    SaveManager.salvarPersonagem(player);
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida!");
            }
        }
    }

    // Método para escolher um personagem
    private static Personagens escolherPersonagem(Scanner scanner) {
        System.out.println("\nSelecione o seu personagem:");
        System.out.println("1. Guerreiro (Aragorn)");
        System.out.println("2. Arqueiro (Legolas)");
        System.out.println("3. Cavaleiro (Éomer)");
        System.out.println("4. Mago (Gandalf)");
        System.out.println("5. Clerigo (Elrond)");
        System.out.println("6. Monge (Frodo)");

        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                return new Guerreiro(1, "Aragorn", 180, 100, 100, 180);
            case 2:
                return new Arqueiro(2, "Legolas", 100, 100, 100, 100);
            case 3:
                return new Cavaleiro(3, "Éomer", 140, 100, 100, 140);
            case 4:
                return new Mago(4, "Gandalf", 160, 230, 100, 160);
            case 5:
                return new Clerigo(5, "Elrond", 70, 180, 100, 70);
            case 6:
                return new Monge(6, "Frodo", 140, 100, 100, 140);
            default:
                System.out.println("Escolha inválida! Aragorn selecionado como padrão.");
                return new Guerreiro(1, "Aragorn", 180, 100, 100, 180);
        }
    }

    // Método para banir personagem pela classe
    private static void banirPersonagem(Scanner scanner, Personagens player) {
        System.out.print("Digite o nome da classe do personagem para banir (ex: Guerreiro): ");
        String classePersonagem = scanner.next();
        
        Personagens personagem = encontrarPersonagemPorClasse(classePersonagem);
        if (personagem != null) {
            personagem.banir();
            System.out.println("Personagem " + personagem.getNome() + " da classe " + classePersonagem + " foi banido.");
        } else {
            System.out.println("Nenhum personagem encontrado com a classe " + classePersonagem + "!");
        }
    }

    // Método para restaurar personagem pela classe
    private static void restaurarPersonagem(Scanner scanner, Personagens player) {
        System.out.print("Digite o nome da classe do personagem para restaurar (ex: Guerreiro): ");
        String classePersonagem = scanner.next();
        
        Personagens personagem = encontrarPersonagemPorClasse(classePersonagem);
        if (personagem != null) {
            personagem.restaurar();
            System.out.println("Personagem " + personagem.getNome() + " da classe " + classePersonagem + " foi restaurado.");
        } else {
            System.out.println("Nenhum personagem encontrado com a classe " + classePersonagem + "!");
        }
    }

    // Método para procurar personagem pela classe
    private static Personagens encontrarPersonagemPorClasse(String classe) {
        // Aqui, a lógica é procurar por qualquer personagem com a classe fornecida
        for (Personagens p : personagensList) {  // Exemplo de lista de personagens
            if (p.getPersonagemClasse().equalsIgnoreCase(classe)) {
                return p;
            }
        }
        return null;  // Se não encontrar, retorna null
    }

    // Método para selecionar um inimigo aleatório
    private static Monstros escolherInimigo() {
        Monstros[] inimigos = {
                new Monstros(0, "Young Spiders", 68, 45),
                new Monstros(1, "Giant Rats", 75, 50),
                new Monstros(2, "Raven-men", 95, 60),
                new Monstros(3, "Small Stone Trolls", 130, 80)
        };
        return inimigos[new Random().nextInt(inimigos.length)];
    }

    // Método para mostrar o status do jogador
    private static void mostrarStatus(Personagens player) {
        System.out.println("\n--- Status do Jogador ---");
        System.out.println("Nome: " + player.getNome());
        System.out.println("Classe: " + player.getPersonagemClasse());
        System.out.println("Nível: " + player.getNivel());
        System.out.println("XP: " + player.getExperiencia() + "/" + player.getXpParaProximoNivel());
        System.out.println("HP: " + player.getHP());
        System.out.println("Mana: " + player.getMana());
    }

    private static void editarNivel(Scanner scanner, Personagens player) {
        System.out.print("Digite o novo nível do personagem: ");
        int novoNivel = scanner.nextInt();
        player.editarNivel(novoNivel);
    }

    private static void mudarClasse(Scanner scanner, Personagens player) {
        System.out.println("\nEscolha a nova classe para o seu personagem:");
        System.out.println("1. Guerreiro");
        System.out.println("2. Arqueiro");
        System.out.println("3. Cavaleiro");
        System.out.println("4. Mago");
        System.out.println("5. Clérigo");
        System.out.println("6. Monge");

        int escolha = scanner.nextInt();
        String novaClasse = "";

        switch (escolha) {
            case 1:
                novaClasse = "Guerreiro";
                break;
            case 2:
                novaClasse = "Arqueiro";
                break;
            case 3:
                novaClasse = "Cavaleiro";
                break;
            case 4:
                novaClasse = "Mago";
                break;
            case 5:
                novaClasse = "Clérigo";
                break;
            case 6:
                novaClasse = "Monge";
                break;
            default:
                System.out.println("Escolha inválida! Nenhuma mudança foi feita.");
                return;
        }

        player.mudarClasse(novaClasse);
    }

    private static void explorarDungeon(Scanner scanner, Personagens player) {
        System.out.println("Escolha a dificuldade da dungeon:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println("4. Savage");

        int dificuldadeEscolhida = scanner.nextInt();
        String dificuldade = "";

        switch (dificuldadeEscolhida) {
            case 1:
                dificuldade = "Easy";
                break;
            case 2:
                dificuldade = "Medium";
                break;
            case 3:
                dificuldade = "Hard";
                break;
            case 4:
                dificuldade = "Savage";
                break;
            default:
                System.out.println("Escolha inválida! Dungeon 'Easy' selecionada como padrão.");
                dificuldade = "Easy";
        }

        // Criar uma nova Dungeon e iniciar a exploração
        Dungeon dungeon = new Dungeon(player, dificuldade);
        dungeon.explorar();

        // Salvar progresso do jogador após explorar a dungeon
        SaveManager.salvarPersonagem(player);
    }
}
