package console;
import java.io.IOException;

public class ClearConsole {
    public void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Linux") || System.getProperty("os.name").contains("Mac")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                System.out.println("Limpeza do console não suportada para este sistema.");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao tentar limpar o console: " + e.getMessage());
        }
    }
}