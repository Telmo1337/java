

public class Dungeon {
    private Personagens player;
    private String dificuldade;

    public Dungeon(Personagens player, String dificuldade) {
        this.player = player;
        this.dificuldade = dificuldade;
    }

    public void explorar() {
        System.out.println("\nVocê entrou na dungeon de dificuldade: " + dificuldade);

        // Verificando se o personagem tem o nível necessário para a dificuldade da dungeon
        if (!verificarRequisitosDeDificuldade()) {
            System.out.println("Seu nível é muito baixo para essa dungeon! Você precisa de um nível maior.");
            return;
        }

        // Obter a lista de monstros conforme a dificuldade
        Monstros[] inimigos = escolherInimigos();

        // Lutar contra todos os monstros da dungeon
        for (Monstros inimigo : inimigos) {
            System.out.println("\nVocê encontrou o monstro: " + inimigo.getNome());
            Batalha batalha = new Batalha(player, inimigo);
            batalha.startBattle(); // Inicia a batalha contra o monstro atual

            // Se o jogador perdeu a batalha, ele não continua a dungeon
            if (player.getHP() <= 0) {
                System.out.println("Você foi derrotado! Fim da dungeon.");
                return;
            }
        }

        System.out.println("Você derrotou todos os inimigos da dungeon!");
    }

    private boolean verificarRequisitosDeDificuldade() {
        int nivelJogador = player.getNivel();
        switch (dificuldade) {
            case "Easy":
                return nivelJogador >= 1;
            case "Medium":
                return nivelJogador >= 15;
            case "Hard":
                return nivelJogador >= 20;
            case "Savage":
                return nivelJogador >= 30;
            default:
                return false;
        }
    }

    private Monstros[] escolherInimigos() {
        Monstros[] inimigos = null;

        switch (dificuldade) {
            case "Easy":
                inimigos = new Monstros[] {
                    new Monstros(0, "Goblin", 50, 20),
                    new Monstros(1, "Wargs", 60, 25),
                    new Monstros(2, "Orc", 70, 30)
                };
                break;
            case "Medium":
                inimigos = new Monstros[] {
                    new Monstros(0, "Orc", 80, 45),
                    new Monstros(1, "Uruk-hai", 100, 60),
                    new Monstros(2, "Mountain Troll", 150, 75)
                };
                break;
            case "Hard":
                inimigos = new Monstros[] {
                    new Monstros(0, "Giant Spider", 200, 120),
                    new Monstros(1, "Scatha", 250, 150),
                    new Monstros(2, "Sauron", 310, 250)
                };
                break;
            case "Savage":
                inimigos = new Monstros[] {
                    new Monstros(0, "Smaug", 500, 300),
                    new Monstros(1, "Sauron", 600, 350),
                    new Monstros(2, "Balrog", 700, 400)
                };
                break;
            default:
                System.out.println("Dificuldade desconhecida, retornando inimigo padrão.");
                inimigos = new Monstros[] { new Monstros(0, "Goblin", 50, 20) };
                break;
        }

        return inimigos;
    }
}
