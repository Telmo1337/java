public class Monstros implements Interativos  {
    private int ID;
    private int HP;
    private String nome;
    private int mana;  // Adding mana to the monsters

    public Monstros(int ID, String nome, int HP, int mana) {
        this.ID = ID;
        this.HP = HP;
        this.nome = nome;
        this.mana = mana;
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

    @Override
    public String getPersonagemClasse() {
        return "Monstro";
    }

    @Override
    public void takeDamage(int damage) {
        this.HP -= damage;
    }

    @Override
    public void attack(Interativos target) {
        target.takeDamage(9);  // Example of a fixed damage normal attack
    }

    public void specialAttack1(Interativos target) {
        if (mana >= 20) {
            mana -= 20;  // Use mana
            System.out.println(this.nome + " usou Garras Selvagens!");
            target.takeDamage(16);  // Example special attack damage
        } else {
            System.out.println(this.nome + " não tem mana suficiente para Garras Selvagens!");
        }
    }

    public void specialAttack2(Interativos target) {
        if (mana >= 25) {
            mana -= 25;  // Use mana
            System.out.println(this.nome + " usou Rugido Terrível!");
            target.takeDamage(20);  // Example special attack damage
        } else {
            System.out.println(this.nome + " não tem mana suficiente para Rugido Terrível!");
        }
    }

    // Getters and setters for mana if needed
    public int getMana() {
        return mana;
    }

    public void useMana(int amount) {
        if (mana >= amount) {
            mana -= amount;
        } else {
            System.out.println("Mana insuficiente!");
        }
    }
}
