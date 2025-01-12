import java.io.Serializable;

public class Personagens implements Interativos, Serializable {
    private int ID;
    private int HP;
    private int mana;
    private String nome;
    private String personagemClasse;
    private int maxMana; // Adicionar atributo de mana máxima
    private int maxHP; // Adicionar atributo de HP máximo

    private int nivel; // Adicionar atributo de nível
    private int experiencia; // Atributo de experiência
    private int xpParaProximoNivel; // A quantidade de XP necessária para o próximo nível

    public Personagens(int ID, String nome, int HP, String personagemClasse, int mana, int maxMana, int maxHP) {
        this.ID = ID;
        this.nome = nome;
        this.HP = HP;
        this.personagemClasse = personagemClasse;
        this.mana = mana;
        this.nivel = 1; // Inicia com nível 1
        this.experiencia = 0; // Inicia com 0 de XP
        this.xpParaProximoNivel = 100; // XP necessário para o nível 2
        this.maxMana = maxMana; // Adiciona a mana máxima
        this.maxHP = maxHP; // Adiciona o HP máximo
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
        target.takeDamage(0); // Exemplo de dano fixo
    }

    public void useMana(int amount) {
        if (amount <= mana) {
            mana -= amount;
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    // adicionar metodo para ganahr XP
    public void ganharXP(int xpGanho) {
        experiencia = experiencia + xpGanho;
        System.out.println("Ganhou " + xpGanho + " de XP!");
        System.out.println("XP Atual: " + experiencia + "/" + xpParaProximoNivel);

        while (experiencia >= xpParaProximoNivel) {
            subirNivel();
        }
    }

    // Adicionar método para subir de nível
    public void subirNivel() {
        nivel++;
        experiencia -= xpParaProximoNivel;
        xpParaProximoNivel = (int) (xpParaProximoNivel * 1.2); // Aumenta a XP necessária para o próximo nível
    
        // Atualizando os valores máximos de HP e Mana
        maxHP += 70;  // Aumenta o valor máximo de HP
        maxMana += 40;  // Aumenta o valor máximo de Mana
    
        // Garantir que o HP e a Mana não ultrapassem seus respectivos máximos
        HP = Math.min(HP + 70, maxHP);  // Atualiza HP e não deixa ultrapassar o valor máximo
        mana = Math.min(mana + 40, maxMana);  // Atualiza Mana e não deixa ultrapassar o valor máximo
    
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

}
