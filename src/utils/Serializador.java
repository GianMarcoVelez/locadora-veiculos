package utils;

import java.io.*;
import java.util.List;

public class Serializador {
    
    public static <T> void salvarDados(List<T> lista, String caminhoArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(lista);
            System.out.println("Dados salvos em " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public static <T> List<T> carregarDados(String caminhoArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
            return null;
        }
    }
}