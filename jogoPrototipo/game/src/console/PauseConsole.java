package console;
import java.util.Scanner;

public class PauseConsole {
    public void pauseConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine(); // Espera até o usuário pressionar Enter
    }
}