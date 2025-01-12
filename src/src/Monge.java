public class Monge extends Personagens{
    public Monge(int ID, String nome, int HP, int mana) {
        super(ID, nome, HP, "Monge", mana);
    }

     //ataque normal
     public void normalAttack(Interativos target){
        System.out.println(this.getNome() + " atacou com um ataque normal!");
        target.takeDamage(10);
    }

    public void specialAttackQ(Interativos target){
        if(getMana() >= 17) {
            useMana(17);
            System.out.println(this.getNome() + " usou Fists of Fury para atacar!");
            target.takeDamage(20);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackW(Interativos target){
        if(getMana() >= 24) {
            useMana(24);
            System.out.println(this.getNome() + " usou Dragon Palm  para atacar!");
            target.takeDamage(28);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackE(Interativos target) {
        if (getMana() >= 36) {
            useMana(36);
            System.out.println(getNome() + " usou Heaven’s Step para atacar!");
            target.takeDamage(44);  // Special attack damage
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    
}
