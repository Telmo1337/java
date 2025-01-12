import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

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
            System.out.println("5. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    player = escolherPersonagem(scanner); // Método para seleção de personagem
                    SaveManager.salvarPersonagem(player); // Salvar personagem logo após ser escolhido
                    break;
                case 2:
                    if (player == null) {
                        System.out.println("Escolha um personagem primeiro!");
                    } else {
                        Monstros inimigo = escolherInimigo(); // Método para selecionar um inimigo aleatório
                        System.out.println("Você encontrou um inimigo! " + inimigo.getNome());
                        Batalha batalha = new Batalha(player, inimigo);
                        batalha.startBattle(); // Inicia a batalha
                        SaveManager.salvarPersonagem(player); // Salvar progresso após a batalha
                    }
                    break;
                case 3:
                    if (player == null) {
                        System.out.println("Escolha um personagem primeiro!");
                    } else {
                        // Adiciona a escolha da dificuldade
                        System.out.println("Escolha a dificuldade da dungeon:");
                        System.out.println("1. Easy");
                        System.out.println("2. Medium");
                        System.out.println("3. Hard");
                        System.out.println("4. Savage");
                        
                        int dificuldadeEscolhida = scanner.nextInt();
                        String dificuldade = "";  // Variável para armazenar a dificuldade escolhida
                        
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
                        
                        // Agora criando a Dungeon com o player e a dificuldade escolhida
                        Dungeon dungeon = new Dungeon(player, dificuldade); 
                        dungeon.explorar(); // O jogador explora a dungeon
                        SaveManager.salvarPersonagem(player); // Salvar progresso após explorar a dungeon
                    }
                    break;
                case 4:
                    if (player == null) {
                        System.out.println("Nenhum personagem escolhido ainda!");
                    } else {
                        mostrarStatus(player); // Método para mostrar o status do jogador
                    }
                    break;
                case 5:
                    System.out.println("Obrigado por jogar!");
                    SaveManager.salvarPersonagem(player); // Salvar progresso antes de sair
                    scanner.close();
                    System.exit(0); // Encerra o programa
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
            case 1: return new Guerreiro(1, "Aragorn", 180, 100, 100, 180);
            case 2: return new Arqueiro(2, "Legolas", 100, 100, 100, 100);
            case 3: return new Cavaleiro(3, "Éomer", 140, 100, 100, 140);
            case 4: return new Mago(4, "Gandalf", 160, 230, 100, 160);
            case 5: return new Clerigo(5, "Elrond", 70, 180, 100, 70);
            case 6: return new Monge(6, "Frodo", 140, 100, 100, 140);
            default:
                System.out.println("Escolha inválida! Aragorn selecionado como padrão.");
                return new Guerreiro(1, "Aragorn", 180, 100, 100, 180);
        }
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
}
