import java.io.Serializable;

public class Mago extends Personagens implements Serializable {
    public Mago(int ID, String nome, int HP, int mana, int maxMana, int maxHP) {
        super(ID, nome, HP, "Mago", mana, maxMana, maxHP);
    }

    //ataque normal
    public void normalAttack(Interativos target){
        System.out.println(this.getNome() + " atacou com um ataque normal!");
        target.takeDamage(10);
    }

    public void specialAttackQ(Interativos target){
        if(getMana() >= 18) {
            useMana(18);
            System.out.println(this.getNome() + " usou Teleport Slash para atacar!");
            target.takeDamage(25);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackW(Interativos target){
        if(getMana() >= 29) {
            useMana(29);
            System.out.println(this.getNome() + " usou Frost Explosion para atacar!");
            target.takeDamage(36);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackE(Interativos target){
        if(getMana() >= 48) {
            useMana(48);
            System.out.println(this.getNome() + " usou Arcane Blast para atacar!");
            target.takeDamage(47);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }
    
}
