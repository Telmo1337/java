public class Clerigo  extends Personagens{
    public Clerigo(int ID, String nome, int HP, int mana) {
        super(ID, nome, HP, "Clerigo", mana);
    }
    
    //ataque normal
    public void normalAttack(Interativos target){
        System.out.println(this.getNome() + " atacou com um ataque normal!");
        target.takeDamage(7);
    }

    public void specialAttackQ(Interativos target){
        if(getMana() >= 14) {
            useMana(14);
            System.out.println(this.getNome() + " usou Holy Smite para atacar!");
            target.takeDamage(19);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackW(Interativos target){
        if(getMana() >= 29) {
            useMana(29);
            System.out.println(this.getNome() + " usou Divine Wrath  para atacar!");
            target.takeDamage(34);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void heal(Interativos target) {
        if (getMana() >= 12) {
            useMana(12);
            System.out.println(getNome() + " usou Divine Healing e heals himself!");
            takeDamage(-20);  // Healing the character who called the method
        } else {
            System.out.println("Not enough mana for healing.");
        }
    }

    
}
