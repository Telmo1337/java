import java.util.Scanner;
import java.util.Random;

public class Batalha {

    private Personagens player;
    private Monstros enemy;
    private Scanner scanner;
    private Random random;

    public Batalha(Personagens player, Monstros enemy) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    public void startBattle() {

        while (player.getHP() > 0 && enemy.getHP() > 0) {
            System.out.println("\n-------Iniciar Batalha-------");
            printStatus();

            playerTurn();

            if (enemy.getHP() > 0) {
                enemyTurn();
            }
        }

        if (player.getHP() <= 0) {
            System.out.println("\nPerdeste a batalha!");
        } else {
            System.out.println("\nGanhaste a batalha!");
        }
    }

    // Show Mana cost before selection metodo
    private void showManaCosts() {
        if (player instanceof Guerreiro) {
            System.out.println("Sword Slash : 18 Mana");
            System.out.println("Whirlwind: 24 Mana");
            System.out.println("Berserk Fury: 35 Mana");
        } else if (player instanceof Arqueiro) {
            System.out.println("Flame Arrow: 14 Mana");
            System.out.println("Arrow Storm: 28 Mana");
            System.out.println("Rapid Volley: 35 Mana");
        } else if (player instanceof Clerigo) {
            System.out.println("Holy Smite: 12 Mana");
            System.out.println("Divine Wrath: 22 Mana");
            System.out.println("Divine Healing : 30 Mana");
        } else if (player instanceof Mago) {
            System.out.println("Teleport Slash: 20 Mana");
            System.out.println("Frost Explosion: 30 Mana");
            System.out.println("Arcane Blast: 40 Mana");
        } else if (player instanceof Monge) {
            System.out.println("Fists of Fury: 15 Mana");
            System.out.println("Dragon Palm: 25 Mana");
            System.out.println("Heaven’s Step: 35 Mana");
        } else if (player instanceof Cavaleiro) {
            System.out.println("Shield Bash: 18 Mana");
            System.out.println("Chaos Blade: 26 Mana");
            System.out.println("Charge: 38 Mana");
        }
    }


    private void printStatus() {
        System.out.println("\nEstado Atual:");
        System.out.println(player.getNome() + " - HP: " + player.getHP() + " | Mana: " + player.getMana());
        System.out.println(enemy.getNome() + " - HP: " + enemy.getHP());
    }

    public void playerTurn() {
        System.out.println("\nTeu turno! Escolha uma ação:\n");
        showManaCosts();
        System.out.println("\n1. Normal Attack");
        System.out.println("2. Special Attack 1");
        System.out.println("3. Special Attack 2");
        System.out.println("4. Special attack 4");

        int action = scanner.nextInt();

        switch (action) {
            case 1:
                if (player instanceof Guerreiro) {
                    ((Guerreiro) player).normalAttack(enemy);
                } else if (player instanceof Arqueiro) {
                    ((Arqueiro) player).normalAttack(enemy);
                } else if (player instanceof Clerigo) {
                    ((Clerigo) player).normalAttack(enemy);
                } else if (player instanceof Mago) {
                    ((Mago) player).normalAttack(enemy);
                } else if (player instanceof Monge) {
                    ((Monge) player).normalAttack(enemy);
                } else if (player instanceof Cavaleiro) {
                    ((Cavaleiro) player).normalAttack(enemy);
                }
                break;
            case 2:
                if (player instanceof Guerreiro) {
                    System.out.println("usou 18 de mana");
                    ((Guerreiro) player).specialAttackQ(enemy);
                } else if (player instanceof Arqueiro) {
                    ((Arqueiro) player).specialAttackQ(enemy);
                } else if (player instanceof Clerigo) {
                    ((Clerigo) player).specialAttackQ(enemy);
                } else if (player instanceof Mago) {
                    ((Mago) player).specialAttackQ(enemy);
                } else if (player instanceof Monge) {
                    ((Monge) player).specialAttackQ(enemy);
                } else if (player instanceof Cavaleiro) {
                    ((Cavaleiro) player).specialAttackQ(enemy);
                }
                break;
            case 3:
                if (player instanceof Guerreiro) {
                    ((Guerreiro) player).specialAttackW(enemy);
                } else if (player instanceof Arqueiro) {
                    ((Arqueiro) player).specialAttackW(enemy);
                } else if (player instanceof Clerigo) {
                    ((Clerigo) player).specialAttackW(enemy);
                } else if (player instanceof Mago) {
                    ((Mago) player).specialAttackW(enemy);
                } else if (player instanceof Monge) {
                    ((Monge) player).specialAttackW(enemy);
                } else if (player instanceof Cavaleiro) {
                    ((Cavaleiro) player).specialAttackW(enemy);
                }
                break;
            case 4:
                if (player instanceof Clerigo) {
                    ((Clerigo) player).heal(player); // Cleric heals itself
                } else {
                    if (player instanceof Guerreiro) {
                        ((Guerreiro) player).specialAttackE(enemy);
                    } else if (player instanceof Arqueiro) {
                        ((Arqueiro) player).specialAttackE(enemy);
                    } else if (player instanceof Mago) {
                        ((Mago) player).specialAttackE(enemy);
                    } else if (player instanceof Monge) {
                        ((Monge) player).specialAttackE(enemy);
                    } else if (player instanceof Cavaleiro) {
                        ((Cavaleiro) player).specialAttackE(enemy);
                    }
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    // Enemy's turn - random action
    private void enemyTurn() {
        System.out.println("\n" + enemy.getNome() + "'s turn!");

        // Randomly choose attack type
        int enemyAction = random.nextInt(3); // Three possible actions for simplicity

        switch (enemyAction) {
            case 1:
                enemy.attack(player);
                break;
            case 2:
                enemy.specialAttack1(player);
                break;
            case 3:
                enemy.specialAttack2(player);
                break;
        }
    }
}
