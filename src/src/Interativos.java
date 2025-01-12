public interface Interativos {
    
    // Atributos (declarados como métodos abstratos)
    int getID();
    int getHP();
    

    // Métodos abstratos
    String getPersonagemClasse();  // Método para obter a classe do personagem
    
    // Métodos
    void takeDamage(int damage);
    void attack(Interativos target);
}
