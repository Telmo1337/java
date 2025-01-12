import java.io.*;

public class SaveManager {

    // Salva o personagem em um arquivo binário
    public static void salvarPersonagem(Personagens personagem) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("personagem.dat"))) {
            oos.writeObject(personagem);  // Serializa o objeto personagem
            System.out.println("Personagem salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o personagem: " + e.getMessage());
        }
    }

    // Carrega o personagem a partir do arquivo binário
    public static Personagens carregarPersonagem() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("personagem.dat"))) {
            return (Personagens) ois.readObject();  // Desserializa o objeto personagem
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum personagem salvo encontrado.");
            return null;
        }
    }
}
