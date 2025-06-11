package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class LogSistema {
    
    private static final String ARQUIVO_LOG = "logs/sistema.log";

    public static void registrar(String mensagem) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_LOG, true))) {
            writer.println(LocalDateTime.now() + " - " + mensagem);
        } catch (IOException e) {
            System.err.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}