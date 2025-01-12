import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        

        Scanner scanner = new Scanner(System.in);

        // Display character selection menu
        System.out.println("Select your character:");
        System.out.println("1. Guerreiro (Warrior)");
        System.out.println("2. Arqueiro (Archer)");
        System.out.println("3. Cavaleiro (Knight)");
        System.out.println("4. Mago (Mage)");
        System.out.println("5. Clerigo (Cleric)");
        System.out.println("6. Monge (Monk)");

        // Get user input
        int choice = scanner.nextInt();
        Personagens player = null;

        // Create player character based on user selection
        switch (choice) {
            case 1:
                player = new Guerreiro(1, "Warrior", 180, 100);  // Guerreiro example
                break;
            case 2:
                player = new Arqueiro(2, "Archer", 100, 100);  // Arqueiro example
                break;
            case 3:
                player = new Cavaleiro(3, "Knight", 140, 100);  // Cavaleiro example
                break;
            case 4:
                player = new Mago(4, "Mage", 80, 160);  // Mago example
                break;
            case 5:
                player = new Clerigo(5, "Cleric", 70, 180);  // Clerigo example
                break;
            case 6:
                player = new Monge(6, "Monk", 140, 100);  // Monge example
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Guerreiro.");
                player = new Guerreiro(1, "Warrior", 150, 100);  // Default to Guerreiro
                break;
        }

        // Create an enemy monster
        Monstros enemy = new Monstros(1, "Gonçalo Ferreira", 200, 45);  // Example enemy monster

        // Create a Batalha object and start the battle
        Batalha batalha = new Batalha(player, enemy);
        batalha.startBattle();  // Start the battle
        scanner.close();  // Close the scanner
    }
    




}
