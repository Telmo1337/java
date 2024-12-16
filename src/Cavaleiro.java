public class Cavaleiro extends Personagens {
    public Cavaleiro(int ID, String nome, int HP, int mana){
        super(ID, nome, HP, "Cavaleiro", mana);
    }

     // Normal Attack
     public void normalAttack(Interativos target) {
        System.out.println(getNome() + " attacks normally with a sword!");
        target.takeDamage(13);  // Basic knight attack
    }

    // Special Attack q (uses mana)
    public void specialAttackQ(Interativos target) {
        if (getMana() >= 15) {
            useMana(15);
            System.out.println(getNome() + " usou Shield Bash para atacar!");
            target.takeDamage(26);  // Special attack damage
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    // Special Attack w(uses mana)
    public void specialAttackW(Interativos target) {
        if (getMana() >= 26) {
            useMana(26);
            System.out.println(getNome() + " usou Chaos Blade para atacar!");
            target.takeDamage(36);  // Special attack damage
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

     // Special Attack e (uses mana)
     public void specialAttackE(Interativos target) {
        if (getMana() >= 33) {
            useMana(33);
            System.out.println(getNome() + " usou Charge para atacar!");
            target.takeDamage(48);  // Special attack damage
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }
}
