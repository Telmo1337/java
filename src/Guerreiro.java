public class Guerreiro extends Personagens {
    public Guerreiro(int ID, String nome, int HP, int mana){
        super(ID, nome, HP, "Guerreiro", mana);
    }


     //ataque normal
     public void normalAttack(Interativos target){
        System.out.println(this.getNome() + " atacou com um ataque normal!");
        target.takeDamage(8);
    }

    public void specialAttackQ(Interativos target){
        if(getMana() >= 18) {
            useMana(18);
            System.out.println(this.getNome() + " usou Sword Slash para atacar!");
            target.takeDamage(20);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackW(Interativos target){
        if(getMana() >= 24) {
            useMana(24);
            System.out.println(this.getNome() + " usou Whirlwind para atacar!");
            target.takeDamage(30);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackE(Interativos target){
        if(getMana() >= 31) {
            useMana(31);
            System.out.println(this.getNome() + " usou Berserk Fury para atacar!");
            target.takeDamage(44);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }
}
