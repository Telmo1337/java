public class Arqueiro  extends Personagens{
    public Arqueiro(int ID, String nome, int HP, int mana) {
        super(ID, nome, HP, "Arqueiro", mana);
    }


    //ataque normal
    public void normalAttack(Interativos target){
        System.out.println(this.getNome() + " atacou com um ataque normal!");
        target.takeDamage(9);
    }

    public void specialAttackQ(Interativos target){
        if(getMana() >= 14) {
            useMana(14);
            System.out.println(this.getNome() + " usou Flame Arrow para atacar!");
            target.takeDamage(22);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackW(Interativos target){
        if(getMana() >= 28) {
            useMana(28);
            System.out.println(this.getNome() + " usou Arrow Storm para atacar!");
            target.takeDamage(34);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }

    public void specialAttackE(Interativos target){
        if(getMana() >= 35) {
            useMana(35);
            System.out.println(this.getNome() + " usou Rapid Volley para atacar!");
            target.takeDamage(42);
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }
}


