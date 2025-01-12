public class Personagens implements Interativos {
    private int ID;
    private int HP;
    private int mana;
    private String nome;
    private String personagemClasse;

  

    public Personagens(int ID, String nome, int HP, String personagemClasse, int mana) {
        this.ID = ID;
        this.nome = nome;
        this.HP = HP;
        this.personagemClasse = personagemClasse;
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
        target.takeDamage(0);  // Exemplo de dano fixo
    }



    public void useMana(int amount) {
        if(amount <= mana) {
            mana -= amount;
        } else {
            System.out.println("Mana insuficiente para usar habilidade!");
        }
    }
}
