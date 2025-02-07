import java.io.Serializable;

public class Personagens implements Interativos, Serializable {
    private int ID;
    private int HP;
    private int mana;
    private String nome;
    private String personagemClasse;
    private int maxMana;
    private int maxHP;
    private int nivel;
    private int experiencia;
    private int xpParaProximoNivel;
    private boolean banido; // Atributo para controle de banimento

    public Personagens(int ID, String nome, int HP, String personagemClasse, int mana, int maxMana, int maxHP) {
        this.ID = ID;
        this.nome = nome;
        this.HP = HP;
        this.personagemClasse = personagemClasse;
        this.mana = mana;
        this.nivel = 1;
        this.experiencia = 0;
        this.xpParaProximoNivel = 100;
        this.maxMana = maxMana;
        this.maxHP = maxHP;
        this.banido = false; // Inicialmente, a personagem não está banida
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getHP() {
        return HP;
    }

    public String getNome() {
        return nome;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public String getPersonagemClasse() {
        return personagemClasse;
    }

    @Override
    public void takeDamage(int damage) {
        this.HP -= damage;
    }

    @Override
    public void attack(Interativos target) {
        target.takeDamage(0);
    }

    public void useMana(int amount) {
        if (amount <= mana) {
            mana -= amount;
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void ganharXP(int xpGanho) {
        experiencia += xpGanho;
        System.out.println("Ganhou " + xpGanho + " de XP!");
        System.out.println("XP Atual: " + experiencia + "/" + xpParaProximoNivel);

        while (experiencia >= xpParaProximoNivel) {
            subirNivel();
        }
    }

    public void subirNivel() {
        nivel++;
        experiencia -= xpParaProximoNivel;
        xpParaProximoNivel = (int) (xpParaProximoNivel * 1.2);
        maxHP += 70;
        maxMana += 40;
        HP = Math.min(HP + 70, maxHP);
        mana = Math.min(mana + 40, maxMana);

        System.out.println(nome + " subiu para o nível " + nivel + "!");
        System.out.println("Novo HP: " + HP + " | Novo HP Máximo: " + maxHP);
        System.out.println("Nova Mana: " + mana + " | Nova Mana Máxima: " + maxMana);
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getXpParaProximoNivel() {
        return xpParaProximoNivel;
    }

    public void restaurarMana() {
        this.mana = this.maxMana;
        System.out.println(this.nome + " recuperou toda a mana!");
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void restaurarHP() {
        this.HP = this.maxHP;
        System.out.println(this.nome + " recuperou toda a vida!");
    }

    public int getMaxHP(){
        return maxHP;
    }

    public void editarNivel(int novoNivel) {
        if (novoNivel > 0 && novoNivel != this.nivel) {
            this.nivel = novoNivel;
            this.experiencia = 0;
            this.xpParaProximoNivel = (int) (100 * Math.pow(1.2, novoNivel - 1));
            this.maxHP = 100 + (novoNivel * 70);
            this.maxMana = 50 + (novoNivel * 40);
            this.HP = maxHP;
            this.mana = maxMana;

            System.out.println(nome + " agora está no nível " + novoNivel + "!");
        } else {
            System.out.println("O nível inserido é inválido!");
        }
    }

    public void mudarClasse(String novaClasse) {
        this.personagemClasse = novaClasse;
        this.nivel = 1;
        this.experiencia = 0;
        this.xpParaProximoNivel = 100;
        this.maxHP = 100;
        this.maxMana = 50;
        this.HP = maxHP;
        this.mana = maxMana;

        System.out.println(nome + " mudou para a classe " + novaClasse + "!");
        System.out.println("Todos os atributos foram redefinidos!");
    }

    //  Métodos para Banir e Restaurar Personagens

    public void banir() {
        if (!banido) {
            banido = true;
            System.out.println(nome + " foi banido e está oculto!");
        } else {
            System.out.println(nome + " já está banido!");
        }
    }

    public void restaurar() {
        if (banido) {
            banido = false;
            System.out.println(nome + " foi restaurado e está disponível novamente!");
        } else {
            System.out.println(nome + " já está disponível!");
        }
    }

    public boolean isBanido() {
        return banido;
    }
}
